package com.example.reservationserviceapplication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation bookReservation(Reservation reservation) {
        reservation.setStatus("CONFIRMED");
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation cancelReservation(Long id) {
        return reservationRepository.findById(id).map(reservation -> {
            reservation.setStatus("CANCELLED");
            return reservationRepository.save(reservation);
        }).orElse(null);
    }
}
