package com.codeacademy.diningreview.model;

import com.codeacademy.diningreview.utils.Status;

public class AdminReview {
  
  private Review pendingReview;

  public AdminReview(Review pendingReview) {
    this.pendingReview = pendingReview;
  }

  public void updateStatus(boolean accept) {
    Status status = accept ? Status.ACCEPTED : Status.REJECTED;
    this.pendingReview.setStatus(status);
  }

}
