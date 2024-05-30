package com.example.spring.tacos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/** Объявляет {@code Bean} компонент {@code PasswordEncoder}, который мы будем использовать при создании новых пользователей
 * и при аутентификации
 * */
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        // Возвращаем один из средств шифрования паролей
        return new BCryptPasswordEncoder();
    }
}