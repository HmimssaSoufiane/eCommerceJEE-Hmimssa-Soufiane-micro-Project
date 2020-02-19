package metier;

public class Personne {
	//password (numero) and nom that what we only collect from the InscriptionClient Servlet 
	
	int numero;
	String nom;	
	
	public Personne(int numero, String nom) {
		super();
		this.numero = numero;
		this.nom = nom;
	}
	public Personne() {
		super();
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
}
