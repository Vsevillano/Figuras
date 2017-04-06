package pgn.poo.examenMarzoSevillanoVegaVictoriano;

import java.util.ArrayList;
import java.util.ListIterator;

import pgn.poo.utiles.Menu;
import pgn.poo.utiles.Teclado;

/**
 * 
 * @author Victoriano Sevillano Vega
 * @version 1.0
 */
public class Figuritas {
	/**
	 * Estructura donde se guardaran nuestras figuras
	 */
	private ArrayList<Figura> figuritas = new ArrayList<Figura>();
	/**
	 * Menu para crear figuras
	 */
	private Menu menuFiguras = new Menu("** Elige una figura a crear",
			new String[] { "Circulo", "Cuadrado", "Rectangulo", "Triangulo Rectangulo" });
	/**
	 * Menu para borrar
	 */
	private Menu menuBorrar;

	/**
	 * Crea 3 figuras de cada tipo
	 */
	void altaMasiva() {
		for (int i = 0; i < 3; i++) {
			annadirRectangulo();
			annadirCuadrado();
			annadirCirculo();
			annadirTriangulo();
		}
		System.out.println(toString());
	}
	
	/**
	 * Añade un triangulo a la lista
	 */
	private void annadirTriangulo() {
		try {
			figuritas.add(new TrianguloRectangulo(numeroAleatorio(), numeroAleatorio()));
		} catch (DimensionMenorQueCeroException e) {
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Añade un circulo a la lista
	 */
	private void annadirCirculo() {
		try {
			figuritas.add(new Circunferencia(numeroAleatorio()));
		} catch (DimensionMenorQueCeroException e) {
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Añade un Cuadrado a la lista
	 */
	private void annadirCuadrado() {
		try {
			figuritas.add(new Cuadrado(numeroAleatorio()));
		} catch (DimensionMenorQueCeroException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Añade un Rectangulo a la lista
	 */
	private void annadirRectangulo() {
		try {
			figuritas.add(new Rectangulo(numeroAleatorio(), numeroAleatorio()));
		} catch (DimensionMenorQueCeroException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Genera un numero aleatorio entre 0 y 1
	 * 
	 * @return
	 */
	private double numeroAleatorio() {
		return Math.round(Math.random() * 100)/100d;
	}

	/**
	 * Realiza un alta en funcion de la figura que se quiera
	 */
	void altaSelectiva() {
		int opcion;
		do {
			opcion = menuFiguras.gestionar();
			try {
				gestionarOpciones(opcion);
			} catch (DimensionMenorQueCeroException e) {
				System.err.println(e.getMessage());
			}
		} while (opcion != menuFiguras.SALIR);

	}

	/**
	 * Gestiona las opciones del menu de figuras
	 * 
	 * @param opcion
	 * @throws DimensionMenorQueCeroException
	 */
	private void gestionarOpciones(int opcion) throws DimensionMenorQueCeroException {
		switch (opcion) {
		case 1:
			// Circulo
			figuritas.add(new Circunferencia(Teclado.leerDecimal("Dame el radio del Circulo:")));
			break;
		case 2:
			// Cuadrado
			figuritas.add(new Cuadrado(Teclado.leerDecimal("Dame el lado del Cuadrado:")));
			break;
		case 3:
			// Rectangulo
			figuritas.add(new Rectangulo(Teclado.leerDecimal("Dame la base del Rectangulo:"),
					Teclado.leerDecimal("Dame la altura del Rectangulo:")));
			break;
		case 4:
			// Triangulo rectangulo
			figuritas.add(new Rectangulo(Teclado.leerDecimal("Dame la base del Rectangulo:"),
					Teclado.leerDecimal("Dame la altura del Rectangulo:")));
			break;
		}
	}

	/**
	 * Lista el numero de triangulos
	 */
	void listarTriangulos() {
		int contador = 0;
		for (Figura figura : figuritas) {
			if (figura instanceof TrianguloRectangulo)
				contador++;
		}
		System.out.println("Total de triángulos: " + contador);

	}

	/**
	 * Lista todas las figuras del reves
	 */
	void listarDelReves() {
		ListIterator<Figura> iterator = figuritas.listIterator(figuritas.size());
		while (iterator.hasPrevious())
			System.out.print(iterator.previous());
	}

	/**
	 * Elimina una figura por identificador
	 * 
	 * @param ident
	 * @throws EliminarFiguritaException
	 */
	void removeIdent(int ident) throws EliminarFiguritaException {
		try {
			figuritas.remove(new Rectangulo(ident));
		} catch (IndexOutOfBoundsException e) {
			throw new EliminarFiguritaException("ERROR no se pudo eliminar la figura");
		}
						
	}

	/**
	 * Genera el array de cadena a partir de las figuritas existentes
	 * 
	 * @return
	 */
	public String[] generarArrayFiguras() {
		String[] opcionesMenu = new String[figuritas.size()];
		for (int i = 0; i < figuritas.size(); i++) {
			opcionesMenu[i] = figuritas.get(i).toString();
		}
		return opcionesMenu;
	}

	/**
	 * Elimina un elemento de la lista por indice
	 * @throws EliminarFiguritaException 
	 */
	void removeIndex() throws EliminarFiguritaException {
		int indice;
		do {
			menuBorrar = new Menu("** Elige una de las figuras a borrar", generarArrayFiguras());
			indice = menuBorrar.gestionar();
			gestionarBaja(indice);
		} while (indice != menuBorrar.SALIR && continuar("¿Desea eliminar otra figura? S/N"));
	}

	/**
	 * Realiza la baja por indice de la lista
	 * 
	 * @param indice
	 * @throws EliminarFiguritaException 
	 */
	private void gestionarBaja(int indice) throws EliminarFiguritaException {
			try {
				Figura figura = figuritas.get(indice - 1);
				if (figuritas.remove(figura))
					System.out.println("Eliminada:\n" + figura);
			} catch (IndexOutOfBoundsException e) {
				throw new EliminarFiguritaException("ERROR no se pudo eliminar la figura");
			}
	}

	/**
	 * Devuelve true o false en funcion del caracter
	 * 
	 * @param msj
	 * @return
	 */
	private static boolean continuar(String msj) {
		switch (Teclado.leerCaracter(msj)) {
		case 'N':
		case 'n':
			return false;
		default:
			return true;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return figuritas.size() + " Figuritas\n" + figuritas;
	}

	/**
	 * Devuelve si la lista esta vacia o no
	 * @return
	 */
	boolean isEmpty() {
		return figuritas.isEmpty();
	}

}
