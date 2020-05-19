package vista;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controlador.GestorBBDD;
import controlador.GestorFicheros;
import modelo.Artista;
import modelo.Cancion;
import modelo.Cancion.Genero;
import modelo.Disco;
import modelo.Interaccion;

public class Formulario {

	public void menu() {
		Scanner sc = new Scanner(System.in);
		int aux = -1;
		ArrayList<Interaccion> miArray = new ArrayList<Interaccion>();
		GestorBBDD migestor = new GestorBBDD();
		GestorFicheros fich = new GestorFicheros();
		Formulario form = new Formulario();
		Cancion cancion = new Cancion();
		Artista artista = new Artista();
		Disco disco = new Disco();
		do {
			System.out.println("_____MEN�_____");
			System.out.println("1. Insertar canci�n");
			System.out.println("2. Insertar artista");
			System.out.println("3. Insertar disco");
			System.out.println("4. Modificar canci�n");
			System.out.println("5. Modificar artista");
			System.out.println("6. Modificar disco");
			System.out.println("7. Borrar canci�n");
			System.out.println("8. Borrar artista");
			System.out.println("9. Borrar disco");
			System.out.println("10. Ver Biblioteca");
			System.out.println("11. Salir");
			System.out.println("_____________");
			System.out.print("Introduce una opcion: ");
			aux = sc.nextInt();

			switch (aux) {
			case 1:
				cancion = form.insertarCancion();
				migestor.insertarCancionBBDD(cancion);
				break;
			case 2:
				artista = form.insertarArtista();
				migestor.insertarArtistaBBDD(artista);
				break;
			case 3:
				disco = form.insertarDiscos();
				migestor.insertarDiscoBBDD(disco);
				break;
			case 4:
				migestor.mostrarCanciones();
				System.out.print("Inserte el nombre de la canci�n a modificar: ");
				String modificarCancion = sc.nextLine();
				cancion = form.modificarCancion(cancion);
				migestor.modificarCancionBBDD(modificarCancion, cancion);
				break;
			case 5:
				migestor.mostrarArtistas();
				System.out.println("Inserte el nombre del artista a modificar:");
				String modificarArtista = sc.nextLine();
				artista = form.modificarArtista(artista);
				migestor.modificarArtista(modificarArtista, artista);
				break;
			case 6:
				migestor.mostrarDiscos();
				System.out.print("Inserte el nombre del disco a modificar: ");
				String modificarDisco = sc.nextLine();
				disco = form.modificarDisco(disco);
				migestor.modificarDisco(modificarDisco, disco);
				break;
			case 7:
				migestor.mostrarCanciones();
				System.out.print("Introduzca el nombre de la cancion que quiere borrar: ");
				String nombreCancion = sc.nextLine();
				migestor.borrarCancionBBDD(nombreCancion);
				break;
			case 8:
				migestor.mostrarArtistas();
				System.out.print("Introduzca el nombre del artista que quiere borrar: ");
				String nombreArtista = sc.nextLine();
				migestor.borrarArtistaBBDD(nombreArtista);
				break;
			case 9:
				migestor.mostrarDiscos();
				System.out.print("Introduzca el nombre del disco que quiera borrar: ");
				String nombreDisco = sc.nextLine();
				migestor.borrarDiscoBBDD(nombreDisco);
				break;
			case 10:
				miArray = migestor.mostrarTodo();
				fich.escribirHTML(miArray);
				break;
			case 11:
				System.out.println("�Hasta pronto!");
			default:
				System.out.println("Opci�n incorrecta!, pulse una tecla para continuar");

				// Como introducimos un integer, salta el primer nextLine para obligar al
				// usuario a leer el mensaje de error y pulsar una tecla
				sc.nextLine();
				sc.nextLine();
				break;
			}

		} while (aux != 11);
	}

	public Cancion insertarCancion() {
		Scanner sc = new Scanner(System.in);
		GestorBBDD gestor = new GestorBBDD();
		Cancion micancion = new Cancion();
		int aux=-1;
		System.out.print("Dime el nombre de la canci�n: ");
		micancion.setNombreCancion(sc.nextLine());
		// TODO asegurarse que el usuario meta un n�mero
		System.out.print("�Cu�nto dura? en segundos");
		micancion.setDuracion(sc.nextInt());
		//sc.nextLine();
		// TODO: Convertir en un Switch, si el usuario no ha elegido bien el g�nero que
		// lo vuelva a pedir.
		System.out.print(
				"Selecciona un g�nero? (1.ROCK,2.FOLK,3.POP,4.REGGAETON,5.ELECTR�NICA,6.JAZZ,7.METAL,8.BLUES,9.FUNK,"
				+ "10.ALTERNATIVO,11.CLASICA,12.AMBIENTE):");
		
		do {
			aux=sc.nextInt();
			switch(aux){
			case 1:
				micancion.setGenero(Genero.ROCK);
				break;
			case 2:
				micancion.setGenero(Genero.FOLK);
				break;
			case 3:
				micancion.setGenero(Genero.POP);
				break;
			case 4:
				micancion.setGenero(Genero.REGGAETON);
				break;
			case 5:
				micancion.setGenero(Genero.ELECTR�NICA);
				break;
			case 6:
				micancion.setGenero(Genero.JAZZ);
				break;
			case 7:
				micancion.setGenero(Genero.METAL);
				break;
			case 8:
				micancion.setGenero(Genero.BLUES);
				break;
			case 9:
				micancion.setGenero(Genero.FUNK);
				break;
			case 10:
				micancion.setGenero(Genero.ALTERNATIVO);
				break;
			case 11:
				micancion.setGenero(Genero.CLASICA);
				break;
			case 12:	
				micancion.setGenero(Genero.AMBIENTE);
				break;
			default:
				System.out.println("No se ha encontrado el g�nero, por favor elija una opci�n del men� principal.");
				break;
			}			
		}while (aux>12);
		sc.nextLine();
		//Dejamos esto comentado hasta el testeo con la BBDD
		/*String respuesta = sc.nextLine();
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
		}*/

		gestor.mostrarArtistas();
		System.out.print("Dime el artista: ");
		String artista = sc.nextLine();
		micancion.setIdArtista(gestor.conseguirArtista(artista));
	

		gestor.mostrarDiscos();
		System.out.print("Dime el disco al que pertenece la canci�n: ");
		String disco = sc.nextLine();
		micancion.setIdDisco(gestor.conseguirDisco(disco));

		return micancion;
	}

	public Artista insertarArtista() {
		Scanner sc = new Scanner(System.in);
		Artista miartista = new Artista();

		System.out.print("Dime el nombre del artista: ");
		miartista.setNombreArtista(sc.nextLine());

		System.out.print("A�o en el que empez�/empezaron: ");
		miartista.setAnioCreacion(sc.nextInt());

		System.out.print("N�mero de integrantes: ");
		miartista.setNumIntegrantes(sc.nextByte());

		return miartista;
	}

	public Disco insertarDiscos() {
		Scanner sc = new Scanner(System.in);
		Disco midisco = new Disco();

		System.out.print("Dime el nombre del disco: ");
		midisco.setNombreDisco(sc.nextLine());

		System.out.print("Imagen portada del disco (pon nombre ej: JusticeForAll.jpg):");
		midisco.setImgPortada(sc.nextLine());

		System.out.print("Introduce su precio: ");
		boolean check = false;
		while (!check) {
			try {
				midisco.setPrecio(sc.nextFloat());
				check = true;
			} catch (InputMismatchException e) {
				System.out.println("Por favor introduce un dato num�rico");
			} catch (NumberFormatException e) {
				System.out.println("Parece que el sistema no ha aceptado tu s�mbolo de decimales");
			}
		}
		return midisco;
	}

	public Cancion modificarCancion(Cancion c) {
		Scanner sc = new Scanner(System.in);
		GestorBBDD gestor = new GestorBBDD();

		System.out.print("Nuevo nombre de la canci�n: ");
		c.setNombreCancion(sc.nextLine());

		System.out.print("Nueva duraci�n: ");
		c.setDuracion(sc.nextInt());
		sc.nextLine();

		System.out.print(
				"�Cu�l es su nuevo g�nero? (ROCK,FOLK,POP,REGGAETON,ELECTR�NICA,JAZZ,METAL,BLUES,FUNK,ALTERNATIVO,CLASICA,AMBIENTE):");
		String respuesta = sc.nextLine();
		if (respuesta.equalsIgnoreCase(Genero.ROCK.toString())) {
			c.setGenero(Genero.ROCK);
		} else if (respuesta.equalsIgnoreCase(Genero.FOLK.toString())) {
			c.setGenero(Genero.FOLK);
		} else if (respuesta.equalsIgnoreCase(Genero.POP.toString())) {
			c.setGenero(Genero.POP);
		} else if (respuesta.equalsIgnoreCase(Genero.REGGAETON.toString())) {
			c.setGenero(Genero.REGGAETON);
		} else if (respuesta.equalsIgnoreCase(Genero.ELECTR�NICA.toString())) {
			c.setGenero(Genero.ELECTR�NICA);
		} else if (respuesta.equalsIgnoreCase(Genero.JAZZ.toString())) {
			c.setGenero(Genero.JAZZ);
		} else if (respuesta.equalsIgnoreCase(Genero.METAL.toString())) {
			c.setGenero(Genero.METAL);
		} else if (respuesta.equalsIgnoreCase(Genero.FOLK.toString())) {
			c.setGenero(Genero.FOLK);
		} else if (respuesta.equalsIgnoreCase(Genero.BLUES.toString())) {
			c.setGenero(Genero.BLUES);
		} else if (respuesta.equalsIgnoreCase(Genero.FUNK.toString())) {
			c.setGenero(Genero.FUNK);
		} else if (respuesta.equalsIgnoreCase(Genero.ALTERNATIVO.toString())) {
			c.setGenero(Genero.ALTERNATIVO);
		} else if (respuesta.equalsIgnoreCase(Genero.CLASICA.toString())) {
			c.setGenero(Genero.CLASICA);
		} else if (respuesta.equalsIgnoreCase(Genero.AMBIENTE.toString())) {
			c.setGenero(Genero.AMBIENTE);
		} else {
			System.out.println("No se ha encontrado el g�nero, por favor revise los g�neros que se pueden introducir.");
		}

		gestor.mostrarArtistas();
		System.out.print("Nuevo artista: ");
		String artista = sc.nextLine();
		c.setIdArtista(gestor.conseguirArtista(artista));

		gestor.mostrarDiscos();
		System.out.print("Nuevo disco: ");
		String disco = sc.nextLine();
		c.setIdDisco(gestor.conseguirDisco(disco));

		return c;
	}

	public Artista modificarArtista(Artista a) {
		Scanner sc = new Scanner(System.in);
		GestorBBDD gestor = new GestorBBDD();
		sc.nextLine();

		System.out.print("Nuevo nombre del Artista: ");
		a.setNombreArtista(sc.nextLine());
		// sc.nextLine();

		System.out.print("Nuevo a�o en el que empezaron: ");
		a.setAnioCreacion(sc.nextInt());

		System.out.print("N�mero de integrantes: ");
		a.setNumIntegrantes(sc.nextByte());

		return a;
	}

	public Disco modificarDisco(Disco d) {
		Scanner sc = new Scanner(System.in);
		GestorBBDD gestor = new GestorBBDD();

		System.out.print("Nuevo nombre del disco: ");
		d.setNombreDisco(sc.nextLine());

		System.out.println("Nueva imagen de portada: ");
		d.setImgPortada(sc.nextLine());

		System.out.print("Introduce su nuevo precio: ");
		boolean check = false;
		while (!check) {
			try {
				d.setPrecio(sc.nextFloat());
				check = true;
			} catch (InputMismatchException e) {
				System.out.println("Por favor introduce un dato num�rico");
			} catch (NumberFormatException e) {
				System.out.println("Parece que el sistema no ha aceptado tu s�mbolo de decimales");
			}
		}
		return d;
	}
}
