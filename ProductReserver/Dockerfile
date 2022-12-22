FROM eclipse-temurin:11-jdk-focal

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN mkdir /opt/app ./mvnw dependency:go-offline

COPY src ./src

EXPOSE 6000

CMD ["./mvnw", "spring-boot:run"]