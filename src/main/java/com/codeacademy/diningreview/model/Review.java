package com.codeacademy.diningreview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.codeacademy.diningreview.utils.Status;
import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter 
@Entity
@Table(name = "reviews")
public class Review {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user")
  private String user;

  @Column(name = "restaurant_id")
  @Positive(message = "invalid restaurant id")
  private Long restaurantId;

  @Column(name = "peanut")
  @NotNull(message = "peanut rating missing")
  @Range(min = 1, max = 5)
  private Long peanut;

  @Column(name = "egg")
  @NotNull(message = "egg rating missing")
  @Range(min = 1, max = 5)
  private Long egg;

  @Column(name = "dairy")
  @NotNull(message = "dairy is missing")
  @Range(min = 1, max = 5)
  private Long dairy;

  @Column(name = "comment")
  private String comment;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private Status status;
}
