package com.saraya.flightservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Flight {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long  flight_id;
   private Integer  flight_no;
   private LocalDate departure_date;
   private LocalDate arrival_date;
   private LocalTime from;
    private LocalTime to;
   private Long booking_id;


}
