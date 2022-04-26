package ar.edu.unlam.pb2.montaCargas;

import java.util.ArrayList;

import ar.edu.unlam.pb2.cargas.carga;

public class montaCarga {

	private Double pesoMaximo;
	private ArrayList<carga> cargas = new ArrayList<carga>();
	private ArrayList<carga> cargasSubidas = new ArrayList<carga>();
	private ArrayList<carga> cargasEnElPiso = new ArrayList<carga>();

	public montaCarga(Double pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	public Double getPesoMaximo() {
		return pesoMaximo;
	}

	public boolean cargarCarga(carga carga1) {
		Double pesoYaCargado = 0.0;
		for (carga carga : this.cargas) {
			pesoYaCargado += carga.getPeso();}
			Double pesoCargadoProvisorio = pesoYaCargado + carga1.getPeso();
		
		if(pesoCargadoProvisorio < this.pesoMaximo ) {
			return cargas.add(carga1);
		}
		else return false;
	}

	public Integer obtenerCantidadDeCargas() {
		return this.cargas.size();
	}

	public Double obtenerPesoCargado() {
		Double pesoCargado = 0.0;
		/*Una forma de hacerlo es:
		 for(int i = 0; i < this.cargas.size(); i++){
		  	pesoCargado += this.cargas.get(i).getPeso();} */
		//La otra forma de recorrer el Arraylist es con el foreach (escribo for y ctrl+espacio)
		for (carga carga : this.cargas) {
			pesoCargado += carga.getPeso();
		}
		return pesoCargado;
	}

	public boolean subirCarga(carga carga1) {
		cargas.remove(carga1);
		return cargasSubidas.add(carga1);
	}

	public Integer obtenerCantidadDeCargasSubidas() {
		return this.cargasSubidas.size();
	}

	public Double obtenerPesoSubido() {
		Double pesoSubido = 0.0;
		for (carga carga : this.cargasSubidas) {
			pesoSubido += carga.getPeso();
		}
		return pesoSubido;
	}

	public boolean bajarTodasLasCargas() {
		
		boolean bajo = false;
		/*Double pesoYaCargado = 0.0;
		for (int i = 0 ; i<cargasSubidas.size();i++){
			for (carga carga : this.cargasSubidas) {
				pesoYaCargado += carga.getPeso();}
				Double pesoCargadoProvisorio = pesoYaCargado + this.cargasSubidas.get(i).getPeso();
			if(pesoCargadoProvisorio < this.pesoMaximo ) {
				 bajo = cargas.add(cargasSubidas.get(i)) ;
			}; 
		}*/
		for (int i = 0 ; i<cargasSubidas.size();i++){
		    bajo = cargas.add(cargasSubidas.get(i)) ;
		}
		cargasSubidas.removeAll(cargas);
		
		return bajo;
	}

	public boolean subirTodasLasCargas() {
		boolean subio = false;
		for (int i = 0 ; i<cargas.size();i++){
		    subio = cargasSubidas.add(cargas.get(i)) ;
		}
		cargas.removeAll(cargas);
		return subio;
	}

}
