SpringAcademicProject

A college academic project that uses Spring Web with Maven, Thymeleaf, JPA, and MySQL to simulate a restaurant management application.

In this project, two applications were created that connect to the same database:

RestaurantADM: A management application that allows creating, reading, updating, and removing restaurants, as well as their menu items (full CRUD).

Customer: A customer portal that allows users to read restaurant menus and place orders, which are added to a cart saved in the HTTP session.

The project explores the Spring Framework, using Spring Data JPA for database operations and Thymeleaf for front-end rendering. Basic HTML and CSS were used to create a more user-friendly interface.

Features

1. Admin Module (RestaurantADM)

Restaurants:

[X] Create new restaurants.

[X] List all restaurants.

[X] Update restaurant information.

[X] Delete a restaurant.

Menu Items:

[X] Add new items to a specific restaurant.

[X] List all items for a restaurant.

[X] Update an item's information.

[X] Delete a menu item.

2. Customer Module (Customer)

Menu:

[X] List all restaurants.

[X] View the complete menu of a selected restaurant.

Shopping Cart:

[X] Add menu items to the cart.

[X] The cart is unique for each user, stored in the HTTP session (@SessionScope).

[X] View items in the cart and the total order amount.

Technologies Used

Back-end: Spring Boot (Spring Web, Spring Data JPA)

Front-end: Thymeleaf, HTML5, CSS3

Database: MySQL

Dependency Management: Maven

How to Run

Clone the repository:

git clone [https://github.com/YourUser/SpringAcademicProject.git](https://github.com/YourUser/SpringAcademicProject.git)
cd SpringAcademicProject


Configure the Database:

Open the application.properties files in:

RestaurantADM/src/main/resources/application.properties

Customer/src/main/resources/application.properties

Update the following lines with your MySQL credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=your_mysql_user
spring.datasource.password=your_mysql_password


Run the applications:
You can run each application (RestaurantADM and Customer) separately from your IDE (IntelliJ, STS) or via Maven.

To run with Maven (one at a time, in separate terminals):

# In terminal 1 (inside the RestaurantADM folder):
cd RestaurantADM
mvn spring-boot:run

# In terminal 2 (inside the Customer folder):
cd Customer
mvn spring-boot:run
