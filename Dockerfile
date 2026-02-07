FROM maven:3.9.12-eclipse-temurin-17 as build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17
WORKDIR /app

COPY --from=build /app/target/marabot02.jar marabot02.jar

COPY .env .env

ENTRYPOINT [ "java", "-jar", "marabot02.jar" ]