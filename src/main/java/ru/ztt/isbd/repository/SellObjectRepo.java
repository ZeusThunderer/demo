package ru.ztt.isbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ztt.isbd.model.Request;
import ru.ztt.isbd.model.SellObject;
import ru.ztt.isbd.model.Users;

import java.util.List;

public interface SellObjectRepo extends JpaRepository<SellObject, Integer> {
    SellObject findByObjTypeAndAndReferenceId(String obj_type,Integer reference_id);
    List<SellObject> findAllByUsersByUserId(Users user);
    List<SellObject> findAllByObjType(String obj_type);
}
