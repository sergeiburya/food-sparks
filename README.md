
<div align="center"><img  src="src/main/resources/static/img/logo.jpg" height="50" title="Logo" alt=""/></div>
<h2 align="center">REST API</h2>
<h4 align="center">You can see the full implementation of the team project at the link: <a href="https://dev6379.dlymbcthwyxq5.amplifyapp.com/">FOODSPARKS</a></h4>


### Description: 
This application is the back-end part of the FOODSPARKS web service.<br>
The roles for users implemented in the application are ADMIN and USER.
Depending on the role, access to certain pages of the application is granted.
By default, the user is created with the role - USER.<br>
The service allows the user to choose a recipe of Ukrainian national cuisine depending on the region of the country, view step-by-step instructions for cooking the dish and order the selected products.<br>
The user is given the opportunity to register, after which the user receives an email to confirm the registration.<br> For the first order, the user receives a discount of 20% of the order amount.
After placing the order, the user receives a letter in the mail with an attachment of a PDF document with a detailed description of the completed order.<br>
A user with the ADMIN role has access to all pages of the application and can perform operations to add, change, search, and delete information in the following controllers:
* AddressController 
* ComplexityController
* CuisineRegionController
* DishTypeController
* GenderController
* OrderController
* ProductController
* RecipeController
* ShoppingCartController
* UserController
* WarehouseController 

After launching the application, the database (based on Liquibase scripts) will add products, recipes, and product balances in the warehouse, which are necessary to start working with the application.

### Project structure.
* Repository - Data Access Layer
* DTO - Data Transfer Object
* Service - Application logic layer
* RestControllers - Presentation layer

### Languages and Tools:
![Java](https://img.shields.io/badge/Java-11-%23ED8B00.svg?style=java&logo=java&logoColor=white)
![Sql](https://img.shields.io/badge/SQL-F8F8FF?style=flat&logo=mysql&logoColor=0000CD)
[![Lombok](https://img.shields.io/badge/Lombok-1.18.22-blue.svg)](https://projectlombok.org/)
![Hibernate](https://img.shields.io/badge/Hibernate-FFD700?style=flat&logo=Hibernate&logoColor=808080)
![Spring](https://img.shields.io/badge/Spring-9ACD32?style=flat&logo=Spring&logoColor=F8F8FF)
[![Spring Security](https://img.shields.io/badge/Spring%20Security-2.5.3-green.svg)](https://spring.io/projects/spring-security)
[![Spring MVC](https://img.shields.io/badge/Spring%20MVC-2.5.3-green.svg)](https://spring.io/projects/spring-framework)
[![Spring Boot Mail](https://img.shields.io/badge/Spring%20Boot%20Mail-2.5.3-green.svg)](https://spring.io/projects/spring-boot)
[![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-2.5.3-green.svg)](https://spring.io/projects/spring-data-jpa)
[![Liquibase](https://img.shields.io/badge/Liquibase-4.4.3-blue.svg)](https://www.liquibase.org/)
![JWT](https://img.shields.io/badge/JWT-black?style=badge&logo=JSON%20web%20tokens)
![Javax](https://img.shields.io/badge/Javax-FFE4B5?style=flat&logo=Javax&logoColor=F8F8FF)
[![Swagger](https://img.shields.io/badge/Swagger-2.0-green.svg)](https://swagger.io/specification/v2/)
![Git](https://img.shields.io/badge/Git-F8F8FF?style=flat&logo=Git&logoColor=FF0000)
![Maven](https://img.shields.io/badge/Maven-F8F8FF?style=flat&logo=apachemaven&logoColor=F4A460)
![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=apache&logo=apache-tomcat&logoColor=black)
![Html](https://img.shields.io/badge/HTML-F8F8FF?style=flat&logo=html5&logoColor=black)
![Mosquitto](https://img.shields.io/badge/mosquitto-%233C5280.svg?style=badge&logo=eclipsemosquitto&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=badge&logo=postman&logoColor=white)
![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=badge&logo=amazon-aws&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=badge&logo=intellij-idea&logoColor=white)
![Jira](https://img.shields.io/badge/jira-%230A0FFF.svg?style=badge&logo=jira&logoColor=white)

### Quick Start:
1. Clone the [repository](https://github.com/sergeiburya/food-sparks)
2. Install MySQL
3. Create schema food_sparks
4. Set the necessary database connection settings in the file [application.properties](src/main/resources/application.properties)   
5. Start application.

### About team
#### [Anastasiia Boiko](https://github.com/aanaanaasaa) - QA - Product Owner
#### [Viktoriia Melnyk](https://github.com/Viktoriia-Melnyk) - QA - Scrum master
#### [Tetiana Kuzub]() - UI/UX - Demo Presenter
#### [Azarov Artur](https://github.com/azarovartur) - Java Developer - Team Lead
#### [Serhii Buria](https://github.com/sergeiburya) - Java Developer - Team member
#### [Maksym Storozhuk](https://github.com/Fispil) - Frontend Developer -Team member
