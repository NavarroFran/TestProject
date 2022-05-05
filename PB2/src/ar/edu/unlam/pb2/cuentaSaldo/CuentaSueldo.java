package ar.edu.unlam.pb2.cuentaSaldo;


import ar.edu.unlam.pb2.cuenta.Cuenta;

public class CuentaSueldo extends Cuenta {

	public CuentaSueldo(Double saldo) {
		super(saldo);
	}
	
	@Override
	public void retirarSaldo(Double saldoARetirar) {
		if(saldoARetirar <= super.getSaldo() ) {
			super.retirarSaldo(saldoARetirar);;
		}
	}

	

}



