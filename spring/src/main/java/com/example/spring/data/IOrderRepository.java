package com.example.spring.data;

import com.example.spring.tacos.TacoOrder;

public interface IOrderRepository {
    TacoOrder save(TacoOrder tacoOrder);
}
