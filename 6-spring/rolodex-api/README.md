This functional code allows you to do the following:

- Add a user to the H2 database at `http://localhost:5000/api/h2` by sending a POST request to this endpoint `http://localhost:5000/api/users/add`
 
 <br>
 
 ```json
 {
    "firstName" : "Bruce",
    "lastName" : "Banner",
    "username": "thehulk",
    "password": "secret123",
    "email" : "hulk@mail.com",
    "addresses" : [
        {
            "street" : "3 Park Ave.",
            "secondary" : "Apt 212",
            "state" : "NJ",
            "city" : "Trenton",
            "zip" : "11223-023"
        },
        {
            "street" : "42 Main St.",
            "secondary" : "Apt B",
            "state" : "FL",
            "city" : "Boca Raton",
            "zip" : "45333-043"
        }
    ]
}
```

- Once you add a user, you can login by sending a `POST` request to the endpoint `http://localhost:5000/api/login` with the following body in the request:

<br>

```json
{
    "username" : "thehulk",
    "password" : "secret123"
}
```
