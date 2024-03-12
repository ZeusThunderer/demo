package ru.ztt.isbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ztt.isbd.model.Multitool;
import ru.ztt.isbd.model.MultitoolModel;

import java.util.List;

public interface MultitoolRepo extends JpaRepository<Multitool, Integer> {
    List<Multitool> findAllByMultitoolModel(MultitoolModel multitoolModel);
    List<Multitool> findAllById(Integer id);
}
