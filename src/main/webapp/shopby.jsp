<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.fdmgroup.fdmazon.model.Product"%>
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

<body>
	<header><%@ include file="header.jsp"%></header>
	<div id="container">
		<div id="sidebar">
			<%@ include file="advert.jsp"%>
		</div>

		<div id="content">
			<div id="content1">
				<h1><%=request.getAttribute("msg") %></h1>
			</div>

			<div id="content2" ">
				
			</div>
				
			<div id="content3" style="width: auto;">
				<%
				DecimalFormat df = new DecimalFormat("###,###,##0.00");
				List<Product> filteredProductList =(List<Product>)request.getAttribute("fProductList");
				for (Product e: filteredProductList){
					out.print("<div class=\"listproduct\"><a href=\"/fdmazon/productLinkC?link="+e.getProductId()+"\">");
				 	out.print("<img src=\""+e.getProductImg()+"\"></img></a>");
					out.print("<br><a href=\"/fdmazon/productLinkC?link="+e.getProductId()+"\">");
				 	out.print(e.getProductName()+"</a>");
				 	out.print("<br>&pound "+df.format(e.getProductPrice())+"</div>"); 	
				}
				%>
			</div>
		</div>
	</div>
	<footer><jsp:include page="footer.jsp" /></footer>
</body>
</html>