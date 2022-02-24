Feefo Technical Assessment

The project was built with Spring Boot and the DataBase is embedded.

This is an Maven Project so it's required to have mvn installed in the system.

So, by following the commands bellow you will able to run the project:

1) mvn install

2)  mvn spring-boot:run 


If you want to run only the tests , you may execute the following command:

1) mvn test


Interactions to the api:

- 1 

    Pass the string to be normlised through the param {jobTitle}
    in the url.

    If you want to test the string "C# Engineer" please replace
    the char # for %23.

    Returns the Job Title Normalised

    URL: localhost:8080/normalise/{jobTitle} - GET



If you want to test the basic CRUD operations over the api, it's mapped 
acording the proper methods HTTP (PUT, DELETE, POST etc) from the path "/api/".
For example, if you want to insert a new entity 'job', use the URL "/api/jobs/".
