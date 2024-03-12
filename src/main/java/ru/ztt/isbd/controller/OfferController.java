package ru.ztt.isbd.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ztt.isbd.model.SellObject;
import ru.ztt.isbd.model.Users;
import ru.ztt.isbd.service.MultitoolModelService;
import ru.ztt.isbd.service.OwnershipService;
import ru.ztt.isbd.service.SpaceshipModelService;
import ru.ztt.isbd.service.UsersService;

@Controller
public class OfferController {
    @Autowired
    private MultitoolModelService multitoolModelService;
    @Autowired
    private SpaceshipModelService spaceshipModelService;
    @Autowired
    private UsersService usersService;

    @Autowired
    private OwnershipService ownershipService;

    @GetMapping("/market/buy")
    public String buyItem(@RequestParam String type, @RequestParam Integer id, Model model, HttpSession session){
        Users users = (Users) session.getAttribute("user");
        SellObject sellObject;
        if (type == "TOOL")
            sellObject = multitoolModelService.getSellObjectByReferenceIdAndType(type, id);
        else
            sellObject = spaceshipModelService.getSellObjectByReferenceIdAndType(type, id);
        if (users == null || sellObject == null){
            model.addAttribute("notFoundMessage","Not found");
            return "/error";
        }
        if (sellObject.getCost() < users.getBalance() && sellObject.getUsersByUserId().getId() != users.getId()){
            users.setBalance(users.getBalance() - sellObject.getCost());
            ownershipService.saveOwnership(users,sellObject);
            usersService.saveUser(users);
        }
        else if (sellObject.getCost() > users.getBalance()) {
            model.addAttribute("notFoundMessage", "Not enough balance");
            return "/error";
        }
        else {
            model.addAttribute("notFoundMessage", "You cannot buy your own offers");
            return "/error";
        }
        return "redirect:/user";
    }
}
