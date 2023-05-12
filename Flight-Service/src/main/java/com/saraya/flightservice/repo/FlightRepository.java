package com.saraya.flightservice.repo;

import com.saraya.flightservice.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

    @Query("select f.flight_id from Flight f where f.flight_id=?1")
    Long getFlightById(Long flight_id);

    List<Flight> findBooking_id(Long booking_id);
}
