<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
<meta charset="UTF-8">
<title>SGP-App</title>
</head>
<body>

	<div class="container-fluid">
		<h1>Les collaborateurs</h1>

		<c:forEach var="collab" items="${listeCollaborateurs}">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">${collab.nom}${collab.prenom}</h3>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-sm-4">
							<img class="img-responsive" style="max-width: 20%;"
								src="<c:url value = "/images/${collab.photo}"/>">
						</div>
						<div class="col-sm-8">
							<p>klnflgboeghoehgeijfpz</p>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>

	</div>
</body>
</html>