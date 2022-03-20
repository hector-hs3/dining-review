package com.codeacademy.diningreview.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.codeacademy.diningreview.model.User;
import com.codeacademy.diningreview.repository.RestaurantRepository;
import com.codeacademy.diningreview.repository.ReviewRepository;
import com.codeacademy.diningreview.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DiningReviewController {
  
  Logger logger = LoggerFactory.getLogger(DiningReviewController.class);

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

  @GetMapping("/ping")
  public String ping() {
    return "pong";
  }

  @GetMapping("/user/{userName}")
  public User getUserProfile(@PathVariable("userName") String userName) {
    Optional<User> uOptional = userRepo.findByName(userName);

    if (uOptional.isPresent()) {
      return uOptional.get();

    } else {
      String msg = "User does not exist: " + userName;
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg);
    }
  }

  @PostMapping("/user")
  @ResponseStatus(code = HttpStatus.CREATED)
  public User createUserProfile(@Valid @RequestBody User user) {
    Optional<User> uOptional = userRepo.findByName(user.getName());

    if (!uOptional.isPresent()) {
      return userRepo.save(user);
    } else {
      String msg = "User already exists: " + user.getName();
      throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, msg);
    }
  }

  @PutMapping("/user/{userName}")
  @ResponseStatus(code = HttpStatus.ACCEPTED)
  public void updateUserProfile(
    @PathVariable("userName") String userName, 
    @Valid @RequestBody User userBody) {

    Optional<User> uOptional = userRepo.findByName(userName);
    if (!uOptional.isPresent()) {
      String msg = "User does not exist: " + userName;
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg);
    }

    if (!userName.equals(userBody.getName())) {
      String msg = "User name cannot be changed: " + userBody.getName();
      throw new ResponseStatusException(HttpStatus.CONFLICT, msg);
    }

    User user = uOptional.get();
    if (!user.getId().equals(userBody.getId())) {
      userBody.setId(user.getId());
    }

    userRepo.save(userBody);    
  } 

}
