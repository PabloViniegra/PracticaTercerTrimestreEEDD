package controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import modelo.Interaccion;
import vista.Formulario;

public class GestorFicheros {
	
	public void escribirHTML (ArrayList <Interaccion> miArray) {
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
			escribir.write("<tr><th>Nombre del Artista</th><th>Fundación</th><th>Número de Integrantes</th>"
					+ "<th>Nombre del Disco</th><th>Precio</th><th>Imagen de la Portada</th><th>Nombre de la Canción</th>"
					+ "<th>Duracion</th><th>Género</th></tr>");
			
			for (Interaccion i : miArray) {
				escribir.write("<tr> \n");
				escribir.write("<td>" + i.getNombreArtista() + "</td><td>" + i.getAnioCreacion() +
						"</td><td>" + i.getNumIntegrantes() + "</td><td>" + i.getNombreDisco() + "</td><td>" +
						i.getPrecio() + "€" + "</td><td><img src=\"img/" + i.getImgPortada() + "\"" + " width=\"100px\" height=\"100px\"></td><td>" + i.getNombreCancion() +
						"</td><td>" + i.getDuracion() + " minutos" + "</td><td>" + i.getGenero() + "</td> \n");
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
