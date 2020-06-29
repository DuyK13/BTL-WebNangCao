<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>>List chocolates</title>
<link href="<c:url value="resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="resources/js/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="resources/js/bootstrap.min.js" />"></script>
<script src='<c:url value="resources/js/cart.js"></c:url>'
	type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Chocolate List</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>Name</th>
							<th>Quantity</th>
							<th>cost</th>
							<th>description</th>
							<th>listImage</th>
							<th>discount</th>
							<th>category</th>
						</tr>
						<c:forEach var="chocolate" items="${chocolates}" varStatus="x">
							<input type="hidden" id="${chocolate.id}" value="${chocolate.id}"
								name="product_id">
							<c:out value=""></c:out>
							<tr>
								<td>${chocolate.name}</td>
								<td><input type="text" id="quantity"
								 name="product_quantity" value="1"></td>
								<td>${chocolate.cost}</td>
								<td>${chocolate.description}</td>
								<td>${chocolate.image}</td>
								<td>${chocolate.discount}</td>
								<td>${chocolate.category.name}</td>
							<td><a id="btnAddtoCart${chocolate.id}" onclick="addToCart(${chocolate.id})"> 
                            <button type="button" class="btn btn-secondary" >Add</button></a></td>
							</tr>
						</c:forEach>
						<!-- 	<tr>
							<td><input type="hidden" id="product_id" value="1" name="product_id"></td>
							<td><input type="text" id="quantity" required="required" ></td>
							<td><input type="text" id="cost" value="199" readonly="readonly" ></td>
							<td><a id="btnAddtoCart" onclick="addToCart('btnAddtoCart')"> 
                            <button type="button" class="btn btn-secondary" >Add</button></a></td>
						</tr>
						<tr>
							<td><input type="hidden" id="product_id" value="1" name="product_id"></td>
							<td><input type="text" id="quantity" required="required" ></td>
							<td><input type="text" id="cost" value="399"  readonly="readonly" ></td>
							<td><a id="btnAddtoCart" onclick="addToCart('btnAddtoCart')"> 
                            <button type="button" class="btn btn-secondary" >Add</button></a></td>
							
						</tr>
						<tr>
							<td><input type="hidden" id="product_id" value="1" name="product_id"></td>
							<td><input type="text" id="quantity" required="required"  ></td>
							<td><input type="text" id="cost" value="499"  readonly="readonly" ></td>
							<td><a id="btnAddtoCart" onclick="addToCart('btnAddtoCart')"> 
                            <button type="button" class="btn btn-secondary" >Add</button></a></td>
						</tr> -->

						<%-- <c:forEach var="chocolate" items="${chocolates}">
							<tr>
								<td>${chocolate.id}</td>
								<td>${chocolate.name}</td>
								<td>${chocolate.amount}</td>
								<td>${chocolate.cost}</td>
								<td>${chocolate.description}</td>
								<td>${chocolate.listImage.get(0)}</td>
								<td>${chocolate.discount}</td>
								<td>${chocolate.category.name}</td>
							</tr>
						</c:forEach> --%>

					</table>
				</div>
			</div>
		</div>

	</div>
</body>
</html>