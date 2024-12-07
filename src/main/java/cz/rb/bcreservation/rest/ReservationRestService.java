package cz.rb.bcreservation.rest;


import cz.rb.bcreservation.domain.service.ReservationService;
import cz.rb.projectcommon.model.reservation.ReservationListMessage;
import cz.rb.projectcommon.model.reservation.ReservationMessage;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
@Slf4j
public class ReservationRestService {

    private final ReservationService service;

    @GetMapping("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<ReservationListMessage> getReservations() {
        log.info("ReservationRestService | getReservations001 | starting request for all reservations");
        var response = service.getReservations();
        log.info("ReservationRestService | getReservations002 | request finished with number of reservations: {}", response.getReservationMessages().size());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{reservationId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<ReservationMessage> getReservation(final @PathVariable("reservationId") Long reservationId) {
        log.info("ReservationRestService | getReservation001 | starting request for reservation with id: {}", reservationId);
        var response = service.getReservation(reservationId);
        log.info("ReservationRestService | getReservation002 | request finished with reservation: {}", response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<ReservationMessage> addReservation(final @RequestBody ReservationMessage reservationMessage) {
        log.info("ReservationRestService | addReservation001 | starting request with reservation: {}", reservationMessage);
        var response = service.saveReservation(reservationMessage);
        log.info("ReservationRestService | addReservation002 | request finished with reservation: {}", response);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{reservationId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<ReservationMessage> updateReservation(final @PathVariable("reservationId") Long reservationId, final @RequestBody ReservationMessage reservationMessage) {
        log.info("ReservationRestService | updateReservation001 | starting request with reservation: {}", reservationMessage);
        var response = service.updateReservation(reservationId, reservationMessage);
        log.info("ReservationRestService | updateReservation002 | request finished with reservation: {}", response);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{reservationId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Void> deleteReservation(final @PathVariable("reservationId") Long reservationId) {
        log.info("ReservationRestService | deleteReservation001 | starting request for reservation with id: {}", reservationId);
        service.deleteReservation(reservationId);
        log.info("ReservationRestService | deleteReservation002 | request finished");
        return ResponseEntity.ok().build();
    }
}
