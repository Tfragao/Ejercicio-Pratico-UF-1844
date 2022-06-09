package com.taison.bibliotecas;


import java.util.Scanner;

public class Consola {
	private static final Scanner sc = new Scanner(System.in);

	public static void pf(String formato, Object... objects) {
		System.out.printf(formato, objects);
	}

	public static void pl(Object ob) {
		System.out.println(ob);
	}

	public static void pl() {
		System.out.println();
	}

	public static void p(Object ob) {
		System.out.println(ob);
	}

	public static void errorPl(Object ob) {
		System.err.println(ob);
	}



	public static String pedirString(String mensaje) {
		p(mensaje + ": ");
		return sc.nextLine();
	}
	
	public static String pedirString() {
		return sc.nextLine();
	}

	public static long pedirLong(String mensaje) {
		boolean repetir = true;
		String texto;
		Long l = null;

		do {

			try {

				texto = pedirString(mensaje);

				l = Long.parseLong(texto);

				repetir = false;

			} catch (NumberFormatException e) {
				pl("No es numero");
			}

		} while (repetir);

		return l;
	}

	public static int pedirInt(String mensaje) {
		boolean repetir = true;
		String texto;
		Integer i = null;

		do {

			try {

				texto = pedirString(mensaje);

				i = Integer.parseInt(texto);

				repetir = false;

			} catch (NumberFormatException e) {
				pl("No es numero");
			}

		} while (repetir);

		return i;
	}
	
	public static double pedirDouble(String mensaje) {
		boolean repetir = true;
		String texto;
		Double d = null;

		do {

			try {

				texto = pedirString(mensaje);

				d = Double.parseDouble(texto);

				repetir = false;

			} catch (NumberFormatException e) {
				pl("No es numero");
			}

		} while (repetir);

		return d;
	}
}
