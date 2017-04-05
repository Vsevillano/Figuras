package pgn.poo.examenMarzoSevillanoVegaVictoriano;

/**
 * 
 * @author Victoriano Sevillano Vega
 * @version 1.0
 */
public class TrianguloRectangulo extends Figura {
	/**
	 * Bade del rectangulo
	 */
	private double base;
	/**
	 * Altura del rectangulo
	 */
	private double altura;

	/**
	 * Constructor del rectangulo
	 * 
	 * @param base
	 * @param altura
	 * @throws DimensionMenorQueCeroException
	 */
	public TrianguloRectangulo(double base, double altura) throws DimensionMenorQueCeroException {
		super();
		setBase(base);
		setAltura(altura);
	}

	/**
	 * Obtiene la base del rectangulo
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
		return (base * altura) / 2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pgn.poo.examenMarzoSevillanoVegaVictoriano.Figura#perimetro()
	 */
	@Override
	double perimetro() {
		return base + altura + Math.sqrt((Math.pow(base, 2) + Math.pow(altura, 2)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pgn.poo.examenMarzoSevillanoVegaVictoriano.Figura#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + "\t" + super.toString() + "[base=" + getBase() + ", altura=" + getAltura()
				+ "]\n";
	}
}
