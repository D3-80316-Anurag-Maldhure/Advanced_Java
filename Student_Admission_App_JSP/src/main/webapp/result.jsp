<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "com.student.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
	<%
		Student student = (Student)request.getAttribute("Student");
		//pageContext.setAttribute("student", student);
	
		if(student.isAdmissionStatus()){
			
			//Search order -> Page -> Request -> Session -> Application
	%>
			
			<%-- <h1>Congrats ${student.getFirstName()} ${student.getLastName()}! 
			You are selected for ${student.getSelectedCourse()}</h1> --%>
			<h1>Congrats ${Student.getFirstName()} ${Student.getLastName()}! 
			You are selected for ${Student.getSelectedCourse()}</h1>
			
	<%
		}
		else{
	%>
			<%-- <h1>Sorry ${student.getFirstName()} ${student.getLastName()}! 
			You are not eligible for ${student.getSelectedCourse()}</h1> --%>
			<h1>Sorry ${Student.getFirstName()} ${Student.getLastName()}! 
			You are not eligible for ${Student.getSelectedCourse()}</h1>
	<%
		}
	%>
		
	
	
</body>
</html>