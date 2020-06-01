<%@ include file="verify.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="errorpage.jsp"%>
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
				<h1>Order Details</h1>
			</div>

			<div id="content2"></div>

			<div id="content3" style="width: 80%;">
				<form style="width: 100%;">
					<fieldset style="border-color: orange;">
						<legend class="large">
							<b></b>
						</legend>
						<table>
							<%@ include file="details.jsp"%>
						</table>
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