# Etapa 1: Construir con Maven
FROM maven:latest AS build
WORKDIR /app
COPY . /app
RUN mvn clean package

# Etapa 2: Crear el contenedor para despliegue
FROM openjdk:17-ea-oraclelinux8
WORKDIR /app
COPY --from=build /app/target/siscope-tarifario-0.0.1-SNAPSHOT.jar /app

EXPOSE 8081
CMD ["java", "-jar", "siscope-tarifario-0.0.1-SNAPSHOT.jar"]
