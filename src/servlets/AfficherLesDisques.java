package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImp.PanierDaoImpl;
import metier.Panier;
import utils.Identification;

@WebServlet("/servlet/achat")
public class AfficherLesDisques extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AfficherLesDisques() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String nom = null;
		Cookie[] cookies = request.getCookies();
		nom = Identification.chercheNom(cookies);
		
		if (request.getSession(false)!=null) {
			
			List<Panier> paniers = new PanierDaoImpl().getPaniers();
			out.println("<html>");
			out.println("<body>");
			out.println("<head>");
			out.println("<title> Commande de disques </title>");
			out.println("<style>" + "th {background-color: #cc6300;color: white;}"
					+ " table, td, th {  border: 1px solid;text-align: center;}"
					+ "table { border-collapse: collapse; width: 70%} " + "th, td {padding: 15px;}" + "</style>");
			out.println("</head>");
			out.println("<body style=\"background-color:#fff2e6;\">");
			out.println("<center>");
			out.println("<h2>" + "Bonjour " + nom + " dans la servlet achat" + "</h2>");
			out.println("<h3>(Liste des disques pour achat)</h3>");
//			Printer.vente(out, paniers);
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
		}else {
			response.sendRedirect("servlets/InscriptionClient");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
