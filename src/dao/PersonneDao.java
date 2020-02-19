package dao;

import java.util.List;

import metier.Personne;

public interface PersonneDao {
	public List<Personne> getPersonnes();
	public Personne getPersonne(int id);
	public void addPersonne(Personne P);
	public void updatePersonne(Personne P);
	public void deletePersonne(int id);

}
