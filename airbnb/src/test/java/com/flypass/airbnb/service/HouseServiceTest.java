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
public class HouseServiceTest {

    @Mock
    private HouseRepository houseRepository;

    @Mock
    private LocationRepository locationRepository;

    @InjectMocks
    private HouseService houseService;

    @Test
    public void saveHouseOK() throws Exception {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(1L);
        locationDTO.setMandatory(true);
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setId(null);
        houseDTO.setName("prueba");
        houseDTO.setAmount(new BigDecimal(30000000));
        houseDTO.setStatus(EnumStatusHouse.ACTIVE);
        houseDTO.setLocation(locationDTO);
        houseDTO.setImage("fasdfasd");

        Location location = new Location(houseDTO.getLocation().getId());
        location.setId(1L);
        location.setMandatory(true);
        location.setMinRental(new BigDecimal(20000));
        Mockito.when(locationRepository.findById(1L)).thenReturn(Optional.of(location));

        Assert.assertNotNull(houseService.saveHouses(houseDTO));
    }


    @Test
    public void saveHouseFailForLocationNull() throws Exception {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(1L);
        locationDTO.setMandatory(true);
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setId(null);
        houseDTO.setName("prueba1");
        houseDTO.setAmount(new BigDecimal(30000000));
        houseDTO.setStatus(EnumStatusHouse.ACTIVE);
        houseDTO.setLocation(locationDTO);
        houseDTO.setImage("fasdfasd");

        Location location = new Location(houseDTO.getLocation().getId());
        location.setMandatory(true);
        location.setMinRental(new BigDecimal(100));
        Mockito.when(locationRepository.findById(1L)).thenReturn(Optional.of(location));

        Mockito.when(houseRepository.findByName(houseDTO.getName())).thenReturn(null);

        try{
            houseService.saveHouses(houseDTO);
        } catch (AirBnbException e){
            Assert.assertEquals(e.getMessage(), Constants.VALIDATE_HOUSE_LOCALE);
        }
    }

    @Test
    public void saveHouseFailAmountZero() throws Exception {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setAmount(new BigDecimal(-1));
        try{
            houseService.saveHouses(houseDTO);
        } catch (AirBnbException e){
            Assert.assertEquals(e.getMessage(), Constants.VALIDATE_HOUSE_POSITIVE_AMOUNT);
        }
    }


    @Test
    public void saveHouseFailForLocationMandatory() throws Exception {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(1L);
        locationDTO.setMandatory(true);
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setId(null);
        houseDTO.setName("prueba1");
        houseDTO.setAmount(new BigDecimal(30000000));
        houseDTO.setStatus(EnumStatusHouse.ACTIVE);
        houseDTO.setLocation(locationDTO);
        houseDTO.setImage("fasdfasd");

        Location location = new Location(houseDTO.getLocation().getId());
        location.setMandatory(false);
        location.setMinRental(new BigDecimal(100));
        Mockito.when(locationRepository.findById(1L)).thenReturn(Optional.of(location));

        Mockito.when(houseRepository.findByName(houseDTO.getName())).thenReturn(null);

        try{
            houseService.saveHouses(houseDTO);
        } catch (AirBnbException e){
            Assert.assertEquals(e.getMessage(), Constants.VALIDATE_HOUSE_LOCALE);
        }
    }


    @Test
    public void saveHouseFailForLocationMinRental() throws Exception {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(1L);
        locationDTO.setMandatory(true);
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setId(null);
        houseDTO.setName("prueba1");
        houseDTO.setAmount(new BigDecimal(100000));
        houseDTO.setStatus(EnumStatusHouse.ACTIVE);
        houseDTO.setLocation(locationDTO);
        houseDTO.setImage("fasdfasd");

        Location location = new Location(houseDTO.getLocation().getId());
        location.setMandatory(true);
        location.setMinRental(new BigDecimal(200000));
        Mockito.when(locationRepository.findById(1L)).thenReturn(Optional.of(location));

        Mockito.when(houseRepository.findByName(houseDTO.getName())).thenReturn(null);

        try{
            houseService.saveHouses(houseDTO);
        } catch (AirBnbException e){
            Assert.assertEquals(e.getMessage(), Constants.VALIDATE_HOUSE_MIN_RENTAL + location.getMinRental());
        }
    }

    @Test
    public void saveHouseFailForHouseName() throws Exception {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(1L);
        locationDTO.setMandatory(true);
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setId(null);
        houseDTO.setName("prueba");
        houseDTO.setAmount(new BigDecimal(30000000));
        houseDTO.setStatus(EnumStatusHouse.ACTIVE);
        houseDTO.setLocation(locationDTO);
        houseDTO.setImage("fasdfasd");

        Location location = new Location(houseDTO.getLocation().getId());
        location.setId(1L);
        location.setMandatory(true);
        location.setMinRental(new BigDecimal(20000));
        Mockito.when(locationRepository.findById(1L)).thenReturn(Optional.of(location));

        House house = new House();
        house.setName("prueba");
        Mockito.when(houseRepository.findByName(houseDTO.getName())).thenReturn(house);

        try{
            houseService.saveHouses(houseDTO);
        } catch (AirBnbException e){
            Assert.assertEquals(e.getMessage(), Constants.VALIDATE_HOUSE_NAME);
        }
    }

    @Test
    public void QueryOK(){
        House house = new House();
        house.setId(1L);
        List<House> houses = new ArrayList<>();

        Mockito.when(houseRepository.findByAmountGreaterThanOrAmountLessThan(new BigDecimal(1000), new BigDecimal(1000))).thenReturn(houses);

        Assert.assertNotNull(houseService.houseQuery(new BigDecimal(1000), new BigDecimal(1000)));
    }

    @Test
    public void QueryEmpty(){
        Mockito.when(houseRepository.findByAmountGreaterThanOrAmountLessThan(new BigDecimal(1000), new BigDecimal(1000))).thenReturn(null);
        Assert.assertNull(houseService.houseQuery(new BigDecimal(1000), new BigDecimal(1000)));
    }

}