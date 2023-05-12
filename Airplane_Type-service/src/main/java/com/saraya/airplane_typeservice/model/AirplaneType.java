package com.saraya.airplane_typeservice.model;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AirplaneType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airplane_type_id;

    @Column(name = "airplane_type_identifier",unique = true)
   private String airplane_type_identifier;

    private String description;
}
