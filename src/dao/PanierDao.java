package dao;

import java.util.List;

import metier.Panier;

public interface PanierDao {
	public List<Panier> getPaniers();
	public Panier getPanier(int id);
	public void addPanier(Panier P);
	public void updatePanier(Panier P);
	public void deletePanier(int id);
}
