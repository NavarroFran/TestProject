package ar.edu.unlam.pb2.testAscensor;
import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.ascensor.Ascensor;
import ar.edu.unlam.pb2.persona.Persona;

public class TestAscensor {

	@Test
	public void sePuedeCrearUnAscensor() {
		Double pesoMaximo = 200.0;
		Integer cantidadPersonasMaxima = 3;
		
		Ascensor a = new Ascensor (cantidadPersonasMaxima, pesoMaximo);
		
		assertNotNull(a);

	}
	
	@Test
	public void sePuedeCrearUnAscensorConPisoMaximoYPisoMinimo() {
		Double pesoMaximo = 200.0;
		Integer cantidadPersonasMaxima = 3;
		Integer pisoMaximo = 10;
		Integer pisoMinimo = 0;
		
		Ascensor miAscensor = new Ascensor (pesoMaximo, cantidadPersonasMaxima, pisoMaximo, pisoMinimo);
		
		assertNotNull(miAscensor);
		
	}
	
	@Test
	public void queUnAscensorVayaAUnPiso() {
		Double pesoMaximo = 200.0;
		Integer cantidadPersonasMaxima = 3;
		Integer pisoMaximo = 10;
		Integer pisoMinimo = 0;
		
		Ascensor miAscensor = new Ascensor (pesoMaximo, cantidadPersonasMaxima, pisoMaximo, pisoMinimo);
		
		Integer pisoDestino = 3;
		
		miAscensor.irAPiso(pisoDestino);
		
		Integer ve = pisoDestino;
		Integer vo = miAscensor.getPisoActual();
		
		assertEquals(ve, vo);
	}
	
	
	@Test
	public void queCuandoElPisoDeseadoSupereAlPisoMaximoElAscensorNoSeMueva() {
		Double pesoMaximo = 200.0;
		Integer cantidadPersonasMaxima = 3;
		Integer pisoMaximo = 10;
		Integer pisoMinimo = 0;
		
		Ascensor miAscensor = new Ascensor (pesoMaximo, cantidadPersonasMaxima, pisoMaximo, pisoMinimo);
		
		Integer pisoDestino = 11;
		
		miAscensor.irAPiso(pisoDestino);
		
		Integer ve = 0;
		Integer vo = miAscensor.getPisoActual();
		
		assertEquals(ve, vo);
	}
	
	@Test
	public void queCuandoElPisoDeseadoSeaMenorAlPisoMinimoElAscensorNoSeMueva() {
		Double pesoMaximo = 200.0;
		Integer cantidadPersonasMaxima = 3;
		Integer pisoMaximo = 10;
		Integer pisoMinimo = 0;
		
		Ascensor miAscensor = new Ascensor (pesoMaximo, cantidadPersonasMaxima, pisoMaximo, pisoMinimo);
		
		Integer pisoDestino = -3;
		
		miAscensor.irAPiso(pisoDestino);
		
		Integer ve = 0;
		Integer vo = miAscensor.getPisoActual();
		
		assertEquals(ve, vo);
	}
	
	@Test
	public void queUnAscensorPuedaCerrarUnaPuerta() {
		Double pesoMaximo = 200.0;
		Integer cantidadPersonasMaxima = 3;
		Integer pisoMaximo = 10;
		Integer pisoMinimo = 0;
		
		Ascensor miAscensor = new Ascensor (pesoMaximo, cantidadPersonasMaxima, pisoMaximo, pisoMinimo);
		
		miAscensor.cerrarPuerta();
		
		assertTrue(miAscensor.isPuertaCerrada());
		
	}
	
	@Test
	public void queUnAscensorPuedaAbrirUnaPuerta() {
		Double pesoMaximo = 200.0;
		Integer cantidadPersonasMaxima = 3;
		Integer pisoMaximo = 10;
		Integer pisoMinimo = 0;
		
		Ascensor miAscensor = new Ascensor (pesoMaximo, cantidadPersonasMaxima, pisoMaximo, pisoMinimo);
		
		miAscensor.abrirPuerta();
		
		assertFalse(miAscensor.isPuertaCerrada());
		
	}
	
	@Test
	public void queCuandoQuieraIrAUnPisoTieneQueEstarLaPuertaCerrada() {
		Double pesoMaximo = 200.0;
		Integer cantidadPersonasMaxima = 3;
		Integer pisoMaximo = 10;
		Integer pisoMinimo = 0;
		
		Ascensor miAscensor = new Ascensor (pesoMaximo, cantidadPersonasMaxima, pisoMaximo, pisoMinimo);
		
		miAscensor.cerrarPuerta();
		
		Integer pisoDestino = 3;
		
		miAscensor.irAPiso(pisoDestino);
		
		Integer ve = 3;
		Integer vo = miAscensor.getPisoActual();
		
		assertEquals(ve, vo);
	}
	
	@Test
	public void queCuandoEsteLaPuertaAbiertaElAscensorNoSeMueva() {
		Double pesoMaximo = 200.0;
		Integer cantidadPersonasMaxima = 3;
		Integer pisoMaximo = 10;
		Integer pisoMinimo = 0;
		
		Ascensor miAscensor = new Ascensor (pesoMaximo, cantidadPersonasMaxima, pisoMaximo, pisoMinimo);
		
		miAscensor.abrirPuerta();
		
		Integer pisoDestino = 3;
		
		miAscensor.irAPiso(pisoDestino);
		
		Integer ve = 0;
		Integer vo = miAscensor.getPisoActual();
		
		assertEquals(ve, vo);
	}
	
	@Test
	public void queAlAscensorPuedanEntrarPersonas() {
		Double pesoMaximo = 200.0;
		Integer cantidadPersonasMaxima = 3;
		Integer pisoMaximo = 10;
		Integer pisoMinimo = 0;
		
		Ascensor miAscensor = new Ascensor (pesoMaximo, cantidadPersonasMaxima, pisoMaximo, pisoMinimo);
		
		Double pesoPersona = 50.0;
		
		
		Persona persona1 = new Persona (pesoPersona);
		
		miAscensor.ingresarPersona(persona1);
		miAscensor.ingresarPersona(persona1);
		
		
		Integer ve = 2;
		Integer vo = miAscensor.getCantidadPersonasIngresadas();
		
		assertEquals(ve, vo);
	}
	
	@Test
	public void queAlAscensorNoPuedanEntrarMasPersonasQueElMaximo() {
		Double pesoMaximo = 200.0;
		Integer cantidadPersonasMaxima = 3;
		Integer pisoMaximo = 10;
		Integer pisoMinimo = 0;
		
		Ascensor miAscensor = new Ascensor (pesoMaximo, cantidadPersonasMaxima, pisoMaximo, pisoMinimo);
		
		Double pesoPersona = 50.0;
		
		
		Persona persona1 = new Persona (pesoPersona);
		
		miAscensor.ingresarPersona(persona1);
		miAscensor.ingresarPersona(persona1);
		miAscensor.ingresarPersona(persona1);
		miAscensor.ingresarPersona(persona1);
		miAscensor.ingresarPersona(persona1);
		
		Integer ve = 3;
		Integer vo = miAscensor.getCantidadPersonasIngresadas();
		
		assertEquals(ve, vo);
	}
	
	@Test
	public void queElPesoDeLasPersonasIngresadasNoSupereElPesoMaximo() {
		Double pesoMaximo = 200.0;
		Integer cantidadPersonasMaxima = 3;
		Integer pisoMaximo = 10;
		Integer pisoMinimo = 0;
		
		Ascensor miAscensor = new Ascensor (pesoMaximo, cantidadPersonasMaxima, pisoMaximo, pisoMinimo);
		
		Double pesoPersona = 100.0;
		
		Persona persona1 = new Persona (pesoPersona);
		
		miAscensor.ingresarPersona(persona1);
		miAscensor.ingresarPersona(persona1);
		miAscensor.ingresarPersona(persona1);
		
		Integer ve = 2;
		Integer vo = miAscensor.getCantidadPersonasIngresadas();
		
		Double valorPesoEsperado = 200.0;
		Double valorPesoObtenido = miAscensor.getPesoTotalDePersonasIngresadas();
		assertEquals(valorPesoEsperado, valorPesoObtenido);
		
		assertEquals(ve, vo);
	}
	
	
}
