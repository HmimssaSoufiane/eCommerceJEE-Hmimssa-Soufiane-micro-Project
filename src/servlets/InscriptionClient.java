package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class InscriptionClient
 */
@WebServlet("/Inscription")
public class InscriptionClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InscriptionClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		String nomRecu = null, motPasseRecu = null;
		String nomCookie = null, motPasseCookie = null;

		// initialisation cookies et paramètres
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("nomCookie")) {
//					cookie.setMaxAge(0);// delete the cookie for testing
//					response.addCookie(cookie); // delete the cookie for testing
					nomCookie = cookie.getValue();

					log("cookie path " + cookie.getPath());

				}
				if (cookie.getName().equals("motPasseCookie")) {
//					cookie.setMaxAge(0); // delete the cookie for testing
//					response.addCookie(cookie);// delete the cookie for testing
					motPasseCookie = cookie.getValue();

				}

			}
		//
		nomRecu = request.getParameter("nom");
		motPasseRecu = request.getParameter("motdepasse");
		if (nomRecu == "" || motPasseRecu == "") {
			motPasseRecu = null;
			nomRecu = null;

		}

		PrintWriter out = response.getWriter();
		if (nomCookie == null && nomRecu == null) {
			// Cas 1 : cas où il n'y a ni de cookies ni de parametres
			out.println("<html>");
			out.println("<body>");
			out.println("<head>");
			out.println("<title> Inscription d'un client </title>");
			out.println("</head>");
			out.println("<body bgcolor='white' >");
			out.println(nomRecu + " | " + motPasseRecu + " | " + nomCookie + " | " + motPasseCookie);
			out.println("<h1> Inscription : </h1>");
			out.println("<h4> Attention mettre nom et le mot de passe avec plus de 3 caracteres </h4>");
			out.println("<form action='Inscription' method='GET' >");

			out.println("<table>");
			out.println("<tr><td>Nom</td><td> <input type='text' size='20' name='nom' > <td></tr>");
			out.println("<tr><td>Mot de passe</td><td> <input type='password' size='20' name='motdepasse'> <td></tr>");
			out.println("<tr><td><input type='submit' value='Inscription'></td>");

			out.println("</table>");
			out.println("</form>");

			out.println("</body>");
			out.println("</html>");

		} else if (nomCookie == null && nomRecu != null && motPasseRecu != null) {
			// Cas 2 : cas où il n'y a pas de cookies mais les paramètres nom et mot de
			// passes sont présents :

			response.addCookie(new Cookie("nomCookie", nomRecu));
			response.addCookie(new Cookie("motPasseCookie", motPasseRecu));

			// insert to the database

			// response.sendRedirect("/eCommerceJEE/Inscription");
			out.println("<html>");
			out.println("<body>");
			out.println("<head>");
			out.println("<title> inscription d'un client </title>");
			out.println("</head>");
			out.println("<body bgcolor='white' >");
			out.println(
					"<h3> votre compte bien enregistrer  , Vous pouvez maintenant <a href=\"/eCommerceJEE/Inscription\">S'identifier</a></h3>");
			out.println("</body>");
			out.println("</html>");

		} else if ((identique(nomRecu, nomCookie) && identique(motPasseRecu, motPasseCookie))) {
			// Cas 3 : cas où le nom et le mot passe sont correctes, appel à la servlet
			// achat

			// Create session and redirect to Achat Servlet
			request.getSession(true);
			response.sendRedirect("/eCommerceJEE/servlet/achat");

		} else if (cookies != null) {
			// Cas 4 : les cookies sont présents demande de s'identifier

			out.println("<html>");
			out.println("<body>");
			out.println("<head>");
			out.println("<title> s'identifier d'un client </title>");
			out.println("</head>");
			out.println("<body bgcolor='orange' >");
			out.println(nomRecu + " | " + motPasseRecu + " | " + nomCookie + " | " + motPasseCookie);
			out.println("<h1>" + "Authentification :" + "</h1>");
			out.println("<form action='Inscription' method='get' >");

			out.println("<table>");
			out.println("<tr><td>Nom</td><td> <input type='text' size='20' name='nom' > <td></tr>");
			out.println("<tr><td>Mot de passe</td><td> <input type='password' size='20' name='motdepasse'> <td></tr>");
			out.println("<tr><td><input type='submit' value='Connexion'></td>");

			out.println("</table>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	boolean identique(String recu, String cookie) {
		return ((recu != null) && (recu.length() > 3) && (cookie != null) && (recu.equals(cookie)));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
