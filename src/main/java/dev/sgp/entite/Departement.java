package dev.sgp.entite;

public class Departement {

	private Integer id;

	private String nom;

	public Departement(Integer id, String nom) {

		this.id = id;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
}
