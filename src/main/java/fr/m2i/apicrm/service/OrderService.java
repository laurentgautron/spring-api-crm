package fr.m2i.apicrm.service;

import fr.m2i.apicrm.dto.OrderMapper;
import fr.m2i.apicrm.exception.NotFoundException;
import fr.m2i.apicrm.model.Order;
import fr.m2i.apicrm.repository.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService{
    
    private final OrderRepository repo;

    @Autowired
    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }
    
    @Override
    public List<Order> findAll() {
        return repo.findAll();
    }

    @Override
    public Order findById(Long id) {
        
        Order order = repo.findById(id).orElseThrow(() -> {
            throw new NotFoundException("order with id: " + id + " was not found");
        });
        
        return order;
        
    }

    @Override
    public Order update(Long id, Order order) {
        
        Order orderToUpdate = findById(id);
        Order updated = OrderMapper.copy(order, orderToUpdate);
        
        return repo.save(updated);
    }

    @Override
    public void delete(Long id) {
        
        Order orderToDelete = findById(id);
        repo.save(orderToDelete);
    }

    @Override
    public Order save(Order order) {
        return repo.save(order);
    }
    
}
