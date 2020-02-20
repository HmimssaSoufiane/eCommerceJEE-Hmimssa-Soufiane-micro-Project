package daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dal.DatabaseConnection;
import dao.CommandeDao;
import dao.PanierDao;
import dao.ProduitDao;
import metier.Panier;
import metier.Personne;

public class PanierDaoImpl implements PanierDao {
	Statement statement;
	ResultSet resultSet;
	DatabaseConnection databaseConnection;
	String message = "l\'operation est termin�e avec succ�s";
	CommandeDao commande;
	ProduitDao produit;
	
	

	public PanierDaoImpl() {
		databaseConnection = DatabaseConnection.getInstance();
		commande=new CommandeDaoImpl();
		produit=new ProduitDaoImpl();
	}

	@Override
	public List<Panier> getPaniers() {
		List<Panier> Paniers = new ArrayList<Panier>();

		try {
			statement = databaseConnection.getConnection().createStatement();
			resultSet = statement.executeQuery("select * from Panier");

			while (resultSet.next()) {
				Panier c = new Panier();
				Paniers.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Paniers;
	}
	@Override
	public List<Panier> getPaniers(Personne personne) {
		List<Panier> Paniers = new ArrayList<Panier>();

		try {
			statement = databaseConnection.getConnection().createStatement();
 			resultSet = statement.executeQuery("SELECT * FROM `panier` p,`commande` c WHERE p.numCommande=c.num and c.numeroPersonn="+personne.getNumero());
			
			while (resultSet.next()) {
				Panier c = new Panier();
				Paniers.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Paniers;
	}

	@Override
	public Panier getPanier(int id) {
		Panier Panier = null;

		try {
			PreparedStatement preparedStatement = databaseConnection.getConnection()
					.prepareStatement("SELECT `numCommande`, `numProduit` FROM `panier` WHERE  num=?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				Panier = new Panier(commande.getCommande(resultSet.getInt(1)), produit.getProduit(resultSet.getInt(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Panier;
	}

	@Override
	public void addPanier(Panier Panier) {
		try {
			String queryString = "INSERT INTO `panier`(`numCommande`, `numProduit`) VALUES  (?,?)";
			PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(queryString);
			preparedStatement.setInt(1, Panier.getCommande().getNum());
			preparedStatement.setInt(2, Panier.getProduit().getNum());
 			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updatePanier(Panier Panier) {
		try {
			String queryString = "UPDATE `panier` SET `numCommande`=?,`numProduit`=? WHERE num=?";
			PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(queryString);
			preparedStatement.setInt(1, Panier.getCommande().getNum());
			preparedStatement.setInt(2, Panier.getProduit().getNum());

 			
 			int rowsUpdated = preparedStatement.executeUpdate();
			if (rowsUpdated > 0) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deletePanier(int id) {
		try {
			String queryString = "DELETE FROM `Panier` WHERE num ?";
			PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(queryString);
			preparedStatement.setInt(1, id);
			int rowsDeleted = preparedStatement.executeUpdate();
			if (rowsDeleted > 0) {
				//new Alert(Alert.AlertType.INFORMATION, message).showAndWait();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
