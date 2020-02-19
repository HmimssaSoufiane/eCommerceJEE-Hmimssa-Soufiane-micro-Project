package daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dal.DatabaseConnection;
import dao.ProduitDao;
import javafx.scene.control.Alert;
import metier.Produit;

public class ProduitDaoImpl implements ProduitDao {
	Statement statement;
	ResultSet resultSet;
	DatabaseConnection databaseConnection;
	String message = "l\'operation est terminee avec succes";

	public ProduitDaoImpl() {
		databaseConnection = DatabaseConnection.getInstance();
	}

	@Override
	public List<Produit> getProduits() {
		List<Produit> Produits = new ArrayList<Produit>();

		try {
			statement = databaseConnection.getConnection().createStatement();
			resultSet = statement.executeQuery("select * from Produit");

			while (resultSet.next()) {
				Produit c = new Produit(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3));
				Produits.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Produits;
	}

	@Override
	public Produit getProduit(int num) {
		Produit Produit = null;

		try {
			statement = databaseConnection.getConnection().createStatement();
			PreparedStatement preparedStatement = databaseConnection.getConnection()
					.prepareStatement("SELECT * FROM `produit` WHERE num=?");
			preparedStatement.setInt(1, num);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				Produit = new Produit(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Produit;
	}

	@Override
	public void addProduit(Produit Produit) {
		try {
			String queryString = "INSERT INTO `Produit`(`nom`) VALUES (?)";
			PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(queryString);
			preparedStatement.setString(1, Produit.getNom());
			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				new Alert(Alert.AlertType.INFORMATION, message).showAndWait();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateProduit(Produit Produit) {
		try {
			String queryString = "UPDATE `produit` SET `nom`=?,`prix`=? WHERE num= ?";
			PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(queryString);
			preparedStatement.setString(1, Produit.getNom());
			preparedStatement.setDouble(2, Produit.getPrix());
			preparedStatement.setInt(3, Produit.getNum());

			int rowsUpdated = preparedStatement.executeUpdate();
			if (rowsUpdated > 0) {
				new Alert(Alert.AlertType.INFORMATION, message).showAndWait();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteProduit(String id) {
		try {
			String queryString = "DELETE FROM `Produit` WHERE  num=?";
			PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(queryString);
			preparedStatement.setString(1, id);
			int rowsDeleted = preparedStatement.executeUpdate();
			if (rowsDeleted > 0) {
				new Alert(Alert.AlertType.INFORMATION, message).showAndWait();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
