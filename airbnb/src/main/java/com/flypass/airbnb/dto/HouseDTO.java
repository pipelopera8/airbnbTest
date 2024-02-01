package com.flypass.airbnb.dto;

import com.flypass.airbnb.general.Enum.EnumStatusHouse;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class HouseDTO {

    private Long id;
    private String name;
    private LocationDTO location;
    private EnumStatusHouse status;
    private String image;
    private BigDecimal amount;

}
