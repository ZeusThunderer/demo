package ru.ztt.isbd.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ztt.isbd.model.*;
import ru.ztt.isbd.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpaceshipModelService {

    @Autowired
    private SpaceshipModelRepo spaceshipModelRepository;
    @Autowired
    private SpaceshipRepo spaceshipRepo;
    @Autowired
    private SellObjectRepo sellObjectRepo;
    @Autowired
    private  RequestRepo requestRepo;

    public List<SpaceshipModel> getAllSpaceshipModels() {
        return spaceshipModelRepository.findAll();
    }

    public SpaceshipModel getSpaceshipModelById(Integer id) {
        return spaceshipModelRepository.findById(id).orElse(null);
    }

    public SpaceshipModel saveSpaceshipModel(SpaceshipModel spaceshipModel) {
        return spaceshipModelRepository.save(spaceshipModel);
    }
    public Spaceship saveSpaceship(Spaceship spaceship) {
        return spaceshipRepo.save(spaceship);
    }
    public Request saveRequest(Request request) {
        return requestRepo.save(request);
    }

    public void deleteSpaceshipModel(Integer id) {
        spaceshipModelRepository.deleteById(id);
    }


    public SellObject getSellObjectByReferenceIdAndType(String type,Integer id){
        return sellObjectRepo.findByObjTypeAndAndReferenceId(type, id);
    }
    public Request getRequestByReferenceIdAndType(String type,Integer id){
        return requestRepo.findByObjTypeAndRequestObjectId(type, id);
    }
    public  List<Spaceship> getSpaceshipsFromSellObjects(List<SellObject> sellObjects){
        List<Spaceship> spaceships = new ArrayList<>();
        for (SellObject sellObject: sellObjects){
            spaceships.add(spaceshipRepo.getReferenceById(sellObject.getReferenceId()));
        }
        return  spaceships;
    }
    public  List<Spaceship> getSpaceshipsFromRequest(List<Request> requests){
        List<Spaceship> spaceships = new ArrayList<>();
        for (Request request: requests){
            spaceships.add(spaceshipRepo.getReferenceById(request.getRequestObjectId()));
        }
        return  spaceships;
    }
    public List<SellObject> getSpaceshipModelByIdForSell(Integer id) {
        List<Spaceship> spaceships= spaceshipRepo.findAllBySpaceshipModel(spaceshipModelRepository.findSpaceshipModelById(id));
        List<SellObject> sellObjects = new ArrayList<>();
        for (Spaceship spaceship: spaceships) {
            SellObject temp = sellObjectRepo.findByObjTypeAndAndReferenceId("SHIP",spaceship.getId());
            if (temp != null) {
                sellObjects.add(temp);
            }
        }
        return  sellObjects;
    }
    public List<Request> getSpaceshipModelByIdForRequest(Integer id) {
        List<Spaceship> spaceships= spaceshipRepo.findAllBySpaceshipModel(spaceshipModelRepository.findSpaceshipModelById(id));
        List<Request> requests= new ArrayList<>();
        for (Spaceship spaceship: spaceships) {
            Request temp = requestRepo.findByObjTypeAndRequestObjectId("SHIP",spaceship.getId());
            if (temp != null) {
                requests.add(temp);
            }
        }
        return  requests;
    }

    // Дополнительные методы, если необходимо, например, для бизнес-логики

}

