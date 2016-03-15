<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="form.css" />" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<form class="form-style" action="ProductServlet" method="post">
    	<h2>Product form</h2>	
    	<label>
        	<span>product id:</span>
			<input class="faded" type="text" name="product_id" value="<c:out value="${product.product_id}" />" readonly>
    	</label>
    	<label>
    		<span>product name:</span>
  			<input type="text" name="product_name" value="<c:out value="${product.product_name}" />">
		</label>
		<label>
			<span>product price:</span>
  			<input type="text" name="product_price" value="<c:out value="${product.product_price}" />">
		</label>
		<label>
			<span>category:</span>
  			<input type="text" name="category" value="<c:out value="${product.category}" />">
		</label>
		<label>
			<span>expiration date: </span>
  			<input type="text" name="expiration_date" value="<c:out value="${product.expiration_date}" />">
		</label>
		<label>
			<span>description:</span>  			  		
  			<textarea name="description">${product.description}</textarea>
		</label>
		<label>
			<span>&nbsp;</span> 
			<input type="submit" class="button" value="Send" /> 
		</label>  			
	</form>
</body>
</html>