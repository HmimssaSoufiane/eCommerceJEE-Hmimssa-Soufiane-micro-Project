package utils;

import java.io.PrintWriter;
import java.util.List;

import metier.Produit;

public class Printer {
	public static void vente(PrintWriter out, List<Produit> produits) {
		out.println("<table border=1>");
		for (Produit produit : produits) {
			out.println("<tr> <td>" + produit.getNom() + " " + produit.getPrix()+ " Euros </td>");
			out.println(" <td><a href=\"/eCommerceJEE/servlet/commande?produit="+produit.getNum()+"\">");
			out.println("<img src='L:\\JEE2\\eCommerceJEE-Hmimssa-Soufiane-micro--Project\\img\\supermarket.png' width='20' border=0></a><br> </td> </tr>");
		} 
		out.println("</table> </form>");
	}
}
