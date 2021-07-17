# Recipes - Stage II implementation
Stage II implementation supports storage of multiple recipes. This is done using HashMap class from Java Standard Library. HashMap is not ideal because it is not thread safe and we may see unexpected behaviour, nevertheless for now HashMap it is as we will be using a database, H2, in the next stage. 

# Technical Details
Lombok (used in previous stage as well) is used to avoid boilerplate code. It will create getters, setters, a readable string, constructors, and overrrides the hashcode and equal methods. In addition @Component and @Autowired annotations of the Spring Framework lets objects be created at application startup, stored in a container (IoC Container) and injects them when the host class needs them. This takes off some of the load of the host class by letting the container manage the lifecycle of the objects. Objects created in this fashion are called beans.
Lastly when sending a recipe using a POST request the ingridients and directions keys are now JSON arrays.

### Server (using the built-in server that Spring MVC offers, Apache Tomcat) up and running

<img src="https://bl3302files.storage.live.com/y4mKRt6NO-DA7PtSN7URGP2_KTkJ7pRI-8iasdM3uG1QODeOZ9tPRIoRu1bdY0EzecWmVs-roys02WINUFhJOCB2sNXAR39XZ6SnF3MalcS2Ue3butn5uavZSHLzK9eVmL7dmTSwBQv_rJvD-eFz4qdaGZ0U-8K7rt3JVb1dkvtSPKkGfqChz5UN5zpnJzM7BXF?width=1920&height=1080&cropmode=none" width="1080" height="720" />

### Making a POST request

<img src="https://bl3302files.storage.live.com/y4mXr67_I4y12E_YHTqx8hoXF1CPZdIMJwu4sc9HbZbd6xG-mOSMuOhhrThyQ8SsZXGg07JsZnoOpBOXXCvyzla_GtTJ0uUVlTSW0jbaDEjVL_t3rsOBXsncPJkLjiJ3Rr2H88q0NB6mEB8sjbipnI5m1vkoK5ZMlC8woOtcms1z_DM02Pczu1JgiBEiVa5QK-p?width=1920&height=1080&cropmode=none" width="1080" height="720" alt= "GET request on POSTMAN"/>

1. The API has a new endpoint for POST request: /api/recipe/new
2. The body of the request is JSON text
3. We can see the success of the request as we receive the HTTP status code of 200
4. As a response we receive a ID which can be used to retrieve our recipe using GET request

### Making a GET request

<img src="https://bl3302files.storage.live.com/y4m-w_DUUVTTMwMtp7VqVThoZLnRZcgzMSdDyyqT-qYCIInjOmrRV0ii7gcchplV_oukl1o_QrvAksLpfWxs0_dEBxno4saafxi_2WaoEKZ2cIK7_YW3YOQoNEkpXX1kiyOCqUdKD-FN3M3PwUeImlrhKS9Uvkonm33ax94lEJfKpxvEgWg7K-pF8cxfTBGQAw8?width=1920&height=1080&cropmode=none" width="1080" height="720" alt= "GET request on POSTMAN"/>

1. The API has a new endpoint for GET request: /api/recipe/{id}
2. We can see the success of the request as we receive the HTTP status code of 200
3. As response we receive our recipe back (that is assuming our id is valid, incorrect id will result in a NOT_FOUND HTTP error)
