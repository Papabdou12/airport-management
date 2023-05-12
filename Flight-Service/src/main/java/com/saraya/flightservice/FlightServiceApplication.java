package com.saraya.flightservice;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class FlightServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightServiceApplication.class, args);
    }

    @Bean

 public  ModelMapper getModel(){
        ModelMapper mapper = new ModelMapper();
        Converter<String, LocalDate> converter= mappingContext -> LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd,MM,yyyy"));
        mapper.addConverter(converter);

        Converter<String, LocalTime> converter1 = mappingContext -> LocalTime.parse(mappingContext.getSource(),DateTimeFormatter.ofPattern("HH,mm,ss"));
        mapper.addConverter(converter1);
        return mapper;
    }
}
