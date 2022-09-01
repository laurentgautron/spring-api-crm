package fr.m2i.apicrm.service;

import fr.m2i.apicrm.dto.CustomerDTO;
import fr.m2i.apicrm.model.Customer;
import java.util.List;


public interface ICustomerService {
    
    List<Customer> findAll();
    Customer findById(Long id);
    Customer createCustomer(Customer customer);
    CustomerDTO updateCustomer(Long id, Customer content);
    CustomerDTO deleteCustomer(Long id);
    void saveCustomer(Customer customer);
}
