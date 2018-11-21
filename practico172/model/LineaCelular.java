package model;
public class LineaCelular extends LineaTelefonica{
	
	public static final int COSTO_MINUTO_CELULAR = 10;
	private int minutosACelular;
	
	public LineaCelular(int minACel, int minLoc){
		super(minLoc);
		this.minutosACelular = minACel;
	}
	
	@Override
	public Double calcularCostoLlamadas(){
		Double total = (this.minutosACelular*1.0) * COSTO_MINUTO_CELULAR;
		total += (this.minutosLocales*1.0) * COSTO_MINUTO_LOCAL;
		return total;
	}
}