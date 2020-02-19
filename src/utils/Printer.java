package utils;

import java.io.PrintWriter;
import java.util.List;

import metier.Produit;

public class Printer {
	public static void vente(PrintWriter out, List<Produit> produits) {
		out.println("<table border=1>");
		for (Produit produit : produits) {
			out.println("<tr> <td>" + produit.getNom() + " " + produit.getPrix()+ " Euros </td>");
			out.println(" <td><A HREF=\"commande\">");
			out.println("<IMG SRC='L:\\JEE2\\eCommerceJEE-Hmimssa-Soufiane-micro--Project\\img\\supermarket.png' width='20' BORDER=0></A><br> </td> </tr>");
		}
		out.println("</table> </form>");
	}
}
