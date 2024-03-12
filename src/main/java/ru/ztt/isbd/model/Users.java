package ru.ztt.isbd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", schema = "studs", catalog = "postgres")
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "login", nullable = false, length = 255)
    private String login;
    @Basic
    @Column(name = "role_id", nullable = false)
    private Integer roleId;
    @Basic
    @Column(name = "balance", nullable = false)
    private Integer balance;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<Request> requestsById;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<SellObject> sellObjectsById;
}
