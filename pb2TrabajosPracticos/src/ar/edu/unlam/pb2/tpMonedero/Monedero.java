package ar.edu.unlam.pb2.tpMonedero;

public class Monedero {
	private double dineroActual;
	
	public Monedero (double dineroInicial) {
		this.dineroActual = dineroInicial;
	}
	
	public double consultarSaldo() {
		return this.dineroActual;
	}
	
	public void meterDinero(double dineroIngresado) {
		this.dineroActual += dineroIngresado;
	}
	
	public void retirarDinero(double dineroRetirado) {
		if(dineroRetirado < this.dineroActual) {
			this.dineroActual -= dineroRetirado;
		}
	}
	
} 
