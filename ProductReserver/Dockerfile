FROM eclipse-temurin:11-jdk-jammy

WORKDIR /app

COPY .mvn/ .mvn
COPY ./mvnw pom.xml ./
COPY src ./src

EXPOSE 6000

CMD ["./mvnw", "spring-boot:run"]