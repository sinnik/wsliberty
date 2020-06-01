<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.fdmgroup.fdmazon.model.Product"%>

<% 	out.print("<h1>Latest Products</h1>");
	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("productList");
	Iterator<Product> it = list.iterator();
	int i = 0;
	while(it.hasNext() && i<10){
		Product e = (Product) it.next();
		out.print("<div class=\"listproduct\"><a href=\"/fdmazon/productLinkC?link="+e.getProductId()+"\">");
	 	out.print("<img src=\""+e.getProductImg()+"\"></img></a>");
		out.print("<br><a href=\"/fdmazon/productLinkC?link="+e.getProductId()+"\">");
	 	out.print(e.getProductName()+"</a>");
	 	out.print("<br>&pound"+e.getProductPrice()+"</div>");
	 	i++;
	}
%>