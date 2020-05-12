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
			System.out.println("_____MEN�_____");
			System.out.println("1. Insertar canci�n");
			System.out.println("2. Modificar canci�n");
			System.out.println("3. Borrar canci�n");
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
					System.out.println("Introduce un n�mero por favor.");
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
				System.out.println("�Hasta pronto!");
				break;
			default:
				System.out.println("Opci�n incorrecta");
			}
			
		} while (aux != 5);
	}
	
	public Cancion insertarCancionBBDD () {
		Scanner sc = new Scanner(System.in);
		GestorBBDD gestor = new GestorBBDD();
		Cancion micancion = new Cancion();
		System.out.print("Dime el nombre de la canci�n: ");
		micancion.setNombreCancion(sc.nextLine());
		System.out.print("�Cu�nto dura?");
		micancion.setDuracion(sc.nextInt());
		sc.nextLine();
		System.out.print("Cu�l es su g�nero? (ROCK,FOLK,POP,REGGAETON,ELECTR�NICA,JAZZ,METAL,BLUES,FUNK,ALTERNATIVO,CLASICA,AMBIENTE):");
		String respuesta = sc.nextLine();
		if (respuesta.equalsIgnoreCase(Genero.ROCK.toString())) {
			micancion.setGenero(Genero.ROCK);
		} else if (respuesta.equalsIgnoreCase(Genero.FOLK.toString())) {
			micancion.setGenero(Genero.FOLK);
		} else if (respuesta.equalsIgnoreCase(Genero.POP.toString())) {
			micancion.setGenero(Genero.POP);
		} else if (respuesta.equalsIgnoreCase(Genero.REGGAETON.toString())) {
			micancion.setGenero(Genero.REGGAETON);
		} else if (respuesta.equalsIgnoreCase(Genero.ELECTR�NICA.toString())) {
			micancion.setGenero(Genero.ELECTR�NICA);
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
			System.out.println("No se ha encontrado el g�nero, por favor revise los g�neros que se pueden introducir.");
		}
		System.out.print("Dime el artista: ");
		String artista = sc.nextLine();
		micancion.setIdArtista(gestor.conseguirArtista(artista));
		//TODO: hacer lo mismo con los discos que con los artistas.
		System.out.print("Dime el disco al que pertenece la canci�n: ");
		String disco = sc.nextLine();
		
		return micancion;
	}
}
