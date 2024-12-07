package cz.rb.bcreservation.domain.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "all_reservations")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reservation_date_start", nullable = false)
    private String reservationDateStart;

    @Column(name = "reservation_date_end", nullable = false)
    private String reservationDateEnd;

    @Column(name = "reservation_dog_id", nullable = false)
    private Long dogId;

    @Column(name = "reservation_owner_id", nullable = false)
    private Long ownerId;

    @Column(name = "full_price", nullable = false)
    private Long fullPrice;

    @Column(name = "number_of_days", nullable = false)
    private Integer numberOfDays;
}
