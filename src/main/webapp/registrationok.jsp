<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="errorpage.jsp"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FDMazon</title>
<link rel="stylesheet" type="text/css" href="/fdmazon/styles/fdmcss.css" />
</head>

<body>
	<header>
		<%@ include file="header.jsp"%>
	</header>
	<div id="container">
		<div id="sidebar"></div>

		<div id="content">
			<div id="content1">
				<h1>Thank you for registering with us.</h1>
			</div>

			<div id="content2">
				<h4>Please check your email and click on the link to activate
					your account.</h4>
			</div>

			<div id="content3"></div>

		</div>
	</div>
	<footer>
		<jsp:include page="footer.jsp" />
	</footer>

</body>
</html>