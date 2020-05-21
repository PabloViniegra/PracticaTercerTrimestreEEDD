package modelo;

/**
 * Permite contruir un objeto Cancion.
 * 
 * @author Pablo, Jonatan y Clara
 *
 */
public class Cancion {
	public enum Genero {
		ROCK, FOLK, POP, REGGAETON, ELECTR�NICA, JAZZ, METAL, BLUES, FUNK, ALTERNATIVO, CLASICA, AMBIENTE
	}

	private int idCancion;
	private String nombreCancion;
	private int duracion;
	private Genero genero;
	private int idArtista;
	private int idDisco;

	// Getters and Setters
	/**
	 * Accedente del identificador de la Cancion.
	 * 
	 * @return el identificador de la Cancion
	 */
	public int getIdCancion() {
		return idCancion;
	}

	/**
	 * Mutador del identificador de la Cancion.
	 * 
	 * @param idCancion el identificador de la Cancion
	 */
	public void setIdCancion(int idCancion) {
		this.idCancion = idCancion;
	}

	/**
	 * Accedente del nombre de la Cancion.
	 * 
	 * @return el nombre de la cancion
	 */
	public String getNombreCancion() {
		return nombreCancion;
	}

	/**
	 * Mutador del nombre de la Cancion
	 * 
	 * @param nombreCancion el nombre de la Cancion
	 */
	public void setNombreCancion(String nombreCancion) {
		this.nombreCancion = nombreCancion;
	}

	/**
	 * Accedente de la duraci�n de la Cancion.
	 * 
	 * @return la duraci�n de la Cancion
	 */
	public int getDuracion() {
		return duracion;
	}

	/**
	 * Mutador de la duraci�n de la Cancion.
	 * 
	 * @param duracion la duraci�n de la Cancion
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	/**
	 * Accedente del g�nero al que pertenece la Cancion (es un enum).
	 * 
	 * @return el g�nero al que pertenece la Cancion
	 */
	public Genero getGenero() {
		return genero;
	}

	/**
	 * ^ Mutador del g�nero al que pertenece la Cancion (es un enum).
	 * 
	 * @param genero el g�nero al que pertenece la Cancion
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	/**
	 * Accedente del identificador del Artista que es tratado como clave for�ena.
	 * 
	 * @return el identificador del Artista
	 */
	public int getIdArtista() {
		return idArtista;
	}

	/**
	 * Mutador del identificador del Artista que es tratado como clave for�nea.
	 * 
	 * @param idArtista el identificador del Artista
	 */
	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}

	/**
	 * Accedente del identificador del Disco que es tratado como clav for�nea.
	 * 
	 * @return el identificador del Disco
	 */
	public int getIdDisco() {
		return idDisco;
	}

	/**
	 * Mutador del identificador del Disco que es tratado como clav for�nea.
	 * 
	 * @param idDisco el identificador del Disco
	 */
	public void setIdDisco(int idDisco) {
		this.idDisco = idDisco;
	}

}
