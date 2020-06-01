<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="errorpage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="refresh" content="3;url=/fdmazon/index.jsp" />
<title>FDMazon</title>
<link rel="stylesheet" type="text/css" href="/fdmazon/styles/fdmcss.css" />
</head>
<body>
	<header>
		<%
			if (request.getAttribute("sessionId") != null) {
				session.invalidate();
			}
		%>
		<%@ include file="header.jsp"%>
	</header>
	<div id="container">
		<div id="sidebar"></div>

		<div id="content">
			<div id="content1">
				<h1>You have signed out successfully.</h1>
				<h1>Thank you for using FDMazon.</h1>
			</div>

			<div id="content2">
				<h4>You will be redirected to the home page in 3 seconds.</h4>
			</div>

			<div id="content3"></div>
		</div>
	</div>
	<footer>
		<%@ include file="footer.jsp"%>
	</footer>

</body>
</html>