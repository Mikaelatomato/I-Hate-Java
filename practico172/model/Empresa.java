package model;
import java.util.*;

public class Empresa {
	
	private LineaTelefonica[] lineasT = new LineaTelefonica[4];

	public Empresa(){
	
	}
	
	public Double calcularCostoTotalLineas(){
		Double total = 0.0;
		for (int i = 0; i < lineasT.length; i++){
			total += lineasT[i].calcularCostoLlamadas();
		}
		return total;
	}
	
	public LineaTelefonica[] getLineasT(){
		return lineasT;
	}
}