package com.example.reservationserviceapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/book")
    public ResponseEntity<Reservation> bookReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.bookReservation(reservation));
    }

    @GetMapping("list")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @PostMapping("/cancel")
    public ResponseEntity<Reservation> cancelReservation(@RequestParam Long id) {
        Reservation updated = reservationService.cancelReservation(id);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }
}
