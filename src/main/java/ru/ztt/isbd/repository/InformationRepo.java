package ru.ztt.isbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ztt.isbd.model.Information;

public interface InformationRepo extends JpaRepository<Information, Integer> {
    Information findInformationById(Integer id);
}
