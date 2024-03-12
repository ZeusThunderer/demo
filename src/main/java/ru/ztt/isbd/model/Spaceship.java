package ru.ztt.isbd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "spaceship", schema = "studs", catalog = "postgres")
public class Spaceship {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "speed", nullable = false)
    private Integer speed;

    @Column(name = "handling", precision = 0)
    private Float handling;

    @Column(name = "color", nullable = false, length = 255)
    private String color;

    @ManyToOne
    @JoinColumn(name = "ship_model", referencedColumnName = "id", nullable = false)
    private SpaceshipModel spaceshipModel;

}
