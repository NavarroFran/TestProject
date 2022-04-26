package ar.edu.unlam.pb2.testMontaCargas;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.cargas.carga;
import ar.edu.unlam.pb2.montaCargas.montaCarga;

public class testMontaCargas {

	@Test
	public void queSePuedaCrearUnaCargaConPeso() {
		Double peso = 120.0;
		
		carga carga1 = new carga(peso);
		
		Double vo = carga1.getPeso();
		
		assertEquals(vo, peso, 0.01);
		
	}

	@Test
	public void queSePuedaCrearUnMontaCargaConPesoMaximo() {
		Double pesoMaximo = 300.0;
		
		montaCarga miMontaCarga = new montaCarga(pesoMaximo);
		
		assertNotNull(miMontaCarga);
	}
	
	@Test
	public void queSePuedaAgregarUnaCargaAlMontaCarga() {
		Double peso1 = 15.0;
		Double peso2 = 10.0;
		carga carga1 = new carga(peso1);
		carga carga2 = new carga(peso2);
		
		Double pesoMaximo = 300.0;
		montaCarga miMontaCarga = new montaCarga(pesoMaximo);
		
		boolean agrego = miMontaCarga.cargarCarga(carga1);
		assertTrue(agrego);
		
		miMontaCarga.cargarCarga(carga2);
		Integer cantidadCargasEsperadas = 2;
		Integer cantidadCargasObtenidas = miMontaCarga.obtenerCantidadDeCargas();
		assertEquals (cantidadCargasEsperadas,cantidadCargasObtenidas );
		
		Double ve = 25.0;
		Double vo = miMontaCarga.obtenerPesoCargado();
		assertEquals (ve,vo,0.01);
	}
	
	@Test
	public void queLasCargasAgregadasNoSuperenElPesoMaximoDelMontaCarga() {
		Double peso1 = 150.0;
		Double peso2 = 10.0;
		Double peso3 = 200.0;
		carga carga1 = new carga(peso1);
		carga carga2 = new carga(peso2);
		carga carga3 = new carga(peso3);
		
		Double pesoMaximo = 300.0;
		montaCarga miMontaCarga = new montaCarga(pesoMaximo);
		
		miMontaCarga.cargarCarga(carga1);
		miMontaCarga.cargarCarga(carga2);
		miMontaCarga.cargarCarga(carga3);
		
		Integer cantidadCargasEsperadas = 2;
		Integer cantidadCargasObtenidas = miMontaCarga.obtenerCantidadDeCargas();
		assertEquals (cantidadCargasEsperadas,cantidadCargasObtenidas );
	}
	
	@Test
	public void queUnMontaCargaPuedaSubirCargas() {
		Double peso1 = 15.0;
		carga carga1 = new carga(peso1);

		Double pesoMaximo = 300.0;
		montaCarga miMontaCarga = new montaCarga(pesoMaximo);
		
		miMontaCarga.cargarCarga(carga1);
		
		boolean subio = miMontaCarga.subirCarga(carga1);
		assertTrue(subio);
		
		Integer cantidadCargasEsperadas = 0;
		Integer cantidadCargasObtenidas = miMontaCarga.obtenerCantidadDeCargas();
		assertEquals (cantidadCargasEsperadas,cantidadCargasObtenidas );
		
		Double peso2 = 10.0;
		Double peso3 = 20.0;
		carga carga2 = new carga(peso2);
		carga carga3 = new carga(peso3);
		miMontaCarga.cargarCarga(carga2);
		miMontaCarga.cargarCarga(carga3);
		
		boolean subioTodas = miMontaCarga.subirTodasLasCargas();
		assertTrue(subioTodas);
		
		Integer cargasEsperadas = 3;
		Integer cantidadObtenidas = miMontaCarga.obtenerCantidadDeCargasSubidas();
		assertEquals (cargasEsperadas,cantidadObtenidas );
		
		Integer ve = 0;
		Integer vo = miMontaCarga.obtenerCantidadDeCargas();
		assertEquals (ve,vo );
	}
	
	@Test 
	public void queUnMontaCargaRegistreCuantoSubio() {
		Double peso1 = 150.0;
		Double peso2 = 10.0;
		Double peso3 = 20.0;
		carga carga1 = new carga(peso1);
		carga carga2 = new carga(peso2);
		carga carga3 = new carga(peso3);
		
		Double pesoMaximo = 300.0;
		montaCarga miMontaCarga = new montaCarga(pesoMaximo);
		
		miMontaCarga.cargarCarga(carga1);
		miMontaCarga.cargarCarga(carga2);
		miMontaCarga.cargarCarga(carga3);
		
		miMontaCarga.subirCarga(carga1);
		miMontaCarga.subirCarga(carga2);
		miMontaCarga.subirCarga(carga3);
		
		Integer cantidadDeCargasSubidasEsperadas = 3;
		Integer cantidadDeCargasSubidasObtenidas = miMontaCarga.obtenerCantidadDeCargasSubidas();
		assertEquals(cantidadDeCargasSubidasEsperadas, cantidadDeCargasSubidasObtenidas);
		
		Double cantidadDePesoSubidoEsperado = 180.0;
		Double cantidadDePesoSubidoObtenido = miMontaCarga.obtenerPesoSubido();
		assertEquals(cantidadDePesoSubidoEsperado, cantidadDePesoSubidoObtenido, 0.01);
		
	}
	
	@Test
	public void queBajeTodasLasCargasQueSubio() {
		Double peso1 = 150.0;
		Double peso2 = 10.0;
		Double peso3 = 20.0;
		carga carga1 = new carga(peso1);
		carga carga2 = new carga(peso2);
		carga carga3 = new carga(peso3);
		
		Double pesoMaximo = 300.0;
		montaCarga miMontaCarga = new montaCarga(pesoMaximo);
		
		miMontaCarga.cargarCarga(carga1);
		miMontaCarga.cargarCarga(carga2);
		miMontaCarga.cargarCarga(carga3);
		
		miMontaCarga.subirCarga(carga1);
		miMontaCarga.subirCarga(carga2);
		miMontaCarga.subirCarga(carga3);
		
		Integer cantidadDeCargasSubidasEsperadas = 3;
		Integer cantidadDeCargasSubidasObtenidas = miMontaCarga.obtenerCantidadDeCargasSubidas();
		assertEquals(cantidadDeCargasSubidasEsperadas, cantidadDeCargasSubidasObtenidas);
		
		boolean bajo = miMontaCarga.bajarTodasLasCargas();
		assertTrue(bajo);
		
		Integer cantidadDeCargasSubidasEsperadasDespuesDeBajar = 0;
		Integer cantidadDeCargasSubidasObtenidasDespuesDeBajar = miMontaCarga.obtenerCantidadDeCargasSubidas();
		assertEquals(cantidadDeCargasSubidasEsperadasDespuesDeBajar, cantidadDeCargasSubidasObtenidasDespuesDeBajar);
		
	}
}
