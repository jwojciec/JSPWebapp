<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link href="<c:url value="products.css" />" rel="stylesheet">
<title>Products page</title>
</head>
<body>
	<h2>Product list:</h2>
		<table class="table-style">
        <thead>
            <tr>
                <th>Product Id</th>
                <th>Name</th>
                <th>Price</th>
                <th colspan=2></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><c:out value="${product.product_id}" /></td>
                    <td><c:out value="${product.product_name}" /></td>
                    <td><c:out value="${product.product_price}" /></td>
                    <td><a href="ProductServlet?action=edit&productId=<c:out value="${product.product_id}"/>">Edit</a></td>
                    <td><a href="ProductServlet?action=delete&productId=<c:out value="${product.product_id}"/>">Delete</a></td>                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="ProductServlet?action=insert">Add new product</a></p>		
</body>
</html>