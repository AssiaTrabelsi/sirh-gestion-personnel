<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
<meta charset="UTF-8">
<title>SGP-App</title>
</head>
<body>
  
<div class="container">
<h2>Nouveau Collaborateur</h2>

  <form method="post">
    <div class="form-group">
      <label for="nom">Nom:<span class="requis">*</span></label>
      <input type="text" class="form-control" id="nom" placeholder="Entrer votre nom" name="nom">
      <span class="erreur">${erreurs['nom']}</span>
      <br />
    </div>
    <div class="form-group">
      <label for="prenom">Prenom:<span class="requis">*</span></label>
      <input type="text" class="form-control" id="prenom" placeholder="Entrer votre prenom" name="prenom">
      <span class="erreur">${erreurs['prenom']}</span>
      <br />
    </div>
    
     <div class="form-group">
      <label for="datenaissance">Date de Naissance:<span class="requis">*</span></label>
      <input type="text" class="form-control" id="datenaissance" placeholder="Entrer votre date de naissance" name="datenaissance">
     <span class="erreur">${erreurs['dateNaiss']}</span>
      <br />
    </div>
    <div class="form-group">
      <label for="adresse">Adresse</label>
      <input type="text" class="form-control" id=adresse placeholder="Entrer votre adresse" name="adresse">
    </div>
     <div class="form-group">
      <label for="nss">Numéro de sécurité sociale:<span class="requis">*</span></label>
      <input type="text" class="form-control" id=nss placeholder="Entrer votre numéro" name="nss">
   <span class="erreur">${erreurs['nss']}</span>
      <br />
    </div>
  
    <button type="submit" class="btn btn-default">Créer</button>
  </form>
</div>


</form>

</body>
