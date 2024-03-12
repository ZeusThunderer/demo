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
@Table(name = "multitool", schema = "studs", catalog = "postgres")
public class Multitool {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "damage", nullable = false, length = 255)
    private String damage;

    @Column(name = "color", nullable = false, length = 255)
    private String color;

    @ManyToOne
    @JoinColumn(name = "tool_model", referencedColumnName = "id", nullable = false)
    private MultitoolModel multitoolModel;

}
