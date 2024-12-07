package cz.rb.bcreservation.domain.exceptions;

public class ReservationNotFoundException extends RuntimeException {

    public ReservationNotFoundException(final String message) {
        super(message);
    }
}
