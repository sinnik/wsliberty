<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="errorpage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FDMazon</title>
<link rel="stylesheet" type="text/css" href="/styles/fdmcss.css" />
</head>
<script type="text/javascript">
	function checkStock(quantity){
		if(quantity.value > <%=request.getAttribute("pStock")%>){
			quantity.value = <%=request.getAttribute("pStock")%>
		} 
		if(quantity.value < 0){
			quantity.value = 0;
		}
	}
</script>
<body>
	<header><%@ include file="header.jsp"%></header>
	<div id="container">
		<div id="sidebar">
			<%@ include file="advert.jsp"%>
		</div>

		<div id="content">
			<div id="content1">
				<h1><%=request.getAttribute("pName")%></h1>
				<img class="zoom" src="<%=request.getAttribute("pImg")%>" />
			</div>

			<div id="content2" style="width: 20%; min-width: 150px;">
				<form action="/addBasketC" method="post" >
					<table style="font-size: 1em;">
						<tr>
							<td>Price:</td>
							<td class="right">&pound;<%=request.getAttribute("pPrice")%></td>
						<tr>
							<td>Stock:</td>
							<td class="right"><%=request.getAttribute("pStock")%></td>
						</tr>
						<tr>
							<td><label for="quantity">Quantity</label></td>
							<td class="right"><input type="text" name="quantity" title="Enter value no more than available stock"
								id="quantity" style="width: 50px;" required onchange="checkStock(this.value);"></td>
						</tr>
						<tr>
							<td></td>
							<input type="hidden" name="productAdded" value=<%=request.getAttribute("pId")%> />
							<input type="hidden" name="stock" value=<%=request.getAttribute("pStock")%> />
							<td class="right"><input class="large" type="submit"
								value="Add to basket" pattern="\d+"></td>
						</tr>
					</table>
				</form>
			</div>
				
			<div id="content3" style="width: auto;">
				<% if (session.getAttribute("addbasketmsg")!=null){out.print("<a style=\"color:red\">"+session.getAttribute("addbasketmsg")+"</a><br/><br/>");
						session.setAttribute("addbasketmsg", null);}%>
				<b>Product Category: </b><%=request.getAttribute("pCat")%><br /> <b>Brand:
				</b><%=request.getAttribute("pBrand")%><br /> <b>Product Id: </b><%=request.getAttribute("pId")%><br />
				<b>Product Code: </b><%=request.getAttribute("pCode")%><br /> <br />
				<b>Product Description</b><br><%=request.getAttribute("pDesc")%>
			</div>
		</div>
	</div>
	<footer><jsp:include page="footer.jsp" /></footer>
</body>
</html>