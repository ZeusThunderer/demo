package ru.ztt.isbd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ztt.isbd.model.*;
import ru.ztt.isbd.service.MultitoolModelService;

import java.util.List;

@Controller
@RequestMapping("/multitoolmodels")
public class MultitoolController {

    @Autowired
    private MultitoolModelService multitoolModelService;

    @GetMapping
    public String getAllMultitoolModels(Model model) {
        List<MultitoolModel> multitoolModels = multitoolModelService.getAllMultitoolModels();
        model.addAttribute("multitoolModels", multitoolModels);
        return "multitoolmodels/list";
    }
    @GetMapping("/multitools")
    public  String getAllMultitools(@RequestParam Integer id, Model model){
        List<SellObject> sellObjects_multitools =  multitoolModelService.getMultitoolModelByIdForSell(id);
        List<Multitool> multitools= multitoolModelService.getMultitoolsFromSellObjects(sellObjects_multitools);
        model.addAttribute("multitools", multitools);
        model.addAttribute("sellObjects", sellObjects_multitools);
        List<Request> requests =  multitoolModelService.getMultitoolModelByIdForRequest(id);
        List<Multitool> multitools_for_requsets= multitoolModelService.getMultitoolsFromRequest(requests);
        model.addAttribute("multitools_for_request", multitools_for_requsets);
        model.addAttribute("requests", requests);
        MultitoolModel multitoolModel = multitoolModelService.getMultitoolModelById(id);
        model.addAttribute("model",multitoolModel);
        return "multitoolmodels/multitools";
    }


}