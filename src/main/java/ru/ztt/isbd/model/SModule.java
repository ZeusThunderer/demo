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
@Table(name = "smodule", schema = "studs", catalog = "postgres")
public class SModule {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "module_name", nullable = false, length = 255)
    private String moduleName;

    @Column(name = "module_class", nullable = false, length = -1)
    private String moduleClass;

    @Column(name = "modelu_desc", nullable = true, length = -1)
    private String modeluDesc;

}
