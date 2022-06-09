package com.taison.presentacion;

import com.taison.accesodatos.DaoCoche;
import com.taison.accesodatos.DaoCocheMemoria;
import com.taison.entidades.Coche;
import com.taison.entidades.EntidadesException;

import static com.taison.bibliotecas.Consola.*;
import static com.taison.bibliotecas.Consola.errorPl;
import static com.taison.bibliotecas.Consola.pl;

public class PresentacionCoches {

	private static final DaoCoche DAO = DaoCocheMemoria.getInstancia();

	public static void main(String[] args) {
		int opcion;

		do {

			mostrarMenu();
			opcion = pedirOpcion();
			procesarOpcion(opcion);

		} while (opcion != 0);

	}

	private static void mostrarMenu() {
		pl("1. Insertar los datos del coche");
		pl("2. Mostrar todos los coches");
		pl("0. Salir");

	}

	private static int pedirOpcion() {

		return pedirInt("Selecciona una de las opciones del menú");
	}

	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			insertar();
			break;

		case 2:
			mostrarTodos();
			break;

		case 0:
			pl("Gracias por utilizar la aplicación");
			break;
		default:
			errorPl("Por favor, elija una de las opciones existentes");
		}

	}

	private static void mostrarTodos() {
		pl();

		ListadoCoches();
		for (Coche coche : DAO.obtnerTodos()) {
			mostrarLinea(coche);
		}

		pl();
	}

	private static void insertar() {
		
		boolean repetir = false;

		do {
			 Coche coche = new Coche();	//Pongo aqui para que se crea otro objecto,caso el usuario quiera añadir mas coches en la lista.

			try {
				coche.setMarca(pedirString("Introduce la marca del coche"));
				coche.setModelo(pedirString("Cual es el modelo del coche"));
				coche.setMatricula(pedirString("Introduce la matricula del coche"));
				coche.setColor(pedirString("Cual es el color del coche"));
				coche.setPotencia(pedirLong("Cual es la potencia del coche"));
				coche.setCilindrada(pedirDouble("Introduce la cilindrada del coche"));
				DAO.insertar(coche);

				pl("Quieres introducir un vehículo más o no (contesta con : si o no)");
				String respuesta = pedirString();
				if (respuesta.trim().toLowerCase().equals("si")) {
					repetir = true;
				} else {
					repetir = false;
				}

			} catch (EntidadesException e) {
				pl(e.getMessage());
			}

		} while (repetir);

	}

	private static void ListadoCoches() {
		pl(" Id\tMatricula      \tMarca      \tModelo    \tColor     \tPotencia      \tCilindrada     ");

	}

	private static void mostrarLinea(Coche coche) {
		pf("%2d\t%8s\t%-15s\t%4s\t%13s\t%13dcv\t%14.3f cc\n", coche.getId(), coche.getMatricula(), coche.getMarca(),
				coche.getModelo(), coche.getColor(), coche.getPotencia(), coche.getCilindrada());

	}

}
