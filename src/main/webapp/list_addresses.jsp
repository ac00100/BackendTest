<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head><title>Address List</title></head>

<body>
	<h1>Load Address List from session</h1>
	<a href="/index">Go Back Home</a>
	<p></p>
	<table border="1">
		<tr>
			<th>Street</th>
			<th>House Number</th>
			<th>Postal Code</th>
			<th>City</th>
			<th>Geo Location(LAT)</th>
			<th>Geo Location(LNG)</th>
			<th>Distance</th>
			<th>Type</th>
		</tr>
		<c:forEach items="${addressBlocks}" var="addressBlock">
			<c:set var="address" value="${addressBlock.address}"/>
			<tr>
				<td>${address.street}</td>
				<td>${address.housenumber}</td>
				<td>${address.postalcode}</td>
				<td>${address.city}</td>
				<td>${address.geoLocation.lat}</td>
				<td>${address.geoLocation.lng}</td>
				<td>${addressBlock.distance}</td>
				<td>${addressBlock.type}</td>
			</tr>
		</c:forEach>
	</table>
</body>

</html>