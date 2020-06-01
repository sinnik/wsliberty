<%@page import="java.util.Iterator"%>
<%@page import="com.fdmgroup.fdmazon.model.Order"%>
<%@page import="java.util.ArrayList"%>
<%
	out.print("<tr><th>Order Date</th><th>Order Id</th><th>Order Status</th><th></th></tr>");
	ArrayList<Order> uOList = (ArrayList<Order>) request.getAttribute("orderList");
	Iterator<Order> oIt = uOList.iterator();
	while (oIt.hasNext()) {
		Order o = (Order) oIt.next();
		String orderStatus = "Ordered";
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
		out.print("<tr><td>" + o.getOrderedDateTime() + "</td>");
		out.print("<td>" + o.getOrderId()+ "</td>");
		out.print("<td>" + orderStatus + "</td>");
		out.print("<td><a href=\"/fdmazon/orderDetailsC?linkOD=" + o.getOrderId() + "\">View order details</a></td></tr>");
	}
%>