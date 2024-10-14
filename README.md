# Social Network Analysis Tool Implementation
# Objective
## Problem Statement
- Develop a social network analysis tool that allows users to manage a social network and performs various analysis on it.
- The system should support operations such as adding users, creating friendships, finding the shortest path between users, and identifying communities.
## NFRs
- Duration of this exercise is 120 minutes. Please manage your time accordingly.
## Features
  1. #### **User Management** 
     - **Add a new user**: Create a new user with userId, name and email. 
     - **Remove a user**: Delete a user by their userId. 
     - **List all users**: Retrieve a list of all registered users.
  2. #### **User Management**
     - **Create a friendship**: Establish a friendship between two users by their userIds.
     - **Remove a friendship**: Remove a friendship between two users.
     - **List friend of a user**: Retrieve a list of all friends of a specific user.
  3. #### **Network Analysis**
     - **Shortest path**: Find the shortest path between two users (minimum number of connections).
     - **Community detection**: Identify groups of users who are densely connected to each other.
     - **Degree centrality**: Calculate the number of direct connections (friends) each user has.
##
  
### Technology stack
 - Java 21
 - Spring Boot 3.x
 - Neo4j 5.x (graph database)
 - Maven (Dependency Management)
 - Junit5 & Mockito (Unit testing)

### Pre-requisites:
 - Java 17 or later
 - Neo4j (Install Neo4j and ensure the server is running)
 - Maven 3.6+

## Getting Started
 ### Steps:
1. Clone the repository 
    ```bash
    git clone https://github.com/Bayvao/social-network-analysis.git
    ``` 
2. Configure Neo4j
    ```bash
   spring.neo4j.url=bolt://localhost:7687 
   spring.neo4j.authentication.username=your_username
   spring.neo4j.authentication.password=your_password 
   ``` 
3. Run `mvn clean install` to build the project

## REST API Endpoints
1. ### User Management
    * **Add a new user**: POST /users
      * Request Body:   
        ```json
        { 
            "userId": "john",
            "name": "John Doe",
            "email": "john.doe@example.com"
        }
        ```
    * **Delete a user**: DELETE /users/{userId}
    * **List all users**: GET /users
