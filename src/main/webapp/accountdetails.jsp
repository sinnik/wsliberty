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
				<h1>Account Details</h1>
			</div>

			<div id="content2">
				<% if (session.getAttribute("editMsg")!=null){out.print("<p style=\"color:blue;\">"+session.getAttribute("editMsg")+"</p>");} session.setAttribute("editMsg", null);%>
			</div>

			<div id="content3" style="width: 80%;">
				<form action="/fdmazon/accountDetailsC" method="GET"
					style="width: auto;">
					<fieldset style="border-color: orange;">
						<legend class="large">
							<b>Personal Details</b>
						</legend>
						<table>
							<tr>
								<td><b>Name</b>
								<td>
							</tr>
							<tr>
								<td><%=request.getAttribute("uTitle") + " " + request.getAttribute("uFirstName") + " "
									+ request.getAttribute("uLastName")%></td>
							</tr>
							<tr>
								<td><b>Address</b></td>
							</tr>
							<tr>
								<td><%=request.getAttribute("uHouseNo") + ", " + request.getAttribute("uStreet") + ", "
									+ request.getAttribute("uTown") + ", " + request.getAttribute("uPostcode") + ", "
									+ request.getAttribute("uCountry")%></td>
							</tr>
							<tr>
								<td><b>Email</b></td>
							</tr>
							<tr>
								<td><%=session.getAttribute("sessionId")%></td>
							</tr>
							<tr>
							<tr>
								<td><b>Phone</b></td>
							</tr>
							<tr>
								<td><%=request.getAttribute("uPhone")%></td>
							</tr>
							<tr>
								<td><b>Member since</b></td>
							</tr>
							<tr>
								<td><%=request.getAttribute("uRegisteredDate")%></td>
							</tr>
							<tr>
								<td><b>Balance</b></td>
							</tr>
							<tr>
								<td>&pound; <%=request.getAttribute("uBalance")%></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<input type="hidden" name="stage" value="b" />
							<tr>
								<td><input class="large" type="submit" value="Edit Account Details"></td>
							</tr>
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