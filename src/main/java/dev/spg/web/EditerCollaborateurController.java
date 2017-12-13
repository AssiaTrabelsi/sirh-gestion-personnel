package dev.spg.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String matricule = req.getParameter("matricule");
		resp.setContentType("text/html");

		if (matricule == null) {
			resp.setStatus(400);

			resp.getWriter().write("<p>Un matricule est attendu</p>");
		} else

		{
			resp.getWriter().write("<h1> Edition de collaborateur</h1>" + "<p> Matricule:" + matricule + "</p>");
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String matricule = req.getParameter("matricule");
		String titre = req.getParameter("titre");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");

		ArrayList<String> ObjetManquant = new ArrayList<>();
		if (matricule == null || matricule.equals("")) {

			ObjetManquant.add("matricule");
		}
		if (titre == null || titre.equals("")) {
			ObjetManquant.add("titre");
		}
		if (nom == null || nom.equals("")) {
			ObjetManquant.add("nom");
		}
		if (prenom == null || prenom.equals("")) {
			ObjetManquant.add("prenom");
		}
		resp.setContentType("text/html");
		
		StringBuilder message = new StringBuilder("Les paramètres suivants sont incorrects : ");
		if (ObjetManquant.size() > 0) {
			for (String m : ObjetManquant) {
				message.append(m).append(", ");
			}
			resp.sendError(400, message.toString());
		} else {
			resp.setContentType("text/html");

			resp.getWriter();

			resp.getWriter().write("<h1>Création d'un collaborateur avec les informations suivantes :</h1>"

					+ "<p>matricule=" + matricule + ",titre=" + titre + ",nom=" + nom + ",prenom=" + prenom + ".</p>");

		}

	}
}
