package dev.spg.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;
import dev.sgp.entite.*;
public class ListerCollaborateursController extends HttpServlet {

	
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();
		req.setAttribute("listeCollaborateurs", collaborateurs);
		 req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").
		 forward(req, resp);
		 
		
		
	}

}
