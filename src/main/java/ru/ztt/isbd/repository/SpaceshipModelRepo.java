package ru.ztt.isbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ztt.isbd.model.SpaceshipModel;

import java.util.List;

public interface SpaceshipModelRepo extends JpaRepository<SpaceshipModel, Integer> {
    SpaceshipModel findSpaceshipModelById(Integer id);
}
