package cz.rb.bcreservation.domain.service;

import cz.rb.bcreservation.domain.exceptions.ReservationNotFoundException;
import cz.rb.bcreservation.domain.mapper.LocalDateTimeMapper;
import cz.rb.bcreservation.domain.mapper.ReservationMapper;
import cz.rb.bcreservation.domain.repository.ReservationRepository;
import cz.rb.projectcommon.model.reservation.ReservationListMessage;
import cz.rb.projectcommon.model.reservation.ReservationMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository repository;
    private final ReservationMapper mapper;
    private final LocalDateTimeMapper localDateTimeMapper;

    public ReservationListMessage getReservations() {
        var reservationList = repository.findAll();
        return mapper.toListMessage(reservationList);
    }

    public void deleteReservation(Long id) {
        repository.deleteById(id);
    }

    public ReservationMessage saveReservation(ReservationMessage message) {
        var reservation = repository.saveAndFlush(mapper.toEntity(message));
        return mapper.toMessage(reservation);
    }

    public ReservationMessage updateReservation(Long id, ReservationMessage message) {
        var reservation = repository.findById(id);

        if (reservation.isEmpty()) {
            throw new ReservationNotFoundException("Reservation with ID " + id + " not found");
        }

        message.setId(reservation.get().getId());
        return message;
    }

    private void updateReservationInDatabase(final ReservationMessage message) {
        repository.updateReservation(
                message.getId(),
                localDateTimeMapper.dateToString(message.getReservationDateStart()),
                localDateTimeMapper.dateToString(message.getReservationDateEnd()),
                message.getDogId(),
                message.getOwnerId(),
                message.getFullPrice(),
                message.getNumberOfDays()
        );
    }


    public ReservationMessage getReservation(Long id) {
        var reservation = repository.findById(id);

        if (reservation.isEmpty()) {
            throw new ReservationNotFoundException("Reservation with ID " + id + " not found");
        }

        return mapper.toMessage(reservation.get());
    }
}
