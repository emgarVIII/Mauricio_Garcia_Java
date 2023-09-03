package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.company.customerdataservice.repository.CustomerRepositoryTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    // Wiring in the MockMvc object
    @Autowired
    MockMvc mockMvc;
    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    @MockBean
    CustomerRepository repo;
    Customer c;

    @BeforeEach
    public void setUp() {
        repo.deleteAll();
        c = new Customer();
        c.setFirstName("Walter");
        c.setLastName("White");
        c.setEmail("walter_white@utexas.edu");
        c.setCompany("Gray Matter Technologies");
        c.setPhoneNumber("981-092-4842");
        c.setAddress1("308 Negra Arroyo Lane");
        c.setCity("Albuquerque");
        c.setState("New Mexico");
        c.setZipCode("87111");
        c.setCountry("US");
    }

    // POST route that creates a new customer
    @Test
    public void createCustomerTest() throws Exception {
        String inputJson = mapper.writeValueAsString(c);
        mockMvc.perform(post("/customers")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    // PUT route that updates an existing customer
    @Test
    public void updateCustomerTest() throws Exception {
        String inputJson = mapper.writeValueAsString(c);
        mockMvc.perform(put("/customers/", c.getCustomerId())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    // DELETE route that deletes an existing customer
    @Test
    public void deleteCustomerTest() throws Exception {
        repo.deleteById(c.getCustomerId());
        assertFalse(repo.existsById(c.getCustomerId()));
    }

    // GET route that returns a specific customer by id
    @Test
    public void getCustomerByIDTest() throws Exception {
        String inputJson = mapper.writeValueAsString(c);
        mockMvc.perform((get("/customers/{id}", c.getCustomerId()))
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

    // GET route that returns all customers of a specific state
    @Test
    public void getAllCustomersInStateTest() throws Exception {
        mockMvc.perform(get("/customers/state/{state}", c.getState())) // specify state value
                .andExpect(status().isOk());
    }
}
