package com.example.Customer.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.ui.Model;

@Controller
public class RestaurantController {
  @Autowired
  private RestaurantRepository restaurantRepository;
  
  @GetMapping(value = {"/restaurants", "/"})
  public String restaurantsList(Model model){
    model.addAttribute("restaurants", restaurantRepository.findAll());

    return "/restaurants";
  }

  @GetMapping("/{id}/menu-itens")
  public String itensList(@PathVariable("id") Integer id, Model model){
    Restaurant restaurant = restaurantRepository.findById(id).orElseThrow();

    model.addAttribute("restaurant", restaurant);

    return "menu-itens";
  }

  @GetMapping("/{id}/orders")
  public String makeOrder(@PathVariable("id") Integer id, Model model){
    Restaurant restaurant = restaurantRepository.findById(id).orElseThrow();

    model.addAttribute("restaurant", restaurant);

    return "orders";
  }
}
