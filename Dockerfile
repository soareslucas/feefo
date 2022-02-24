
# Run stage
#
FROM openjdk:8-jdk-alpine
ADD target/*.jar correlation.jar
#COPY --from=build /target/Jumia-0.0.1-SNAPSHOT.jar /jumia.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/correlation.jar"]


