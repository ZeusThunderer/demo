package ru.ztt.isbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ztt.isbd.model.SModule;

import java.util.List;

public interface SModuleRepo extends JpaRepository<SModule, Integer> {
    SModule findSModuleById(Integer id);
}
