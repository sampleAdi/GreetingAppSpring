﻿My-Greeting-App:

A Spring Boot application for managing greeting messages with CRUD operations, user authentication, and additional features like email notifications and API documentation.

---

Branches Overview:


main - The main branch of the project.

UC1_greeting - Basic greeting functionality.

UC2_service_greeting - Service layer implementation for greetings.

UC3_user-name_greeting - Greeting with a custom name.

UC4_save_greeting - Save greeting messages.

UC5_find_greeting - Fetch a greeting by ID.

UC6_listAll_greeting - List all saved greeting messages.

UC7_editMsg_greeting - Edit existing greeting messages.

UC8_deleteMsg_greeting - Delete greeting messages.

UC9_RegisterLogin_greeting - User authentication (Registration & Login).

UC10_swagger_greeting - API documentation using Swagger.

UC11_sendingEmails_greeting - Sending emails upon successful registration.

UC12_resetpassword_greeting - Implemented reset and forgot password feature.


---


Features:


  - Create, Read, Update, and Delete (CRUD) operations for greetings.
  
  - Personalized greetings with names.
  
  - User authentication (registration & login).
  
  - API documentation with Swagger.
  
  - Email notifications for registration and password reset.


---


Technologies Used:

  - Spring Boot 3.4.3
  
  - Spring Security (for authentication)
  
  - H2 Database (for local development)
  
  - Swagger (for API documentation)
  
  - Maven (for dependency management)


---


Installation & Run:


  Clone the repository:
  
    - git clone <repository-url>
  
  Navigate to the project directory:
  
    - cd greetingApp
  
  Build and run the application:
  
    - mvn spring-boot:run
  
  Access Swagger UI for API documentation:
  
    - http://localhost:8090/swagger-ui.html
