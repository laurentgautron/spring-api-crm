package fr.m2i.apicrm.service;

import fr.m2i.apicrm.dto.CustomerDTO;
import fr.m2i.apicrm.model.Customer;
import java.util.List;


public interface ICustomerService {
    
    List<Customer> findAll();
    Customer findById(Long id);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer content);
    Customer deleteCustomer(Long id);
    Customer save(Customer customer);
    
}
