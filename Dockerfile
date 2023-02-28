FROM openjdk:11
EXPOSE 8235
ADD /target/Camunda-1.0.0-SNAPSHOT.jar Camunda.jar
ENTRYPOINT ["java","-jar","/Camunda.jar"]