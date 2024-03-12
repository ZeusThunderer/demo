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
@Table(name = "multitool_model", schema = "studs", catalog = "postgres")
public class MultitoolModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tool_name", nullable = false, length = 255)
    private String toolName;

    @Column(name = "tool_class", nullable = false, length = -1)
    private String toolClass;
    @OneToMany(mappedBy = "multitoolModel")
    private List<Multitool> multitoolsById;

}
