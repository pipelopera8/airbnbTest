package com.flypass.airbnb.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LocationDTO {

    private Long id;
    private String location;
    private BigDecimal minRental;
    private Boolean mandatory;

}
