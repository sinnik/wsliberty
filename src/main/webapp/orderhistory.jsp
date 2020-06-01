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
		<div id="sidebar"></div>

		<div id="content">
			<div id="content1">
				<h1>Order History</h1>
			</div>

			<div class="hidden" id="content2"></div>

			<div id="content3" style="width: 80%;">
				<form action="" method="post" style="width: 100%;">
					<fieldset style="border-color: orange;">
						<legend class="large">
							<b>Order History</b>
						</legend>
						<table>
							<%@ include file="orderList.jsp"%>
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