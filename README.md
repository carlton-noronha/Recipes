# Recipes - Stage I implementation
In stage I of the project I create a simple Web Service (REST API) which allows users to upload a recipe using a POST request and the body of the request to pass JSON data.
On a sucessful POST request the user can retrieve the recipe by making a GET request. The data they obtain is in JSON format. I have used POSTMAN to make both requests. Below are screenshots of the working application.

### Server (using the built-in server that Spring MVC offers, Apache Tomcat) up and running

<img src="https://bl3302files.storage.live.com/y4mKRt6NO-DA7PtSN7URGP2_KTkJ7pRI-8iasdM3uG1QODeOZ9tPRIoRu1bdY0EzecWmVs-roys02WINUFhJOCB2sNXAR39XZ6SnF3MalcS2Ue3butn5uavZSHLzK9eVmL7dmTSwBQv_rJvD-eFz4qdaGZ0U-8K7rt3JVb1dkvtSPKkGfqChz5UN5zpnJzM7BXF?width=1920&height=1080&cropmode=none" width="1080" height="720" />

### Making a POST request

<img src="https://bl3302files.storage.live.com/y4miB3OA7lJCE69RK-aNu2yllqjBW8A4_nieHGVSfrlCqoA9S5r7HycBLwspzYJeyGsujCofxkhCe0_-rmxX0IekxDc_xemWPTjiXqzP73Jn1FPT21yPlP7GIHJWeGGRPge6lMEHBfly6uF6uO-bprjjKLLDyo3V33uwXzBUpKBD1Z2rS98XabawA2JFNiOTQCU?width=1920&height=1080&cropmode=none" width="1080" height="720" alt="POST request on POSTMAN"/>

We can see the success of the request as we receive the HTTP status code of 200 (shown in the red rectangular box)

### Making a GET request

<img src="https://bl3302files.storage.live.com/y4mOoK8gk06yZKV1yg2QniBxYg7U5UhIRykywojaqI-pjdNyY9twg7OkmIg1R15PLInkXysdM_libQ750ee5zQesRoWXkfuHatskGVh7aGaoxlLly608Qaj2X4GbBjvpP1PdwPVz3tcO1TsA7Gy47Pa1T7QxHYfbb6qk10UIq08qPz-gPXc8T-ZZ5MISNNYUi7E?width=1920&height=1080&cropmode=none" width="1080" height="720" alt= "GET request on POSTMAN"/>

We can see the success of the request as we receive the HTTP status code of 200 (shown in the small red rectangular box) and JSON response (shown in the large red rectangular box)
