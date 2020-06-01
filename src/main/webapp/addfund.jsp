<%@ include file="verify.jsp"%>
<%@ page errorPage="errorpage.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
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
			<h1>Top up</h1>
		</div>

		<div id="content2">Sorry, this service is not available at this moment.</div>

		<div id="content3"style="width: 80%;">
			<form action="" method="post" >
				<fieldset style="border-color:orange;">
					<legend class="large" ><b></b></legend>
					<table>
							<tr>
								<td><h3></h3></td>
							</tr>
							<td><label for="paymentMethod"><b>Payment Options</b></label>
								<br/> <br/>
								<input type="radio" name="paymentMethod" value="card" disabled>Credit/Debit Card 
								<input type="radio" name="paymentMethod" value="paypal" disabled>PayPal
							</td></tr>									
							<tr>
								<td><h3></h3></td>
							</tr>
							<td><label for="amount"><b>Top up amount</b></label> <br/>
									<input type="text" name="amount" title="Enter amount in GBP" value="0.00" step="0.01" pattern="\d+">
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
								<td><input class="large" type="submit" value="Top Up"></td>
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