package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        ArrayList<Customer> customerList = new ArrayList<>();
        // format: 0: ID, 1: company name, 2: charge, 3: date
        for(String[] x: customerData){ // iterates through every ArrayList

            // parsing data
            int id = Integer.parseInt(x[0]);
            String companyName = x[1];
            int charge = Integer.parseInt(x[2]);
            String date = x[3];

            // create customer object (find through id)
            Customer customer = findCustomerById(customerList, id);

            // if no customer has that id, make a new one
            if(customer == null){
                customer = new Customer();
                customer.setId(id);
                customer.setName(companyName);
                customerList.add(customer);
            }
           AccountRecord record = new AccountRecord();
           record.setCharge(charge);
           record.setChargeDate(date);
           customer.getCharges().add(record);
        }
        printCustomerList(customerList);
    }

    // helper method to find customer ID, returns null if not found
    private static Customer findCustomerById(ArrayList<Customer> customers, int id){
        for (Customer customer: customers) {
            // if found customer with given id, return it
            if (customer.getId() == id) {
                return customer;
            }
        }
         return null; // if nothing found
    }
    // prints customer list in order of: positive accounts -> neg accounts -> zero accounts
    private static void printCustomerList(ArrayList<Customer> customers){
        ArrayList<Customer> pos = new ArrayList<>();
        ArrayList<Customer> neg = new ArrayList<>();
        ArrayList<Customer> zero = new ArrayList<>(); // zero case
        printSeparator();
        for (Customer customer : customers){
            if(customer.getBalance() > 0){
                pos.add(customer);
            }else if(customer.getBalance() < 0){
                neg.add(customer);
            }else{
                zero.add(customer);
            }
        }
        // printing of positive, negative and neutral values
        System.out.println("Positive accounts:\n");
        for(Customer customer: pos){
            System.out.println(customer.toString());
        }
        emptyNotification(pos);
        printSeparator();
        System.out.println("Negative accounts:\n");
        for(Customer customer: neg){
            System.out.println(customer.toString());
        }
        emptyNotification(neg);
        printSeparator();
        System.out.println("Neutral accounts:\n");
        for(Customer customer: zero){
            System.out.println(customer.toString());
        }
        emptyNotification(zero);
        printSeparator();
    }

    private static void printSeparator(){
        System.out.println("***************************************************************\n");
    }

    // if empty then say it is empty
    private static void emptyNotification(ArrayList<Customer> customers){
        if(customers.size() == 0){
            System.out.println("No results found.\n");
        }
    }
}
