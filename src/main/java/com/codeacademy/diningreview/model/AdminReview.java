package com.codeacademy.diningreview.model;

import com.codeacademy.diningreview.utils.Status;

import lombok.Getter;

public class AdminReview {
  
  @Getter
  private Review review;

  public AdminReview(Review pendingReview) {
    this.review = pendingReview;
  }

  public void acceptStatus(boolean accept) {
    Status status = accept ? Status.ACCEPTED : Status.REJECTED;
    this.review.setStatus(status);
  }

}
