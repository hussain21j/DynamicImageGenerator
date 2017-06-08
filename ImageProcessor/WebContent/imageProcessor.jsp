<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Get the name of the file from the session and storing it into a variable -->
	<%
		String imgageFileURI = (String) session.getAttribute("SESSION_ATTRIBUTE_IMAGE_URI");
		System.out.println("imgageFileURI :" + imgageFileURI);
	%>
	Show the Image dynamically. To get the New Image Go back and click on Get New Image
	<div id="DIV_NEW_IMAGE">
		<img alt="" src="<%=imgageFileURI%>">
	</div>
	
</body>
</html>