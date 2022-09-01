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
            
        // on pourrait faire des log : System.out.println(...)
        } catch (NumberFormatException nfe) {
            return ErrorResponseEntity.build("The parameter 'id' is not valid", 400, "/v1/customers/" + id, HttpStatus.BAD_REQUEST);
        } catch (NotFoundException nfe) {
            return ErrorResponseEntity.build("Customer was not found", 404, "/v1/customers/" + id, HttpStatus.NOT_FOUND);
        } catch( Exception e) {
            return ErrorResponseEntity.build("An error occured", 500, "/v1/customers/" + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    // créer un client
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, 
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.POST)
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerDTO customerDTO) {
        
        try {
            Customer customerToCreate = CustomerMapper.buildCustomer(customerDTO);
            Customer created = customerService.createCustomer(customerToCreate);
            CustomerDTO createdDTO = CustomerMapper.buildCustomerDTO(created);
            // on met status OK car dns la norme du 201, on ne retourne rien
            return ResponseEntity.status(HttpStatus.OK).body(createdDTO);
            
        } catch (Exception e) {
            System.out.println("an error was occured");
            return ErrorResponseEntity.build("An error occured", 500, "/v1/customers/", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // modifier un client
    @RequestMapping(value = "/update/{id}", 
                    method = RequestMethod.PUT,
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateCustomer(@RequestBody CustomerDTO content, @PathVariable("id") String id) {
        
        try {
            Long idLong = Long.parseLong(id);
            Customer updated = customerService.updateCustomer(idLong, content);
            CustomerDTO dto = CustomerMapper.buildCustomerDTO(updated);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
            
        } catch (NotFoundException nf) {
            return ErrorResponseEntity.build("Customer was not found", 404, "/v1/customers/" + id, HttpStatus.NOT_FOUND);
        } catch (NumberFormatException nfe) {
            return ErrorResponseEntity.build("The parameter 'id' is not valid", 400, "/v1/customers/" + id, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    // delete
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") String id) {
        
        try {
            Long idLong = Long.parseLong(id);
            Customer customerToDelete = customerService.deleteCustomer(idLong);
            CustomerDTO dto = CustomerMapper.buildCustomerDTO(customerToDelete);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
            
        } catch (NotFoundException nfe) {
            return ErrorResponseEntity.build("Customer was not found", 404, "/v1/customers/delete/" + id, HttpStatus.NOT_FOUND);
        } catch (NumberFormatException e) {
            return ErrorResponseEntity.build("The parameter 'id' is not valid", 400, "/v1/customers/" + id, HttpStatus.BAD_REQUEST);
        }
    }

    
    
}
