FROM openjdk:11
WORKDIR /home/app
ENV SPRING_PROFILES_ACTIVE=dev
COPY target/product-service-v0.1.0.jar app.jar
EXPOSE 8500
ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "-jar", "app.jar"]
