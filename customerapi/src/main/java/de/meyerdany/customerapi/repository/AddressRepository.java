package de.meyerdany.customerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.meyerdany.customerapi.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
