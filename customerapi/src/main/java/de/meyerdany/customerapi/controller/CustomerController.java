package de.meyerdany.customerapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.meyerdany.customerapi.entity.Customer;
import de.meyerdany.customerapi.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")

public class CustomerController {
	
	private CustomerRepository customerRepository;

	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@GetMapping("")
	public List<Customer> index() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getCustomerById(@PathVariable("id") long id) {
		Optional<Customer> data = customerRepository.findById(id);

	    if (data.isPresent()) {
	      return new ResponseEntity<>(data.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	 @PostMapping("")
	 public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
	    try {
	    	Customer _cust = customerRepository.saveAndFlush(customer);
	      return new ResponseEntity<>(_cust, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	
}
