# README Summary for Stock Management API

### Reference Documentation
For further reference, please consider the following sections:
This API allows for managing stock information, including creating new stock records and retrieving stock details.

Features
Create a new stock
Retrieve all stocks with pagination
Retrieve a specific stock by its ID
Update the price of a single stock

Technologies Used
Java
Spring Boot
Spring Data JPA
H2 Database (or your preferred database)
Endpoints
Create Stock

URL: /api/stocks/create
Method: POST
Request Body: StockRequestDto (JSON)
{
"name": "string",
"currentPrice": "double"
}

Response: 201 Created
{
"message": "Stock created successfully"
}

Get All Stocks

URL: /api/stocks
Method: GET
Query Parameters:
pageNo (default: 0)
pageSize (default: 10)
Response: 200 OK

[
{
"id": "long",
"name": "string",
"currentPrice": "double",
"createDate": "timestamp",
"lastUpdate": "timestamp"
}
]

Get Stock By ID

URL: /api/stocks/{id}
Method: GET
Response: 200 OK
{
"id": "long",
"name": "string",
"currentPrice": "double",
"createDate": "timestamp",
"lastUpdate": "timestamp"
}

Classes
Controller Class (StockController)

Handles HTTP requests and returns responses using StockDto.
Service Interface (StockService)

Defines methods for retrieving and managing stock data.
Service Implementation Class (StockServiceImpl)

Implements the business logic for creating and retrieving stock data.
Converts Stock entities to StockDto objects.
DTO Class (StockRequestDto)

Represents the data structure for stock information used in API responses.
Entity Class (Stock)

Represents the stock data model in the database.
Example StockServiceImpl Method

Getting Started

git clone <repository-url>
cd <repository-directory>

Clone the repository:

git clone <repository-url>
cd <repository-directory>

Build and run the application:
mvn spring-boot:run

Access the API:

Base URL: http://localhost:8080/api/stock

