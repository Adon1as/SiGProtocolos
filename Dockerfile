FROM maven:3.8.7-eclipse-temurin-17-alpine AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

RUN apk add --no-cache nodejs npm
RUN mvn vaadin:build-frontend
RUN mvn clean package -DskipTests


FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar ./app.jar

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]