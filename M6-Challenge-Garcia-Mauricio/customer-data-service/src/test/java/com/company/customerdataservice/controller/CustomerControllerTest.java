package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.company.customerdataservice.repository.CustomerRepositoryTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
    CustomerRepositoryTest repo;
    Customer c;


    @BeforeEach
    public void setUp() {
        repo.deleteAll();
        c = new Customer();
        c.setCustomer_id(1);
        c.setFirst_name("Walter");
        c.setLast_name("White");
        c.setEmail("walter_white@utexas.edu");
        c.setCompany("Gray Matter Technologies");
        c.setPhone_number("981-092-4842");
        c.setAddress1("308 Negra Arroyo Lane");
        c.setCity("Albuquerque");
        c.setState("New Mexico");
        c.setZip_code("87111");
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
        mockMvc.perform(put("/customers/{id}", c.getCustomer_id())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    // DELETE route that deletes an existing customer
    @Test
    public void deleteCustomerTest() throws Exception {
        String inputJson = mapper.writeValueAsString(c);
        mockMvc.perform(delete("/customers/{id}", c.getCustomer_id())
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

    // GET route that returns a specific customer by id
    @Test
    public void getCustomerByIDTest() throws Exception {
        String inputJson = mapper.writeValueAsString(c);
        mockMvc.perform((get("/customers/{id}", c.getCustomer_id()))
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
