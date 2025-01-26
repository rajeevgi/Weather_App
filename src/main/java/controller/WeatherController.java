package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/show-weather")
public class WeatherController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String cityName = request.getParameter("city-name");
		cityName = URLEncoder.encode(cityName,"UTF-8");
		String apiKey = "YOUR_API_KEY";
		String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey
				+ "&units=metric";

		// To create an url object first create object of uri and then use toUrl()
		// method.
		try {
			URI uri = new URI(apiUrl);
			URL url = uri.toURL();

			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

			connection.setRequestMethod("GET");

			InputStream inputStream = connection.getInputStream();

			InputStreamReader StreamReader = new InputStreamReader(inputStream);

			Scanner sc = new Scanner(StreamReader);

			StringBuilder stringBuilder = new StringBuilder();

			while (sc.hasNext()) {
				stringBuilder.append(sc.nextLine());
			}

			System.out.println(stringBuilder);

			Gson gson = new Gson();

			JsonObject jsonResponse = gson.fromJson(stringBuilder.toString(), JsonObject.class);
			
//			long timestamp = jsonResponse.get("dt").getAsLong();
			
			long timeSec = jsonResponse.get("dt").getAsLong();
			
			Date date = new Date(timeSec*1000);
			
			SimpleDateFormat twelveHourFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
			
//			System.out.println(timeSec);
			
//			format the date
			String formattedDate = twelveHourFormat.format(date);

			System.out.println(date);
			
			double temp = jsonResponse.getAsJsonObject("main").get("temp").getAsDouble();
			
			System.out.println(temp);
			
			String weatherCondtion = jsonResponse.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
			
			System.out.println(weatherCondtion);
			
			request.setAttribute("jsonResonse", jsonResponse);
			
			request.setAttribute("date", formattedDate);
			request.setAttribute("temp", temp);
			request.setAttribute("weatherCondition", weatherCondtion);
			request.setAttribute("cityname", URLDecoder.decode(cityName, "UTF-8"));


			request.getRequestDispatcher("/weather-dashboard.jsp").forward(request, response);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
