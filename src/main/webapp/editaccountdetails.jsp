<%@ include file="verify.jsp" %>
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
		if(form.newPassword.value.length > 0){
			if(form.newPassword.value == form.newPassword2.value) {
				if (!checkPassword(form.newPassword.value)) {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return true;
		}
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
			<h1>Update account</h1>
		</div>

		<div class="notdisplay" id="content2"></div>

		<div id="content3" style="width: 80%;">
			<form action="/fdmazon/editAccountC" method="post" onsubmit="return checkForm(this);">
				<fieldset style="border-color: orange;">
					<legend class="large">
						<b>Update Account Details</b>
					</legend>
					<table>
						<tr>
							<td><h3></h3></td>
						</tr>
						<tr>
							<td><label for="newFirstName">First Name</label><br /> <input
								type="text" name="newFirstName" title="Enter first name" placeholder="<%=request.getAttribute("uFirstName") %>"></td>
						</tr>
						<tr>
							<td><label for="newLastName">Last Name</label><br /> <input
								type="text" name="newLastName" title="Enter last name" placeholder="<%=request.getAttribute("uLastName") %>"></td>
						</tr>
						<tr>
							<td><label for="newHouseNo">House No</label><br /> <input
								type="text" name="newHouseNo" title="Enter house no or house name" placeholder="<%=request.getAttribute("uHouseNo") %>"></td>
						</tr>
						<tr>
							<td><label for="newStreet">Street</label><br /> <input
								type="text" name="newStreet" title="Enter street" placeholder="<%=request.getAttribute("uStreet") %>"></td>
						</tr>
						<tr>
							<td><label for="newTown">Town</label><br /> <input type="text"
								name="newTown" title="Enter town" placeholder="<%=request.getAttribute("uTown") %>"></td>
						</tr>
						<tr>
							<td><label for="newPostcode">Postcode</label><br /> <input
								type="text" name="newPostcode"
								title="Enter postcode (e.g. LS1 4BN)" id="postcode2" placeholder="<%=request.getAttribute("uPostcode") %>"
						></td></tr>
<!-- 								onchange="checkPostcode(this.value);" -->
<!-- 								pattern="/^([a-zA-Z]){1}([0-9][0-9]|[0-9]|[a-zA-Z][0-9][a-zA-Z]|[a-zA-Z][0-9][0-9]|[a-zA-Z][0-9]){1}([ ])([0-9][a-zA-z][a-zA-z]){1}$/" -->
						<tr>
							<td><label for="newCountry">Country</label><br /> 
							<input type="text" name="newCountry" title="Enter country" placeholder="<%=request.getAttribute("uCountry") %>"></td>
						</tr>

						<tr>
							<td><label for="newPhone">Phone</label><br /> 
							<input type="text" name="newPhone" title="Enter phone number (e.g. 004412345678)" placeholder="<%=request.getAttribute("uPhone") %>" pattern="\d+"></td>
						</tr>
<!-- 						<tr> -->
<!-- 							<td><label for="newPassword">New Password</label><br />  -->
<!-- 							<input type="password" name="newPassword" title="Must contain at least 6 characters, including UPPER/lower case and number." pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" onchange="form.newPassword2.pattern = this.value;"></td> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td><label for="newPassword2">Confirm New Password</label><br />  -->
<!-- 							<input type="password" name="newPassword2" title="Repeat password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" onchange="form.newPassword.pattern = this.value;"></td> -->
<!-- 						</tr> -->
						<tr>
							<td><h2></h2></td>
						</tr>
						<tr>
							<td><label for="oldPassword"><b>Password (required)</b></label><br />
								<input type="password" name="oldPassword" title="Enter password to confirm update" placeholder="Enter password to confirm update" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" required ></td>
						</tr>
						<tr>
							<td><input class="large" type="submit" value="Update account details">
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