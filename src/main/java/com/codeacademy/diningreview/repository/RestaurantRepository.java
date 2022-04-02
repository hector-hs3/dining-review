package com.codeacademy.diningreview.repository;

import java.util.List;

import com.codeacademy.diningreview.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
  List<Restaurant> findByNameAndZipcode(String name, Long zipcode);
  List<Restaurant> findByZipcodeAndReviewsGreaterThanOrderByOverallDesc(Long zipcode, Long reviews);
}
