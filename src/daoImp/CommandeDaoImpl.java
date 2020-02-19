package daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dal.DatabaseConnection;
import dao.CommandeDao;
import dao.PersonneDao;
import metier.Commande;

public class CommandeDaoImpl implements CommandeDao {
	Statement statement;
	ResultSet resultSet;
	DatabaseConnection databaseConnection;
	String message = "l\'operation est termin�e avec succ�s";
	
	PersonneDao personne;
	

	public CommandeDaoImpl() {
		databaseConnection = DatabaseConnection.getInstance();
		personne=new PersonneDaoImpl();
	}

	@Override
	public List<Commande> getCommandes() {
		List<Commande> Commandes = new ArrayList<Commande>();

		try {
			statement = databaseConnection.getConnection().createStatement();
			resultSet = statement.executeQuery("select * from Commande");

			while (resultSet.next()) {
				Commande c = new Commande();
				Commandes.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Commandes;
	}

	@Override
	public Commande getCommande(int id) {
		Commande Commande = null;

		try {
			statement = databaseConnection.getConnection().createStatement();
			PreparedStatement preparedStatement = databaseConnection.getConnection()
					.prepareStatement("SELECT * FROM `commande` WHERE num=?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				Commande = new Commande(resultSet.getInt(1), personne.getPersonne(resultSet.getInt(2)), resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Commande;
	}

	@Override
	public void addCommande(Commande Commande) {
		try {
			String queryString = "INSERT INTO `commande`( `numeroPersonne`, `etat`) VALUES (?,?)";
			PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(queryString);
			preparedStatement.setInt(1, Commande.getPersonne().getNumero());
			preparedStatement.setString(2, Commande.getEtat());
 			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateCommande(Commande Commande) {
		try {
			String queryString = "UPDATE `commande` SET `numeroPersonne`=?,`etat`=? WHERE 1 num = ?";
			PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(queryString);
			preparedStatement.setInt(1, Commande.getNum());
			preparedStatement.setInt(2, Commande.getPersonne().getNumero());
			preparedStatement.setString(3, Commande.getEtat());

 			
 			int rowsUpdated = preparedStatement.executeUpdate();
			if (rowsUpdated > 0) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCommande(int id) {
		try {
			String queryString = "DELETE FROM `commande` WHERE num ?";
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
