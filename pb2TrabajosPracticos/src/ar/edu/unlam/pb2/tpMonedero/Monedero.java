package ar.edu.unlam.pb2.tpMonedero;

public class Monedero {
	private Integer dineroActual;
	
	public Monedero (Integer dineroInicial) {
		this.dineroActual = dineroInicial;
	}
	
	public Integer consultarSaldo() {
		return this.dineroActual;
	}
	
	public void meterDinero(Integer dineroIngresado) {
		this.dineroActual += dineroIngresado;
	}
	
	public void retirarDinero(Integer dineroRetirado) {
		if(dineroRetirado < this.dineroActual) {
			this.dineroActual -= dineroRetirado;
		}
	}
	
} 
