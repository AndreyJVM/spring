package com.example.spring.tacos.data;

import com.example.spring.tacos.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository
        extends CrudRepository<TacoOrder, Long> {
}