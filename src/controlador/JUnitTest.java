package controlador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitTest {
	//Test bueno
	@Test
	public void idArtistaAPartirDelNombre() {
		GestorBBDD gestor = new GestorBBDD();
		String a="Metallica";
		int resultado = gestor.conseguirArtista(a);
		assertEquals(8, resultado);
		System.out.println(resultado);
	}
	//Test bueno
	@Test
	public void idDiscoAPartirDelNombre() {
		GestorBBDD gestor = new GestorBBDD();
		String d="Master of Puppets";
		int resultado = gestor.conseguirDisco(d);
		assertEquals(4, resultado);
		System.out.println(resultado);
	}
	//Test bueno
		@Test
		public void e() {
			GestorBBDD gestor = new GestorBBDD();
			String a="Metallica";
			String d="Master of Puppets";
			int resultadoA= gestor.conseguirArtista(a);
			int resultadoD = gestor.conseguirDisco(d);
			int resultado = resultadoA+resultadoD;
			assertEquals(12, resultado);
			System.out.println(resultado);
		}
		
		
	
	
	

}
