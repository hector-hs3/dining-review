package com.codeacademy.diningreview.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurants")
public class Restaurant {

  @Id
  @GeneratedValue
  @Getter @Setter private Long id;

  @Column(name = "name")
  @Getter @Setter private String name;

  @Column(name = "overall")
  @Getter @Setter private Long overall;

  @Column(name = "peanut")
  @Getter @Setter private Long peanut;

  @Column(name = "egg")
  @Getter @Setter private Long egg;

  @Column(name = "dairy")
  @Getter @Setter private Long dairy;
  
}
