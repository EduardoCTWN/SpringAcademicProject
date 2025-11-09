package com.example.RestaurantADM.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
  
import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class RestaurantController {
  @Autowired
  private RestaurantRepository restaurantRepository;
  
  
  @Autowired
  private MenuItemRepository menuItemRepository;

  @GetMapping("/new-restaurant")
  public String newRestaurant(Model model){
    model.addAttribute("restaurant", new Restaurant());
    
    return "new-restaurant";
  }

  @PostMapping("/save-restaurant")
  public String saveRestaurant(@ModelAttribute Restaurant restaurant){
    restaurantRepository.save(restaurant);

    return "redirect:/restaurants";
  }

  @GetMapping(value = {"/restaurants", "/"})
  public String restaurantsList(Model model){
    model.addAttribute("restaurants", restaurantRepository.findAll());

    return "/restaurants";
  }

  @GetMapping("/{id}/new-item")
  public String newItem(@PathVariable("id") Integer id, MenuItem menuItem, Model model){
    Restaurant restaurant = restaurantRepository.findById(id).orElseThrow();
    model.addAttribute("restaurant", restaurant);
    
    return "new-item";
  }

  @PostMapping("/{id}/save-item")
  public String saveItem(@PathVariable("id") Integer id, MenuItem menuItem){
    Restaurant restaurant = restaurantRepository.findById(id).orElseThrow();

    menuItem.setRestaurant(restaurant);
    menuItem.setId(null);

    menuItemRepository.save(menuItem);
    return "redirect:/" + restaurant.getId() + "/menu-itens";
  }

  @GetMapping("/{id}/restaurant-edit")
  public String restaurantEdit(Model model, @PathVariable("id") Integer id){
    Restaurant restaurant = restaurantRepository.findById(id).orElseThrow();

    model.addAttribute("restaurant", restaurant);
    
    return "restaurant-edit";
  }

  @PostMapping("/{id}/save-restaurant-edit")
  public String saveRestaurantEdit(@PathVariable Integer id, @Valid @ModelAttribute("restaurant") MenuItem itemFromForm, BindingResult result, Model model){
    if(result.hasErrors()){
      return "restaurant-edit";
    }
    Restaurant existingRestaurant = restaurantRepository.findById(id).orElseThrow();
    
    existingRestaurant.setName(itemFromForm.getName());

    restaurantRepository.save(existingRestaurant);

    return "redirect:/restaurants";
  }

  @GetMapping("/{id}/menu-itens")
  public String itensList(@PathVariable("id") Integer id, Model model){
    Restaurant restaurant = restaurantRepository.findById(id).orElseThrow();

    model.addAttribute("restaurant", restaurant);

    return "menu-itens";
  }

  @GetMapping("/itens/{id}/item-edit")
  public String menuItemEdit(Model model, @PathVariable("id") Integer id){
    MenuItem menuItem = menuItemRepository.findById(id).orElseThrow();
    
    model.addAttribute("restaurant", menuItem.getRestaurant());
    model.addAttribute("menuItem", menuItem);
    
    return "item-edit";
  }

  @PostMapping("/itens/{id}/save-item-edit")
  public String saveMenuItemEdit(@PathVariable Integer id, @Valid @ModelAttribute("menuItem") MenuItem itemFromForm, BindingResult result, Model model){
    if(result.hasErrors()){
      return "item-edit";
    }

    MenuItem existingItem = menuItemRepository.findById(id).orElseThrow();

    existingItem.setName(itemFromForm.getName());
    existingItem.setDescription(itemFromForm.getDescription()); 
    existingItem.setPrice(itemFromForm.getPrice());

    menuItemRepository.save(existingItem);

    return "redirect:/" + existingItem.getRestaurant().getId() + "/menu-itens";
  }

  @GetMapping("/{id}/remove-restaurant")
  public String removeRestaurant(@PathVariable Integer id){
    Restaurant restaurant = restaurantRepository.findById(id).orElseThrow();

    restaurantRepository.delete(restaurant);

    return "redirect:/restaurants";
  }

  @GetMapping("/itens/{id}/remove-item")
  public String removeMenuItem(Model model, @PathVariable("id") Integer id){
    MenuItem menuItem = menuItemRepository.findById(id).orElseThrow();

    menuItemRepository.delete(menuItem);
    
    return "redirect:/" + menuItem.getRestaurant().getId() + "/menu-itens";
  }
}
