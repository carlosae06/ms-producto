FROM openjdk:26-ea-21-jdk-oraclelinux8

RUN mkdir /app
RUN addgroup -S test && adduser -S test -G test
RUN chown -R test:test /app

USER test
WORKDIR /app
COPY target/*.jar /app.jar

# Ejecuta cuando se inicia el contenedor
ENTRYPOINT ["java", "-jar", "/app.jar"]
CMD ["algo"]
