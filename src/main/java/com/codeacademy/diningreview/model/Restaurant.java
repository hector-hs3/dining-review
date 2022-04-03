package com.codeacademy.diningreview.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

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
  @NotBlank(message = "name is mandatory")
  private String name;
  
  @Column(name = "zipcode")
  @Positive(message = "zipcode is required")
  @Digits(integer = 5, fraction = 0)
  private Long zipcode;

  @Column(name = "reviews")
  private Long reviews;

  @Column(name = "overall")
  private String overall;

  @Column(name = "peanut")
  private String peanut;

  @Column(name = "egg")
  private String egg;

  @Column(name = "dairy")
  private String dairy;
  
}
