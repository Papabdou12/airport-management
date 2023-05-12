package com.saraya.flightservice.controller;

import com.saraya.flightservice.model.Flight;
import com.saraya.flightservice.model.FlightDto;
import com.saraya.flightservice.service.FlightService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/flights")
public class FlightController {

    private  final FlightService service;

    private  final ModelMapper mapper;


    public FlightController(FlightService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

@GetMapping("/")
    public List<Flight> getAll(){
        return service.getAll();

    }
    @GetMapping("/{flight_id}")
    public  Long getFlightById(@PathVariable Long flight_id) {
        return service.getFlightById(flight_id);

    }

    @PostMapping("/")
    public Flight create(@RequestBody Flight flight){
      FlightDto dto= mapper.map(flight, FlightDto.class);
        return service.create(dto);
    }
    @PutMapping("/")
    public Flight update(@RequestBody FlightDto dto){
      return service.update(dto);
    }

    @PostMapping("/seat/price/{seat}/{price}/bookings")
    public List <Flight> getFlightsByBooking(@PathVariable String seat,@PathVariable int price) {


        return service.getFlightsByBooking(seat,price);
    }

@DeleteMapping("/{flight_id}")
    public void deleteById(@PathVariable Long flight_id ){
        service.deleteById(flight_id);
    }
}
