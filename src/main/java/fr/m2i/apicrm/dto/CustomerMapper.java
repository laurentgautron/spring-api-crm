package fr.m2i.apicrm.dto;

import fr.m2i.apicrm.model.Customer;

public class CustomerMapper {
    
    public static CustomerDTO buildCustomerDTO (Customer customer) {
        
        if (customer == null) {
            return new CustomerDTO();
        }
        
        String state = customer.getState() ? "ACTIF" : "INACTIF";
        
        return new CustomerDTO(
                customer.getId(),
                customer.getLastname(),
                customer.getFirstname(),
                customer.getCompany(),
                customer.getMail(),
                customer.getPhone(),
                customer.getAddress(),
                customer.getZipCode(),
                customer.getCity(),
                customer.getCountry(),
                state
        );
    }
    
    public static Customer buildCustomer(CustomerDTO customerDTO) {
        
        if (customerDTO == null) {
            return null;
        }
        
        Boolean stateBool = customerDTO.getState().equals("ACTIF");
        
        return new Customer(
                customerDTO.getLastname(),
                customerDTO.getFirstname(),
                customerDTO.getCompany(),
                customerDTO.getMail(),
                customerDTO.getPhone(),
                customerDTO.getAddress(),
                customerDTO.getZipCode(),
                customerDTO.getCity(),
                customerDTO.getCountry(),
                stateBool
        );
    }
    
    public static Customer copy(Customer customer, Customer content) {
        
        if (content.getLastname() != null) {
            customer.setLastname(content.getLastname());
        }
        
        if (content.getFirstname() != null) {
            customer.setFirstname(content.getFirstname());
        }
        
        if (content.getCompany() != null) {
            customer.setCompany(content.getCompany());
        }
        
        if (content.getMail() != null) {
            customer.setMail(content.getMail());
        }
        
        if (content.getPhone() != null) {
            customer.setPhone(content.getPhone());
        }
        
        if (content.getAddress() != null) {
            customer.setAddress(content.getAddress());
        }
        
        if (content.getZipCode() != null) {
            customer.setZipCode(content.getZipCode());
        }
        
        if (content.getCity() != null) {
            customer.setCity(content.getCity());
        }
        
        if (content.getCountry() != null) {
            customer.setCountry(content.getCountry());
        }
        
        return customer;
    }
    
}
