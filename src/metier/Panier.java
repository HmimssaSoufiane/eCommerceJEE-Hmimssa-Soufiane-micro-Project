package metier;

public class Panier {
	Commande  commande;
	Produit produit;
	
	public Panier() {
		super();
	}
	public Panier(Commande commande, Produit produit) {
		super();
		this.commande = commande;
		this.produit = produit;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	
}
