FROM openjdk:8
EXPOSE 8080
ADD target/QuizApp.jar QuizApp.jar
ENTRYPOINT["java","-jar","/QuizApp.jar"]