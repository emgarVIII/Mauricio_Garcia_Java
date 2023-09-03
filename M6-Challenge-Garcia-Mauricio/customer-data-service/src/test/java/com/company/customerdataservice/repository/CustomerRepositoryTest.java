package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repo;
    Customer c1;
    Customer c2;

    @BeforeEach
    void setUp() {
        repo.deleteAll();

        // first test customer
        c1 = new Customer();
        c1.setFirstName("Walter");
        c1.setLastName("White");
        c1.setEmail("walter_white@utexas.edu");
        c1.setCompany("Gray Matter Technologies");
        c1.setPhoneNumber("981-092-4842");
        c1.setAddress1("308 Negra Arroyo Lane");
        c1.setCity("Albuquerque");
        c1.setState("New Mexico");
        c1.setZipCode("87111");
        c1.setCountry("US");
        repo.save(c1);

        // second test customer
        c2 = new Customer();
        c2.setFirstName("Jesse");
        c2.setLastName("Pinkman");
        c2.setEmail("jesse_pinkman@sup.dude");
        c2.setCompany("Vamonos Pest");
        c2.setPhoneNumber("505-555-1234");
        c2.setAddress1("9809 Margo Street");
        c2.setCity("Albuquerque");
        c2.setState("New Mexico");
        c2.setZipCode("87101");
        c2.setCountry("US");
        repo.save(c2);
    }

    @Test
    public void shouldCreateCustomer() {
        Customer c3 = new Customer();
        c3.setFirstName("Mike");
        c3.setLastName("Ehrmentraut");
        c3.setEmail("mike_ehrmantraut@lospollos.org");
        c3.setCompany("Los Pollos Hermanos Security");
        c3.setPhoneNumber("505-555-5678");
        c3.setAddress1("1234 Security Drive");
        c3.setCity("Albuquerque");
        c3.setState("New Mexico");
        c3.setZipCode("87102");
        c3.setCountry("US");
        repo.save(c3);
        assertEquals(3, repo.findAll().size());
    }

    @Test
    public void shouldUpdateCustomer(){
        c2.setState("Texas");
        c2.setCity("Austin");
        c2.setZipCode("78705");
        repo.save(c2);
        assertEquals("Texas", c2.getState());
        assertEquals("Austin", c2.getCity());
        assertEquals("78705", c2.getZipCode());
    }

    @Test
    public void shouldDeleteCustomerById(){
        assertTrue(repo.existsById(c2.getCustomerId()));
        repo.deleteById(c2.getCustomerId());
        assertEquals(1, repo.findAll().size());
    }

    @Test
    public void shouldGetCustomerById(){
        Optional<Customer> foundCustomerOpt = repo.findById(c1.getCustomerId());
        assertTrue(foundCustomerOpt.isPresent());
        Customer foundCustomer = foundCustomerOpt.get();
        assertEquals(c1.getCustomerId(), foundCustomer.getCustomerId());
        assertEquals(c1.getFirstName(), foundCustomer.getFirstName());
        assertEquals(c1.getLastName(), foundCustomer.getLastName());
        assertEquals(c1.getEmail(), foundCustomer.getEmail());
    }

    @Test
    public void shouldGetCustomersByState() {
        List<Customer> customers = repo.findByState("New Mexico");
        assertThat(customers).isNotEmpty();
    }
}
