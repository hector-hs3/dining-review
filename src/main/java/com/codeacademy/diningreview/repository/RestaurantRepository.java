package com.codeacademy.diningreview.repository;

import com.codeacademy.diningreview.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
  
}
