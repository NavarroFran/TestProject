package ar.edu.unlam.pb2.Transaccion;

import java.time.LocalDate;

public class Transaccion {

	private Double saldoDeLaTransaccion;
	private String motivoDeTransaccion;
	private LocalDate fecha;

	public Transaccion(Double saldoDeLaTransaccion, String motivoDeTransaccion, LocalDate fecha) {
		this.saldoDeLaTransaccion = saldoDeLaTransaccion;
		this.motivoDeTransaccion = motivoDeTransaccion;
		this.fecha = fecha;
	}

	public Double getSaldoDeLaTransaccion() {
		return saldoDeLaTransaccion;
	}

	public String getMotivoDeTransaccion() {
		return motivoDeTransaccion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

}
