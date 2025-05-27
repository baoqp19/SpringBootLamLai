# Sử dụng Maven với JDK 21 để build ứng dụng
FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY . .

# Chạy lệnh Maven để build project and  chạy các unit tests
RUN mvn clean package -DskipTests

# Sử dụng JDK 21 để chạy ứng dụng sau khi đã build
FROM openjdk:21-jdk
COPY --from=build /app/target/ProjectSpringboot-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]


# # Sử dụng Maven với JDK 21 để build ứng dụng
# FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
# WORKDIR /app

# # Chỉ copy các file cần thiết trước để tối ưu cache
# COPY pom.xml .
# COPY src ./src

# # Build ứng dụng, bỏ qua test để build nhanh hơn
# RUN mvn clean package -DskipTests

# # Sử dụng JDK 21 để chạy ứng dụng sau khi đã build
# FROM openjdk:21-jdk-slim
# WORKDIR /app

# # Copy JAR file đã được build từ stage trước
# COPY --from=build /app/target/ProjectSpringboot-0.0.1-SNAPSHOT.jar app.jar

# # Mở port 8080 (dành cho docker run hoặc môi trường cloud)
# EXPOSE 8080

# # Khởi chạy ứng dụng
# ENTRYPOINT ["java", "-jar", "app.jar"]
