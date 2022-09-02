package fr.m2i.apicrm.service;

import fr.m2i.apicrm.model.Order;
import java.util.List;


public interface IOrderService {
    
    List<Order> findAll();
    Order findById(Long id);
    Order create(Order order);
    Order update(Order order);
    Order delete(Order order);
    
}
