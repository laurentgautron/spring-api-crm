package fr.m2i.apicrm.service;

import fr.m2i.apicrm.dto.CustomerDTO;
import fr.m2i.apicrm.dto.CustomerMapper;
import fr.m2i.apicrm.exception.NotFoundException;
import fr.m2i.apicrm.model.Customer;
import fr.m2i.apicrm.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService implements ICustomerService {
    
    private final CustomerRepository repo;
    
    @Autowired
    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }
    
    @Override
    public List<Customer> findAll() {
        List<Customer> customers = repo.findAll();    
        return customers;
    }
    
    @Override
    public Customer findById(Long id) {
        Customer customer = repo.findById(id).orElseThrow(() -> {
            throw new NotFoundException("customer with id: " + id + " was not found");
        });
        return customer;
    }
    
    @Override
    public Customer createCustomer(Customer customer) {
                
        Customer customerToCreate = new Customer(
                customer.getLastname(),
                customer.getFirstname(),
                customer.getCompany(),
                customer.getMail(),
                customer.getPhone(),
                customer.getAddress(),
                customer.getZipCode(),
                customer.getCity(),
                customer.getCountry(),
                customer.getState()
        );
        repo.save(customerToCreate);
        return customerToCreate;
    }

    @Override
    public Customer updateCustomer(Long id, Customer content) {
        
        Customer customerToUpdate = findById(id);
        
        if (content == null) {
            return null;
        }
        
        Customer updated = CustomerMapper.copy(customerToUpdate, content);
        
        
        
        return repo.save(updated);
    }
    
    @Override
    public Customer deleteCustomer(Long id) {
        
        Customer customerToDelete = repo.findById(id).orElseThrow(() -> {
            throw new NotFoundException("customer with id: " + id + " was not found");
        });
        
        repo.delete(customerToDelete);
        
        return customerToDelete;
    }
    
    @Override
    public Customer save(Customer customer) {
        return repo.save(customer);
    }
    
}
