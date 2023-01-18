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

import de.meyerdany.customerapi.entity.Address;
import de.meyerdany.customerapi.entity.Customer;
import de.meyerdany.customerapi.repository.AddressRepository;
import de.meyerdany.customerapi.repository.CustomerRepository;

@RestController
@RequestMapping("/address")

public class AdressController {
	
	private AddressRepository addressRepository;

	public AdressController(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
	
	@GetMapping("")
	public List<Address> index() {
		return addressRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Address> getCustomerById(@PathVariable("id") long id) {
		Optional<Address> data = addressRepository.findById(id);

	    if (data.isPresent()) {
	      return new ResponseEntity<>(data.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	 @PostMapping("")
	 public ResponseEntity<Address> createCustomer(@RequestBody Address adr) {
	    try {
	    	Address _adr = addressRepository.saveAndFlush(adr);
	      return new ResponseEntity<>(_adr, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	
}
