# Module 1 Challenge: Account Balancing

## 1. Application Overview

This application is a command-line application that will parse accounting information and output user-readable reports.

## 2. Goals

The goal of this Challenge is to reinforce your knowledge of Git, GitHub, and Java. Specifically, you will do the following:

* Iterate through collections using fundamental Java concepts.

* Convert raw data into Java classes.

* Print specific data using control flow statements or streams.

* Commit code to a Git repository.

* Push your local repository to a remote repository.

## 3. Instructions

In the starter code, you will find a partially completed application that contains a hardcoded `List<String[]>` of `Customer` information.  

Requirements:

* Update the `main()` method in the `Main` class.

* Iterate through a `List<String[]>` that contains multiple records for each `Customer`, converting it into `List<Customer>` where there is only one copy of each customer (`Integer.parseInt()` converts a `String` to an integer).

* Update the `getBalance()` method in the `Customer` class to sum all charges.

* Update the `toString()` method in the `Customer` class to print the customer ID, customer name, and customer balance.

* Add JUnit test cases to test your newly added `getBalance()` and `toString()` functionality.

You must also complete the following user stories:

* As a user, I would like to access a list of all accounts that are positive. (Use `System.out.println`.)

* As a user, I would like to access a list of all accounts that are negative. (Use `System.out.println`.)

## 4. Submission

The submission process might seem intimidating, but it will become second nature in no time. Follow these steps to submit your Challenge:

1. **Create and clone a working Java repo:** On the GitHub website, create a repository called `YourFirstName_YourLastName_Java`. Clone the repository onto your machine.

2. **Copy your folder:** When you have completed your Challenge assessment, copy your completed `M1-Challenge-Lastname-Firstname` folder (located inside in your Working Folder Java) into your personal GitHub repository folder located on your desktop.

3. **Complete the commands:** Once the `M1-Challenge-Lastname-Firstname` folder has been copied into the GitHub repository folder, navigate into your GitHub repository in either your terminal (macOS) or Git Bash (Windows). Once you have navigated to the appropriate repository, complete the following commands (which should be familiar):

    * `git add -A`

    * `git commit-m"< commit message >"` (where `< commit message >` is your commit message for the commit)

    * `git push origin master`

4. **Navigate:** Open your personal GitHub account. Navigate to the  `YourFirstName_YourLastName_Java` repository.

5. **Confirm:** Select the `M1-Challenge-Lastname-Firstname` folder that you created and uploaded. Confirm that ALL of the expected projects have been included inside that folder. Again, the folder name should be related to the module associated with the Challenge.

Finally, make sure to double-check that you've completed your submission!

## 5. Grading Requirements

In this Challenge, your grade will consist of a combination of general setup and formatting requirements and your actual code. Refer to the following criteria for more detailed information.

### 5.1 General Setup and Format Requirements: 10%

* Your solution must reside in an IntelliJ project called `M1-Challenge-Lastname-Firstname`&mdash;**5%**

* Code is clean (follows general patterns as presented in class)&mdash;**5%**

### 5.2 Unique Customers: 20%

* Find all of the unique customers

### 5.3 Customer Balance: 20%

* Add the charges to the balance for each customer&mdash;**10%**

* Sum the charges to get the balance for a customer&mdash;**10%**

### 5.4 Print Customer: 20%

* Print customer information

### 5.5 Positive Balances: 10%

* Find and display all accounts with a positive balance

### 5.6 Negative Balances: 10%

* Find and display all accounts with a negative balance

### 5.7 Test Cases: 10%

* Verification of `getBalance()` functionality&mdash;**5%**

* Verification of `toString()` functionality&mdash;**5%**

---

© 2023 2U. All Rights Reserved.
