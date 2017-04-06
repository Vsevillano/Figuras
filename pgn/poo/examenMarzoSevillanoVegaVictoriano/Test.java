package pgn.poo.examenMarzoSevillanoVegaVictoriano;

import pgn.poo.utiles.Menu;
import pgn.poo.utiles.Teclado;

/**
 * 
 * @author Victoriano Sevillano Vega
 * @version 1.0
 */
public class Test {
	/**
	 * Menu para las altas
	 */
	private static Menu menuAltas;
	/**
	 * Menu para las bajas
	 */
	private static Menu menuBajas;
	/**
	 * Menu para listar
	 */
	private static Menu menuListar;
	/**
	 * Estructura que almacena figuritas
	 */
	private static Figuritas figuritas = new Figuritas();

	public static void main(String[] args) {

		Menu menuGeneral = new Menu("**General", new String[] { "Altas", "Bajas", "Listar" });

		menuAltas = new Menu("**Altas", new String[] { "Masivas (dimensiones aleatorias, 3 figuras de cada tipo)",
				"Selectivas (dimensiones por teclado)" });

		menuBajas = new Menu("**Altas", new String[] { "Por identificador", "Por indice en la lista" });

		menuListar = new Menu("**Listar", new String[] { "Todos", "Triangulos", "Del reves" });

		int opcion;

		do {
			opcion = menuGeneral.gestionar();
			gestionarOpciones(opcion);
		} while (opcion != menuGeneral.SALIR);
	}

	/**
	 * Gestiona las opciones del menu principal
	 * 
	 * @param opcion
	 */
	private static void gestionarOpciones(int opcion) {
		switch (opcion) {
		case 1:
			// Altas
			do {
				opcion = menuAltas.gestionar();
				gestionarAltas(opcion);
			} while (opcion != menuAltas.SALIR);
			break;
		case 2:
			// Bajas
			do {
				opcion = menuBajas.gestionar();
				gestionarBajas(opcion);
			} while (opcion != menuBajas.SALIR);
			break;
		case 3:
			// Listar
			do {
				opcion = menuListar.gestionar();
				gestionarListar(opcion);
			} while (opcion != menuListar.SALIR);
			break;
		default:
			// Salir
			System.out.println("Aaadios!");
			break;
		}
	}

	/**
	 * Gestiona las opciones del menu de bajas
	 * 
	 * @param opcion
	 */
	private static void gestionarBajas(int opcion) {
		if (figuritas.isEmpty()) {
			System.out.println("Vacio");
			return;
		}
		switch (opcion) {
		case 1:
			// Por identificador
			try {
				figuritas.removeIdent(Teclado.leerEntero("Dame el identificador de la figura:"));
			} catch (EliminarFiguritaException e) {
				System.err.println(e.getMessage());
			}
			break;
		case 2:
			// Por indice en la lista
			try {
				figuritas.removeIndex();
			} catch (EliminarFiguritaException e) {
				System.err.println(e.getMessage());
			}
			break;
		}
	}

	/**
	 * Gestiona las opciones del menu de listar
	 * 
	 * @param opcion
	 */
	private static void gestionarListar(int opcion) {
		switch (opcion) {
		case 1:
			// Todos
			System.out.println(figuritas.toString());
			break;
		case 2:
			// Triangulos
			figuritas.listarTriangulos();
			break;
		case 3:
			// Del reves
			figuritas.listarDelReves();
			break;
		}
	}

	/**
	 * Gestiona el tipo de alta a realizar
	 * 
	 * @param opcion
	 */
	private static void gestionarAltas(int opcion) {
		switch (opcion) {
		case 1:
			// Masivas
			figuritas.altaMasiva();
			break;
		case 2:
			// Selectivas
			figuritas.altaSelectiva();
			break;
		}
	}
}
