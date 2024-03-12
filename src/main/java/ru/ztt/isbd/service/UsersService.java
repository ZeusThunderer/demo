package ru.ztt.isbd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ztt.isbd.model.Users;
import ru.ztt.isbd.repository.UsersRepo;

@Service
public class UsersService {
    @Autowired
    private UsersRepo usersRepo;

    public Users getUserByLogin(String str){
        return usersRepo.findUsersByLogin(str);
    }
    public Users saveUser(Users user){
        return usersRepo.save(user);
    }
}
