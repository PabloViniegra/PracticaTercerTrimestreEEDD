package controlador;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

import vista.Formulario;


public class GestorBBDD {
	
	public Connection accesoBBDD() {
		Properties datos = new Properties();
		InputStream entrada = null;
		Connection conn = null;
		try {
			entrada = new FileInputStream("BBDD.properties");
			datos.load(entrada);
			// Cargamos los datos del fichero de propiedades en variables
			String host = datos.getProperty("host");
			String nombrebbdd = datos.getProperty("nombreBBDD");
			String usuario = datos.getProperty("nombreUsuario");
			String contrasenia = datos.getProperty("contraseña");
			// Construimos un string con la sentencia de conexion a la Base de datos
			String principal = "jdbc:mysql://" + host + "/" + nombrebbdd;
			// Construimos el objeto de la Conexión con los datos requeridos
			conn = DriverManager.getConnection(principal, usuario, contrasenia);

		} catch (IOException e) {
			System.err.println(e.getLocalizedMessage());
			Formulario f = new Formulario();
			f.menu();
			
		} catch (SQLException e) {
			System.err.print(e.getLocalizedMessage());
			Formulario f = new Formulario();
			f.menu();
		}
		// Devolvemos el objeto
		return conn;
	}
	
	public int conseguirArtista (String a) {
		Connection conn = null;
		GestorBBDD g = new GestorBBDD();
		int id = 0;
		try {
			conn = g.accesoBBDD();
			Statement consulta = conn.createStatement();
			String query = "select IdArtista from artistas where NombreArt='" + a + "'";
			ResultSet resultado = consulta.executeQuery(query);
			if (resultado.next()) {
				id=resultado.getInt("IdArtista");
			} else {
				System.out.println("No se ha encontrado el artista. Revise si lo ha escrito bien.");
			}
			
		} catch (SQLException e) {
			System.err.print(e.getLocalizedMessage());
			Formulario f = new Formulario();
			f.menu();
		}
		return id;
	}

}
