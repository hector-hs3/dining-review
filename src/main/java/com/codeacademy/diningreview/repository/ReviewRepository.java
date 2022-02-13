package com.codeacademy.diningreview.repository;

import com.codeacademy.diningreview.model.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
  
}
