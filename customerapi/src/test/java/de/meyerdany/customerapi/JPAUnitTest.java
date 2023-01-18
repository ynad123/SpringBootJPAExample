package de.meyerdany.customerapi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import de.meyerdany.customerapi.entity.Address;
import de.meyerdany.customerapi.entity.Customer;
import de.meyerdany.customerapi.repository.CustomerRepository;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //produktiv DB verwenden

public class JPAUnitTest {

  @Autowired
  CustomerRepository repository;
  

  @Test
  public void should_find_no_customer_if_repository_is_empty() {
    Iterable customers = repository.findAll();
    assertThat(customers).isEmpty();
  }

  @Test
  public void should_store_a_customer() {
	Address adr = new Address("MusterStreet", "MusterTown", "123");
    Customer cust = repository.save(new Customer("Susi", "Sorglos", adr));
    assertEquals("Susi", cust.getFirstName());
    assertEquals("Sorglos", cust.getLastName());
    assertEquals("MusterStreet", cust.getAddress().getStreet());
    assertEquals("MusterTown", cust.getAddress().getTown());
    assertEquals("123", cust.getAddress().getZipCode());
  }
  
}
