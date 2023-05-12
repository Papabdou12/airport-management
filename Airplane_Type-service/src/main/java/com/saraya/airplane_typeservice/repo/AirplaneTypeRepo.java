package com.saraya.airplane_typeservice.repo;

import com.saraya.airplane_typeservice.model.AirplaneType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
public interface AirplaneTypeRepo extends JpaRepository<AirplaneType,Long> {

    @Query("select a.airplane_type_id  from AirplaneType a where a.airplane_type_identifier=:airplane_type_identifier")

    Long getAirplaneTypes( String airplane_type_identifier);
}
