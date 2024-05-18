package com.example.spring.tacos.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/** После создания taco перенаправить пользователя на форму заказа, откуда он сможет сделать заказ на
 * доставку своего taco
 * */
@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    @GetMapping("/current")
    public String orderFrom() {
        return "orderFrom";
    }
}