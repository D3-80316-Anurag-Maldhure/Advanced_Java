<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PORTAL</title>
</head>
<body>
	<center>
		<h1>Student Admission Portal</h1>
	</center>
	<hr/>
	<br/>
	<h3 style = "text-align:center;">Admission form</h3>
	<br/>
	<form action="admission.jsp" method="post">
      <table style="background-color: lightgrey; margin: auto">
        <tr>
          <td>Enter First Name : </td>
          <td><input type="text" name="fname" /></td>
        </tr>
         <tr>
          <td>Enter Last Name : </td>
          <td><input type="text" name="lname" /></td>
        </tr>
        <tr>
          <td>Enter Test Score : </td>
          <td><input type="number" name="score" /></td>
        </tr>
        <tr>
          <td>Enter Course : </td>
          <td><label for="course">Select your course:</label>
			<select name="course">
			    <option value="DAC">DAC</option>
			    <option value="DBDA">DBDA</option>
			    <option value="DITISS">DITISS</option>
			    <option value="DESD">DESD</option>
			    <option value="DMC">DMC</option>
			</select>
          </td>
        </tr>
        <tr>
          <td><input type="submit" value="Student Admission" /></td>
        </tr>
      </table>
    </form>
    	<br/>
    	<br/>
    <hr/>
</body>
</html>