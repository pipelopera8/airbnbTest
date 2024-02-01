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
public class HouseService {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private LocationRepository locationRepository;

    public HouseDTO saveHouses(HouseDTO houseDTO) throws AirBnbException, Exception {
        House house = new House();
        validateHouse(houseDTO);
        BeanUtils.copyProperties(houseDTO, house);
        house.setLocation(new Location(houseDTO.getLocation().getId()));
        houseRepository.save(house);
        return houseDTO;
    }

    private void validateHouse (HouseDTO houseDTO) throws AirBnbException{
        if (BigDecimal.ZERO.compareTo(houseDTO.getAmount()) > 0){
            throw new AirBnbException(Constants.VALIDATE_HOUSE_POSITIVE_AMOUNT);
        }
        House houseOld = houseRepository.findByName(houseDTO.getName());
        if(houseOld != null){
            throw new AirBnbException(Constants.VALIDATE_HOUSE_NAME);
        }
        Location location = locationRepository.findById(houseDTO.getLocation().getId()).orElse(null);
        if(location == null || !location.getMandatory()){
            throw new AirBnbException(Constants.VALIDATE_HOUSE_LOCALE);
        } else {
            if(location.getMinRental().compareTo(houseDTO.getAmount()) > 0){
                throw new AirBnbException(Constants.VALIDATE_HOUSE_MIN_RENTAL + location.getMinRental());
            }
        }
    }

    public List<House> houseQuery (BigDecimal minAmount, BigDecimal maxAmount){
        return houseRepository.findByAmountGreaterThanOrAmountLessThan(minAmount, maxAmount);
    }

}
