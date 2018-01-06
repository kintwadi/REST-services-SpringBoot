# REST-services-SpringBoot
Let's create a REST service for a  “Member” service so that we can easily:  -- Create a new member  -- Read an existing member  -- Update an existing member  -- Delete member(s) which are no longer used  -- List existing members No frontend, only REST services.  

Criterias:

Member attributs are:  
First name 
Last name 
Date of birth 
Postal code (ZIP)

steps:

    Accepts JSON or XML
    Response in JSON or XML
    Input validation
    Error handling via HTTP status code and specific message constraints
    Data storage: (in memory) database (derby)

----------------------------***----------------------

Evironment and tools 
IDE: eclipse 
Dependecy: Maven 
version: JDK8/JDK9
------------------------**----------------------------

Sample: Use curl commands for queries, for instance:
1. create some members:
curl -H "Content-Type: application/json" -X POST -d '{"firstName":"Antonio","lastName":"Mabiala", "dateOfBirth": "2000-10-10", "postalCode":"76308"}' \http://localhost:8080/task/createMember

2 check inserted members

curl -H "Content-Type: application/json" -X GET http://localhost:8080/task/getAll

3. read member with ID 1

curl -H "Content-Type: application/json" -X GET http://localhost:8080/task/getMember/1

4. update member with ID 1

curl -H "Content-Type: application/json" -X PUT -d '{"firstName":"Jose Eduardo","lastName":"dos Santos", "dateOfBirth": "1866-06-06", "postalCode":"00000"}' \http://localhost:8080/task/updateMember/1


#5. delete a member by ID curl -H "Content-Type: application/json" -X DELETE http://localhost:8080/task/deleteMember/1
#6. delete all members curl -H "Content-Type: application/json" -X DELETE http://localhost:8080/task/deleteAll

Using an IDE:

    import the project as Maven project and run.

    Use an external RESTClient for queries.

