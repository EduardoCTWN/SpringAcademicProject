package com.example.Customer.Application;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class MenuItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank(message = "O nome é obrigatorio")
  private String name;

  private String description;

  @NotNull(message = "O preço é obrigatorio")
  private double price;

  @ManyToOne
  @JoinColumn(name = "restaurant_id")
  private Restaurant restaurant;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public double getPrice() {
    return price;
  }


  public void setPrice(double price) {
    this.price = price;
  }


  public Restaurant getRestaurant() {
    return restaurant;
  }


  public void setRestaurant(Restaurant restaurant) {
    this.restaurant = restaurant;
  }


  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    this.id = id;
  }
}

