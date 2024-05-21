package com.example.spring.data;

import com.example.spring.tacos.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface IOrderRepository
        extends CrudRepository<TacoOrder, String> {

}