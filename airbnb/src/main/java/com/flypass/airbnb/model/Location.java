package com.flypass.airbnb.model;

import com.flypass.airbnb.general.util.BooleanToStringConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "tfps_ubicaciones")
@Data
public class Location {

    @Id
    @Column(name = "cdubicacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dsubicacion")
    private String location;

    @Column(name = "vrminimo_alquiler")
    private BigDecimal minRental;


    @Convert(converter = BooleanToStringConverter.class)
    @Column(name = "snobligatorio")
    private Boolean mandatory;

    public Location(){
    }
    public Location(Long id){
        this.id = id;
    }
}
