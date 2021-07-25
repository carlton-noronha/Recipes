# Stage III implementation
In this stage I permanently store recipes in H2 Database this database is locally stored on the user's computer. Also the user can now delete a recipe now from the database through a DELETE request. DELETE request is available at the same endpoint as GET request: /api/recipe/{id}.  One successful deletion HTTP Status Code 204 (NO CONTENT) is returned.

## Technical Details:
In this project rather than using JDBC, ORM (object relational model) is used. When using ORM, entities of the database are represented using Classes and the columns of the entity are represented through the fields of the class. The classes and their respective fields need to be annotated appropriately.

In this project as Software architecture the layered architecture is used. It has 4 main layers and each layer communicates with exactly the layer directly above or below it. The four layers are as follows from top to bottom:

1. Presentation layer: responsible for creating the view the user can interact with.
2. Business layer: implements the rules for solving the problem for which the application is being developed.
3. Persistence layer: handles the data storage and also responsible for ORM mapping
4. Databse layer: which actually implements the database storage, creates tables etc.

Some small details have been taken care of as well such as call fields are compulsory i.e. Empty or null values will not be permitted or else HTTP Code 400 will be returned.

## Screenshots:
1. Project architecture and Class representing our tables in the database.
<img src="https://bl3302files.storage.live.com/y4mPkxxOi5ZmCW-asClYIT1rBrlEp4rP1I6DGFDjZ4mTAKMjea3LwCe3UZHadIfwTHPd7-yRyBbz9ZhfbMMl_0jROJ8RwZ3aYYSAwZET-q2Abe0GeeuWfgtkwfb-8-XXLNSpVo_xjeWwwwFTlwym_YM1jBg_cgnH0Q5rRQW4UfZOuN6vcY-NWFyYGRn-A5JVFpX?width=1920&height=1080&cropmode=none" width="1080" height="720" />

2. Database schema:
<img src="https://bl3302files.storage.live.com/y4mZgIl9JtqNEX0ftJYts9f5VEB1t0L7ZhWpnQAWHY9W3FtCSj2Ny5Zm0btOjQ4Hwnjf2hsD7LKmhF6ee2Br2bDudNjpyEzx9gnCv_W063HAdWmyvawtDT3QXH-frYjFPOB-lbtB2MuHeKlYmT-O30EePKurBbrxU5bdumKG2V4ZIoSuT-Gy7DKyh4wULV7uZTs?width=1920&height=1027&cropmode=none" width="1080" height="720" />

3. Post Request with all fields entered:
<img src="https://bl3302files.storage.live.com/y4mLAdzDDZJ9b9WBKU_NMX8Oqy9p8ttgiEJA_z9dH_mLmaiyoRCqPJMgkEJeJ-oMaCVJr29kyUWruNIRsRJfhzSde00qc6GDNtTMgJhX1XSXXalV4eYWVhAspB_AGFy0wznnayBM1WUnNsPOLSrGWg4XBUBjhYI2by1UDhWC5c_VtWh_xLkyxmvyCREXSpkFhWE?width=1920&height=1080&cropmode=none" width="1080" height="720" />
  1. The POST request endpoint
  2. The Request Body
  3. The HTTP Status Code (200)
  4. The Response body
 
4. Post Request with one field null:
<img src="https://bl3302files.storage.live.com/y4mQqOW4w2oH3jz0L8ixB7bHwNiWHZY7-myismZhyA4Ifm8LSbuG1_4BGCy5VmwZTMgBZjWJCi1Fz3JgoIzDaWIYXqnkEeU-kbMy1UI5Uojqj-a674HwnP0IdNcRXvNl1LhYjVxjzPmZmYRbRNog9k96PxhY5l6hC7D53V8CuwqE_4l1Yf5O56kvt3_VAbRTV2H?width=1920&height=1080&cropmode=none" width="1080" height="720" />
As we can see we receive a Bad Request HTTP Status Code

5. GET Request
<img src="https://bl3302files.storage.live.com/y4m4O2STKSFbmITN5h1twC0FLid2dep9hl6XDHJCJ5xGLNxDxfq96iYR9dB3zrLPfwS8gb1x-RgFNN_fUtX6geBJZZdA5VjTRzKL9aI0DWMVk_P3eL8CKKlZHoID9jXOacaq4Oay_ldVRNU3DiDdn3jv6uMGD6O0k8d7BzQFOLNoCo3ozas2vEHQU_Og-Yn6u2E?width=1920&height=1080&cropmode=none" width="1080" height="720" />
  1. The GET request endpoint
  2. The HTTP Status Code (200)
  3. The Response body
If the recipe with the specified id does not exist HTTP Status code 400 is returned.

6. DELETE Request
<img src="https://bl3302files.storage.live.com/y4mVg5yBz6cQ0GM8XY-dah0AcbN-qmQ_fU8m3GzKPJaEy9kr92e97Hbx_oTU6lkpquKZzLNKnUUp0hHjjOzpNwIdeUSEACVvaQ4WFu8FLjj0RWLDfSiBy_LhlpRSHztgv9HMDW1kEd4ZJ9sBDehlIT7Kx8GOmdYq4kNeceoEQJ9yapm3EU_EHb0o_CH-b32yRVi?width=1920&height=1080&cropmode=none" width="1080" height="720" />
  1. The DELETE request endpoint
  2. The HTTP Status Code (204)





