package ru.ztt.isbd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ownership", schema = "studs", catalog = "postgres")
public class Ownership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "own_date")
    private LocalDateTime ownDate;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private Users usersByUserId;
    @ManyToOne
    @JoinColumn(name = "sell_object_id", referencedColumnName = "id", nullable = false)
    private SellObject sellObject;
}
