<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<!-- //cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css
-->
<link
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script>
	$(document).ready(function() {
		$('#stutab').DataTable({
			pagingType : 'full_numbers',
		});
	});
</script>



<script>
	function deleteConfirm() {
		return confirm("Are you sure, you want to delete?");
	}
</script>
</head>
<body>
	<H3>view Students</H3>



	<a href="loadForm">Add New Student</a>
	<table border="2" id="stutab">
		<thead>
			<tr>
				<th>StudentNumber</th>
				<th>Student Name</th>
				<th>StudentAddress</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>



		<tbody>
			<c:forEach items="${allStudents}" var="s">
				<tr>
					<td>${s.sno}</td>
					<td>${s.sname}</td>
					<td>${s.sadd}</td>
					<td><a href="editstu?id=${s.sno}">Edit</a></td>
					<td><a href="deletestu?id=${s.sno}" onclick="deleteConfirm()">Delete</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>