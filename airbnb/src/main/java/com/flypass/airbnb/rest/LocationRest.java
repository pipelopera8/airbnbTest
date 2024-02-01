package com.flypass.airbnb.rest;

import com.flypass.airbnb.general.util.Constants;
import com.flypass.airbnb.general.util.ResponseObject;
import com.flypass.airbnb.model.Location;
import com.flypass.airbnb.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationRest {

    @Autowired
    private LocationService locationService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseObject<List<Location>> getLocations (){
        List<Location> locations = locationService.getLocations();
        if(!locations.isEmpty()){
            return new ResponseObject<> (locations, HttpStatus.ACCEPTED, Constants.SUCESS);
        }
        return new ResponseObject<> (locations, HttpStatus.NO_CONTENT, HttpStatus.NO_CONTENT.name());
    }
}
