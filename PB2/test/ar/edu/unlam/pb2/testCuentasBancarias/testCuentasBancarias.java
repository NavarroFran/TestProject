package ar.edu.unlam.pb2.testCuentasBancarias;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.cajaDeAhorro.CajaDeAhorro;
import ar.edu.unlam.pb2.cuentaSaldo.CuentaSaldo;

public class testCuentasBancarias {

	@Test
	public void queSePuedaCrearUnaCuentaSaldo() {
		Double saldo = 2000.0;
		
		CuentaSaldo miCuentaSaldo = new CuentaSaldo(saldo);
		
		assertNotNull(miCuentaSaldo);
	}
	
	
	@Test
	public void queNoSePuedaRetirarMasDineroDelQueSeTieneEnLaCuentaSaldo() {
		Double saldo = 2000.0;
		
		CuentaSaldo miCuentaSaldo = new CuentaSaldo(saldo);
		
		Double saldoARetirar = 200.0;
		miCuentaSaldo.retirarSaldo(saldoARetirar);
		
		Double ve = saldo - saldoARetirar;
		Double vo = miCuentaSaldo.getSaldo();
		
		assertEquals (ve, vo);
		
		Double saldoARetirarExcedente = 200000.0;
		miCuentaSaldo.retirarSaldo(saldoARetirarExcedente);
		
		Double valorEsperado = saldo - saldoARetirar;
		Double valorObtenido =  miCuentaSaldo.getSaldo();
		
		assertEquals (valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaCrearUnaCajaDeAhorrosQueLuegoDeLaQuintaExtraccionCobre6PesosExtra() {
		Double saldo = 200.0;
		
		CajaDeAhorro miCajaDeAhorro = new CajaDeAhorro(saldo);
		
		assertNotNull(miCajaDeAhorro);
		
		Double saldoARetirar = 20.0;
		miCajaDeAhorro.retirarSaldoConExtra(saldoARetirar);
		miCajaDeAhorro.retirarSaldoConExtra(saldoARetirar);
		miCajaDeAhorro.retirarSaldoConExtra(saldoARetirar);
		miCajaDeAhorro.retirarSaldoConExtra(saldoARetirar);
		miCajaDeAhorro.retirarSaldoConExtra(saldoARetirar);
		miCajaDeAhorro.retirarSaldoConExtra(saldoARetirar);
		
		Double ve = 74.0;
		Double vo = miCajaDeAhorro.getSaldo();
		
		assertEquals(ve, vo, 0.1);
		
	}
	
	
	
}
