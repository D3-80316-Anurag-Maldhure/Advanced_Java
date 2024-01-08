<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.student.*"%>
<%@page import="java.util.HashMap"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admission</title>
</head>
<%-- <%!
	//declare n instantiate a HashMap to store data
	HashMap<String, Student> studentDetailsMap;//private scoped var.

	public void jspInit() {
		//instantiate a HashMap n populate
		studentDetailsMap = new HashMap<>();
	}
%> --%>
<body>
<%
		String firstNameString = request.getParameter("fname");
		String lastNameString = request.getParameter("lname");
		int score = Integer.parseInt(request.getParameter("score"));
		String selectedCourse = request.getParameter("course");
		
		Student newStudent = new Student(firstNameString, lastNameString, score, 
				false, Course.valueOf(selectedCourse));
		
		//System.out.println(newStudent);
		
		//System.out.println(newStudent.getTestScore() >=  Course.valueOf(selectedCourse).getMinMarks()?"Pappu pass":"Abhyaas kar");
		
		if(newStudent.getTestScore() >=  Course.valueOf(selectedCourse).getMinMarks())
				newStudent.setAdmissionStatus(true);
				else
					newStudent.setAdmissionStatus(false);
		
		request.setAttribute("Student", newStudent);
		
		RequestDispatcher rd;
		
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		
%>

</body>
</html>