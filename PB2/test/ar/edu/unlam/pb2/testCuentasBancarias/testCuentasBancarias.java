package ar.edu.unlam.pb2.testCuentasBancarias;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import ar.edu.unlam.pb2.CuentaCorriente.CuentaCorriente;
import ar.edu.unlam.pb2.cajaDeAhorro.CajaDeAhorro;
import ar.edu.unlam.pb2.cuenta.Cuenta;
import ar.edu.unlam.pb2.cuentaSaldo.CuentaSueldo;

public class testCuentasBancarias {

	@Test
	public void queSePuedaCrearUnaCuenta() {
		Double saldo = 2000.0;
		
		Cuenta miCuenta = new Cuenta(saldo);
		
		assertNotNull(miCuenta);
		
		miCuenta.depositarSaldo(200.0);
		
		Double ve = 2200.0;
		Double vo = miCuenta.getSaldo();
		
		assertEquals(ve, vo);
	}
	
	@Test
	public void queSePuedaCrearUnaCuentaSueldo() {
		Double saldo = 2000.0;
		
		CuentaSueldo miCuenta = new CuentaSueldo(saldo);
		
		assertNotNull(miCuenta);
		
		Double saldoARetirar = 200.0;
		miCuenta.retirarSaldo(saldoARetirar);
		
		Double ve = saldo - saldoARetirar;
		Double vo = miCuenta.getSaldo();
		
		assertEquals (ve, vo);
		
	}
	
	
	@Test
	public void queNoSePuedaRetirarMasDineroDelQueSeTieneEnLaCuentaSaldo() {
		Double saldo = 2000.0;
		
		CuentaSueldo miCuenta = new CuentaSueldo(saldo);
		
		Double saldoARetirarExcedente = 200000.0;
		miCuenta.retirarSaldo(saldoARetirarExcedente);
		
		Double valorEsperado = saldo;
		Double valorObtenido =  miCuenta.getSaldo();
		
		assertEquals (valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaCrearUnaCajaDeAhorrosQueLuegoDeLaQuintaExtraccionCobre6PesosExtra() {
		Double saldo = 200.0;
		
		CajaDeAhorro miCajaDeAhorro = new CajaDeAhorro(saldo);
		
		assertNotNull(miCajaDeAhorro);
		
		Double saldoARetirar = 20.0;
		miCajaDeAhorro.retirarSaldo(saldoARetirar);
		miCajaDeAhorro.retirarSaldo(saldoARetirar);
		miCajaDeAhorro.retirarSaldo(saldoARetirar);
		miCajaDeAhorro.retirarSaldo(saldoARetirar);
		miCajaDeAhorro.retirarSaldo(saldoARetirar);
		miCajaDeAhorro.retirarSaldo(saldoARetirar);
		
		Double ve = 74.0;
		Double vo = miCajaDeAhorro.getSaldo();
		
		assertEquals(ve, vo, 0.1);
		
	}
	
	@Test
	public void queSePuedaCrearUnaCuentaCorrienteQueCobre5PorCientoDelExcedente(){
		Double saldo = 100.0;
		Double limiteAdicional = 150.0;
		CuentaCorriente miCuenta = new CuentaCorriente(saldo, limiteAdicional);
		
		assertNotNull(miCuenta);
		
		Double saldoARetirar = 200.0;
		miCuenta.retirarSaldo(saldoARetirar);
		
		Double valorEsperado = -105.0;
		Double valorObtenido = miCuenta.getSaldo();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	
	@Test
	public void queSePuedanRegistrarLasTransacciones() {
		Double saldo = 100.0;
		CuentaSueldo miCuenta = new CuentaSueldo(saldo);
		
		Double saldoARetirar = 10.0;
		miCuenta.retirarSaldo(saldoARetirar);
		
		Double saldoADepositar = 1000.0;
		miCuenta.depositarSaldo(saldoADepositar);
		
		Integer ve = 2;
		Integer vo = miCuenta.obtenerCantidadDeTransacciones();
		
		assertEquals (ve,vo);
		
		String textoEsperado = "Se retiro dinero";
		String textoObtenido = miCuenta.obtenerMotivoDeLaTransaccion(0);
		
		assertEquals(textoObtenido, textoEsperado);
		
		Double valorEsperadoDeSaldoDepositado = saldoADepositar;
		Double valorObtenidoDeSaldoDepositado = miCuenta.obtenerSaldoDeLaTransaccion(1);
		
		assertEquals(valorEsperadoDeSaldoDepositado,valorObtenidoDeSaldoDepositado );
		
		LocalDate fe = LocalDate.now();
		LocalDate fo = miCuenta.obtenerFechaDeLaTransaccion(0);
		
		assertEquals (fe, fo);
	}
	
	@Test
	public void queSePuedaRegistrarEnUnaCuentaCorriente(){
		Double saldo = 100.0;
		Double limiteAdicional = 150.0;
		CuentaCorriente miCuenta = new CuentaCorriente(saldo, limiteAdicional);
		
		assertNotNull(miCuenta);
		
		Double saldoARetirar = 200.0;
		miCuenta.retirarSaldo(saldoARetirar);
		
		String textoEsperado = "Se retiro dinero";
		String textoObtenido = miCuenta.obtenerMotivoDeLaTransaccion(0);
		
		assertEquals(textoObtenido, textoEsperado);
		
		Double valorEsperadoDeSaldoRetirado = saldoARetirar + 5.0;
		Double valorObtenidoDeSaldoRetirado = miCuenta.obtenerSaldoDeLaTransaccion(0);
		
		assertEquals(valorEsperadoDeSaldoRetirado,valorObtenidoDeSaldoRetirado);
		
		LocalDate fe = LocalDate.now();
		LocalDate fo = miCuenta.obtenerFechaDeLaTransaccion(0);
		
		assertEquals (fe, fo);
	}
	
}
