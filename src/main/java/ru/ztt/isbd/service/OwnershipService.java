package ru.ztt.isbd.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ztt.isbd.model.Ownership;
import ru.ztt.isbd.model.SellObject;
import ru.ztt.isbd.model.Users;
import ru.ztt.isbd.repository.OwnershipRepo;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class OwnershipService {
    @Autowired
    private OwnershipRepo ownershipRepo;

    public  void deleteByUser(Integer id){
        ownershipRepo.deleteById(id);
    }

    public Ownership getOwnershipByUserAndRefId(Users user, SellObject sellObject){
        return ownershipRepo.findByUsersByUserIdAndSellObject(user, sellObject);
    }
    public void saveOwnership(Users user, SellObject sellObject){
        Ownership ownership = new Ownership();
        ownership.setUsersByUserId(user);
        ownership.setSellObject(sellObject);
        ownership.setOwnDate(LocalDateTime.now());
        ownershipRepo.save(ownership);
    }
    public List<Ownership> getOwnershipByUser(Users users){
        return ownershipRepo.findAllByUsersByUserId(users);
    }

    public  Ownership findOwnershipBySellObject(SellObject sellObject){
        return  ownershipRepo.findBySellObject(sellObject);
    }
}
