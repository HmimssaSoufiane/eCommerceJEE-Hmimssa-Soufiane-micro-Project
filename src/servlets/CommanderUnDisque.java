package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Panier;
import utils.Identification;

/**
 * Servlet implementation class CommanderUnDisque
 */
@WebServlet("/servlet/commande")
public class CommanderUnDisque extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommanderUnDisque() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = null;
		int numberOfPruducts = 0;
		Cookie[] cookies = request.getCookies();
		nom = Identification.chercheNom(cookies);
		
		HttpSession httpSession=request.getSession();
		
		ArrayList<Panier> paniers=null;
		if(httpSession.getAttribute("Produit")!=null)
			paniers=new ArrayList<Panier>();
		
		if(httpSession.getAttribute("nbreProduit")!=null) 
			numberOfPruducts= (Integer) httpSession.getAttribute("numberOfPruducts");
	
		String order=request.getParameter("order");
		if (order != null) {
			if (order.equals("add")) {
				if(httpSession.getAttribute("nbreProduit")==null) numberOfPruducts++;
				/*
				String nom = request.getParameter("nom");
				String prix = request.getParameter("prix");
				String num = request.getParameter("num");
				*/
			}
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<head>");
		out.println("<title> Commande de disques </title>");
		out.println("<style>"
					+"th {background-color: #cc6300;color: white;}"
					+ " table, td, th {  border: 1px solid;text-align: center;}"
					+ "table { border-collapse: collapse; width: 70%} "
					+ "th, td {padding: 15px;}"
					+ "</style>");
		out.println("</head>");
		out.println("<body style=\"background-color:#fff2e6;\">");
		out.println("<center>");
		out.println("<h2>" + "Bonjour " + nom + " dans la servlet achat" + "</h2>");
		out.println("<h3>(Votre panier)</h3>");
		out.println("<table>");
		out.println("<tr><th>Informations disque commandes</th></tr>");
		
		for (Panier panier : paniers) {
			out.println("<tr><td>"+ panier.getProduit().getNom()+" | "+panier.getProduit().getPrix()+"s euros</td></tr>");
		}
		out.println("</table>");
		out.println("<p> Votre panier contient : "+numberOfPruducts+" disque(s)<p><br> ");
		out.println("<a href='achat'> Vous pouvez commandez un autre disque </a><br> ");
		out.println("<a href='enregistre'> Vous pouvez enregistrer votre commande </a><br> ");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
