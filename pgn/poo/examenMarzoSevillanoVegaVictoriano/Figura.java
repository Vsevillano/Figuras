package pgn.poo.examenMarzoSevillanoVegaVictoriano;

/**
 * 
 * @author Victoriano Sevillano Vega
 * @version 1.0
 */
public abstract class Figura {
	/**
	 * Identificador univoco de cada figura
	 */
	private int identificador;
	/**
	 * Incremento para el identificador
	 */
	private static int contador;

	/**
	 * Constructor de figura
	 */
	public Figura() {
		setIdentificador();
	}

	public Figura(int ident) {
		this.identificador = ident;
	}

	/**
	 * Obtiene el identificador
	 * 
	 * @return
	 */
	protected int getIdentificador() {
		return identificador;
	}

	/**
	 * Asigna el identificador
	 */
	private void setIdentificador() {
		identificador = contador++;
	}

	/**
	 * Area de la figura
	 * 
	 * @return
	 */
	abstract double area();

	/**
	 * Perimetro de la figura
	 * 
	 * @return
	 */
	abstract double perimetro();

	/**
	 * Comprueba que las dimensiones no sean menor de 0.5
	 * 
	 * @param dimension
	 * @throws DimensionMenorQueCeroException
	 *             si las dimensiones son menores a 0.5
	 */
	protected void comprobarDimension(double dimension) throws DimensionMenorQueCeroException {
		if (dimension < 0.5)
			throw new DimensionMenorQueCeroException("ERROR al crear el " + getClass().getSimpleName() + "! "
					+ dimension + ": La dimension ha de tener un minimo de 0.5");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[identificador=" + getIdentificador() + " area=" + area() + ", perimetro=" + perimetro() + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + identificador;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Figura other = (Figura) obj;
		if (identificador != other.identificador)
			return false;
		return true;
	}
}
