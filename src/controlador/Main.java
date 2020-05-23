package controlador;

import java.util.InputMismatchException;
import java.util.Scanner;

import vista.Formulario;

/**
 * Lleva el main de la Aplicación y por tanto el arranque.
 * 
 * @author Pablo, Jonatan y Clara
 *
 */
public class Main {
	/**
	 * LLama al menú de la Aplicación.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("[Recuerda que necesitas primero artistas y discos para introducir canciones.]");
		Scanner sc = new Scanner(System.in);
		Formulario f = new Formulario();
		boolean check = true;
		while (check) {
			try {
				f.menu();
				check = false;
			} catch (InputMismatchException e) {

				// Si el usuario marca un caracter que no sea numérico entra en el bucle
				System.out.println("Introduce un número por favor.");

			} finally {
				System.out.println("Pulse una tecla para continuar.");
				sc.nextLine();
			}
		}
	}
}
