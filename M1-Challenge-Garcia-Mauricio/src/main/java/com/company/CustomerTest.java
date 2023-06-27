package com.company;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer customer = new Customer();
    AccountRecord record = new AccountRecord();

    @BeforeEach
    void setUp(){ // wipes info before every test
        customer = new Customer();
        customer.setId(3);
        customer.setName("The Krusty Krab");
        record = new AccountRecord();
    }

    @org.junit.jupiter.api.Test
    void getBalanceAllPositive() {
        record.setCharge(20000);
        customer.getCharges().add(record);

        record = new AccountRecord();
        record.setCharge(5000);
        customer.getCharges().add(record);

        record = new AccountRecord();
        record.setCharge(5000);
        customer.getCharges().add(record);

        assertEquals(30000, customer.getBalance());
        printOutput(30000, customer.getBalance());
    }

    @org.junit.jupiter.api.Test
    void getBalanceMixed() {
        record.setCharge(-20000);
        customer.getCharges().add(record);

        record = new AccountRecord();
        record.setCharge(5000);
        customer.getCharges().add(record);

        record = new AccountRecord();
        record.setCharge(5000);
        customer.getCharges().add(record);

        assertEquals(-10000, customer.getBalance());
        printOutput(-10000, customer.getBalance());
    }

    @org.junit.jupiter.api.Test
    void getBalanceAllNegatives() {
        record.setCharge(-10000);
        customer.getCharges().add(record);

        record = new AccountRecord();
        record.setCharge(-1000);
        customer.getCharges().add(record);

        record = new AccountRecord();
        record.setCharge(-1000);
        customer.getCharges().add(record);

        assertEquals(-12000, customer.getBalance());
        printOutput(-12000, customer.getBalance());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        record.setCharge(-21000);
        customer.getCharges().add(record);
        System.out.println(customer.toString());
    }

    void printOutput(int expected, int actual){
        System.out.println("Expected: " + expected + "  | Actual: " + actual);
    }
}