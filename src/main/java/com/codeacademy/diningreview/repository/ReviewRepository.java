package com.codeacademy.diningreview.repository;

import java.util.List;

import com.codeacademy.diningreview.model.Review;
import com.codeacademy.diningreview.utils.Status;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
  List<Review> findByStatus(Status status);
  List<Review> findByRestaurantIdAndStatus(Long restaurantId, Status status);
}
