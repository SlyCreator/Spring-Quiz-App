# Spring Quiz App

This is a quiz app built with spring boot java framework

## Installation

Setup JDK in your computer before you can run this project.You can follow this link to setup java on your computer.

https://phoenixnap.com/kb/install-java-windows

Clone the repository into the your computer.

Open the application in your favorite IDE/Text Editor.

Locate the application.properties file and modify the database username,password,

```bash
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3306/database-name //modify the databaseName
spring.datasource.username = root //Modify this to your sql usernmae
spring.datasource.password = password //modify this to sql password or blank if it doesnt have.
spring.jpa.show-sql = false
spring.jpa.hibernate.ddl-auto = create
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
server.port=9003
```

## Usage

Run the application from you IDE using the `Run` button or you can use the terminal to run the project.
use the below command to launch the application
```maven
mvn spring-boot:run
```

### Software Design


### Domain
- User : This holds the information of the user entity.A using has a one to many relationship
- Question : This holds a text field that store the questions into the table
- Option : This holds the options that are available to a queston,also have a many to one relationship with  Question
- Quiz : This belong to a user.it stores the quiz session that a user took.
- QuizAnswer: This holds the information of the answer a user took.Also with it questionId.

### Api Documentation:
The api documentation was documented using postman.


[Api Documentation](https://documenter.getpostman.com/view/18994692/UVeFMS5j#140e21fc-a666-44e2-9060-eee40d820b19)

