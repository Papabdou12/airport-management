package com.saraya.airplane_typeservice.controller;


import com.saraya.airplane_typeservice.model.AirplaneType;
import com.saraya.airplane_typeservice.service.AirplaneTypeService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airplaneTypes")
public class AirplaneTypeController {
    @Autowired
    private final AirplaneTypeService service;

    public AirplaneTypeController(AirplaneTypeService service) {
        this.service = service;
    }

@GetMapping("/")
    public List<AirplaneType> getAll(){
        return service.getAll();

    }

    @GetMapping("/{airplane_type_identifier}")
    public Long getByAirplaneType( @PathVariable String airplane_type_identifier){
        return service.getByAirplaneType( airplane_type_identifier);
    }
@PostMapping("/")
    public AirplaneType save(@RequestBody AirplaneType airplaneType){
        return service.create(airplaneType);
    }
@PutMapping("/")
    public AirplaneType update(@RequestBody AirplaneType airplaneType){
        return service.update(airplaneType);
    }
@DeleteMapping("/{airplane_type_id}")
    public void deleteById(@PathVariable Long  airplane_type_id){
        service.deleteById(airplane_type_id);
    }

}
