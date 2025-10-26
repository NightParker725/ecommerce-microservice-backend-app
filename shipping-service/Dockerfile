FROM openjdk:11
WORKDIR /home/app
ENV SPRING_PROFILES_ACTIVE=dev
COPY target/shipping-service-v0.1.0.jar app.jar
EXPOSE 8600
ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "-jar", "app.jar"]
