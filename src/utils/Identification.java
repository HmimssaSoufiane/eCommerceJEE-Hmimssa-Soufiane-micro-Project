package utils;

import javax.servlet.http.Cookie;

public class Identification {
	public static String chercheNom(Cookie[] cookies) {
		if (cookies != null)
			for (Cookie cookie : cookies)
				if (cookie.getName().equals("nomCookie"))
					return cookie.getValue();

		return "inconnu";

	}
	public static int chercheNum(Cookie[] cookies) {
		if (cookies != null)
			for (Cookie cookie : cookies)
				if (cookie.getName().equals("motPasseCookie"))
					return Integer.parseInt(cookie.getValue()) ;

		return -1;

	}
}