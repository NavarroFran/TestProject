package ar.edu.unlam.pb2.CuentaCorriente;

import ar.edu.unlam.pb2.cuenta.Cuenta;

public class CuentaCorriente extends Cuenta{

	private Double limiteAdicional;
	private final Double PORCENTAJEADICIONAL = 0.05;

	public CuentaCorriente(Double saldo, Double limiteAdicional) {
		super(saldo);
		this.limiteAdicional = limiteAdicional;
	}
	
	
	@Override
	public void retirarSaldo(Double saldoARetirar) {
		Double saldoTotalDeLaCuenta = super.getSaldo() + this.limiteAdicional;
		if(saldoARetirar <=  super.getSaldo() ) {
			super.retirarSaldo(saldoARetirar);
		}else {
			if(saldoARetirar >  super.getSaldo() && saldoARetirar <= saldoTotalDeLaCuenta ) {
				Double importeExtra = (saldoARetirar - super.getSaldo()) * PORCENTAJEADICIONAL;
				Double saldoADescontar = saldoARetirar + importeExtra;
				super.retirarSaldo(saldoADescontar);
			}
		}
	}
}
