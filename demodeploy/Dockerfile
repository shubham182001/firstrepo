FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy only what is needed first (faster builds)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy the source code
COPY src ./src

# Build the project
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

# Run your app
CMD ["java", "-jar", "target/demodeploy-0.0.1-SNAPSHOT.jar"]
