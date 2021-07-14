# Recipes - Stage I implementation
In stage I of the project I create a simple Web Service (REST API) which allows users to upload a recipe using a POST request and the body of the request to pass JSON data.
On a sucessful POST request the user can retrieve the recipe by making a GET request. The data they obtain is in JSON format. I have used POSTMAN to make both requests. Below are screenshots of the working application.

### Server (using the built-in server that Spring MVC offers, Apache Tomcat) up and running

<img src="https://1drv.ms/u/s!AnlqtLA7KeGYk3IMJTpzfs1NhjK6" alt="">

### Making a POST request

<img src="https://1drv.ms/u/s!AnlqtLA7KeGYk3HJ6mPjxMVgQ7Kv" alt="POST Request on POSTMAN">

We can see the success of the request as we receive the HTTP status code of 200 (shown in the red rectangular box)

### Making a GET request

<img src="https://1drv.ms/u/s!AnlqtLA7KeGYk3AMgNqQR7947rXu" alt="GET Request on POSTMAN">

We can see the success of the request as we receive the HTTP status code of 200 (shown in the small red rectangular box) and JSON response (shown in the large red rectangular box)
