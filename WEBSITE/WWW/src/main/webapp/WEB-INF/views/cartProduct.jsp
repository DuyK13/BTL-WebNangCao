<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/cart.js"></script>
</head>
<body>
	<table class="table table-striperd table-bordered">
		<tr>
			<th>Id</th>
			<th>Quantity</th>
			<th>Remove</th>
		</tr>
			<c:forEach var="x" items="${cart.getAll()}" varStatus="c">
				<tr>
				<td>${x.id}</td>
				<td><a id="btnDown${c.index}" onclick="btnDownClick(${c.index})"><button class="minus is-form" >-</button></a>					
													<input aria-label="quantity" class="input-qty" id="quan${c.index}"  min="1" name="" type="number" 
														value="${x.quantity}">
												<a id="btnUp${c.index}" onclick="btnUpClick(${c.index})"><button class="plus is-form">+</button></a></td>
				<td><input type="hidden" value="${x.id}" id="choco_id${c.index}"></td>
				<td><a id="btnRemove${c.index}" onclick="btnRemoveClick(${c.index})"><button>Xóa giỏ hàng</button></a></td>
			</tr>
			</c:forEach>
			<tr><td>Tổng tiền:${cart.getTotal()}</td></tr>
	</table>
</body>
</html>