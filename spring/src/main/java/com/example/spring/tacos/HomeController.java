package com.example.spring.tacos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**Класс контроллера, обрабатывающий запросы с корневым путём {@code /}
 * и передаёт их представлению домашней страницы без заполнения модели данных */
@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
}