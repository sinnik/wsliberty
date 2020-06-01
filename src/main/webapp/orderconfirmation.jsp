<%@ include file="verify.jsp"%>
<%@ page errorPage="errorpage.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/fdmazon/styles/fdmcss.css" />
<title>FDMazon</title>
</head>

<body>
	<header>
		<%@ include file="header.jsp"%>
	</header>
	<div id="container">
		<div class="hidden" id="sidebar"></div>

		<div id="content">
			<div id="content1">
				<h1>Checkout (Step 3 of 3)</h1>
			</div>

			<div id="content2"></div>

			<div id="content3" style="width: 80%;">
				<form action="/fdmazon/orderConfirmationC" method="post" style="width: 100%;">
					<fieldset style="border-color: orange;">
						<legend class="large"><b></b></legend>
						<%@include file="checkoutdetails.jsp" %>
						<input class="large" type="submit" value="Place Order">
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<footer>
		<%@ include file="footer.jsp"%>
	</footer>

</body>
</html>