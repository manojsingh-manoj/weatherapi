# Weather API

A Spring Boot RESTful API for managing weather data, including creating, retrieving, and filtering weather records.

## Table of Contents
- [Project Overview](#project-overview)
- [Technologies](#technologies)
- [Setup and Installation](#setup-and-installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Data Model](#data-model)
- [Error Handling](#error-handling)
- [Testing](#testing)
- [Production Considerations](#production-considerations)
- [Contributing](#contributing)

## Project Overview

The Weather API allows users to manage weather records, including temperature data for specific cities and dates. It supports creating new records, retrieving records by ID, and filtering records by date, city, or sorting criteria.

## Technologies

- **Java**: 17
- **Spring Boot**: 3.2.7
- **Maven**: 3.x
- **JPA/Hibernate**: For database operations
- **H2 Database**: In-memory database for development and testing
- **OpenAPI/Swagger**: For API documentation
- **JUnit 5**: For testing
- **Mockito**: For mocking in unit tests
- **MockMvc**: For integration testing

## Setup and Installation

1. **Prerequisites**:
    - Java 17 JDK
    - Maven 3.x
    - Git

2. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd weather-api
   ```

3. **Install Dependencies**:
   ```bash
   mvn clean install
   ```

4. **Configure Database**:
    - The application uses an in-memory H2 database by default for development and testing.
    - For production, configure a persistent database (e.g., PostgreSQL) in `src/main/resources/application.yml`.

   Example `application.yml` for PostgreSQL:
   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/weatherdb
       username: your_username
       password: your_password
     jpa:
       hibernate:
         ddl-auto: update
   ```

## Running the Application

1. **Build and Run**:
   ```bash
   mvn clean package
   java -jar target/WeatherApi-1.0-SNAPSHOT.jar
   ```

2. **Run Without Testing**:
   ```bash
   mvn clean package -Dmaven.test.skip=true
   java -jar target/WeatherApi-1.0-SNAPSHOT.jar
   ```

3. **Access the Application**:
    - The API is available at `http://localhost:8080`.
    - Swagger UI: `http://localhost:8080/swagger-ui.html`.

## API Endpoints

| Method | Endpoint             | Description                              | Request Body | Query Parameters                     | Response |
|--------|----------------------|------------------------------------------|--------------|-------------------------------------|----------|
| POST   | `/weather`           | Creates a new weather record             | Weather JSON | None                                | 201, Weather |
| GET    | `/weather`           | Retrieves weather records with filters   | None         | `date`, `city`, `sort` (optional)   | 200, List<Weather> |
| GET    | `/weather/{id}`      | Retrieves a weather record by ID         | None         | None                                | 200, Weather; 404 if not found |

### Query Parameters
- `date`: Filter by date in `YYYY-MM-DD` format (e.g., `2019-06-11`).
- `city`: Filter by city (case-insensitive, comma-separated, e.g., `London,Moscow`).
- `sort`: Sort by `date` (ascending) or `-date` (descending).

### Example Requests

**Create a Weather Record**:
```bash
curl -X POST http://localhost:8080/weather \
-H "Content-Type: application/json" \
-d '{
    "date": "2023-10-01",
    "lat": 40.7128,
    "lon": -74.0060,
    "city": "New York",
    "state": "New York",
    "temperatures": [20.0, 21.0, 22.0]
}'
```

**Retrieve Filtered Records**:
```bash
curl http://localhost:8080/weather?city=New%20York&date=2023-10-01&sort=date
```

**Retrieve by ID**:
```bash
curl http://localhost:8080/weather/1
```

## Data Model

A weather record is represented as follows:

```json
{
    "id": 1,
    "date": "2023-10-01",
    "lat": 40.7128,
    "lon": -74.0060,
    "city": "New York",
    "state": "New York",
    "temperatures": [20.0, 21.0, 22.0]
}
```

- **id**: Unique integer identifier (auto-generated).
- **date**: Date in `YYYY-MM-DD` format.
- **lat**: Latitude (float).
- **lon**: Longitude (float).
- **city**: City name (string).
- **state**: State name (string, optional).
- **temperatures**: List of temperature readings (doubles).

## Error Handling

The API returns structured error responses:

```json
{
    "code": "E1001",
    "message": "Weather not found."
}
```

Common error codes:
- **E1001**: Weather record not found.
- **E1002**: Weather ID is null.
- **E1003**: Invalid date format.

## Testing

1. **Run Tests**:
   ```bash
   mvn clean test
   ```

2. **Test Coverage**:
    - Integration tests: `WeatherApiRestControllerTest` covers controller endpoints.
    - Unit tests: `WeatherServiceTest` covers service layer logic.
    - Tests include happy paths, filtering, sorting, and error scenarios.