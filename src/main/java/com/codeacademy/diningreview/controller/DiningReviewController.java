package com.codeacademy.diningreview.controller;

import java.util.Optional;

import com.codeacademy.diningreview.model.User;
import com.codeacademy.diningreview.repository.RestaurantRepository;
import com.codeacademy.diningreview.repository.ReviewRepository;
import com.codeacademy.diningreview.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DiningReviewController {
  
  private final UserRepository userRepo;
  private final ReviewRepository reviewRepo;
  private final RestaurantRepository restaurantRepo;

  public DiningReviewController(
    final UserRepository userRepository, 
    final ReviewRepository reviewRepository, 
    final RestaurantRepository restaurantRepository) {

    this.userRepo = userRepository;
    this.reviewRepo = reviewRepository;
    this.restaurantRepo = restaurantRepository;
  }

  @GetMapping("/user/{userName}")
  @ResponseBody
  public User getUserProfile(@PathVariable("userName") String userName) {
    Optional<User> userOptional = userRepo.findByName(userName);

    if(userOptional.isPresent()) {
      return userOptional.get();

    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }
  }


}
