package metier;

public class Produit {

	int num;
	String nom;
	Double prix;
	
	
	
	public Produit() {
		super();
	}
	public Produit(int num, String nom, Double prix) {
		super();
		this.num = num;
		this.nom = nom;
		this.prix = prix;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Produit [num=" + num + ", nom=" + nom + ", prix=" + prix + "]";
	}
}
