<%@page import="java.text.DecimalFormat"%>
<%@page import="com.fdmgroup.fdmazon.model.OrderProduct"%>
<%@page import="com.fdmgroup.fdmazon.model.Order"%>
<%@page import="java.util.ArrayList" import="java.util.List"%>
<%
	DecimalFormat df = new DecimalFormat("###,###,##0.00");
	String orderStatus = "Ordered";
	Order o = (Order) request.getAttribute("oLinked");
	if (o.getPackedDateTime() != null) {
		orderStatus += " > Packed";
	}
	if (o.getShippedDateTime() != null) {
		orderStatus += " > Shipped";
	}
	if (o.getCancelledDateTime() != null) {
		orderStatus += " > Cancelled";
	}
	if (o.getReturnedDateTime() != null) {
		orderStatus += " > Returned";
	}
	out.print("<tr><td><b>Order ID: </b></td><td>"+o.getOrderId()+"</td><td> </td><td> </td></tr><tr><br><br></tr>");
	out.print("<tr><td><b>Recipient:</b></td><td>" + o.getRecipient());
	out.print("<tr><td><b>Recipient address:</b></td><td>" + o.getShipHouseNo() + " " + o.getShipStreet() + o.getShipTown() + ", " + o.getShipPostcode() +", " + o.getShipCountry() + "</td></tr></table><br>");
	
	out.print("<table><th>Category</th><th>Product Id</th><th>Product Name</th><th>Unit Price</th><th>Quantity</th><th>Subtotal</th></tr>");
	double total=0.0d;
	for (OrderProduct op : o.getOrderProductList()){
		out.print("<tr><td>" + op.getProduct().getCategory() + "</td>");
		out.print("<td class=\"center\">" + op.getProduct().getProductId() + "</td>");
		out.print("<td><a href=\"/fdmazon/productLinkC?link=" + op.getProduct().getProductId() + "\">"+ op.getProduct().getProductName() + "</a></td>");
		out.print("<td>&pound; " + df.format(op.getProduct().getProductPrice()) + "</td>");			
		out.print("<td class=\"center\">" + op.getQuantity() + "</td>");
		out.print("<td>&pound; " + df.format(op.getProduct().getProductPrice() * op.getQuantity()) + "</td>");
		total+=(op.getProduct().getProductPrice() * op.getQuantity());
		}
	out.print("<tr><td></td><td></td><td></td><td></td><td class=\"center\"><b>TOTAL :</b></td><td><b>&pound; "+df.format(total)+"</b></td></tr>");
	out.print("</table><br><br><br>");
	
	out.print("<table><tr><td><b>Order Status: " + orderStatus + "</b>");
	out.print("<tr><td>Tracking code:</td><td>" + o.getTrackingCode()+"</td><td> </td><td> </td></tr>");
	out.print("<tr><td>Ordered date/time:</td><td>" + o.getOrderedDateTime()+"</td><td> </td><td> </td></tr>");
	if (o.getPackedDateTime() != null) {
		out.print("<tr><td>Packed date/time:</td><td>" + o.getPackedDateTime()+"</td><td> </td><td> </td></tr>");
	}
	if (o.getShippedDateTime() != null) {
		out.print("<tr><td>Shipped date/time:</td><td>" + o.getShippedDateTime()+"</td><td> </td><td> </td></tr>");
	}
	if (o.getCancelledDateTime() != null) {
		out.print("<tr><td>Cancelled date/time:</td><td>" + o.getCancelledDateTime()+"</td><td> </td><td> </td></tr>");
	}
	if (o.getReturnedDateTime() != null) {
		out.print("<tr><td>Returned date/time:</td><td>" + o.getReturnedDateTime()+"</td><td> </td><td> </td></tr>");
	}
%>