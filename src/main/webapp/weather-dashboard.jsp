<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Weather Dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<style type="text/css">
body {
	background-image: url("weather-app.jpg");
	background-size: cover;
	background-repeat: no-repeat;
	background-color: rgba(0,0,0,0.5);
}
</style>
</head>
<body>

	<%-- <c:set var="jsonResponse" value="<%=request.getAttribute(\"jsonResponse\") %>"></c:set>
	
	${jsonResonse} --%>

	<%-- <br>
	<br>
	<br>
	<div class="formAlignment">
		<div>
			<h1>Welcome to Weather Application</h1>
			<form action="show-weather" method="post">
				City Name: <input type="text" name="city-name"
					value="${requestScope.cityname}"> <input type="submit"
					value="check weather">
			</form>
			<br>
			<br>
			<h1>Temperature: ${requestScope.temp}celsius</h1>
			<h1>Date: ${requestScope.date}</h1>
			<h1>Condition: ${requestScope.weatherCondition}</h1>
		</div>
	</div> --%>

	<div style="background-image: url('weather-app.jpeg');"></div>

	<div class="d-flex justify-content-center align-itmes-center mt-5">
		<h3>Weather Application</h3>
	</div>

	<div
		class="container-fluid mt-5 d-flex justify-content-center align-items-center">
		<div class="border border-2 border-dark rounded p-5">
			<form action="show-weather" method="post">
				<div class="input-group mb-3">
					<input class="form-control me-2" type="text"
						placeholder="Enter City Name:" value="${requestScope.cityname}">
					<div class="input-group-append">
						<input class="btn btn-success" type="submit" value="check weather">
					</div>
				</div>
				<div>
					<h1>Temperature: ${requestScope.temp}celsius</h1>
					<h1>Date: ${requestScope.date}</h1>
					<h1>Condition: ${requestScope.weatherCondition}</h1>
				</div>
			</form>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>