package controlador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Ésta clase la utilizamos para realizar pruebas y comparar con los valores
 * esperados a partir de un parámetro de entrada, en los dos primeros obtenemos
 * el resultado esperado, en el tercero forzamos el fallo
 * 
 * @author Jónatan,Pablo,Clara
 *
 */
class JUnitTest {
	// Test bueno
	@Test
	public void idArtistaAPartirDelNombre() {
		GestorBBDD gestor = new GestorBBDD();
		String a = "Metallica";
		int resultado = gestor.conseguirArtista(a);
		assertEquals(8, resultado);
		System.out.println(resultado);
	}

	// Test bueno
	@Test
	public void idDiscoAPartirDelNombre() {
		GestorBBDD gestor = new GestorBBDD();
		String d = "Master of Puppets";
		int resultado = gestor.conseguirDisco(d);
		assertEquals(4, resultado);
		System.out.println(resultado);
	}

	// Test con fallos
	@Test
	public void e() {
		GestorBBDD gestor = new GestorBBDD();
		String a = "Metallica";
		String d = "Master of Puppets";
		int resultadoA = gestor.conseguirArtista(a);
		int resultadoD = gestor.conseguirDisco(d);
		int resultado = resultadoA + resultadoD;
		assertEquals(11, resultado);
		System.out.println(resultado);
	}

}
