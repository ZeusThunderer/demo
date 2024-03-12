package ru.ztt.isbd.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ztt.isbd.model.Information;
import ru.ztt.isbd.repository.InformationRepo;

import java.util.List;

@Service
public class InformationService {

    @Autowired
    private InformationRepo informationRepository;
    //suu
    public List<Information> getAllInformation() {
        return informationRepository.findAll();
    }

    public Information getInformationById(Integer id) {
        return informationRepository.findById(id).orElse(null);
    }

    public Information saveInformation(Information information) {
        return informationRepository.save(information);
    }

    public void deleteInformation(Integer id) {
        informationRepository.deleteById(id);
    }

    // Дополнительные методы, если необходимо, например, для бизнес-логики
}

