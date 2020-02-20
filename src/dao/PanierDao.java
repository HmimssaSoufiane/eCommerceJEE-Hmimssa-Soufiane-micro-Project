package dao;

import java.util.List;

import metier.Panier;
import metier.Personne;

public interface PanierDao {
	public List<Panier> getPaniers();
	public Panier getPanier(int id);
	public void addPanier(Panier P);
	public void updatePanier(Panier P);
	public void deletePanier(int id);
	List<Panier> getPaniers(Personne personne);
}
