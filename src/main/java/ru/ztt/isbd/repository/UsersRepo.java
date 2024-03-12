package ru.ztt.isbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ztt.isbd.model.Users;

public interface UsersRepo extends JpaRepository<Users, Integer> {
    Users findUsersByLogin(String login);
}
