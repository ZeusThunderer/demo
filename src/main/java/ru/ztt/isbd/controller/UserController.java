package ru.ztt.isbd.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ztt.isbd.model.Ownership;
import ru.ztt.isbd.model.Users;
import ru.ztt.isbd.repository.OwnershipRepo;
import ru.ztt.isbd.service.OwnershipService;
import ru.ztt.isbd.service.UsersService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private OwnershipService ownershipService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Возвращает шаблон страницы, содержащий форму входа
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String login, Model model, HttpSession session) {
        Users userFound = usersService.getUserByLogin(login);
        if (userFound != null) {
            System.out.println(userFound.getLogin());
            session.setAttribute("user",userFound);
            return "redirect:/home"; // Если пользователь найден, перенаправляем на страницу успешной авторизации
        } else {
            model.addAttribute("notFoundMessage", "Пользователь с таким логином не найден");
            return "login"; // Если пользователь не найден, возвращаем обратно на страницу входа
        }
    }
    @GetMapping("/user")
    public String userPage( Model model, HttpSession session){
        List<Ownership> ownerships = ownershipService.getOwnershipByUser((Users) session.getAttribute("user")) ;
        model.addAttribute("ownerships", ownerships);
        return "user";
    }
    @GetMapping("/logout")
    public String logOut(Model model, HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @PostMapping("/money")
    public String addMoney(@RequestParam Integer money, Model model, HttpSession session){
        Users user = (Users) session.getAttribute("user");
        if (money == null)
            money = 0;
        user.setBalance(user.getBalance()+money);
        usersService.saveUser(user);
        session.setAttribute("user", user);
        return "user";
    }
}
