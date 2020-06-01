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

<script>
	function checkPostcode(str) {
		var repc = /^([a-zA-Z]){1}([0-9][0-9]|[0-9]|[a-zA-Z][0-9][a-zA-Z]|[a-zA-Z][0-9][0-9]|[a-zA-Z][0-9]){1}([ ])([0-9][a-zA-z][a-zA-z]){1}$/;
		echo
		$str;
		return repc.test(str);
	}
	function checkForm(form) {
// 		if (!checkPostcode(form.postcode.value)) {
// 			return false;
// 		}
		return true;
	}
</script>

<body>
	<header>
		<%@ include file="header.jsp"%>
	</header>
	<div id="container">
		<div id="sidebar"></div>

		<div id="content">
			<div id="content1">
				<h1>Checkout (Step 1 of 3)</h1>
			</div>

			<div id="content2">
			</div>

			<div id="content3" style="width: 80%;">
				<form action="/fdmazon/checkout1C" method="post" onsubmit="return checkForm(this);">
					<fieldset style="border-color: orange;">
						<legend class="large">
							<b>Recipient Details</b>
						</legend>
						<table>
							<tr>
								<td><h3></h3></td>
							</tr>
							<tr>
								<td><label for="recipient">Recipient</label><br /> <input
									type="text" name="recipient" title="Enter recipient full name" required></td>
							</tr>
							<tr>
								<td><label for="shipHouseNo">House No</label><br /> <input
									type="text" name="shipHouseNo" title="Enter house no or house name"
									required></td>
							</tr>
							<tr>
								<td><label for="shipStreet">Street</label><br /> <input
									type="text" name="shipStreet" title="Enter street" required></td>
							</tr>
							<tr>
								<td><label for="shipTown">Town</label><br /> <input
									type="text" name="shipTown" title="Enter town" required></td>
							</tr>
							<tr>
								<td><label for="shipPostcode">Postcode</label><br /> <input
									type="text" name="shipPostcode"
									title="Enter postcode (e.g. LS1 4BN)" id="shipPostcode" required></td>
							</tr>
							<!-- 								onchange="checkPostcode(this.value);" -->
							<!-- 								pattern="/^([a-zA-Z]){1}([0-9][0-9]|[0-9]|[a-zA-Z][0-9][a-zA-Z]|[a-zA-Z][0-9][0-9]|[a-zA-Z][0-9]){1}([ ])([0-9][a-zA-z][a-zA-z]){1}$/" -->
							<tr>
								<td><label for="shipCountry">Country</label><br /> <input
									type="text" name="shipCountry" title="Enter country" required></td>
							</tr>
							<tr>
								<td><h2></h2></td>
							</tr>
							<tr>
								<td><input class="large" type="submit" value="Next step (Payment)"></td>
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