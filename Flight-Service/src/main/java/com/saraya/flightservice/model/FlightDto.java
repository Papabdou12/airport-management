package com.saraya.flightservice.model;

import lombok.Data;


@Data
public class FlightDto {

    private Long  flight_id;
    private Integer  flight_no;
    private String departure_date;
    private String arrival_date;
    private String from;
    private String to;
    private String seat;
    private int price;
}
