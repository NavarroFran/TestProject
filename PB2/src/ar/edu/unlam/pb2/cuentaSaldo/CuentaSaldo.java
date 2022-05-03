package ar.edu.unlam.pb2.cuentaSaldo;

public class CuentaSaldo {

	private Double saldo;
	

	public CuentaSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void retirarSaldo(Double saldoARetirar) {
		if(saldoARetirar <= this.saldo ) {
			this.saldo -= saldoARetirar;
		}
	}
}



