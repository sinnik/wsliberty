<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="errorpage.jsp"%>
<% if(!session.getAttribute("sessionId").equals(session.getAttribute("admin"))) {
    out.println("<script>parent.location.href='/fdmazon/index.jsp'</script>"); }%>
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
				<h1>Add/Remove Product</h1>
			</div>

			<div id="content2">
			<% if (request.getAttribute("regMsg")!=null){out.print("<p style=\"color:red;\">"+request.getAttribute("regMsg")+"</p>");} %>
			</div>

			<div id="content3" style="width: 80%;">
				<form action="/fdmazon/addProductC" method="post" >
					<fieldset style="border-color: orange;">
						<legend class="large">
							<b>Add/Remove Products</b>
						</legend>
						<table>
							<tr>
								<td><h3></h3></td>
							</tr>
							<tr>
								<td><label for="productName">Product Name</label><br /> <input
									type="text" name="productName" title="Enter product name" required></td>
							</tr>
							<tr>
								<td><label for="productPrice">Product Price</label><br /> <input
									type="text" name="productPrice" title="Enter product price" required></td>
							</tr>
							<tr>
								<td><label for="productCode">Produce Code</label><br /> <input
									type="text" name="productCode" title="Enter product code" required></td>
							</tr>
							<tr>
								<td><label for="productDescription">Product Description</label><br /> <input
									type="text" name="productDescription" title="Enter product description" required></td>
							</tr>
							<tr>
								<td><label for="productImg">Product Image Url</label><br /> <input
									type="text" name="productImg" title="Enter product image url" required></td>
							</tr>
							<tr>
								<td><label for="productBrand">Product Brand</label><br /> <input
									type="text" name="productBrand"	title="Enter product brand" required></td>
							</tr>
							<tr>
								<td><label for="productCategory">Product Category</label><br /> <input
									type="text" name="productCategory" title="Enter product category" required></td>
							</tr>
							<tr>
								<td><label for="productStock">Product Stock</label><br /> <input
									type="text" name="productStock" title="Enter product stock" required
									pattern="\d+"></td>
							</tr>
							<tr>
								<td><h2></h2></td>
							</tr>
							<tr>
								<td><input class="large" type="submit" value="Add new product"></td>
							</tr>
						</table>
					</fieldset>
				</form>
				<br/>
				<br/>
				<form action="/fdmazon/removeProductC" method="post" >
					<fieldset style="border-color: orange;">
						<legend class="large">
							<b>Remove Products</b>
						</legend>
						<table>
							<tr>
								<td><h3></h3></td>
							</tr>
							<tr>
								<td><label for="productId">Product ID</label><br /> <input
									type="text" name="productId" title="Enter product Id" pattern="\d+" required></td>
							</tr>
							<tr>
								<td><h2></h2></td>
							</tr>
							<tr>
								<td><input class="large" type="submit" value="Remove product"></td>
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