<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="errorpage.jsp"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.fdmgroup.fdmazon.model.OrderProduct"%>
<%@page import="com.fdmgroup.fdmazon.model.Order"%>
<%@page import="java.util.ArrayList" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/fdmazon/styles/fdmcss.css" />
<title>FDMazon</title>
</head>
<script type="text/javascript">	function checkStock(quantity){
		if(quantity.value > <%=request.getAttribute("pStock")%>){quantity.value = <%=request.getAttribute("pStock")%>} 
		if(quantity.value < 0){	quantity.value = 0;	}	} </script>
<body>
	<header>
		<%@ include file="header.jsp"%>
	</header>
	<div id="container">
		<div class="hidden" id="sidebar"></div>

		<div id="content">
			<div id="content1">
				<h1>Shopping Cart</h1>
			</div>

			<div id="content2"></div>

			<div id="content3" style="width: 80%;">
				<form action="/fdmazon/basketC" method="post" style="width: 100%;"
					onsubmit="return checkForm(this);">
					<fieldset style="border-color: orange;">
						<legend class="large">
							<b></b>
						</legend>
						<%
							if (session.getAttribute("basket") == null) {
								Order order = new Order("", "", "", "", "", "", "");
								session.setAttribute("basket", order);
							}
							DecimalFormat df = new DecimalFormat("###,###,##0.00");
							Order order = (Order) session.getAttribute("basket");
							out.print(
									"<table><th>Category</th><th>Product Id</th><th>Product Name</th><th>Unit Price</th><th>Quantity</th><th>Subtotal</th></tr>");
							double total = 0.00d;
							if (order.getOrderProductList() == null) {
								out.print("<tr><td></td>");
								out.print("<td class=\"center\"></td>");
								out.print("<td></td>");
								out.print("<td></td>");
								out.print("<td class=\"center\"></td>");
								out.print("<td><br/><br/></td></tr>");
								out.print("<tr><td></td><td></td><td></td><td></td><td><b>Total :</b></td><td><b>&pound; "
										+ df.format(total) + "</b></td></tr>");
								out.print("</table><br/><br/><br/>");
							} else {
								for (OrderProduct op : order.getOrderProductList()) {
									out.print("<tr><td>" + op.getProduct().getCategory() + "</td>");
									out.print("<td class=\"center\">" + op.getProduct().getProductId() + "</td>");
									out.print("<td><a href=\"/fdmazon/productLinkC?link=" + op.getProduct().getProductId() + "\">"
											+ op.getProduct().getProductName() + "</a></td>");
									out.print("<td>&pound; " + df.format(op.getProduct().getProductPrice()) + "</td>");
									out.print("<td class=\"center\"><input size=\"2\" type=\"text\" name="
											+ op.getProduct().getProductId() + " placeholder=" + op.getQuantity() + "></td>");
									out.print(
											"<td>&pound; " + df.format(op.getProduct().getProductPrice() * op.getQuantity()) + "</td>");
									total += (op.getProduct().getProductPrice() * op.getQuantity());
									
								}
								session.setAttribute("basketTotal", total);
								out.print("<tr><td></td><td></td><td></td><td></td><td><b>Total :</b></td><td><b>&pound; "
										+ df.format(total) + "</b></td></tr>");
								out.print("</table><br><br><br>");
							}
						%>
						<input type="submit" value="Update basket">
					</fieldset>
				</form>
				<br /> <br />
				<form action="/fdmazon/checkoutC" method="post">
					<input class="large" type="submit" value="Checkout">
				</form>
			</div>
		</div>
	</div>
	<footer>
		<%@ include file="footer.jsp"%>
	</footer>

</body>
</html>