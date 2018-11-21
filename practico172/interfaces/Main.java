 package interfaces;
 import java.util.*;
 import model.*;
 public class Main{
	public static void main(String[] args){
		Empresa t = new Empresa();
		t.getLineasT()[0] = new LineaTelefonica(450);
		t.getLineasT()[1] = new LineaCelular(1200, 200);
		t.getLineasT()[2] = new LineaCelular(30, 100);
		t.getLineasT()[3] = new LineaTelefonica(165);

		System.out.print(t.calcularCostoTotalLineas());
	}
 }