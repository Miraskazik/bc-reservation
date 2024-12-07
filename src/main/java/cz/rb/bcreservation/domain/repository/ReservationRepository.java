package cz.rb.bcreservation.domain.repository;

import cz.rb.bcreservation.domain.repository.entity.ReservationEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE ReservationEntity r " +
            "SET r.reservationDateStart = :reservationDateStart, " +
            "r.reservationDateEnd = :reservationDateEnd, " +
            "r.dogId = :dogId, " +
            "r.ownerId = :ownerId, " +
            "r.fullPrice = :fullPrice, " +
            "r.numberOfDays = :numberOfDays " +
            "WHERE r.id = :id")
    void updateReservation(
            @Param("id") Long id,
            @Param("reservationDateStart") String reservationDateStart,
            @Param("reservationDateEnd") String reservationDateEnd,
            @Param("dogId") Long dogId,
            @Param("ownerId") Long ownerId,
            @Param("fullPrice") Long fullPrice,
            @Param("numberOfDays") Integer numberOfDays
    );
}
