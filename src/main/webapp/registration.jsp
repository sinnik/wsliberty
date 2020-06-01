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
	function checkPassword(str) {
		var re = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{6,}$/;
		echo
		$str;
		return re.test(str);
	}
	function checkPostcode(str) {
		var repc = /^([a-zA-Z]){1}([0-9][0-9]|[0-9]|[a-zA-Z][0-9][a-zA-Z]|[a-zA-Z][0-9][0-9]|[a-zA-Z][0-9]){1}([ ])([0-9][a-zA-z][a-zA-z]){1}$/;
		echo
		$str;
		return repc.test(str);
	}
	function checkForm(form) {
		if (form.password.value == form.password2.value) {
			if (!checkPassword(form.password.value)) {
				return false;
			}
		} else if (!(form.email.value == form.email2.value)) {
			return false;
			// 		} else if (!checkPostcode(form.postcode.value)) {
			// 			return false;
		} else {
			return false;
		}
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
				<h1>Create account</h1>
			</div>

			<div id="content2">
			<% if (request.getAttribute("regMsg")!=null){out.print("<p style=\"color:red;\">"+request.getAttribute("regMsg")+"</p>");} %>
			</div>

			<div id="content3" style="width: 80%;">
				<form action="/fdmazon/registrationFormC" method="post"
					onsubmit="return checkForm(this);">
					<fieldset style="border-color: orange;">
						<legend class="large">
							<b>Registration Form</b>
						</legend>
						<table>
							<tr>
								<td><h3></h3></td>
							</tr>
							<tr>
								<td><label for="userTitle">Title</label><br /> 
									<input type="radio" name="userTitle" value="Mr" checked>Mr 
									<input type="radio" name="userTitle" value="Mrs">Mrs 
									<input type="radio" name="userTitle" value="Madam">Madam 
									<input type="radio" name="userTitle" value="Ms">Ms 
									<input type="radio" name="userTitle" value="Miss">Miss</td>
							</tr>
							<tr>
								<td><label for="firstName">First Name</label><br /> <input
									type="text" name="firstName" title="Enter first name" required></td>
							</tr>
							<tr>
								<td><label for="lastName">Last Name</label><br /> <input
									type="text" name="lastName" title="Enter last name" required></td>
							</tr>
							<tr>
								<td><label for="houseNo">House No</label><br /> <input
									type="text" name="houseNo" title="Enter house no or house name"
									required></td>
							</tr>
							<tr>
								<td><label for="street">Street</label><br /> <input
									type="text" name="street" title="Enter street" required></td>
							</tr>
							<tr>
								<td><label for="town">Town</label><br /> <input
									type="text" name="town" title="Enter town" required></td>
							</tr>
							<tr>
								<td><label for="postcode">Postcode</label><br /> <input
									type="text" name="postcode"
									title="Enter postcode (e.g. LS1 4BN)" id="postcode" required></td>
							</tr>
							<!-- 								onchange="checkPostcode(this.value);" -->
							<!-- 								pattern="/^([a-zA-Z]){1}([0-9][0-9]|[0-9]|[a-zA-Z][0-9][a-zA-Z]|[a-zA-Z][0-9][0-9]|[a-zA-Z][0-9]){1}([ ])([0-9][a-zA-z][a-zA-z]){1}$/" -->
							<tr>
								<td><label for="country">Country</label><br /> <input
									type="text" name="country" title="Enter country" required></td>
							</tr>

							<tr>
								<td><label for="phone">Phone</label><br /> <input
									type="text" name="phone"
									title="Enter phone number (e.g. 004412345678)" required
									pattern="\d+"></td>
							</tr>
							<tr>
								<td><h2></h2></td>
							</tr>
							<tr>
								<td><label for="email"><b>Email (Username)</b></label><br />
									<input type="email" name="email" title="Enter email" required
									onchange="form.email2.pattern = this.value;"></td>
							</tr>
							<tr>
								<td><label for="email">Confirm Email (Username)</label><br />
									<input type="email" name="email2" title="Repeat email" required></td>
							</tr>
							<tr>
								<td><label for="password">Password</label><br /> <input
									type="password" name="password"
									title="Must contain at least 6 characters, including UPPER/lower case and number."
									required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
									onchange="form.password2.pattern = this.value;"></td>
							</tr>
							<tr>
								<td><label for="password2">Confirm Password</label><br />
									<input type="password" name="password2" title="Repeat password"
									required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"></td>
							</tr>
							<tr>
								<td><input class="large" type="submit"
									value="Create your FDMazon account">
									<p class="small">
										<a href="/fdmazon/tnc.jsp">By signing in you agree to
											FDMazon's Conditions of Use and Sale, Privacy Notice and
											Cookies and Internet Advertising.</a>
									</p></td>
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