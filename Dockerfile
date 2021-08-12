# This image contains only runtime for application, application should be build before building image

# this is runtime image, we need jre for running java application
FROM openjdk:11-jre

# create working dir
WORKDIR /opt/spring

# copy only jar from local target directory
COPY build/libs/spring-mongo-demo-*.jar spring-mongo-demo.jar

# expose port (for spring default is 8080, if changed in config then should be changed in expose)
EXPOSE 8080

# command that will be runned after container start - launch the spring application
CMD ["java", "-jar", "spring-mongo-demo.jar"]
