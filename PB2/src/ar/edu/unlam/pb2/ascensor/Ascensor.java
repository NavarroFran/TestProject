package ar.edu.unlam.pb2.ascensor;

import ar.edu.unlam.pb2.persona.Persona;

public class Ascensor {

	private Integer cantidadPersonasMaxima;
	private Double pesoMaximo;
	private Integer pisoMaximo;
	private Integer pisoMinimo;
	private Integer pisoActual;
	private boolean puertaCerrada;
	private Integer cantidadPersonasIngresadas;
	private Double pesoTotalDePersonasIngresadas;


	public Ascensor(Integer cantidadPersonasMaxima, Double pesoMaximo) {
		this.cantidadPersonasMaxima = cantidadPersonasMaxima;
		this.pesoMaximo = pesoMaximo;
		this.pisoActual = 0;
		this.puertaCerrada = true;
		this.cantidadPersonasIngresadas = 0;
		this.pesoTotalDePersonasIngresadas = 0.0;
	}

	public Ascensor(Double pesoMaximo, Integer cantidadPersonasMaxima, Integer pisoMaximo, Integer pisoMinimo) {
		this.cantidadPersonasMaxima = cantidadPersonasMaxima;
		this.pesoMaximo = pesoMaximo;
		this.pisoMaximo = pisoMaximo;
		this.pisoMinimo = pisoMinimo;
		this.pisoActual = 0;
		this.puertaCerrada = true;
		this.cantidadPersonasIngresadas = 0;
		this.pesoTotalDePersonasIngresadas = 0.0;
	}

	public boolean isPuertaCerrada() {
		return puertaCerrada;
	}

	public Integer getCantidadPersonasMaxima() {
		return cantidadPersonasMaxima;
	}

	public void setCantidadPersonasMaxima(Integer cantidadPersonasMaxima) {
		this.cantidadPersonasMaxima = cantidadPersonasMaxima;
	}

	public Double getPesoMaximo() {
		return pesoMaximo;
	}

	public void setPesoMaximo(Double pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	public Integer getPisoMaximo() {
		return pisoMaximo;
	}

	public void setPisoMaximo(Integer pisoMaximo) {
		this.pisoMaximo = pisoMaximo;
	}

	public Integer getPisoMinimo() {
		return pisoMinimo;
	}

	public void setPisoMinimo(Integer pisoMinimo) {
		this.pisoMinimo = pisoMinimo;
	}

	public Integer getPisoActual() {
		return pisoActual;
	}
	
	public Integer getCantidadPersonasIngresadas() {
		return cantidadPersonasIngresadas;
	}

	public Double getPesoTotalDePersonasIngresadas() {
		return pesoTotalDePersonasIngresadas;
	}

	public void irAPiso(Integer pisoDestino) {
		if(this.puertaCerrada == true && pisoDestino >= this.pisoMinimo && pisoDestino <= this.pisoMaximo) {
			this.pisoActual = pisoDestino;
		}
	}

	public void cerrarPuerta() {
		if(this.puertaCerrada == false) {
			this.puertaCerrada = true;
		}
	}

	public void abrirPuerta() {
		if(this.puertaCerrada == true) {
			this.puertaCerrada = false;
		}
		
	}

	public void ingresarPersona(Persona persona1) {
		Double pesoTotalProvisorio = this.pesoTotalDePersonasIngresadas + persona1.getPesoPersona();
		if(this.cantidadPersonasIngresadas < this.cantidadPersonasMaxima && pesoTotalProvisorio <= this.pesoMaximo ) {
			this.cantidadPersonasIngresadas ++;
			this.pesoTotalDePersonasIngresadas = pesoTotalProvisorio;
		}
	}
	
}
