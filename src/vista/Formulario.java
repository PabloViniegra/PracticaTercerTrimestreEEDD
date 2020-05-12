package vista;

import java.util.InputMismatchException;
import java.util.Scanner;
import controlador.GestorBBDD;

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
}
