# Weather App

A Java Servlet-based Weather Application that fetches and displays real-time weather information for a specified location. This project demonstrates the use of Servlets, JSP, and APIs in a dynamic web application.

---

## Features

- **Search Weather by Location:** Enter the name of a city to get its current weather details.
- **Real-Time Weather Data:** Integrates with a weather API to fetch live weather updates.
- **Responsive Design:** User-friendly interface built using JSP and CSS.
- **Error Handling:** Displays meaningful messages for invalid inputs or API errors.

---

## Technologies Used

- **Backend:** Java Servlets
- **Frontend:** JSP, HTML, CSS
- **API Integration:** Weather API (e.g., OpenWeatherMap, WeatherStack)
- **Server:** Apache Tomcat

---

## Prerequisites

1. JDK 8 or higher
2. Apache Tomcat Server
3. Maven (for dependency management)
4. API key from a weather service provider (e.g., OpenWeatherMap)

---

## Setup and Installation

### Configure the API Key
1. Register at [OpenWeatherMap](https://openweathermap.org/) or your preferred weather API provider.
2. Obtain an API key.
3. Update the `WeatherService` class with your API key:

   ```java
   private static final String API_KEY = "your_api_key_here";
   ```

### Build the Project
1. Open the project in your IDE.
2. Build the project using Maven or manually add necessary dependencies.

### Deploy on Tomcat Server
1. Export the project as a WAR file.
2. Place the WAR file in the `webapps` directory of your Tomcat server.
3. Start the server and access the application at `http://localhost:8080/weather-app`.

---

## Directory Structure

```
weather-app/
|
|-- src/main/java/
|   |-- com.example.weather/
|       |-- controller
|       |-- WeatherController
|
|-- src/main/webapp/
|   |-- WEB-INF/
|   |   |-- web.xml
|   |-- index.html
|   |-- weather-dashboard.jsp
|
|-- pom.xml
```

---

## How It Works

1. **User Input:**
   - The user enters a city name in the search form on `index.jsp`.

2. **Data Processing:**
   - The `WeatherServlet` processes the request and calls the `WeatherService` to fetch data from the weather API.

3. **API Call:**
   - The `WeatherService` sends an HTTP GET request to the weather API and retrieves the JSON response.

4. **Response Rendering:**
   - The weather data is parsed and displayed on the `weather-dashboard.jsp` page.

---
## Acknowledgments

- [OpenWeatherMap API](https://openweathermap.org/) for providing weather data.
- [Bootstrap](https://getbootstrap.com/) for design components (if applicable).

---

## Contributing

Contributions are welcome! Please open an issue or submit a pull request if you'd like to contribute to this project.
