package com.flypass.airbnb.respository;

import com.flypass.airbnb.model.House;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface HouseRepository extends CrudRepository<House, Long> {

    House findByName(String name);

    List<House> findByAmountGreaterThanOrAmountLessThan(BigDecimal amountMin, BigDecimal amountMax);

}
