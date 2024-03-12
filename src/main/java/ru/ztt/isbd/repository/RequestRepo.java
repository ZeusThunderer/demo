package ru.ztt.isbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ztt.isbd.model.Request;
import ru.ztt.isbd.model.Users;

import java.util.List;

public interface RequestRepo extends JpaRepository<Request, Integer> {
    List<Request> findAllByUsersByUserId(Users user);
    List<Request> findAllByObjType(String obj_type);
    Request findByObjTypeAndRequestObjectId(String obj_type, Integer id);
}
