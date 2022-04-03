package com.codeacademy.diningreview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter 
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  @NotBlank(message = "name is mandatory")
  private String name;
  
  @Column(name = "city")
  private String city;

  @Column(name = "state")
  private String state;

  @Column(name = "zipcode")
  @Digits(integer = 5, fraction = 0)
  private Long zipcode;

  @Column(name = "peanut")
  private boolean peanut;

  @Column(name = "egg")
  private boolean egg;

  @Column(name = "dairy")
  private boolean dairy;
  
}
