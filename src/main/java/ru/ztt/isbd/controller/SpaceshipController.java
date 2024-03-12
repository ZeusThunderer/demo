package ru.ztt.isbd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ztt.isbd.model.Spaceship;
import ru.ztt.isbd.model.SpaceshipModel;
import ru.ztt.isbd.model.Request;
import ru.ztt.isbd.model.SellObject;
import ru.ztt.isbd.service.SpaceshipModelService;

import java.util.List;

@Controller
@RequestMapping("/spaceshipmodels")
public class SpaceshipController {

    @Autowired
    private SpaceshipModelService spaceshipModelService;

    @GetMapping
    public String getAllSpaceshipModels(Model model) {
        List<SpaceshipModel> spaceshipModels = spaceshipModelService.getAllSpaceshipModels();
        model.addAttribute("spaceshipModels", spaceshipModels);
        System.out.println(spaceshipModels.get(0).getShipName());
        return "spaceshipmodels/list";
    }
    @GetMapping("/spaceships")
    public  String getAllSpaceships(@RequestParam Integer id, Model model){
        List<SellObject> sellObjects_spaceships =  spaceshipModelService.getSpaceshipModelByIdForSell(id);
        List<Spaceship> spaceships= spaceshipModelService.getSpaceshipsFromSellObjects(sellObjects_spaceships);
        model.addAttribute("spaceships", spaceships);
        model.addAttribute("sellObjects", sellObjects_spaceships);
        List<Request> requests =  spaceshipModelService.getSpaceshipModelByIdForRequest(id);
        List<Spaceship> spaceships_for_requsets= spaceshipModelService.getSpaceshipsFromRequest(requests);
        model.addAttribute("spaceships_for_request", spaceships_for_requsets);
        model.addAttribute("requests", requests);
        SpaceshipModel spaceshipModel = spaceshipModelService.getSpaceshipModelById(id);
        model.addAttribute("model",spaceshipModel);
        return "spaceshipmodels/spaceships";
    }


}