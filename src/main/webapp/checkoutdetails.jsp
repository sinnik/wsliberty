<%@page import="java.text.DecimalFormat"%>
<%@page import="com.fdmgroup.fdmazon.model.OrderProduct"%>
<%@page import="com.fdmgroup.fdmazon.model.Order"%>
<%@page import="java.util.ArrayList" import="java.util.List"%>
<%
	DecimalFormat df = new DecimalFormat("###,###,##0.00");
	Order order = (Order)session.getAttribute("basket");
	//out.print("<fieldset style=\"border-color: orange;\"><legend class=\"large\"><b>Recipient Details</b></legend>");
	out.print("<table><tr><td><b>Recipient Name</b><td></tr>");	
	out.print("<tr><td>"+order.getRecipient()+"</td></tr><br/>");
	out.print("<tr><td><b>Recipient Address</b></td></tr>");
	out.print("<tr><td>"+order.getShipHouseNo()+" "+order.getShipStreet()+", "+order.getShipTown()+", "+order.getShipPostcode()+", "+order.getShipCountry()+"</td></tr><br/></table><br/><br/r>");
	//out.print("</fieldset>");
	
	out.print("<table><th>Category</th><th>Product Id</th><th>Product Name</th><th>Unit Price</th><th>Quantity</th><th>Subtotal</th></tr>");
	double total=0.00d;
	for (OrderProduct op : order.getOrderProductList()){
		out.print("<tr><td>" + op.getProduct().getCategory() + "</td>");
		out.print("<td class=\"center\">" + op.getProduct().getProductId() + "</td>");
		out.print("<td><a href=\"/fdmazon/productLinkC?link=" + op.getProduct().getProductId() + "\">"+ op.getProduct().getProductName() + "</a></td>");
		out.print("<td>&pound; " + df.format(op.getProduct().getProductPrice()) + "</td>");			
		out.print("<td class=\"center\">" + op.getQuantity() + "</td>");
		out.print("<td>&pound; " + df.format(op.getProduct().getProductPrice() * op.getQuantity()) + "</td>");
		total+=(op.getProduct().getProductPrice() * op.getQuantity());
		}
	session.setAttribute("basketTotal", total);
	out.print("<tr><td></td><td></td><td></td><td></td><td><b>Total :</b></td><td><b>&pound; "+df.format(total)+"</b></td></tr>");
	out.print("</table><br><br><br>");
	
%>