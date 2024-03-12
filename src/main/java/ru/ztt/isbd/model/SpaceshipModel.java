package ru.ztt.isbd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "spaceship_model", schema = "studs", catalog = "postgres")
public class SpaceshipModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ship_name", nullable = false, length = 255)
    private String shipName;

    @Column(name = "ship_class", nullable = false, length = -1)
    private String shipClass;
    @OneToMany(mappedBy = "spaceshipModel")
    private List<Spaceship> spaceshipsById;
}
