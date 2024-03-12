package ru.ztt.isbd.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ztt.isbd.model.SModule;
import ru.ztt.isbd.repository.SModuleRepo;

import java.util.List;

@Service
public class SModuleService {

    @Autowired
    private SModuleRepo sModuleRepository;

    public List<SModule> getAllSModules() {
        return sModuleRepository.findAll();
    }

    public SModule getSModuleById(Integer id) {
        return sModuleRepository.findById(id).orElse(null);
    }

    public SModule saveSModule(SModule sModule) {
        return sModuleRepository.save(sModule);
    }

    public void deleteSModule(Integer id) {
        sModuleRepository.deleteById(id);
    }



    // Дополнительные методы, если необходимо, например, для бизнес-логики
}
