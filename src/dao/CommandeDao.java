package dao;

import java.util.List;

import metier.Commande;


public interface CommandeDao {

	public List<Commande> getCommandes();
	public Commande getCommande(int id);
	public void addCommande(Commande C);
	public void updateCommande(Commande C);
	public void deleteCommande(int id);
}
