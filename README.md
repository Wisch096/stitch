# stitch

This is a SpringBoot API.

## Project Setup

Make sure you have your Java and Spring Boot development environment configured. If not, you can follow the instructions in the official Spring Boot documentation to set up your environment: [Spring Boot Documentation](https://spring.io/guides/gs/spring-boot/)

## Database Configuration

The project uses an in-memory H2 database to simplify configuration. The `src/main/resources/application.properties` file contains the database configurations.

I've also left commented-out configurations for PostgreSQL in both the `application.properties` file and `pom.xml` file, in case you want to use PostgreSQL. I used H2 for ease of development.

## CRUD Functionality

The project includes the following CRUD functionalities:

1. **Add Person**

   - Method: POST
   - Endpoint: `/person`
   - Payload: JSON with `name` and `department` fields
   - Example Payload:
     ```json
     {
       "name": "Alice",
       "department": "Department A"
     }
     ```

2. **List Persons**

   - Method: GET
   - Endpoint: `/person`

3. **Add Task**

   - Method: POST
   - Endpoint: `/task`
   - Payload: JSON with `title`, `description`, `deadline`, `department`, and `allocatedPersonId` fields
   - Example Payload:
     ```json
     {
       "title": "Task 1",
       "description": "Description for Task 1",
       "deadline": "2023-09-01",
       "department": "Department A",
       "allocatedPersonId": 1
     }
     ```

4. **List Tasks**

   - Method: GET
   - Endpoint: `/task`

5. **Allocate Task to Person**

   - Method: PUT
   - Endpoint: `/task/allocate/{id}`
   - Example Endpoint: `/tasks/allocate/1`

6. **Finish Task**

   - Method: PUT
   - Endpoint: `/tasks/finish/{id}`
   - Example Endpoint: `/tasks/finish/{id}`

7. **List Oldest Unallocated Tasks**

   - Method: GET
   - Endpoint: `/tasks/pending?limit=3`
   - Example Endpoint: `/tasks/pending?limit=3`

8. **List Department Summaries**

   - Method: GET
   - Endpoint: `/departments`

9. **Search People by Name and Period, Returning Average Expenses per Task**

   - Method: GET
   - Endpoint: `/person/spending`
   - Query Parameters:
     - `name` (required): The name of the person for whom you want to retrieve expenses.
     - `dataInicio` (required): The start date of the period to calculate expenses (ISO 8601 format).
     - `dataFim` (required): The end date of the period to calculate expenses (ISO 8601 format).
   - Response: A list of JSON objects containing information about people's expenses within the specified period.
   - Example Endpoint: `/expenses?name=Alice&dataInicio=2023-01-01&dataFim=2023-12-31`
     ```json
     [
       {
         "name": "Alice",
         "totalExpenses": 250.0
       },
       {
         "name": "Carol",
         "totalExpenses": 150.0
       }
     ]
     ```

## Running the Project

1. Clone the repository to your local machine.
2. Open the project in your IDE (e.g., IntelliJ IDEA or Eclipse).
3. Run the `MatheusApplication` class to start the Spring Boot application.
4. Use tools like Postman or cURL to test the CRUD functionalities.

This project showcases a robust CRUD application built using Spring Boot and Spring Data JPA. It includes advanced features like custom queries, entity relationships, and comprehensive CRUD operations. The project provides a solid foundation for creating similar applications and demonstrates strong proficiency in Java web development.

For any further inquiries or discussions, feel free to reach out.

Happy coding!
