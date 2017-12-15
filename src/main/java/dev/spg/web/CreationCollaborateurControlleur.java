package dev.spg.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class CreationCollaborateurControlleur extends HttpServlet {

	private final String SOCIETE = ResourceBundle.getBundle("application").getString("societe");

	private static final String vue = "/WEB-INF/views/collab/editerCollaborateurs.jsp";
	private static final String champ_nom = "nom";
	private static final String champ_prenom = "prenom";
	private static final String champ_dateNaiss = "datenaissance";
	private static final String champ_adresse = "adresse";
	private static final String champ_nss = "nss";

	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/collab/editerCollaborateurs.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		Map<String, String> erreurs = new HashMap<String, String>();
				// recuperation des champs du formulaire
		String nom = req.getParameter(champ_nom);
		String prenom = req.getParameter(champ_prenom);
		String dateNaiss = req.getParameter(champ_dateNaiss);
		String adresse = req.getParameter(champ_adresse);
		String nss = req.getParameter(champ_nss);

		// validation des champs

		try {

			validationNom(nom);
		} catch (Exception e) {
			erreurs.put(champ_nom, e.getMessage());
		}

		try {

			validationPrenom(prenom);
		} catch (Exception e) {
			erreurs.put(champ_prenom, e.getMessage());
		}

		try {

			validationDateNaiss(dateNaiss);
		} catch (Exception e) {
			erreurs.put(champ_dateNaiss, e.getMessage());
		}

		try {

			validationNumSS(nss);
		} catch (Exception e) {
			erreurs.put(champ_nss, e.getMessage());
		}

		if (!erreurs.isEmpty()) {
			req.setAttribute("erreurs", erreurs);
			req.getRequestDispatcher("/WEB-INF/views/collab/editerCollaborateurs.jsp").forward(req, resp);

		} else {
			Collaborateur collab = new Collaborateur();

			String matricule = "M" + collabService.listerCollaborateurs().size();
			collab.setNom(nom);
			collab.setPrenom(prenom);
			collab.setDate_naissance(LocalDate.parse(dateNaiss));
			collab.setAdresse(adresse);
			collab.setEmailPro(prenom + "." + nom + "@" + SOCIETE + ".com");
			collab.setNum_secu_sociale("nss");
			collab.setDateHeureCreation(ZonedDateTime.now());
			collab.setMatricule(matricule);
			//collab.setPhoto("./webapp/images/avatar.png");
			
			collabService.sauvegarderCollaborateur(collab);

			resp.sendRedirect(req.getContextPath() + "/collaborateurs/lister");
		}
	}

	private void validationNom(String nom) throws Exception {
		if (nom == null && nom.equals("")) {
			throw new Exception("Le champs nom est vide");
		}

	}

	private void validationPrenom(String prenom) throws Exception {
		if (prenom == null && prenom.equals("")) {
			throw new Exception("Le  champs prenom est vide");
		}

	}

	private void validationDateNaiss(String dateNaiss) throws Exception {
		if (dateNaiss == null && dateNaiss.equals("")) {
			throw new Exception("Le champs de dateNaiss est vide");
		}

	}

	private void validationNumSS(String nss) throws Exception {
		if (nss != null && nss.trim().length() < 15) {
			throw new Exception("Le champs NSS est vide et il doit contenir au moins 15 caractères");
		}
	}

}
