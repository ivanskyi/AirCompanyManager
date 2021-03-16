# Java Air Company Manager

## Overview
This project contains REST application that allows management air company, airplane, flight information.

## Guidelines
To run this application you must do the next steps:

1. Clone this repository.
   
   ```
   https://github.com/olehivanskiy/AirCompanyManager
   ```   

2. Except for it, you must get MySQL docker image. This image has some test data.
   To create a connection with the application and MySQl image. We must start the container, but switch to another port. Below is a command for doing it.
   Docker command to pull and start MySQL container:
   ```
   docker run -v mysql-data:/var/lib/mysql -d  -p 3009:3306 --name air_manager_db  olehivanskyi/air_manager_database
   ```

3. After done all the above step,  we can test use some rest functionals;

## Information about functional

1. CRUD operation with Air Company information.

- To create an air company we use the address:
```
Address: */company/create
Request type: POST
Request param: body (object AirCompanyDto)
```

-  To get all air companies we use the address:
```
Address: */company/getAll
Request type: GET
Request param: non
```

- For get air company by id, we use address:
```
Address: */company/getById/{Id}
Request type: GET
Request param: argument ( {Id} - is't number that mean company id)
```

- For update air company we use the address:
```
Address: */company/update
Request type: POST
Request param: body (object AirCompanyDto)
```

- For delete air company by id, we use address:
```
Address: */company/deleteById/{Id}
Request type: DELETE
Request param: argument ( {Id} - is't number that mean company id)
```


2. Operation which allows change airplane company owner.

- To change airplane owner we can use the address:
```
Address: */flight/changeOwner/{airPlaneID}/{companyId}
Request type: POST
Request param: 
        {airPlaneID} - it's mean airplane id where we can change owner. 
        {companyId} - it's mean new company owner id. 
```

3. Operation which allows searching of all flights with some status code and company owner.

- For get search data we can use address:
```
Address: */flight/getAllByStatusCodeAndCompanyName
Request type: GET
Request param: status - it's mean flight status. 
               companyName - it's mean company name, which  flights we want search.
```

4. Operations that allow you to search for all flights with active
   status and flight duration of more than 24 hours.

- For get search data we can use address:
```
Address: */flight/getAllThatFlyingOver24Hours
Request type: GET
Request param: non
```

5. Operations that allow creating airplane.
- To do it use the address:
```
Address: */airplane/create
Request type: POST
Request param: body (object AirplaneDto)
```


6. Operations that allow creating a new flight.
- To do it use the address:
```
Address: */flight/create
Request type: POST
Request param: body (object FlightDto)
```


7. Operations that allow change flight status code.
- To do it use the address:
```
Address: */flight/changeStatusCode
Request type: GET
Request param: 
            flightId - it's mean flight id.
            newStatusCode - it's mean new status code for flight. 
            date - it's mean date which we insert in one of few field. 
                   If we need another date that current date
```

8. Operations that allow getting all flights with status code COMPLETED    where real fly time is bigger than the estimated time.
- To do it use the address:
```
Address: */flight/completeWhichLate
Request type: GET
Request param: non            
```

# Hints
Symbol ```*``` before URL means our application address.
- Port for connection with application:
```
host:8075
```

- Port for connection with database:
```
host:3009
```
- Database access info:
```
user:root
password:pass
```


