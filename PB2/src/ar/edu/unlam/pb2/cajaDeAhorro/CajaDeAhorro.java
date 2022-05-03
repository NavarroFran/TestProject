package ar.edu.unlam.pb2.cajaDeAhorro;

import ar.edu.unlam.pb2.cuentaSaldo.CuentaSaldo;

public class CajaDeAhorro extends CuentaSaldo {
	
	private Integer contadorDeExtracciones = 0;
	private final Double COSTOADICIONAL = 6.0;

	public CajaDeAhorro(Double saldo) {
		super(saldo);
	}

	public void retirarSaldoConExtra(Double saldoARetirar) {
		Double saldoActualEnLaCuenta = this.getSaldo();
		if(saldoARetirar <= saldoActualEnLaCuenta && this.contadorDeExtracciones < 5) {
			this.retirarSaldo(saldoARetirar);
			contadorDeExtracciones++;
		}else {
			if(saldoARetirar <= saldoActualEnLaCuenta && this.contadorDeExtracciones >= 5) {
				Double saldoADescontar = saldoARetirar + COSTOADICIONAL;
				this.retirarSaldo(saldoADescontar);
				contadorDeExtracciones++;
			}
		}
	}
	
	
	public void sacarPlata(Double saldoARetirar) {
		this.retirarSaldo(saldoARetirar);
	}
	
	public Double cuantaPlataTengo() {
		Double saldoActualEnLaCuenta = this.getSaldo();
		return saldoActualEnLaCuenta;
	}
	
	
}
