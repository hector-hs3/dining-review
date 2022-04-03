package com.codeacademy.diningreview.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.codeacademy.diningreview.model.AdminReview;
import com.codeacademy.diningreview.model.Restaurant;
import com.codeacademy.diningreview.model.Review;
import com.codeacademy.diningreview.model.User;
import com.codeacademy.diningreview.repository.RestaurantRepository;
import com.codeacademy.diningreview.repository.ReviewRepository;
import com.codeacademy.diningreview.repository.UserRepository;
import com.codeacademy.diningreview.utils.Status;

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

  @PostMapping("/user/{userName}/review")
  @ResponseStatus(code = HttpStatus.CREATED)
  public Review createReview(
    @PathVariable("userName") String userName,
    @Valid @RequestBody Review reviewBody) {

    Optional<User> uOptional = userRepo.findByName(userName);
    if (!uOptional.isPresent()) {
      String msg = "User does not exist: " + userName;
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg);
    }

    Optional<Restaurant> rOptional = restaurantRepo.findById(reviewBody.getRestaurantId());
    if (!rOptional.isPresent()) {
      String msg = "Restaurant ID does not exist: " + reviewBody.getRestaurantId(); 
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg);
    }


    if (!userName.equals(reviewBody.getUser())) {
      reviewBody.setUser(userName);
    }

    reviewBody.setStatus(Status.PENDING);
    return reviewRepo.save(reviewBody);
  }

  @GetMapping("/admin/reviews")
  public List<Review> getPendingReviews() {
    return reviewRepo.findByStatus(Status.PENDING);
  }
  
  @GetMapping("/admin/reviews/{reviewId}")
  @ResponseStatus(code = HttpStatus.ACCEPTED)
  public Review acceptReview(@PathVariable("reviewId") String rId, @RequestParam Boolean accept) {
    
    Optional<Review> rOptional = reviewRepo.findById(Long.parseLong(rId));
    if (!rOptional.isPresent()) {
      String msg = "Given review ID does not exist: " + rId;
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg);
    }

    Review pendingReview = rOptional.get();
    if (!pendingReview.getStatus().equals(Status.PENDING)) {
      String msg = "Review no longer pending: " + pendingReview.getStatus();
      throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, msg);
    }

    AdminReview adminReview = new AdminReview(pendingReview);
    adminReview.acceptStatus(accept);
    return reviewRepo.save(adminReview.getReview());
  }

  @PostMapping("/restaurants")
  @ResponseStatus(code = HttpStatus.CREATED)
  public Restaurant createRestaurant(@Valid @RequestBody Restaurant rBody) {
    List<Restaurant> matches = restaurantRepo.findByNameAndZipcode(rBody.getName(), rBody.getZipcode());
    
    if (!matches.isEmpty()) {
      String msg = "Restaurant " +rBody.getName() + " already exists in " + rBody.getZipcode();
      throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, msg);
    }
    Restaurant restaurant = new Restaurant(null, rBody.getName(), rBody.getZipcode(), null, null, null, null, null);
    return restaurantRepo.save(restaurant);
  }  

  @GetMapping("/restaurants/{restaurantId}")
  public Restaurant getRestaurant(@PathVariable("restaurantId") String rId) {
    Optional<Restaurant> rOptional = restaurantRepo.findById(Long.parseLong(rId));

    if (!rOptional.isPresent()) {
      String msg = "Restaurant with id " + rId + " does not exit";
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg);
    }

    return rOptional.get();
  }
}
