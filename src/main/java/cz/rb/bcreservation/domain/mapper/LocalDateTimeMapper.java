package cz.rb.bcreservation.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;

import static cz.rb.bcreservation.domain.repository.ReservationConstants.DATE_TIME_FORMATTER;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface LocalDateTimeMapper {


    default String dateToString(final java.time.LocalDateTime dateTime) {
        return DATE_TIME_FORMATTER.format(dateTime);
    }

    default LocalDateTime stringToDate(final String dateTime) {
        return LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER);
    }
}
