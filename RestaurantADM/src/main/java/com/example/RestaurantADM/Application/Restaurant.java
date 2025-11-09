package com.example.RestaurantADM.Application;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Restaurant {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  @OneToMany(mappedBy = "restaurant")
  private List<MenuItem> MenuItens;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<MenuItem> getMenuItens(){
    return this.MenuItens;
  }

  public void setMenuItens(List<MenuItem> MenuItens) {
    this.MenuItens = MenuItens;
  }

}
