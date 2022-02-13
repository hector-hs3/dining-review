package com.codeacademy.diningreview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.codeacademy.diningreview.utils.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {
  
  @Id
  @GeneratedValue
  @Getter @Setter private Long id;

  @Column(name = "user")
  @Getter @Setter private String user;

  @Column(name = "restaurant_id")
  @Getter @Setter private Long restaurantId;

  @Column(name = "peanut")
  @Getter @Setter private Long peanut;

  @Column(name = "egg")
  @Getter @Setter private Long egg;

  @Column(name = "dairy")
  @Getter @Setter private Long dairy;

  @Column(name = "comment")
  @Getter @Setter private String comment;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  @Getter @Setter private Status status;
}
