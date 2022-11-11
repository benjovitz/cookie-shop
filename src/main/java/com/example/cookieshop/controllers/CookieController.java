package com.example.cookieshop.controllers;

import com.example.cookieshop.models.Basket;
import com.example.cookieshop.models.Cookie;
import com.example.cookieshop.repositories.CookieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class CookieController {
    CookieRepository repo = new CookieRepository();
    ArrayList<Cookie> list = new ArrayList<>();
    Basket basket = new Basket(list);

    @GetMapping("/")
    public String index(HttpSession session){
        return "index";
    }

    @GetMapping("/basket")
    public String showBasket(HttpSession session, Model model){
        if(session.getAttribute("basket")!= null){
            model.addAttribute("basket",session.getAttribute("basket"));
        } else{
           model.addAttribute("basket",basket);
        }
            return "basket";
    }

    @GetMapping("/shop")
    public String basket( Model cookieModel, HttpSession session){
        cookieModel.addAttribute("cookies",repo.getAllCookies());
        session.setAttribute("basket",basket);
        return "shop";
    }

    @GetMapping("/addToBasket")
    public String add(@RequestParam int id ){
        Cookie cookie = repo.getCookieById(id);
        list.add(cookie);
        basket.setCookieList(list);
        return "redirect:/shop";
    }
}
