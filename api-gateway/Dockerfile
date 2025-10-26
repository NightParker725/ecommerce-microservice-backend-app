FROM openjdk:11
WORKDIR /home/app
ENV SPRING_PROFILES_ACTIVE=dev
COPY target/api-gateway-v0.1.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "-jar", "app.jar"]
