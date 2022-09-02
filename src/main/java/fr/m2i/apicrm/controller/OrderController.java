package fr.m2i.apicrm.controller;

import fr.m2i.apicrm.dto.OrderDTO;
import fr.m2i.apicrm.dto.OrderMapper;
import fr.m2i.apicrm.exception.NotFoundException;
import fr.m2i.apicrm.model.Order;
import fr.m2i.apicrm.response.ErrorResponseEntity;
import fr.m2i.apicrm.service.IOrderService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {
    
    private final IOrderService orderService;
    
    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }
    
    // lister les commandes
    @GetMapping
    public ResponseEntity<Object> getAllOrders() {
        
        List<Order> orders = orderService.findAll();
        List<OrderDTO> dtos = new ArrayList();
        
        for (Order order : orders) {
            OrderDTO orderDTO = OrderMapper.buildOrderDTO(order);
            dtos.add(orderDTO);
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
    
    // récupérer une commande par id
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable("id") String id) {
        
        try {
            Long idLong = Long.parseLong(id);
            Order order = orderService.findById(idLong);
            OrderDTO dto = OrderMapper.buildOrderDTO(order);
            
            return ResponseEntity.status(HttpStatus.OK).body(dto);
            
        } catch (NotFoundException nfe) {
            return ErrorResponseEntity.build("Order with id "+ id, 404, "/v1/orders/" + id, HttpStatus.NOT_FOUND);
        } catch (NumberFormatException nfe) {
            return ErrorResponseEntity.build("the id:" + id + " is not valide", 400, "/v1/orders/" + id, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ErrorResponseEntity.build("An error was occured", 500, "/v1/orders/" + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        
    }
    
    
    // Créer une commande
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> createOrder(@RequestBody OrderDTO dto) {
        try {
            Order toCreate = OrderMapper.buildOrder(dto);
            Order created = orderService.save(toCreate);
            OrderDTO createdDTO = OrderMapper.buildOrderDTO(created);
            
            return ResponseEntity.status(HttpStatus.CREATED).body(createdDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ErrorResponseEntity.build("An error was occured", 500, "/v1/orders/", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // modifier une commande
    @PutMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateOrder(@RequestBody OrderDTO orderDTO, @PathVariable("id") String id) {
        
        try {
            
            Long idLong = Long.parseLong(id);
            Order ordertToUpdate = OrderMapper.buildOrder(orderDTO);
            Order updated = orderService.update(idLong, ordertToUpdate);
            OrderDTO updatedDTO = OrderMapper.buildOrderDTO(updated);
            return ResponseEntity.status(HttpStatus.OK).body(updatedDTO);
            
        } catch (NotFoundException nfe) {
            return ErrorResponseEntity.build("the order with id: "+ id + " was not found", 404, "/v1/orders/" + id, HttpStatus.NOT_FOUND);
        } catch (NumberFormatException nfe) {
            return ErrorResponseEntity.build("the id: "+ id + " is not valide", 400, "/v1/orders/" + id, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ErrorResponseEntity.build("An error was occured", 500, "/v1/orders/"+ id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // supprimer une commande
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOrderById(@PathVariable("id") String id) {
        
        try {
            Long idLong = Long.parseLong(id);
            orderService.delete(idLong);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NotFoundException nfe) {
            return ErrorResponseEntity.build("the order with id: "+ id + " was not found", 404, "/v1/orders/"+id, HttpStatus.NOT_FOUND);
        } catch (NumberFormatException nfe) {
            return ErrorResponseEntity.build("the id: "+ id + " is not valide", 400, "/v1/orders/"+id, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ErrorResponseEntity.build("an error was occured", 500, "v1/orders/"+id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
