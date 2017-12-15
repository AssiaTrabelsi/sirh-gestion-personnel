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
		<br>
		<div class="row">
			<div class="col-lg-4 align-self-center">
				<p class="text-right">Rechercher un nom ou un prénom commencant
					par :</p>
			</div>
			<div class="col-lg-2">
				<form method="get">
					<div class="form-group">
						<input name="recherche" type=text class="form-control"
							value="${searchValue}" placeholder="Recherche">
					</div>
				</form>
			</div>
			<div class="col-lg-4 offset-lg-2 align-self-center">

				<div class="form-check">

					<label class="form-check-label"> <input
						class="form-check-input" type="checkbox" value="">Voir les
						collaborateurs désactivés
					</label>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4">
				<p class="text-right">Filtrer par département :</p>
			</div>
			<div class="col-lg-4">
				<form method="get" class="form-inline">
					<div class="form-group mx-sm-3">
						<select name="departement">
							<option value="all">Tous</option>
							<c:forEach var="dept" items="${departements}">
								<option value="${dept.nom}">${dept.nom}</option>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Filtrer</button>
				</form>
			</div>
		</div>


		<br> <br>
		<div class="row">
			<c:forEach var="collab" items="${listeCollaborateurs}">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">${collab.nom}  ${collab.prenom}</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-sm-4">
								<img class="img-responsive" style="max-width: 35%;"
									src="<c:url value = "/images/${collab.photo}"/>">
							</div>
							<br>
							<div class="col-sm-8">
								<p>
									<b>Date de naissance:</b>${collab.date_naissance}</p>
								<p>
									<b>Numéro de sécurité social:</b>${collab.num_secu_sociale}</p>
								<p>
									<b>Email:</b>${collab.emailPro}</p>
								<p>
									<b>Date:</b>${collab.dateHeureCreation}</p>
							</div>
						</div>
						<center>
							<button type="submit" class="btn btn-primary">Editer</button>
						</center>
					</div>

				</div>
			</c:forEach>

		</div>
</body>
</html>

