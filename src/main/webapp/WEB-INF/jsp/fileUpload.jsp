<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>  

</script>  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3 align="center">Please upload files for sorting</h3>
	<table align="center">

		<form:form action="/fileUploadProcess" method="post"
			modelAttribute="fileBeanDTO" enctype="multipart/form-data"> 
			<tr>
			<tr>
				<td>Select a file to insert bulk records.</td>
			</tr>
			<tr>
				<td><form:input type="file" path="multipartFile" name="multipartFile"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="upload File" /></td>
			</tr>
		</form:form>
	</table>
	
</body>
</html>