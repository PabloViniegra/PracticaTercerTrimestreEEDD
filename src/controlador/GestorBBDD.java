package controlador;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import modelo.Artista;
import modelo.Cancion;
import modelo.Disco;
import modelo.Interaccion;
import vista.Formulario;
/**
 * Gestiona la interacción de la Aplicación con la Base de Datos.
 * @author Pablo, Jonatan y Clara
 *
 */
public class GestorBBDD {
	/**
	 * Lee el fichero de propiedades y construye la conexión de la Base de Datos.
	 * @return la conexión a la Base de Datos
	 */
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
	/**
	 * Extrae el identificador a partir del nombre del Artista que haya recibido como parámetro.
	 * @param a la cadena con el nombre del Artista
	 * @return el identificador del Artista
	 */
	public int conseguirArtista(String a) {
		Connection conn = null;
		GestorBBDD g = new GestorBBDD();
		int id = 0;
		try {
			conn = g.accesoBBDD();
			Statement consulta = conn.createStatement();
			String query = "select IdArtista from artistas where NombreArt='" + a + "'";
			ResultSet resultado = consulta.executeQuery(query);
			if (resultado.next()) {
				id = resultado.getInt("IdArtista");
			} else {
				System.out.println("No se ha encontrado el artista. Revise si lo ha escrito bien.");
				System.out.println("Pulsa un botón para continuar.");
				Scanner sc = new Scanner(System.in);
				sc.nextLine();
				Formulario f = new Formulario();
				f.menu();
			}

		} catch (SQLException e) {
			System.err.print(e.getLocalizedMessage());
			Formulario f = new Formulario();
			f.menu();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.print(e.getLocalizedMessage());
					Formulario f = new Formulario();
					f.menu();
				}
			}
		}
		return id;
	}
	/**
	 * Extrae el identificador a partir del nombre del Artista que haya recibido como parámetro.
	 * @param d la cadena con el nombre del Disco
	 * @return el identificador del Disco
	 */
	public int conseguirDisco(String d) {
		Connection conn = null;
		GestorBBDD gestor = new GestorBBDD();
		int id = 0;
		try {
			conn = gestor.accesoBBDD();
			Statement consulta = conn.createStatement();
			String query = "select IdDisco from discos where NombreDisco='" + d + "'";
			ResultSet resultado = consulta.executeQuery(query);
			if (resultado.next()) {
				id = resultado.getInt("IdDisco");
			} else {
				System.out.println("No se ha encontrado el disco. Revise si lo ha escrito bien.");
				System.out.println("Pulsa un botón para continuar.");
				Scanner sc = new Scanner(System.in);
				sc.nextLine();
				Formulario f = new Formulario();
				f.menu();
			}

		} catch (SQLException e) {
			System.err.print(e.getLocalizedMessage());
			Formulario f = new Formulario();
			f.menu();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (final SQLException e) {
					System.err.print(e.getLocalizedMessage());
					final Formulario f = new Formulario();
					f.menu();
				}
			}
			return id;
		}
	}
	/**
	 * Muestra en pantalla todos los Artistas listados en la Base de Datos por su nombre.
	 */
	public void mostrarArtistas() {
		Connection conn = null;
		GestorBBDD gestor = new GestorBBDD();
		try {
			conn = gestor.accesoBBDD();
			Statement consulta = conn.createStatement();
			String query = "select NombreArt from artistas";
			ResultSet resultado = consulta.executeQuery(query);
			System.out.println("Listado de Artistas");
			while (resultado.next()) {
				System.out.println(resultado.getObject("NombreArt"));
			}
		} catch (SQLException e) {
			System.err.print(e.getLocalizedMessage());
			Formulario f = new Formulario();
			f.menu();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.print(e.getLocalizedMessage());
					Formulario f = new Formulario();
					f.menu();
				}
			}

		}
	}
	/**
	 * Muestra en pantalla todos los Discos listados en la Base de Datos por su nombre.
	 */
	public void mostrarDiscos() {
		Connection conn = null;
		GestorBBDD gestor = new GestorBBDD();
		try {
			conn = gestor.accesoBBDD();
			Statement consulta = conn.createStatement();
			String query = "select NombreDisco from discos";
			ResultSet resultado = consulta.executeQuery(query);
			System.out.println("Listado de discos");
			while (resultado.next()) {
				System.out.println(resultado.getObject("NombreDisco"));
			}

		} catch (SQLException e) {
			System.err.print(e.getLocalizedMessage());
			Formulario f = new Formulario();
			f.menu();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.print(e.getLocalizedMessage());
					Formulario f = new Formulario();
					f.menu();
				}
			}

		}
	}
	/**
	 * Recibe un objeto Cancion construido y lo inserta en la Base de Datos.
	 * @param c el objeto Cancion
	 */
	public void insertarCancionBBDD(Cancion c) {
		Connection conn = null;
		GestorBBDD gestor = new GestorBBDD();
		try {
			conn = gestor.accesoBBDD();
			Statement consulta = conn.createStatement();
			String query = "insert into canciones (IdArtista,IdDisco,NombreCan,Duracion,Genero) VALUES ("
					+ c.getIdArtista() + "," + c.getIdDisco() + ",'" + c.getNombreCancion() + "'," + c.getDuracion()
					+ ",'" + c.getGenero() + "')";
			int valor = consulta.executeUpdate(query);

			if (valor == 1)
				System.out.println("Cancion insertada con éxito");
			else
				System.out.println("No se ha podido insertar");
			System.out.println("Pulsa un botón para continuar.");
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
			Formulario f = new Formulario();
			f.menu();
		} catch (SQLException e) {
			System.err.print(e.getLocalizedMessage());
			Formulario f = new Formulario();
			f.menu();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.print(e.getLocalizedMessage());
					Formulario f = new Formulario();
					f.menu();
				}
			}

		}
	}
	/**
	 * Recibe un objeto Artista construido y lo inserta en la Base de Datos.
	 * @param a el objeto Artista
	 */
	public void insertarArtistaBBDD(Artista a) {
		Connection conn = null;
		GestorBBDD gestor = new GestorBBDD();
		try {
			conn = gestor.accesoBBDD();
			Statement consulta = conn.createStatement();
			String query = "insert into artistas (NombreArt,AñoCreacion,NumIntegrantes) VALUES ('"
					+ a.getNombreArtista() + "'," + a.getAnioCreacion() + "," + a.getNumIntegrantes() + ")";
			int valor = consulta.executeUpdate(query);

			if (valor == 1)
				System.out.println("Artista insertado con éxito");
			else
				System.out.println("No se ha podido insertar el artista");
		} catch (SQLException e) {
			System.err.print(e.getLocalizedMessage());
			Formulario f = new Formulario();
			f.menu();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.print(e.getLocalizedMessage());
					Formulario f = new Formulario();
					f.menu();
				}
			}

		}
	}
	/**
	 * Recibe un objeto Disco construido y lo inserta en la Base de Datos.
	 * @param d el objeto Disco
	 */
	public void insertarDiscoBBDD(Disco d) {
		Connection conn = null;
		GestorBBDD gestor = new GestorBBDD();
		try {
			conn = gestor.accesoBBDD();
			Statement consulta = conn.createStatement();
			String query = "insert into discos (NombreDisco,Precio,ImgPortada) VALUES ('" + d.getNombreDisco() + "',"
					+ d.getPrecio() + ",'" + d.getImgPortada() + "')";
			int valor = consulta.executeUpdate(query);

			if (valor == 1)
				System.out.println("Disco insertado con éxito");
			else
				System.out.println("No se ha podido insertar el disco");
			System.out.println("Pulsa un botón para continuar.");
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
			Formulario f = new Formulario();
			f.menu();
		} catch (SQLException e) {
			System.err.print(e.getLocalizedMessage());
			Formulario f = new Formulario();
			f.menu();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.print(e.getLocalizedMessage());
					Formulario f = new Formulario();
					f.menu();
				}
			}

		}
	}
	/**
	 * Borra del registro de la Base de Datos la Cancion cuyo nombre reciba como parámetro.
	 * @param aux el nombre de la Cancion a borrar
	 */
	public void borrarCancionBBDD(String aux) {
		Connection conn = null;
		GestorBBDD gestor = new GestorBBDD();
		try {
			conn = gestor.accesoBBDD();
			Statement consulta = conn.createStatement();
			String query = "delete from canciones where NombreCan='" + aux + "'";
			int valor = consulta.executeUpdate(query);

			if (valor == 1)
				System.out.println("Se ha borrado el registro con éxito");
			else
				System.out.println("No se ha podido borrar el registro");
			System.out.println("Pulsa un botón para continuar.");
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
			Formulario f = new Formulario();
			f.menu();
		} catch (SQLException e) {
			System.err.print(e.getLocalizedMessage());
			Formulario f = new Formulario();
			f.menu();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.print(e.getLocalizedMessage());
					Formulario f = new Formulario();
					f.menu();
				}
			}

		}
	}
	/**
	 * Muestra por pantalla todas las Canciones que se encuentran listadas en la Base de Datos con sus respectivos datos asociados.
	 */
	public void mostrarCanciones() {
		Connection conn = null;
		GestorBBDD gestor = new GestorBBDD();
		try {
			conn = gestor.accesoBBDD();
			Statement consulta = conn.createStatement();
			String query = "select discos.NombreDisco,artistas.NombreArt,canciones.NombreCan,canciones.Duracion,"
					+ "canciones.Genero from discos RIGHT JOIN canciones ON discos.IdDisco=canciones.IdDisco LEFT"
					+ " JOIN artistas ON canciones.IdArtista=artistas.IdArtista";
			ResultSet resultado = consulta.executeQuery(query);
			while (resultado.next()) {
				System.out.println(resultado.getObject("discos.NombreDisco"));
				System.out.println(resultado.getObject("artistas.NombreArt"));
				System.out.println(resultado.getObject("canciones.NombreCan"));
				System.out.println(resultado.getObject("canciones.Duracion"));
				System.out.println(resultado.getObject("canciones.Genero"));
				System.out.println("_________________________________");
			}
		} catch (SQLException e) {
			System.err.print(e.getLocalizedMessage());
			Formulario f = new Formulario();
			f.menu();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.print(e.getLocalizedMessage());
					Formulario f = new Formulario();
					f.menu();
				}
			}

		}
	}
	/**
	 * Borra del registro de la Base de Datos el Artista cuyo nombre reciba como parámetro.
	 * @param aux el nombre del Artista
	 */
	public void borrarArtistaBBDD(String aux) {
		Connection conn = null;
		GestorBBDD gestor = new GestorBBDD();
		try {
			conn = gestor.accesoBBDD();
			Statement consulta = conn.createStatement();
			String query = "delete from artistas where NombreArt='" + aux + "'";
			int valor = consulta.executeUpdate(query);

			if (valor == 1)
				System.out.println("Se ha borrado el artista con éxito");
			else
				System.out.println("No se ha podido borrar el registro");
			System.out.println("Pulsa un botón para continuar.");
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
			Formulario f = new Formulario();
			f.menu();
		} catch (SQLException e) {
			System.err.print(e.getLocalizedMessage());
			Formulario f = new Formulario();
			f.menu();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.print(e.getLocalizedMessage());
					Formulario f = new Formulario();
					f.menu();
				}
			}

		}
	}
	/**
	 * Borra del registro de la Base de Datos el Disco cuyo nombre reciba como parámetro.
	 * @param d el nombre del Disco
	 */
	public void borrarDiscoBBDD(String d) {
		Connection conn = null;
		GestorBBDD gestor = new GestorBBDD();
		try {
			conn = gestor.accesoBBDD();
			Statement consulta = conn.createStatement();
			String query = "delete from discos where NombreDisco='" + d + "'";
			int valor = consulta.executeUpdate(query);

			if (valor == 1)
				System.out.println("Se ha borrado el disco con éxito");
			else
				System.out.println("No se ha podido borrar el registro");
			System.out.println("Pulsa un botón para continuar.");
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
			Formulario f = new Formulario();
			f.menu();
		} catch (SQLException e) {
			System.err.print(e.getLocalizedMessage());
			Formulario f = new Formulario();
			f.menu();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.print(e.getLocalizedMessage());
					Formulario f = new Formulario();
					f.menu();
				}
			}

		}
	}
	/**
	 * Muestra por pantalla todos los datos de  todas las tablas que se encuentran el
	 *  la Base de Datos recibiendo dichos datos en un ArrayList que pasa como parámetro.
	 * @return el ArrayList con la información
	 */
	public ArrayList mostrarTodo() {
		ArrayList<Interaccion> miArray = new ArrayList<Interaccion>();
		Connection conn = null;
		GestorBBDD gestor = new GestorBBDD();
		try {
			conn = gestor.accesoBBDD();
			Statement consulta = conn.createStatement();
			String query = "select artistas.NombreArt,artistas.AñoCreacion,artistas.NumIntegrantes,discos.NombreDisco,discos.Precio,discos.ImgPortada,"
					+ "canciones.NombreCan,canciones.Duracion,canciones.Genero from discos RIGHT JOIN canciones ON discos.IdDisco=canciones.IdDisco"
					+ " LEFT JOIN artistas ON canciones.IdArtista=artistas.IdArtista";
			ResultSet resultado = consulta.executeQuery(query);
			while (resultado.next()) {
				System.out.println("Artista:" + resultado.getObject("artistas.NombreArt") + "|Año Creación:"
						+ resultado.getObject("artistas.AñoCreacion") + "|Integrantes:"
						+ resultado.getObject("artistas.NumIntegrantes") + "|Nombre del Disco:"
						+ resultado.getObject("discos.NombreDisco") + "|Precio:" + resultado.getObject("discos.Precio")
						+ "€|Img:" + resultado.getObject("discos.ImgPortada") + "|Nombre de la Canción:"
						+ resultado.getObject("canciones.NombreCan") + "|Duración:"
						+ resultado.getObject("canciones.Duracion") + " minutos|"
						+ resultado.getObject("canciones.Genero"));
				System.out.println(
						"_______________________________________________________________________________________________________________________________");

				Interaccion j = new Interaccion();
				j.setNombreArtista((String) resultado.getObject("artistas.NombreArt"));
				j.setAnioCreacion((int) resultado.getObject("artistas.AñoCreacion"));
				j.setNumIntegrantes((int) resultado.getObject("artistas.NumIntegrantes"));
				j.setNombreDisco((String) resultado.getObject("discos.NombreDisco"));
				j.setPrecio((float) resultado.getObject("discos.Precio"));
				j.setImgPortada((String) resultado.getObject("discos.ImgPortada"));
				j.setNombreCancion((String) resultado.getObject("canciones.NombreCan"));
				j.setDuracion((int) resultado.getObject("canciones.Duracion"));
				j.setGenero((String) resultado.getObject("canciones.Genero"));
				miArray.add(j);
			}

		} catch (SQLException e) {
			System.err.print(e.getLocalizedMessage());
			Formulario f = new Formulario();
			f.menu();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.print(e.getLocalizedMessage());
					Formulario f = new Formulario();
					f.menu();
				}
			}

		}
		return miArray;

	}
	/**
	 * Modifica la información de un objeto Cancion ya construido y actualiza la Base de Datos.
	 * @param aux el nombre de la Cancion a modificar
	 * @param c el objeto Cancion que va a ser modificado
	 */
	public void modificarCancionBBDD(String aux, Cancion c) {
		Connection conn = null;
		GestorBBDD gestor = new GestorBBDD();
		try {
			conn = gestor.accesoBBDD();
			Statement consulta = conn.createStatement();
			String query = "update canciones set IdArtista=" + c.getIdArtista() + ",IdDisco=" + c.getIdDisco()
					+ ",NombreCan='" + c.getNombreCancion() + "',Duracion=" + c.getDuracion() + ",Genero='"
					+ c.getGenero() + "' where NombreCan='" + aux + "'";
			int valor = consulta.executeUpdate(query);

			if (valor == 1)
				System.out.println("Se ha modificado correctamente la canción");
			else
				System.out.println("No se ha podido modificar el registro");

		} catch (SQLException e) {
			System.err.print(e.getLocalizedMessage());
			Formulario f = new Formulario();
			f.menu();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.print(e.getLocalizedMessage());
					Formulario f = new Formulario();
					f.menu();
				}
			}

		}
	}
	/**
	 * Modifica la información de un objeto Artista ya construido y actualiza la Base de Datos.
	 * @param aux el nombre de la Artista a modificar
	 */
	public void modificarArtista(String aux, Artista a) {
		Connection conn = null;
		GestorBBDD gestor = new GestorBBDD();
		try {
			conn = gestor.accesoBBDD();
			Statement consulta = conn.createStatement();
			String query = "update artistas set NombreArt='" + a.getNombreArtista() + "',AñoCreacion="
					+ a.getAnioCreacion() + ",NumIntegrantes=" + a.getNumIntegrantes() + " where NombreArt='" + aux
					+ "'";

			int valor = consulta.executeUpdate(query);

			if (valor == 1)
				System.out.println("Se ha modificado el artista correctamente");
			else
				System.out.println("No se ha podido modificar el registro");

		} catch (SQLException e) {
			System.err.print(e.getLocalizedMessage());
			Formulario f = new Formulario();
			f.menu();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.print(e.getLocalizedMessage());
					Formulario f = new Formulario();
					f.menu();
				}
			}

		}
	}
	/**
	 * Modifica la información de un objeto Disco ya construido y actualiza la Base de Datos.
	 * @param aux el nombre de la Disco a modificar
	 * @param d el objeto Disco que va a ser modificado
	 */
	public void modificarDisco(String aux, Disco d) {
		Connection conn = null;
		GestorBBDD gestor = new GestorBBDD();
		try {
			conn = gestor.accesoBBDD();
			Statement consulta = conn.createStatement();
			String query = "update discos set ImgPortada='" + d.getImgPortada() + "',NombreDisco='" + d.getNombreDisco()
					+ "',Precio=" + d.getPrecio() + "where NombreDisco='" + aux + "'";
			int valor = consulta.executeUpdate(query);

			if (valor == 1)
				System.out.println("Se ha modificado el disco correctamente");
			else
				System.out.println("No se ha podido modificar el registro");
		} catch (SQLException e) {
			System.err.print(e.getLocalizedMessage());
			Formulario f = new Formulario();
			f.menu();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.print(e.getLocalizedMessage());
					Formulario f = new Formulario();
					f.menu();
				}
			}

		}
	}
}
