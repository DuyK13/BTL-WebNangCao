<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>>List categorys</title>
<link href="<c:url value="resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="resources/js/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<input type="button" value="Add Category" 
				onclick="window.location.href='showCategoryForm'; return false;"
				class="btn btn-primary" /> <br /> <br />
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Category List</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>Name</th>
							<th>amount</th>
							<th>cost</th>
							<th>description</th>
							<th>listImage</th>
							<th>discount</th>
							<th>category</th>
						</tr>

						<c:forEach var="chocolate" items="${chocolates}">
							<c:url var="updateLink"
								value="/chocolate/updateForm/${chocolate.chocolateid}">
								<c:param name="chocolateid" value="${chocolate.chocolateid}" />
							</c:url>

							<c:url var="deleteLink"
								value="/chocolate/delete/${chocolate.chocolateid}">
								<c:param name="chocolateid" value="${chocolate.chocolateid}" />
							</c:url>

							<tr>
								<td>${chocolate.name}</td>
								<td>${chocolate.amount}</td>
								<td>${chocolate.cost}</td>
								<td>${chocolate.description}</td>
								<td>${chocolate.listImage.get(0)}</td>
								<td>${chocolate.discount}</td>
								<td>${chocolate.category.name}</td>
								<td>
									<!-- display the update link --> <a href="${updateLink}">Update</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this chocolate?'))) return false">Delete</a>
								</td>

							</tr>

						</c:forEach>

					</table>

				</div>
			</div>
		</div>

	</div>
</body>
</html>