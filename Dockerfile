FROM openjdk:26-ea-21-jdk-oraclelinux8

COPY target/*.jar /app.jar

CMD ["java", "-jar", "/app.jar"]
