package ru.ztt.isbd.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ztt.isbd.model.*;
import ru.ztt.isbd.service.MultitoolModelService;
import ru.ztt.isbd.service.SpaceshipModelService;

@Controller
public class RequestController {
    @Autowired
    private MultitoolModelService multitoolModelService;

    @Autowired
    private SpaceshipModelService spaceshipModelService;

    @GetMapping("/market/request")
    public String getRequestForm(@RequestParam String type, @RequestParam Integer id, Model model, HttpSession session){
        System.out.println(type+ " " + id);
        if (type.equalsIgnoreCase("TOOL")) {
            MultitoolModel multitoolModel = multitoolModelService.getMultitoolModelById(id);
            session.setAttribute("model", multitoolModel);
            session.setAttribute("type", type);
            return "/market/request/req_form_tool";
        }
        else{
            SpaceshipModel spaceshipModel = spaceshipModelService.getSpaceshipModelById(id);
            session.setAttribute("model", spaceshipModel);
            session.setAttribute("type", type);
            System.out.println(session.getAttribute("type"));
            return "/market/request/req_form_ship";
        }
    }

    @PostMapping("/market/request/req_form_ship")
    public String submitRequestShip(@RequestParam String num1,@RequestParam String num2,@RequestParam Integer num3,@RequestParam Float num4, Model model, HttpSession session) {
        System.out.println(num1 + " " + num2 + " " + num3 + " " + num4);
        Spaceship spaceship = new Spaceship();
        spaceship.setColor(num2);
        spaceship.setSpaceshipModel((SpaceshipModel) session.getAttribute("model"));
        spaceship.setSpeed(Integer.valueOf(num1));
        spaceship.setHandling(num4);
        spaceship = spaceshipModelService.saveSpaceship(spaceship);
        Request request = new Request();
        request.setObjType((String) session.getAttribute("type"));
        request.setCost(num3);
        request.setRequestObjectId(spaceship.getId());
        request.setUsersByUserId((Users) session.getAttribute("user"));
        request = multitoolModelService.saveRequest(request);
        return  "/home";
    }
    @PostMapping("/market/request/req_form_tool")
    public String submitRequestTool(@RequestParam String num1,@RequestParam String num2,@RequestParam Integer num3, Model model, HttpSession session) {
        System.out.println(num1 + " " + num2 + " " + num3);
        Multitool multitool = new Multitool();
        multitool.setColor(num2);
        multitool.setMultitoolModel((MultitoolModel) session.getAttribute("model"));
        multitool.setDamage(num1);
        multitool = multitoolModelService.saveMultitool(multitool);
        Request request = new Request();
        request.setObjType((String) session.getAttribute("type"));
        request.setCost(num3);
        request.setRequestObjectId(multitool.getId());
        request.setUsersByUserId((Users) session.getAttribute("user"));
        request = multitoolModelService.saveRequest(request);
        return  "/home";
    }
}
