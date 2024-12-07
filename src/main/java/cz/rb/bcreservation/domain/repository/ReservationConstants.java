package cz.rb.bcreservation.domain.repository;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ReservationConstants {

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT, Locale.GERMAN);

}
