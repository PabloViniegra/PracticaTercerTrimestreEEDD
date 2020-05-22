package controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import modelo.Interaccion;
import vista.Formulario;

/**
 * Permite la interacción de la Aplicación con los ficheros.
 * 
 * @author Pablo, Jonatan y Clara
 *
 */
public class GestorFicheros {
	/**
	 * Recibe toda la información de la Base de datos en un ArrayList y lo escribe
	 * en un fichero HTML.
	 * 
	 * @param miArray el ArrayList con la información
	 */
	public void escribirHTML(ArrayList<Interaccion> miArray) {
		String uniqueID = UUID.randomUUID().toString();
		File archivo = null;
		FileWriter escribir = null;
		try {
			archivo = new File(uniqueID + ".html");
			escribir = new FileWriter(archivo);
			escribir.write("<!DOCTYPE html> \n");
			escribir.write("<html lang=\"es\"> \n");
			escribir.write("<head> \n");
			escribir.write("<title>" + uniqueID + "</title> \n");
			escribir.write("<meta charset=\"UTF-8\"> \n");
			escribir.write("</head> \n");
			escribir.write("<body> \n");
			escribir.write("<table style=\"text-align:center;display:flex;justify-content:center \" border=\"1\"> \n");
			escribir.write("<tr><th>Nombre del Artista</th><th>Fundacion</th><th>Numero de Integrantes</th>"
					+ "<th>Nombre del Disco</th><th>Precio</th><th>Imagen de la Portada</th><th>Nombre de la Cancion</th>"
					+ "<th>Duracion</th><th>Genero</th></tr>");

			for (Interaccion i : miArray) {
				escribir.write("<tr> \n");
				escribir.write("<td>" + i.getNombreArtista() + "</td><td>" + i.getAnioCreacion() + "</td><td>"
						+ i.getNumIntegrantes() + "</td><td>" + i.getNombreDisco() + "</td><td>" + i.getPrecio() + " euros"
						+ "</td><td><img src=\"img/" + i.getImgPortada() + "\""
						+ " width=\"100px\" height=\"100px\"></td><td>" + i.getNombreCancion() + "</td><td>"
						+ i.getDuracion() + " segundos" + "</td><td>" + i.getGenero() + "</td> \n");
				escribir.write("</tr> \n");

			}
			escribir.write("</table>");
			escribir.write("</body> \n");
			escribir.write("</html>");
			escribir.close();
		} catch (IOException e) {
			System.err.print(e.getLocalizedMessage());
			Formulario form = new Formulario();
			form.menu();
		}
	}
}
