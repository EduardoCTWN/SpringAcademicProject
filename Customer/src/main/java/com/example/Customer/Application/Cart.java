package com.example.Customer.Application;

import java.util.ArrayList;
import java.util.List;

public class Cart {
  private List<CartItem> itens = new ArrayList<>();

  public void addItem(CartItem newItem) {
    for (CartItem existingItem : itens) {
        if (existingItem.equals(newItem)) {
            existingItem.setAmount(existingItem.getAmount() + newItem.getAmount());
            return;
        }
    }

    this.itens.add(newItem);
  }

  public void removeItem(Integer itemId) {
    CartItem itemToRemove = new CartItem(itemId, null, 0, 0, "");

    this.itens.remove(itemToRemove);
  }

  public double getTotalPrice() {
    return itens.stream().mapToDouble(CartItem::getTotalPrice).sum();
  }

  public List<CartItem> getItens() {
    return itens;
  }

  public void setItens(List<CartItem> itens) {
    this.itens = itens;
  }
}

