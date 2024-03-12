package ru.ztt.isbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ztt.isbd.model.Spaceship;
import ru.ztt.isbd.model.SpaceshipModel;

import java.util.List;

public interface SpaceshipRepo extends JpaRepository<Spaceship, Integer> {
    List<Spaceship> findAllBySpaceshipModel(SpaceshipModel spaceshipModel);
    Spaceship findSpaceshipById(Integer id);
}
