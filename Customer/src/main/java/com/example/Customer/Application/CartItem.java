package com.example.Customer.Application;

import java.util.Objects;

public class CartItem {
  private Integer itemId;
  private String name;
  private double unitPrice;
  private int amount;
  private String restaurantName;

  public CartItem(Integer itemId, String name, double unitPrice, int amount, String restaurantName) {
          this.itemId = itemId;
          this.name = name;
          this.unitPrice = unitPrice;
          this.amount = amount;
          this.restaurantName = restaurantName;
  }

  public double getTotalPrice() {
          return this.unitPrice * this.amount;
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      CartItem that = (CartItem) o;

      return Objects.equals(itemId, that.itemId);
  }

  @Override
  public int hashCode() {
      return Objects.hash(itemId);
  }

  public Integer getItemId() {
    return itemId;
  }

  public void setItemId(Integer itemId) {
    this.itemId = itemId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public String getRestaurantName() {
    return restaurantName;
  }

  public void setRestaurantName(String restaurantName) {
    this.restaurantName = restaurantName;
  }
}
