package cz.rb.bcreservation.domain.mapper;

import cz.rb.bcreservation.domain.repository.entity.ReservationEntity;
import cz.rb.projectcommon.model.reservation.ReservationListMessage;
import cz.rb.projectcommon.model.reservation.ReservationMessage;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, uses = LocalDateTimeMapper.class)
public interface ReservationMapper {


    ReservationEntity toEntity(ReservationMessage message);

    ReservationMessage toMessage(ReservationEntity entity);

    List<ReservationMessage> toMessages(List<ReservationEntity> entities);

    List<ReservationEntity> toEntities(List<ReservationMessage> messages);

    default ReservationListMessage toListMessage(List<ReservationEntity> entities) {
        return ReservationListMessage.builder()
                .reservationMessages(toMessages(entities))
                .build();
    }
}
