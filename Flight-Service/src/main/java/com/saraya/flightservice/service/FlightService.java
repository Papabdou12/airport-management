package com.saraya.flightservice.service;


import com.saraya.flightservice.model.Flight;
import com.saraya.flightservice.model.FlightDto;
import com.saraya.flightservice.repo.FlightRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@Transactional
public class FlightService {


    private final FlightRepository repository;


    public FlightService(FlightRepository repository ) {
        this.repository = repository;
    }


    public List<Flight> getAll(){
        return repository.findAll();

    }

    public  Long getFlightById(Long flight_id) {
        return repository.getFlightById(flight_id);

    }



    public Flight create(FlightDto dto){
        Flight flight = new Flight();
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("seat", dto.getSeat());
        urlValues.put("price", String.valueOf(dto.getPrice()));

        Long booking_id = template.getForEntity("localhost:8200/bookings/seat/price/{seat}/{price}",
                Long.class, urlValues).getBody();

        changeToModel(dto, flight);
        flight.setBooking_id(booking_id);
        return repository.save(flight);
    }

    public Flight update(FlightDto dto){
        Flight flight = new Flight();
        flight.setFlight_id(dto.getFlight_id());
        changeToModel(dto, flight);
        return repository.save(flight);
    }


    public List <Flight> getFlightsByBooking(String seat, int price) {
        Map<String, String> values = new HashMap<>();
        values.put("seat", seat);
        values.put(String.valueOf(price), String.valueOf(price));

        RestTemplate template = new RestTemplate();
        Long booking_id = template.getForEntity("localhost:8200/bookings/seat/price/{seat}/{price}",
                Long.class, values).getBody();

        return repository.findBooking_id(booking_id);
    }
    private static void changeToModel(FlightDto dto, Flight flight) {
        flight.setFlight_no(dto.getFlight_no());
        flight.setDeparture_date(LocalDate.parse(dto.getDeparture_date()));
        flight.setArrival_date(LocalDate.parse(dto.getArrival_date()));
        flight.setArrival_date(LocalDate.parse(dto.getArrival_date()));
        flight.setFrom(LocalTime.parse(dto.getFrom()));
        flight.setTo(LocalTime.parse(dto.getTo()));

    }

    public void deleteById(Long flight_id ){
        repository.deleteById(flight_id);
    }
}
