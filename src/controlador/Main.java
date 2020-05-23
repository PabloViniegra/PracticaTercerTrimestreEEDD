package controlador;

import java.util.InputMismatchException;
import java.util.Scanner;

import vista.Formulario;

/**
 * Lleva el main de la Aplicaci�n y por tanto el arranque.
 * 
 * @author Pablo, Jonatan y Clara
 *
 */
public class Main {
	/**
	 * LLama al men� de la Aplicaci�n.
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

				// Si el usuario marca un caracter que no sea num�rico entra en el bucle
				System.out.println("Introduce un n�mero por favor.");

			} finally {
				System.out.println("Pulse una tecla para continuar.");
				sc.nextLine();
			}
		}
	}
}
