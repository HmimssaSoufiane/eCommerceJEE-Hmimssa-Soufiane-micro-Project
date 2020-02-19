package daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dal.DatabaseConnection;
import dao.PersonneDao;
import metier.Personne;

public class PersonneDaoImpl implements PersonneDao{
	Statement statement;
	ResultSet resultSet;
	DatabaseConnection databaseConnection;
	String message = "l\'operation est terminee avec succes";

	public PersonneDaoImpl() {
		databaseConnection = DatabaseConnection.getInstance();
	}

	@Override
	public List<Personne> getPersonnes() {
		List<Personne> Personnes = new ArrayList<Personne>();

		try {
			statement = databaseConnection.getConnection().createStatement();
			resultSet = statement.executeQuery("select * from Personne");

			while (resultSet.next()) {
				Personne c = new Personne(resultSet.getInt(1), resultSet.getString(2));
				Personnes.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Personnes;
	}

	@Override
	public Personne getPersonne(int id) {
		Personne Personne = null;

		try {
			statement = databaseConnection.getConnection().createStatement();
			PreparedStatement preparedStatement = databaseConnection.getConnection()
					.prepareStatement("select * from Personne where numero=?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				Personne = new Personne(resultSet.getInt(1), resultSet.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Personne;
	}

	@Override
	public void addPersonne(Personne Personne) {
		try {
			String queryString = "INSERT INTO `personne`(`nom`) VALUES (?)";
			PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(queryString);
			preparedStatement.setString(1, Personne.getNom());
			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updatePersonne(Personne Personne) {
		try {
			String queryString = "UPDATE `personne` SET `nom`=? WHERE numero= ?";
			PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(queryString);
			preparedStatement.setString(1, Personne.getNom());
			preparedStatement.setInt(2, Personne.getNumero());


			int rowsUpdated = preparedStatement.executeUpdate();
			if (rowsUpdated > 0) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deletePersonne(int id) {
		try {
			String queryString = "DELETE FROM `personne` WHERE  numero=?";
			PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(queryString);
			preparedStatement.setInt(1, id);
			int rowsDeleted = preparedStatement.executeUpdate();
			if (rowsDeleted > 0) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
