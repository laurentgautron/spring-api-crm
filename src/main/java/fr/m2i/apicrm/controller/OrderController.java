package fr.m2i.apicrm.controller;

import fr.m2i.apicrm.model.Order;
import fr.m2i.apicrm.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {
    
    private final OrderService orderService;
    
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    
    // lister les commandes
    @GetMapping
    public ResponseEntity<Object> getAllOrders() {
        List<Order> orders = orderService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }
    
    // récupérer une commande par id
    
    // Créer une commande
    
    // modifier une commande
    
    // supprimer une commande

}
