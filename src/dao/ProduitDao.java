package dao;

import java.util.List;

import metier.Produit;

public interface ProduitDao {
	
	public List<Produit> getProduits();
	public Produit getProduit(int id);
	public void addProduit(Produit P);
	public void updateProduit(Produit P);
	public void deleteProduit(String id);
}
