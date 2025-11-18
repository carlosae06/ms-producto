FROM openjdk:26-ea-21-jdk-oraclelinux8

WORKDIR /app
COPY target/*.jar /app.jar

# Ejecuta cuando se inicia el contenedor
ENTRYPOINT ["java", "-jar", "app.jar"]
