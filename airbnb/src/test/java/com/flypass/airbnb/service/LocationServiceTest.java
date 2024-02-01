package com.flypass.airbnb.service;

import com.flypass.airbnb.dto.HouseDTO;
import com.flypass.airbnb.dto.LocationDTO;
import com.flypass.airbnb.general.Enum.EnumStatusHouse;
import com.flypass.airbnb.general.exception.AirBnbException;
import com.flypass.airbnb.general.util.Constants;
import com.flypass.airbnb.model.House;
import com.flypass.airbnb.model.Location;
import com.flypass.airbnb.respository.HouseRepository;
import com.flypass.airbnb.respository.LocationRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
public class LocationServiceTest {

    @Mock
    private LocationRepository locationRepository;

    @InjectMocks
    private LocationService locationService;

    @Test
    public void QueryOK(){
        Location location = new Location();
        location.setId(1L);
        List<Location> locations = new ArrayList<>();

        Mockito.when(locationRepository.findAll()).thenReturn(locations);
        Assert.assertNotNull(locationService.getLocations());
    }

}