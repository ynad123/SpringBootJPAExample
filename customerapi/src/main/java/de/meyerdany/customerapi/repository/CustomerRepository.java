package de.meyerdany.customerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.meyerdany.customerapi.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
