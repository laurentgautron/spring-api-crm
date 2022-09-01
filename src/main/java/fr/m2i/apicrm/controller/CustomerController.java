package fr.m2i.apicrm.controller;

import fr.m2i.apicrm.dto.CustomerDTO;
import fr.m2i.apicrm.dto.CustomerMapper;
import fr.m2i.apicrm.exception.NotFoundException;
import fr.m2i.apicrm.model.Customer;
import fr.m2i.apicrm.response.ErrorResponseEntity;
import fr.m2i.apicrm.service.ICustomerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {
    
    private final ICustomerService customerService;
    
    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }
    
    // lister les clients
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllCustomers() {
        List<Customer> customers = customerService.findAll();
        List<CustomerDTO> dtos = new ArrayList();
        
        for (Customer customer : customers) {
            CustomerDTO dto = CustomerMapper.buildCustomerDTO(customer);
            dtos.add(dto);
        }
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
    
    // récupérer les clients par id
    @GetMapping(value= "/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCustomerById(@PathVariable("id") String id) throws Exception {
        
        try {
            Long idLong = Long.parseLong(id);
            Customer founded = customerService.findById(idLong);
            CustomerDTO dto = CustomerMapper.buildCustomerDTO(founded);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
            
        } catch (NumberFormatException nfe) {
            return ErrorResponseEntity.build("The parameter 'id' is not valid", 400, "/v1/customers/" + id, HttpStatus.BAD_REQUEST);
        } catch (NotFoundException nfe) {
            return ErrorResponseEntity.build("Customer was not found", 404, "/v1/customers/" + id, HttpStatus.NOT_FOUND);
        } catch( Exception e) {
            return ErrorResponseEntity.build("An error occured", 500, "/v1/customers/" + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    // créer un client
    @RequestMapping(value = "/create", 
                    produces = MediaType.APPLICATION_JSON_VALUE, 
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.POST)
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerDTO customerDTO) {
        
        try {
            Customer customerToCreate = CustomerMapper.buildCustomer(customerDTO);
            Customer created = customerService.createCustomer(customerToCreate);
            CustomerDTO createdDTO = CustomerMapper.buildCustomerDTO(created);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdDTO);
        } catch (Exception e) {
            System.out.println("an error was occured");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    // modifier un client
    @RequestMapping(value = "/v1/customer/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCustomer(@RequestBody CustomerDTO customerDTO, @RequestParam("id") String id) {
        
        try {
            Long.parseLong(id);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        
        try {
            
            CustomerDTO updated = customerService.updateCustomer(Long.parseLong(id), CustomerMapper.buildCustomer(customerDTO));
            return new ResponseEntity<>(updated, HttpStatus.OK);
            
        } catch (Exception e) {
            System.out.println("An error was occured");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    // delete
    
    @RequestMapping(value = "/v1/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") String id) {
        
        try {
            Long.parseLong(id);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        
        try {
            CustomerDTO deleted = customerService.deleteCustomer(Long.parseLong(id));
            return new ResponseEntity<>(deleted, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        
    }

    
    
}
