# Sử dụng Maven với JDK 21 để build ứng dụng
FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY . .

# Chạy lệnh Maven để build project and  chạy các unit tests
RUN mvn clean package -DskipTests

# Sử dụng JDK 21 để chạy ứng dụng sau khi đã build
FROM eclipse-temurin:21-jre

COPY --from=build /app/target/ProjectSpringboot-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]


