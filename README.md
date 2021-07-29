# Stage IV Implementation
This stage comprised of major stages in comparison to the previous stage. Below are the listed changes:

<b>I. API Changes</b>
1. PUT request for modifying a recipe by its ID is available. The API is available at the endpoint: <code>/api/recipe/{id}</code>
2. There can be tonnes of recipes in the database making searching for one by ID difficult. To narrow the search space GET request can be made using either the using query parameter category or name. Both the query parameter values are case in-sensitive (more accurately the SQL query returns case in-sensitive results).

<b>II. Database</b>
1. Change in table Schema (now users can add the category of the recipe as well internally the date of upload / modification will be stored in the database)
2. CRUD respository is introduced with new abstract methods (SQL queries will be formed based on method name) to facilitate date retrieval by making a GET Request with query parameters category or name.

### Screenshots

1. Change in table schema. Two new columns (category and date of upload / modification) are added.
<img src="https://bl3302files.storage.live.com/y4m84V_H_R72HoGPFP9IFuK9oGdQaV_rqhPJpW_E3e8U2sEkVDuLdcOx7b_alYvwWPwHTd9C4AO7i81_NWenj_29qt01L7rvo5CwoPoa42U4BrhK-MYMDYeQCc8zj3e0FhvvObdmd_3eGEu-p8dEnaWaFFl62HZng5FueIBgwprAgFvYkIqMS_qvv_kz1VE0Vtr?width=1922&height=1080&cropmode=none" width="1080" height="720" /> 

2. Code reflecting the changes made to the table schema. <b>We can see the user has no control of the column date. The value is set automatically during constructor call.</b>
<img src="https://bl3302files.storage.live.com/y4mEJ1h1Fp_XTzkj7ZIc7btJW86Hbg66mSzF-ywZlgB4-p8YYAb6dpnfUgxUK3xW2xh2q-9ZV8Tnltveo0wnsvTvHFtoZnuNgNLIyuA_YNXvGzE7uFIuq7F8IuFMMU-f6T83CkzRWKruixtTquNHF9-SaXRv3mcOh7kgvWj0OCN7bWp5pWt-FCPGWSv_nlCuUUk?width=1920&height=1080&cropmode=none" width="1080" height="720" />

3. POST request (<code>/api/recipe/new</code>) is made and we get the id as a response. Here the ID is 34.
<img src="https://bl3302files.storage.live.com/y4mx6ImvDfWv8GmBadNWUihGQpului6IroHKkGKtlaPsoP0iTfga9U1lhe3h5IxjMFNAHiR4w6TkRVwxd5_Tj69lz-V55bxrDtDgryQFbGCk8THx5eo80AzVtIRW7Pvrl8VSMCUESHq4iquw5ml9tdVX9_GKkKV8uq3k3fqlF9TDHlVTM5qMP9ykf3F6QdXPLN9?width=1920&height=1080&cropmode=none" width="1080" height="720" />

4. GET request (<code>/api/recipe/{id}</code>) retrieves a recipe by ID from the Database, if ID is 34 we get the following output.
<img src="https://bl3302files.storage.live.com/y4mvyxycPTKbxRoJX2MGmpdSrwfhdwV_2Q62O-Z5-EaJ4agEo4V2FnCcikgkTtPQ05f1U-7hhAqiuUb8nHfSkd5f0ma0Wf_FpKc9Ch0HD0oYIx_9OOgWrJ7Zu7fUTyYQEAAxVbAPwS6RprCkA-ZgDR3Sg5DVoGF2pnU5srxXo3QYzy3vtOhGko2tAHJKeC2Vcto?width=1920&height=1080&cropmode=none" width="1080" height="720" />

5. PUT request (<code>/api/recipe/{id}</code>) allows users to modify an existing recipe by ID. If the recipe with the specified ID does not exist HTTP Status code 400 (Bad Request) is returned.
<img src="https://bl3302files.storage.live.com/y4mvQdVYYarKFtqdRjPlehBx7ieM2NIYtY5ThTnq3HgNXY6FL-ZjyPjXosEZPtifam28VZuCNwyOoHecxKaRdXV47M7lbgE_jKrFPNM0aOHM8ykQm1lYetmGkXuvLcBOGxPk5GR7X_3pQPPE7CeqsFaC3P03Ts-INPt-6TIjNMLBO4lSxwmM3r5phZAjbQhfa4D?width=1920&height=1080&cropmode=none" width="1080" height="720" />
i. PUT request using ID 34. <br>
ii. Changes made to name, description ingredients and directions <br>
iii. HTTP Status code 204 (No Content) is returned. <br> <br>

6. GET request (<code>/api/recipe/{id}</code>) retrieves a recipe by ID from the Database, if ID is 34 we get the following output. It is updated now consistent with our PUT request.
<img src="https://bl3302files.storage.live.com/y4mxV66dq-za8thx_IpPPcLHApf8dryS8h9lgkKAzl8MK5fJpgQZAxuTD046L_a0RJ1blzQzlZC0EBzFF4ADcW8OzHWbKK2mVJ-Y7JnGkZhXZpRnotKLvRPKaAEDCxCaidxMxADFbr2TeqrH_1oaZb2FHGCgZY7s6R8412XQAClEAAq_uRuvKUVXaITY2kwcSe9?width=1920&height=1080&cropmode=none" width="1080" height="720" />

7. Code handling the PUT request
<img src="https://bl3302files.storage.live.com/y4mvxetjRf2WFPxmDKJT6KMVW_FRmwLIM3fEtkjCGJGs_RnWC0Akn0_KT5WRBBrEd9zz0E0mE08V6beuniQ24zWTy3ma_KWLbYnyrFz9uieED1gLuLESnGu0c0ftk15lEd_J17XsV5MX1rLbEeEbDS_2gtE6t78Y7O03zi5eDMoMvmpMCJtEPXtMcmdf_Tk9Fbx?width=1920&height=1080&cropmode=none" width="1080" height="720" />

8. GET Request (<code>/api/recipe/search?category={value}</code>) for searching by category. The search is case in-sensitive. We receive a list of JSON objects (recipes) as response.
<img src="https://bl3302files.storage.live.com/y4mTEx_ydBovIqeKxgQrjyguVyNX6tt0PakpFDcRtm_iTla61oiFFW4loMhu4dDYUUioaDsAa07cXtAMpSnAvd5rSzub5QovTdhKb1d0MdiJ4OJUk8dKcDdYAFsCzyAp2aPLKtWhs2HakC8kO0owx5zqPCZo9dpyIec7iXQC6pvZc3hjA1zyxyG5A2J6c71TlZI?width=1920&height=1080&cropmode=none" width="1080" height="720" />
  
9. GET Request (<code>/api/recipe/search?name={value}</code>) for searching in name by specified value. The search is case in-sensitive. We receive a list of JSON objects (recipes) as response.
<img src="https://bl3302files.storage.live.com/y4mmbR3CQO6EMpjsvEHF2ofcgskWDsx1r_4cF6PMv78YCH7oPoHHkSoBRMERd2xLxXbIrzjen-Ff5szC8KShY7UPGBgEJhEgjpbTg3Y8meASBeKloTIWoJxeMrdeuHeJkaWpeQ0wAgu80gV-mWhXTe9IOX0HKCl8gRKf24HWNaXljSQO5n2LPVEXRCCvMNv4w4e?width=1920&height=1080&cropmode=none" width="1080" height="720" />

10. Code added to the CRUD repository to generate SQL queries to handle GET Request done using query parameters.
<img src="https://bl3302files.storage.live.com/y4mreZJxI9n0iD8Pfd7JnKYTs2AZOC3xfL1_GJQ85czmSUxirQsIuDm49TRxH98DQhPkcEjS8iRgzbGmcvghIKWGx6yRzermCrvItnyHZBRX8NdR6k7SdWLe-aW4jjyxjzKtCIpYDj6ubPr9YwPIXb_ST_zQnR9SmWaxweHh8uXiZ00qE_ek9dUUGfx5lug9JGR?width=1920&height=1080&cropmode=none" width="1080" height="720" />

11. Code for handling GET Request using query parameters.
<img src="https://bl3302files.storage.live.com/y4m9xFh2tanI2kjqIy_x6Yc2ZskNpdzOO_g0HEk29DEBXInDMgbD9n6_S70-AalwmFHwHfQW-AJJaDHkqbjMLmNLef5JnaF0PFjcdGtcHbkMVae5eHzmo9B_kfz2LNtKQIdTPA1z5bkJsAfQovAQgQhZVXv4KrcYTVVo6pUV7GTsuE-SVvX936TfW5rOjSPlXE_?width=1920&height=1080&cropmode=none" width="1080" height="720" />

The main branch will contain the Final Stage Implementation which will support Authentication and Authorization using Spring Security.
