package com.flypass.airbnb.rest;

import com.flypass.airbnb.dto.HouseDTO;
import com.flypass.airbnb.general.exception.AirBnbException;
import com.flypass.airbnb.general.util.Constants;
import com.flypass.airbnb.general.util.ResponseObject;
import com.flypass.airbnb.model.House;
import com.flypass.airbnb.service.HouseService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/houses")
public class HouseRest {

    @Autowired
    private HouseService houseService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ResponseObject<HouseDTO>> saveHouse(@RequestBody HouseDTO houseDTO) {
        try {
            houseService.saveHouses(houseDTO);
            return new ResponseEntity<>(new ResponseObject<>(houseDTO, HttpStatus.ACCEPTED, Constants.SUCESS), HttpStatus.ACCEPTED);
        } catch (AirBnbException e) {
            return new ResponseEntity<>(new ResponseObject<>(null, HttpStatus.BAD_REQUEST, e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseObject<>(null, HttpStatus.BAD_REQUEST, Constants.ERROR), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, params = {"minAmount", "maxAmount"})
    public ResponseObject<List<House>> getHouses (@RequestParam BigDecimal minAmount, @RequestParam BigDecimal maxAmount){
        List<House> houses = houseService.houseQuery(minAmount, maxAmount);
        if(!houses.isEmpty()){
            return new ResponseObject<> (houses, HttpStatus.ACCEPTED, Constants.SUCESS);
        }
        return new ResponseObject<> (houses, HttpStatus.NO_CONTENT, HttpStatus.NO_CONTENT.name());
    }
}
