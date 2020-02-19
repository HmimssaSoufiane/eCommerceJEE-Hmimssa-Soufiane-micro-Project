package dal;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.http.HttpServlet;

@SuppressWarnings("serial")
public class DatabaseConnection extends HttpServlet {
	private Connection connection;
	private static DatabaseConnection Instance;

	private DatabaseConnection() {
		try {
			//String driver = getServletContext().getInitParameter("jdbc");
			//String databaseURL = getServletContext().getInitParameter("localisation");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/magasin","root","");
			System.out.println("Base de donnees correctement connecte !!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static DatabaseConnection getInstance() {
		if (Instance == null)
			return new DatabaseConnection();
		return Instance;
	}

}
