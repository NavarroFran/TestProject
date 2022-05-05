package ar.edu.unlam.pb2.cuenta;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unlam.pb2.Transaccion.Transaccion;

public class Cuenta {
	
	private Double saldo;
	private final String RETIROSALDO = "Se retiro dinero";
	private final String DEPOSITOSALDO = "Se deposito dinero";
	private ArrayList<Transaccion> registroDeTransacciones = new ArrayList<Transaccion>();
	private LocalDate fecha = LocalDate.now();


	public Cuenta(Double saldo) {
		this.saldo = saldo;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void retirarSaldo(Double saldoARetirar) {
		this.saldo -= saldoARetirar;
		Transaccion registro = new Transaccion(saldoARetirar, RETIROSALDO, fecha);
		registroDeTransacciones.add(registro);
	}

	public void depositarSaldo(double saldoADepositar) {
		this.saldo += saldoADepositar;
		Transaccion registro = new Transaccion(saldoADepositar,DEPOSITOSALDO, fecha);
		registroDeTransacciones.add(registro);
	}
	
	public Integer obtenerCantidadDeTransacciones() {
		return this.registroDeTransacciones.size();
	}
	
	public String obtenerMotivoDeLaTransaccion(int i) {
		return this.registroDeTransacciones.get(i).getMotivoDeTransaccion();
	}
	
	public Double obtenerSaldoDeLaTransaccion(int i) {
		return this.registroDeTransacciones.get(i).getSaldoDeLaTransaccion();
	}
	
	public LocalDate obtenerFechaDeLaTransaccion(int i) {
		return this.registroDeTransacciones.get(i).getFecha();
	}


}
