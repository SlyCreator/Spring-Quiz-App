FROM openjdk:8-jdk-alpine
#FROM openjdk:8
EXPOSE 8080
ADD target/quiz-app.jar quiz-app.jar
ENTRYPOINT ["java","-jar","/quiz-app.jar"]


