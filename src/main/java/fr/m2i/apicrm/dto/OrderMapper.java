package fr.m2i.apicrm.dto;

import fr.m2i.apicrm.model.Customer;
import fr.m2i.apicrm.model.Order;

public class OrderMapper {
    
    public static OrderDTO buildOrderDTO(Order order) {
        
        CustomerDTO customerDTO = CustomerMapper.buildCustomerDTO(order.getCustomer());
        
        return new OrderDTO(
                order.getType(),
                order.getLabel(),
                customerDTO,
                order.getNumberOfDays(),
                order.getUnitPrice(),
                order.getTotalExcludeTaxe(),
                order.getTotalWithTaxe(),
                order.getState()
        );
        
    }
    
    public static Order buildOrder(OrderDTO orderDTO) {
        
        Customer customer = CustomerMapper.buildCustomer(orderDTO.getCustomer());
        
        return new Order(
                orderDTO.getType(),
                orderDTO.getLabel(),
                customer,
                orderDTO.getNumberOfDays(),
                orderDTO.getUnitPrice(),
                orderDTO.getTotalExcludeTaxe(),
                orderDTO.getTotalWithTaxe(),
                orderDTO.getState()
        );
                
    }
    
    public static Order copy(Order order, Order content) {
        
        if (order == null || content == null) {
            return null;
        }
        
        if (content.getCustomer() != null) {
            order.setCustomer(content.getCustomer());
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
