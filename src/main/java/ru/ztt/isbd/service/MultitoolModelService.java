package ru.ztt.isbd.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ztt.isbd.model.*;
import ru.ztt.isbd.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class MultitoolModelService {

    @Autowired
    private MultitoolModelRepo multitoolModelRepository;
    @Autowired
    private MultitoolRepo multitoolRepo;
    @Autowired
    private SellObjectRepo sellObjectRepo;
    @Autowired
    private  RequestRepo requestRepo;

    public List<MultitoolModel> getAllMultitoolModels() {
        return multitoolModelRepository.findAll();
    }

    public MultitoolModel getMultitoolModelById(Integer id) {
        return multitoolModelRepository.findById(id).orElse(null);
    }

    public MultitoolModel saveMultitoolModel(MultitoolModel multitoolModel) {
        return multitoolModelRepository.save(multitoolModel);
    }
    public Multitool saveMultitool(Multitool multitool) {
        return multitoolRepo.save(multitool);
    }
    public Request saveRequest(Request request) {
        return requestRepo.save(request);
    }

    public void deleteMultitoolModel(Integer id) {
        multitoolModelRepository.deleteById(id);
    }


    public SellObject getSellObjectByReferenceIdAndType(String type,Integer id){
        return sellObjectRepo.findByObjTypeAndAndReferenceId(type, id);
    }
    public Request getRequestByReferenceIdAndType(String type,Integer id){
        return requestRepo.findByObjTypeAndRequestObjectId(type, id);
    }
    public  List<Multitool> getMultitoolsFromSellObjects(List<SellObject> sellObjects){
        List<Multitool> multitools = new ArrayList<>();
        for (SellObject sellObject: sellObjects){
            multitools.add(multitoolRepo.getReferenceById(sellObject.getReferenceId()));
        }
        return  multitools;
    }
    public  List<Multitool> getMultitoolsFromRequest(List<Request> requests){
        List<Multitool> multitools = new ArrayList<>();
        for (Request request: requests){
            multitools.add(multitoolRepo.getReferenceById(request.getRequestObjectId()));
        }
        return  multitools;
    }
    public List<SellObject> getMultitoolModelByIdForSell(Integer id) {
        List<Multitool> multitools= multitoolRepo.findAllByMultitoolModel(multitoolModelRepository.findMultitoolModelById(id));
        List<SellObject> sellObjects = new ArrayList<>();
        for (Multitool multitool: multitools) {
            SellObject temp = sellObjectRepo.findByObjTypeAndAndReferenceId("TOOL",multitool.getId());
            if (temp != null) {
                sellObjects.add(temp);
            }
        }
        return  sellObjects;
    }
    public List<Request> getMultitoolModelByIdForRequest(Integer id) {
        List<Multitool> multitools= multitoolRepo.findAllByMultitoolModel(multitoolModelRepository.findMultitoolModelById(id));
        List<Request> requests= new ArrayList<>();
        for (Multitool multitool: multitools) {
            Request temp = requestRepo.findByObjTypeAndRequestObjectId("TOOL",multitool.getId());
            if (temp != null) {
                requests.add(temp);
            }
        }
        return  requests;
    }

    // Дополнительные методы, если необходимо, например, для бизнес-логики

}

