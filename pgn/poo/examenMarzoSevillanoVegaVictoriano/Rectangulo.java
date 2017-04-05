package pgn.poo.examenMarzoSevillanoVegaVictoriano;

/**
 * 
 * @author Victoriano Sevillano Vega
 * @version 1.0
 */
public class Rectangulo extends Figura {
	/**
	 * Base del rectangulo
	 */
	private double base;
	/**
	 * Altura del rectangulo
	 */
	private double altura;

	/**
	 * Constructor del restangulo
	 * 
	 * @param base
	 * @param altura
	 * @throws DimensionMenorQueCeroException
	 */
	public Rectangulo(double base, double altura) throws DimensionMenorQueCeroException {
		super();
		setBase(base);
		setAltura(altura);
	}

	/**
	 * Obtiene la base del restangulo
	 * 
	 * @return
	 */
	public double getBase() {
		return base;
	}

	/**
	 * Asigna la base al rectangulo
	 * 
	 * @param base
	 * @throws DimensionMenorQueCeroException
	 */
	public void setBase(double base) throws DimensionMenorQueCeroException {
		comprobarDimension(base);
		this.base = base;
	}

	/**
	 * Obtiene la altura del rectangulo
	 * 
	 * @return
	 */
	public double getAltura() {
		return altura;
	}

	/**
	 * Asigna la altura al rectangulo
	 * 
	 * @param altura
	 * @throws DimensionMenorQueCeroException
	 */
	public void setAltura(double altura) throws DimensionMenorQueCeroException {
		comprobarDimension(altura);
		this.altura = altura;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pgn.poo.examenMarzoSevillanoVegaVictoriano.Figura#area()
	 */
	@Override
	double area() {
		return getBase() * getAltura();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pgn.poo.examenMarzoSevillanoVegaVictoriano.Figura#perimetro()
	 */
	@Override
	double perimetro() {
		return (2 * getBase()) + (2 * getAltura());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pgn.poo.examenMarzoSevillanoVegaVictoriano.Figura#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + "\t\t" + super.toString() + "[base=" + getBase() + ", altura=" + getAltura()
				+ "]\n";
	}

}
