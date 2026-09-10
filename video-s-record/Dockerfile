FROM eclipse-temurin:26-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:26-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
RUN mkdir -p /app/uploads/covers /app/uploads/music
COPY uploads /app/uploads
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]