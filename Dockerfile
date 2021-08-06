# this image will be used in application build process, we need jdk to build java application
FROM openjdk:11-jdk as builder

# change work dir (current dir)
WORKDIR /tmp/spring

# copy all project to docker
COPY . .

# build an test project
RUN ./mvnw package

# this is runtime image, we need jre for running java application
FROM openjdk:11-jre

# create working dir
WORKDIR /opt/spring

# copy only jar from previous image
COPY --from=builder /tmp/spring/target/spring-mongo-demo-0.0.1-SNAPSHOT.jar spring-mongo-demo.jar

# expose port (for spring default is 8080, if changed in config then should be changed in expose)
EXPOSE 8080

# command that will be runned after container start - launch the spring application
CMD ["java", "-jar", "spring-mongo-demo.jar"]
