<%@page import="java.text.DecimalFormat"%>
<%@ include file="verify.jsp"%>
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
<% DecimalFormat df = new DecimalFormat("###,###,##0.00");%>
<body>
	<header>
		<%@ include file="header.jsp"%>
	</header>
	<div id="container">
		<div id="sidebar"></div>

		<div id="content">
			<div id="content1">
				<h1>Checkout (Step 2 of 3)</h1>
			</div>

			<div id="content2"><% if (request.getAttribute("msg")!=null){ out.print("<p>"+request.getAttribute("msg")+"</p>");} %>
			</div>

			<div id="content3" style="width: 80%;">
				<form action="/fdmazon/checkoutPaymentC" method="post">
					<fieldset style="border-color: orange;">
						<legend class="large">
							<b>Payment</b>
						</legend>
						<table>
							<tr><td><b>Order Total: &pound; <%=df.format(session.getAttribute("basketTotal")) %></b></td>
							</tr>
							<tr>
								<td><h3></h3></td>
							</tr>
							<td><label for="paymentMethod">Payment Options</label>
								<br/> 
								<input type="radio" name="paymentMethod" value="accountBalance" checked>Account Balance 
								<input type="radio" name="paymentMethod" value="card" disabled>Credit/Debit Card 
								<input type="radio" name="paymentMethod" value="paypal" disabled>PayPal
							</td></tr>									
							
							<tr>
								<td><h3></h3></td>
							</tr>
							<tr>
								<td><b>Account Balance : &pound; <%=df.format(request.getAttribute("balance")) %></b></td>
							</tr>
							<tr>
								<td><h3></h3></td>
							</tr>
							<tr><td><b>For card payment only:</b></td></tr>
							<tr>
								<td><label for="cardNo">Credit/Debit Card Number</label> <br/>
									<input type="text" name="cardNo" title="Enter card number">
									<label for="cardCvv">CVV</label><br/>
									<input type="text" name ="cardCvv" title="Enter 3 digit CVV on back of card"/>
									<label for="cardExpiry">Expiry date</label><br/>
									<input type="text" name ="cardExpiry" title="Enter as MMYY"/>
								</td>
							</tr>
							<tr>
								<td><h3></h3></td>
							</tr>
							<tr><td><b>For Paypal payment only:</b></td></tr>
							<tr>
								<td><label for="paypal">Paypal Email Address</label><br /> <input
									type="email" name="paypal" title="Enter paypal email address"></td>
							</tr>
							<tr>
								<td><h2></h2></td>
							</tr>
							<tr>
								<td><input class="large" type="submit" value="Next step (Order Confirmation)"></td>
							</tr>
						</table>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<footer>
		<jsp:include page="footer.jsp" />
	</footer>

</body>
</html>