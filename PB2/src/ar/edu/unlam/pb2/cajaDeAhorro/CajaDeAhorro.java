package ar.edu.unlam.pb2.cajaDeAhorro;

import ar.edu.unlam.pb2.cuenta.Cuenta;

public class CajaDeAhorro extends Cuenta {
	
	private Integer contadorDeExtracciones = 0;
	private final Double COSTOADICIONAL = 6.0;

	public CajaDeAhorro(Double saldo) {
		super(saldo);
	}
	
	@Override
	public void retirarSaldo(Double saldoARetirar) {
		Double saldoActualEnLaCuenta = this.getSaldo();
		if(saldoARetirar <= saldoActualEnLaCuenta && this.contadorDeExtracciones < 5) {
			super.retirarSaldo(saldoARetirar);
			contadorDeExtracciones++;
		}else {
			if(saldoARetirar <= saldoActualEnLaCuenta && this.contadorDeExtracciones >= 5) {
				Double saldoADescontar = saldoARetirar + COSTOADICIONAL;
				super.retirarSaldo(saldoADescontar);
				contadorDeExtracciones++;
			}
		}
	}
	
	

	
}
