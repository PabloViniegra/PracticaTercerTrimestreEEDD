package vista;


import java.util.InputMismatchException;
import java.util.Scanner;
import controlador.GestorBBDD;
import modelo.Cancion;
import modelo.Cancion.Genero;

public class Formulario {
	
	public void menu() {
		Scanner sc = new Scanner(System.in);
		int aux =0;
		GestorBBDD migestor = new GestorBBDD();
		do {
			System.out.println("_____MENÚ_____");
			System.out.println("1. Insertar canción");
			System.out.println("2. Modificar canción");
			System.out.println("3. Borrar canción");
			System.out.println("4. Ver Biblioteca");
			System.out.println("5. Salir");
			System.out.println("_____________");
			System.out.print("Introduce una opcion: ");
			boolean check = false;
			while (!check) {
				try {
					aux = sc.nextInt();
					check = true;
				} catch (InputMismatchException e) {
					System.out.println("Introduce un número por favor.");
					aux = sc.nextInt();
				} finally {
					sc.nextLine();
				}
			}
			
			switch (aux) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				System.out.println("¡Hasta pronto!");
				break;
			default:
				System.out.println("Opción incorrecta");
			}
			
		} while (aux != 5);
	}
	
	public Cancion insertarCancionBBDD () {
		Scanner sc = new Scanner(System.in);
		GestorBBDD gestor = new GestorBBDD();
		Cancion micancion = new Cancion();
		System.out.print("Dime el nombre de la canción: ");
		micancion.setNombreCancion(sc.nextLine());
		System.out.print("¿Cuánto dura?");
		micancion.setDuracion(sc.nextInt());
		sc.nextLine();
		System.out.print("Cuál es su género? (ROCK,FOLK,POP,REGGAETON,ELECTRÓNICA,JAZZ,METAL,BLUES,FUNK,ALTERNATIVO,CLASICA,AMBIENTE):");
		String respuesta = sc.nextLine();
		if (respuesta.equalsIgnoreCase(Genero.ROCK.toString())) {
			micancion.setGenero(Genero.ROCK);
		} else if (respuesta.equalsIgnoreCase(Genero.FOLK.toString())) {
			micancion.setGenero(Genero.FOLK);
		} else if (respuesta.equalsIgnoreCase(Genero.POP.toString())) {
			micancion.setGenero(Genero.POP);
		} else if (respuesta.equalsIgnoreCase(Genero.REGGAETON.toString())) {
			micancion.setGenero(Genero.REGGAETON);
		} else if (respuesta.equalsIgnoreCase(Genero.ELECTRÓNICA.toString())) {
			micancion.setGenero(Genero.ELECTRÓNICA);
		} else if (respuesta.equalsIgnoreCase(Genero.JAZZ.toString())) {
			micancion.setGenero(Genero.JAZZ);
		} else if (respuesta.equalsIgnoreCase(Genero.METAL.toString())) {
			micancion.setGenero(Genero.METAL);
		} else if (respuesta.equalsIgnoreCase(Genero.FOLK.toString())) {
			micancion.setGenero(Genero.FOLK);
		} else if (respuesta.equalsIgnoreCase(Genero.BLUES.toString())) {
			micancion.setGenero(Genero.BLUES);
		} else if (respuesta.equalsIgnoreCase(Genero.FUNK.toString())) {
			micancion.setGenero(Genero.FUNK);
		} else if (respuesta.equalsIgnoreCase(Genero.ALTERNATIVO.toString())) {
			micancion.setGenero(Genero.ALTERNATIVO);
		} else if (respuesta.equalsIgnoreCase(Genero.CLASICA.toString())) {
			micancion.setGenero(Genero.CLASICA);
		} else if (respuesta.equalsIgnoreCase(Genero.AMBIENTE.toString())) {
			micancion.setGenero(Genero.AMBIENTE);
		} else {
			System.out.println("No se ha encontrado el género, por favor revise los géneros que se pueden introducir.");
		}
		System.out.print("Dime el artista: ");
		String artista = sc.nextLine();
		micancion.setIdArtista(gestor.conseguirArtista(artista));
		//TODO: hacer lo mismo con los discos que con los artistas.
		System.out.print("Dime el disco al que pertenece la canción: ");
		String disco = sc.nextLine();
		
		return micancion;
	}
}
