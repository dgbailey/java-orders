package com.javaorders.orders.controllers;


import com.javaorders.orders.models.Customers;
import com.javaorders.orders.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers",
            produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customers> myCustomers = customerService.findAll();
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }

    @GetMapping(value = "/customers/name/{name}",
            produces = {"application/json"})
    public ResponseEntity<?> getCustomerByName(
            @PathVariable
                    String name)
    {
        Customers c = customerService.findCustomerByName(name);
        return new ResponseEntity<>(c, HttpStatus.OK);


    }

    @PostMapping(value = "/customers", consumes = {"application/json"},produces = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid @RequestBody Customers newCustomer) throws URISyntaxException
    {
        newCustomer = customerService.save(newCustomer);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{custcode}").buildAndExpand(newCustomer.getCustcode()).toUri();
        responseHeaders.setLocation(newCustomerURI);
        return new ResponseEntity<>(null,responseHeaders,HttpStatus.CREATED);
    }

    @PutMapping(value = "/customers/{custcode}")
    public ResponseEntity<?> updateCustomer(
            @RequestBody
                    Customers updateCustomer,
            @PathVariable
                    long custcode)
    {
        customerService.update(updateCustomer, custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/customers/{custcode}")
    public ResponseEntity<?> deleteRCustomerById(
            @PathVariable
                    long custcode)
    {
        customerService.delete(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
