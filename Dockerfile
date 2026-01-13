FROM openjdk:26-ea-21-jdk-oraclelinux8

WORKDIR /app
COPY target/*.jar /app.jar

ENV JAVA_OPTS=""
# Ejecuta cuando se inicia el contenedor
CMD ["java", "-jar", "app.jar"]
