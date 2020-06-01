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
	// at least 1 number, 1 lower case, 1 upper case, 6 characters.
	function checkPassword(str) {
		var re = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{6,}$/;
		echo $str;
		return re.test(str);
	}
	
	function checkForm(form) {
		if (form.password.value == null || form.password2.value == null) {
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
			<h1>Sign in</h1>
		</div>

		<div class="notdisplay" id="content2"></div>

		<div id="content3"style="width: 80%;">
			<form action="/fdmazon/signInFormC" method="post"
				onsubmit="return checkForm(this);" >
				<fieldset style="border-color:orange;">
					<legend class="large" ><b></b></legend>
					<table>
						<tr><td><h3></h3></td></tr>
						<tr>
							<td><label for="email"><b>Email (Username)</b></label><br />
								<input type="email" name="loginEmail" title="Enter email" required
								></td>
						</tr>
						<tr>
							<td><label for="password">Password</label><br /> <input
								type="password" name="loginPassword"	title="Must contain at least 6 characters, including UPPER/lower case and number."
								required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
								></td>
						</tr>
						<tr>
							<td><input class="large" type="submit" value="Sign In">
								</td>
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