package com.codeacademy.diningreview.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter 
@Entity
@Table(name = "restaurants")
public class Restaurant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;
  
  @Column(name = "zipcode")
  @Digits(integer = 5, fraction = 0)
  private Long zipcode;

  @Column(name = "reviews")
  private Long reviews;

  @Column(name = "overall")
  private Long overall;

  @Column(name = "peanut")
  private Long peanut;

  @Column(name = "egg")
  private Long egg;

  @Column(name = "dairy")
  private Long dairy;
  
}
