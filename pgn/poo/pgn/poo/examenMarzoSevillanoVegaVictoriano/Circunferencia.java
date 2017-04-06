package pgn.poo.examenMarzoSevillanoVegaVictoriano;

/**
 * 
 * @author Victoriano Sevillano Vega
 * @version 1.0
 */
public class Circunferencia extends Figura {
	/**
	 * Radio de la circunferencia
	 */
	private double radio;

	/**
	 * Constructor con el radio
	 * 
	 * @param radio
	 * @throws DimensionMenorQueCeroException
	 */
	public Circunferencia(double radio) throws DimensionMenorQueCeroException {
		super();
		setRadio(radio);
	}

	/**
	 * Obtiene el radio
	 * 
	 * @return
	 */
	public double getRadio() {
		return radio;
	}

	/**
	 * Comprueba el radio
	 * 
	 * @param radio
	 * @throws DimensionMenorQueCeroException
	 *             si a dimension es menor que 0.5
	 */
	public void setRadio(double radio) throws DimensionMenorQueCeroException {
		comprobarDimension(radio);
		this.radio = radio;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pgn.poo.examenMarzoSevillanoVegaVictoriano.Figura#area()
	 */
	@Override
	double area() {
		return Math.PI * Math.pow(radio, 2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pgn.poo.examenMarzoSevillanoVegaVictoriano.Figura#perimetro()
	 */
	@Override
	double perimetro() {
		return 2 * Math.PI * radio;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pgn.poo.examenMarzoSevillanoVegaVictoriano.Figura#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + "\t" + super.toString() + "[radio=" + getRadio() + "]\n";
	}
}
