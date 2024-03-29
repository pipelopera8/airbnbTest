package com.flypass.airbnb.respository;

import com.flypass.airbnb.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository  extends CrudRepository<Location, Long> {


}
