package com.codeacademy.diningreview.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class AdminReview {
  
  @Getter @Setter
  private boolean accept;
  
  // @Getter @Setter
  // private Review pendingReview;

}
