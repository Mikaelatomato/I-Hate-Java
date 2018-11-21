package model;
public class LineaTelefonica{
	public static final int COSTO_MINUTO_LOCAL=35;
	protected int minutosLocales;
	
	public LineaTelefonica(int minLoc){
		this.minutosLocales = minLoc;
	}
	
	public Double calcularCostoLlamadas(){
	
		return (this.minutosLocales*1.0) * COSTO_MINUTO_LOCAL;
	}
}

	
	