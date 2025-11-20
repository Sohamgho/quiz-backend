# -------------------------------
# 1) Build Stage (Java 21 JDK)
# -------------------------------
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copy Maven wrapper & config
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (cache layer)
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src src

# Build the application
RUN ./mvnw clean package -DskipTests


# -------------------------------
# 2) Run Stage (Java 21 JRE)
# -------------------------------
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the JAR created in build stage
COPY --from=build /app/target/*.jar app.jar

# The port your Spring Boot application uses
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
