package fr.m2i.apicrm.dto;

import fr.m2i.apicrm.model.Customer;
import fr.m2i.apicrm.model.Order;
import fr.m2i.apicrm.model.Status;

public class OrderMapper {
    
    public static OrderDTO buildOrderDTO(Order order) {
        
        if (order == null) {
            return new OrderDTO();
        }
        
        CustomerDTO customerDTO = null;
        
        if (order.getCustomer() != null) {
            customerDTO = CustomerMapper.buildCustomerDTO(order.getCustomer()); 
        }
        
        String state = null;
        
        if (order.getState() != null) {
            // name pour récupérer la valeur de l'ENUM
            state = order.getState().name();
        }
        
        return new OrderDTO(
                order.getId(),
                order.getType(),
                order.getLabel(),
                customerDTO,
                order.getNumberOfDays(),
                order.getUnitPrice(),
                order.getTotalExcludeTaxe(),
                order.getTotalWithTaxe(),
                state
        );
        
    }
    
    public static Order buildOrder(OrderDTO orderDTO) {
        
        Customer customer = null;
        
        if (orderDTO.getCustomer() != null && orderDTO.getCustomer().getId() != null) {
            customer = new Customer();
            customer.setId(orderDTO.getCustomer().getId());
        }
        
        Status state = null;
        
        if (orderDTO.getState() != null) {
            state = Status.valueOf(orderDTO.getState());
        }
        
        return new Order(
                orderDTO.getType(),
                orderDTO.getLabel(),
                customer,
                orderDTO.getNumberOfDays(),
                orderDTO.getUnitPrice(),
                orderDTO.getTotalExcludeTaxe(),
                orderDTO.getTotalWithTaxe(),
                state
        );
                
    }
    
    public static Order copy(Order order, Order content) {
        
        if (order == null || content == null) {
            return null;
        }
        
        if (content.getCustomer() != null && content.getCustomer().getId() != null) {
            Customer customer = new Customer();
            customer.setId(content.getCustomer().getId());
            order.setCustomer(customer);
        }
        
        if (content.getLabel() != null) {
            order.setLabel(content.getLabel());
        }
        
        if (content.getType() != null) {
            order.setType(content.getType());
        }
        
        if (content.getNumberOfDays() != null) {
            order.setNumberOfDays(content.getNumberOfDays());
        }
        
        if (content.getUnitPrice() != null) {
            order.setUnitPrice(content.getUnitPrice());
        }
        
        if (content.getTotalExcludeTaxe() != null) {
            order.setTotalExcludeTaxe(content.getTotalExcludeTaxe());
        }
        
        if (content.getTotalWithTaxe() != null) {
            order.setTotalWithTaxe(content.getTotalWithTaxe());
        }
        
        if (content.getState() != null) {
            order.setState(content.getState());
        }
        
        return order;
    }
    
}
