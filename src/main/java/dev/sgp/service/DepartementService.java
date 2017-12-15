package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Departement;

public class DepartementService {

	List<Departement> departement = new ArrayList<Departement>();

	public DepartementService()

	{
		Departement Comptabilite = new Departement(1, "Comptabilie");
		Departement RH = new Departement(2, "Ressources Humaines");
		Departement Informatique = new Departement(3, "Informatique");
		Departement Administratif = new Departement(4, "Administratif");

		departement.add(Comptabilite);
		departement.add(RH);
		departement.add(Informatique);
		departement.add(Administratif);

	}

	public List<Departement> getDepartement() {
		return departement;
	}

	
}


