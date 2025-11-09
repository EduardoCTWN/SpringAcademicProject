package com.example.Customer.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {
  @Autowired
  private MenuItemRepository menuItemRepository;

  private static final String SESSION_CARRINHO = "sessionCarrinho";

  @PostMapping("/add")
  public String addOnCart(@RequestParam("itemId") Integer itemId, @RequestParam("amount") int amount, @RequestParam("restaurantId") Integer restaurantId, HttpServletRequest request){
    MenuItem item = menuItemRepository.findById(itemId).orElseThrow();
    String restaurantName = item.getRestaurant().getName();

    HttpSession session = request.getSession();
    Cart cart = (Cart) session.getAttribute(SESSION_CARRINHO);

    if(cart == null)
      cart = new Cart();

    CartItem cartItem = new CartItem(item.getId(), item.getName(), item.getPrice(), amount, restaurantName);

    cart.addItem(cartItem);

    session.setAttribute(SESSION_CARRINHO, cart);

    return "redirect:/" + restaurantId + "/orders";
  }

  @GetMapping("")
  public String Cart(Model model, HttpServletRequest request) {
    Cart cart = (Cart) request.getSession().getAttribute(SESSION_CARRINHO);
    
    if (cart == null) {
        model.addAttribute("cart", new Cart());
    } else {
        model.addAttribute("cart", cart);
    }

    return "cart";
  } 

  @GetMapping("/remove/{itemId}")
  public String removeFromCart(@PathVariable("itemId") Integer itemId, HttpServletRequest request) {
    Cart cart = (Cart) request.getSession().getAttribute(SESSION_CARRINHO);

    if (cart != null) {
        cart.removeItem(itemId);
    }

    return "redirect:/cart";
  }
}

