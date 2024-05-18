package com.example.spring.data;

import com.example.spring.tacos.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder tacoOrder);
}
