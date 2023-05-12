package com.saraya.airplane_typeservice.service;


import com.saraya.airplane_typeservice.model.AirplaneType;
import com.saraya.airplane_typeservice.repo.AirplaneTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AirplaneTypeService {
    @Autowired
    private final AirplaneTypeRepo repo;

    public AirplaneTypeService(AirplaneTypeRepo repo) {
        this.repo = repo;
    }

    public List<AirplaneType> getAll(){
        return repo.findAll();

    }

    public Long getByAirplaneType(String airplane_type_identifier){
       return repo.getAirplaneTypes( airplane_type_identifier);
    }

    public AirplaneType create(AirplaneType airplaneType){
        return repo.save(airplaneType);
    }

    public AirplaneType update(AirplaneType airplaneType){
        return repo.save(airplaneType);
    }

    public void deleteById(Long  airplane_type_id){
        repo.deleteById(airplane_type_id);
    }

}
