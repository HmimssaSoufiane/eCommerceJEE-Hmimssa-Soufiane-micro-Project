package metier;

public class Commande {
	int num;
	Personne personne;
	String etat;
	
	public Commande() {
		super();
	}
	public Commande(int num, Personne personne, String etat) {
		super();
		this.num = num;
		this.personne = personne;
		this.etat = etat;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	@Override
	public String toString() {
		return "Commande [numero=" + num + ", personne=" + personne + ", etat=" + etat + "]";
	}
	
	
	
	

}
