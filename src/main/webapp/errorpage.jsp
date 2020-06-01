<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page isErrorPage="true" import="java.io.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FDMazon</title>
<link rel="stylesheet" type="text/css"	href="/fdmazon/styles/fdmcss.css" />
</head>
<body>
	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>
<div id="container">
	<div id="sidebar">
	
	</div>

	<div id="content">
		<div id="content1">
			<h1>Oops, an error has occurred. Please try again later.</h1>
		</div>

		<div id="content2">
			<h4><a href="/fdmazon/home.jsp">Click here to go to the home page.</a></h4>
		</div>

		<div id="content3">

		</div>
	</div>
</div>
	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>

</body>
</html>