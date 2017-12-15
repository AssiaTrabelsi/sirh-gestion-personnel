package dev.sgp.service;

import dev.sgp.entite.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CollaborateurService {
	List<Collaborateur> listeCollaborateurs = new ArrayList<>();

	public List<Collaborateur> listerCollaborateurs() {
		return listeCollaborateurs;
	}

	public void sauvegarderCollaborateur(Collaborateur collab) {
		listeCollaborateurs.add(collab);
	}
/*
	public void _init(List<Departement> depts) {

		Collaborateur collab1 = new Collaborateur("Assia", "Trabelsi", LocalDate.now().minusYears(40), "Nantes",
				"123456789123456");

		sauvegarderCollaborateur(collab1);
	}
	*/
}
