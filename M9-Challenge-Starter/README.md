## Module Challenge: Record Store API Secured

### Overview

Starter code: [./starter](./starter)

In this challenge, you will refactor the provided Record Store API to enforce authentication via OAuth.

### Goals

The goal of this challenge is to reinforce your knowledge of OAuth.

Specifically, you'll do the following:

1. Create an Authorization Server which will facilitate authentication via OAuth.

2. Refactor the provided Record Store API application to enforce authentication accordingly.

### Instructions

1. Create a new local folder named `M9-Challenge-Lastname-Firstname`.  Add all code for this challenge to this folder.

2. Using the techniques described in class, create an Authorization Server which will facilitate OAuth authentication for the provided Record Store API application.

3. For the Authorization server, create a few user accounts for testing purposes.

4. Using the techniques described in class, refactor the provided Record Store API starter project such that the controller enforces authentication via OAuth for all Record Store API routes.

5. Using Insomnia, verify the following:

- An unauthenticated client is unable to access any of the API routes.

- An authenticated OAuth client is able to access all routes, including `GET`, `PUT` and `DELETE` operations.

### Submission

1. **Copy your folder:** When you have completed your challenge, copy your completed `M9-Challenge-Lastname-Firstname` folder into your personal GitHub repository, commit, and push to GitHub.

2. **Confirm:** Navigate to your GitHub repository and confirm that the `M9-Challenge-Lastname-Firstname` folder exists and contains your code.

### Grading Requirements

In this challenge, your grade will consist of a combination of general setup and format requirements and your actual code. Refer to the following criteria for more detailed information.

#### General Setup and Format Requirements: 20 pts

- Challenge is in a folder named `M9-Challenge-Lastname-Firstname`. **5 pts**

- Code is clean and follows general patterns, as presented in class. **15 pts**

#### Authorization Server: 40 pts

Implements the following functionality:

- Returns bearer tokens only when provided with valid username/password pairs. **15 pts**

- Stores user data in MySQL via the Spring Security Schama. **10 pts**

- Validates tokens provided by the Record Store API and sends back the user data associated with the given token. **15 pts**

#### Record Store API: 40 pts

Implements the following functionality:

- Prevents unauthenticated clients access to all API routes. **20 pts**

- Provides access to `GET`, `PUT` and `DELETE` routes to authenticated clients. **20 pts**

---

© 2023 2U. All Rights Reserved.
