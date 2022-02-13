package com.codeacademy.diningreview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue
  @Getter @Setter private Long id;

  @Column(name = "name")
  @Getter @Setter private String name;
  
  @Column(name = "city")
  @Getter @Setter private String city;

  @Column(name = "state")
  @Getter @Setter private String state;

  @Column(name = "zipcode")
  @Getter @Setter private String zipcode;

  @Column(name = "peanut")
  @Getter @Setter private boolean peanut;

  @Column(name = "egg")
  @Getter @Setter private boolean egg;

  @Column(name = "dairy")
  @Getter @Setter private boolean dairy;
  
}
