#CameraIQ Code Challenge
##Instructions
Consider the following details of an Organization and a User:

__Organization:__
* Name
* Address
* Phone

__User:__
* First Name
* Last Name
* Email
* Address
* Phone

Design and implement a simple application serving a RESTful API to perform operations on Organization as well as Users.
Please implement the challenge in any of the Java Web Frameworks. We are looking to see how you design and implement your model as well as your application.
We expect to be able to trace an endpoint down to the data transfer objects (DTO) that represent Organizations and Users. 
Feel free to provide additional documentation (UML, SQL scripts, comments, etc) that may communicate your design choices. 
We expect your API to support the following operations:

* Create a single Organization
* Create a single User
* Add a User to an Organization
* Delete a User from an Organization
* Read all Users who belong to a specific Organization
* Read all Organizations to which a User belongs

##Build and Run the Project
In order to launch the application you may use one of the following ways:
###From Source Code:
####Requirements:
* Java 11
* Gradle 5

####Steps:
- ```git clone https://github.com/sajjadbashar/camera-iq.git```
- change directory to project root folder
- ```./gradlew bootJar```
- ```./build/lib/camera-iq.jar```

###From Container:
####Requirements:
* Docker
####Steps:
- ```git clone https://github.com/sajjadbashar/camera-iq.git```
- change directory to project root folder
- ```docker build -t camera-iq .```
- ```docker run --rm -p 8080:8080 camera-iq```

\* **Make sure you have docker configured to listen on `localhost`**

After launching the application, the API will be listeting on `localhost:8008`. You may use the API calls to test the application.

##API Reference
Method|Path|Request Body Sample|Description
---|---|---|---
__GET__|`/organizations`| |Retrieve the list of all organizations
__POST__|`/organizations`| ```{"name": "CameraIQ", "phone": "888-123-4455", "address": "1615 16th St, Santa Monica, CA 90404"  }```|Create a new organization
__GET__|`/organizations/{id}`| |Retrieve a single organization by given `id`
__DELETE__|`/organizations/{id}`| |Remove a single organization by given `id`
__GET__|`/organizations/{id}/users`| |Retrieve the list of users in a single organization by given `id`
__POST__|`/organizations/{id}/users/{user_id}`| |Add a user by given `user_id` to an organization by given `id`
__DELETE__|`/organizations/{id}/users/{user_id}`| |Remove a user by given `user_id` from an organization by given `id`
__GET__|`/users`| |Retrieve the list of all users
__POST__|`/users`| ```{ "firstName": "Jane", "lastName": "Doe", "email": "janedoe@example.com", "phone": "909-987-6655", "address": "123 Alpine Ave, Culver City, CA 90232" }```|Create a new user
__GET__|`/users/{id}`| |Retrieve a single user by given `id`
__DELETE__|`/users/{id}`| |Remove a single user by given `id`
__GET__|`/users/{id}/organizations`| |Retrieve the list of organizations in a single user by given `id`
 


