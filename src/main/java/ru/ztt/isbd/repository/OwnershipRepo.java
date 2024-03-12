package ru.ztt.isbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ztt.isbd.model.Multitool;
import ru.ztt.isbd.model.Ownership;
import ru.ztt.isbd.model.SellObject;
import ru.ztt.isbd.model.Users;

import java.util.List;

public interface OwnershipRepo extends JpaRepository<Ownership, Integer> {
    List<Ownership> findAllByUsersByUserId(Users user);
    Ownership findByUsersByUserIdAndSellObject(Users user, SellObject sellObject);
    Ownership findBySellObject(SellObject sellObject);
}
