package ru.ztt.isbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ztt.isbd.model.MultitoolModel;

import java.util.List;

public interface MultitoolModelRepo extends JpaRepository<MultitoolModel, Integer> {
    MultitoolModel findMultitoolModelById(Integer id);
}
