package pgn.poo.examenMarzoSevillanoVegaVictoriano;

/**
 * 
 * @author Victoriano Sevillano Vega
 * @version 1.0
 */
public class Cuadrado extends Rectangulo {
	/**
	 * Constructor de cuadrado
	 * 
	 * @param lado
	 * @throws DimensionMenorQueCeroException
	 */
	public Cuadrado(double lado) throws DimensionMenorQueCeroException {
		super(lado, lado);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pgn.poo.examenMarzoSevillanoVegaVictoriano.Rectangulo#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + "\t\t" + "[identificador=" + super.getIdentificador() + " area=" + area()
				+ ", perimetro=" + perimetro() + ", lado=" + getAltura() + "\n";
	}
}
