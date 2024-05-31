package com.example.spring.tacos;

import com.example.spring.tacos.web.WebConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/** Тесты для домашней страницы
 * */
@WebMvcTest(WebConfig.class)
public class WebConfigTest {

    /* Имитируем работу Spring MVC, чтобы не запускать сервер */
    @Autowired
    private MockMvc mockMvc;

    /** Выполняем HTTP-запрос GET с корневым путём {@code /} и затем убедимся, что контроллер выбрал имя представление
     * home, а сама страница содержит фразу "Welcome to..."
     * */
    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(content().string(
                        containsString("Welcome to...")));
    }
}