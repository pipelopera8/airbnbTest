package com.flypass.airbnb.service;

import com.flypass.airbnb.dto.HouseDTO;
import com.flypass.airbnb.general.exception.AirBnbException;
import com.flypass.airbnb.general.util.Constants;
import com.flypass.airbnb.model.House;
import com.flypass.airbnb.model.Location;
import com.flypass.airbnb.respository.HouseRepository;
import com.flypass.airbnb.respository.LocationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getLocations (){
        return (List<Location>) locationRepository.findAll();
    }

}
