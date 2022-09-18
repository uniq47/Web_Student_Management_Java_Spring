<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head> 
<body>
<h1 style="color: green; text-align: center;" >${msg}</h1>

<form:form action ="register" modelAttribute="student">
      <table>
          <tr>
              <td> Student Name:</td>
              <td><form:input path="sname" /></td>
          </tr>
          <tr>
              <td>Student Address:</td>
              <td><form:input path="sadd" /></td>
          </tr>
          <tr>
              <td colspan="2">
                  <input type="submit" value="Register" />
              </td>
          </tr>
      </table>
  </form:form>
  <a href="viewForm">ViewAllrecords</a>
</body>
</html>