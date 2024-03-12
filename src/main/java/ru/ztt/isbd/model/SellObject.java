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
@Table(name = "sell_object", schema = "studs", catalog = "postgres")
public class SellObject {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "obj_type", nullable = false, length = 255)
    private String objType;
    @Basic
    @Column(name = "reference_id", nullable = false)
    private Integer referenceId;
    @Basic
    @Column(name = "cost", nullable = false)
    private Integer cost;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private Users usersByUserId;
}
