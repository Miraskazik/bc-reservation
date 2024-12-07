package cz.rb.bcreservation.domain.mapper;

import cz.rb.bcreservation.domain.repository.entity.ReservationEntity;
import cz.rb.projectcommon.model.reservation.ReservationMessage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-07T01:34:23+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class ReservationMapperImpl implements ReservationMapper {

    @Autowired
    private LocalDateTimeMapper localDateTimeMapper;

    @Override
    public ReservationEntity toEntity(ReservationMessage message) {
        if ( message == null ) {
            return null;
        }

        ReservationEntity.ReservationEntityBuilder reservationEntity = ReservationEntity.builder();

        reservationEntity.id( message.getId() );
        reservationEntity.reservationDateStart( localDateTimeMapper.dateToString( message.getReservationDateStart() ) );
        reservationEntity.reservationDateEnd( localDateTimeMapper.dateToString( message.getReservationDateEnd() ) );
        reservationEntity.dogId( message.getDogId() );
        reservationEntity.ownerId( message.getOwnerId() );
        reservationEntity.fullPrice( message.getFullPrice() );
        reservationEntity.numberOfDays( message.getNumberOfDays() );

        return reservationEntity.build();
    }

    @Override
    public ReservationMessage toMessage(ReservationEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ReservationMessage.ReservationMessageBuilder reservationMessage = ReservationMessage.builder();

        reservationMessage.id( entity.getId() );
        reservationMessage.reservationDateStart( localDateTimeMapper.stringToDate( entity.getReservationDateStart() ) );
        reservationMessage.reservationDateEnd( localDateTimeMapper.stringToDate( entity.getReservationDateEnd() ) );
        reservationMessage.dogId( entity.getDogId() );
        reservationMessage.ownerId( entity.getOwnerId() );
        reservationMessage.fullPrice( entity.getFullPrice() );
        reservationMessage.numberOfDays( entity.getNumberOfDays() );

        return reservationMessage.build();
    }

    @Override
    public List<ReservationMessage> toMessages(List<ReservationEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ReservationMessage> list = new ArrayList<ReservationMessage>( entities.size() );
        for ( ReservationEntity reservationEntity : entities ) {
            list.add( toMessage( reservationEntity ) );
        }

        return list;
    }

    @Override
    public List<ReservationEntity> toEntities(List<ReservationMessage> messages) {
        if ( messages == null ) {
            return null;
        }

        List<ReservationEntity> list = new ArrayList<ReservationEntity>( messages.size() );
        for ( ReservationMessage reservationMessage : messages ) {
            list.add( toEntity( reservationMessage ) );
        }

        return list;
    }
}
