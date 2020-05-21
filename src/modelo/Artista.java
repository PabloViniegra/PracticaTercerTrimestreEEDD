package modelo;

/**
 * Permite construir un objeto Artista.
 * 
 * @author Pablo, Jonatan y Clara
 *
 */
public class Artista {

	private int idArtista;
	private String nombreArtista;
	private int anioCreacion;
	private byte numIntegrantes;

	// Getters and Setters
	/**
	 * Accedente del identificador del Artista.
	 * 
	 * @return el identificador del Artista
	 */
	public int getIdArtista() {
		return idArtista;
	}

	/**
	 * Mutador del identificador del Artista.
	 * 
	 * @param idArtista el identificador del Artista
	 */
	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}

	/**
	 * Accedente del nombre del Artista.
	 * 
	 * @return el nombre del Artista
	 */
	public String getNombreArtista() {
		return nombreArtista;
	}

	/**
	 * Mutador del nombre del Artista.
	 * 
	 * @param nombreArtista el nombre del Artista
	 */
	public void setNombreArtista(String nombreArtista) {
		this.nombreArtista = nombreArtista;
	}

	/**
	 * Accedente del año de creación del Artista.
	 * 
	 * @return el año de creación del Artista
	 */
	public int getAnioCreacion() {
		return anioCreacion;
	}

	/**
	 * Mutador del año de creación del Artista.
	 * 
	 * @param anioCreacion el año de creación del Artista
	 */
	public void setAnioCreacion(int anioCreacion) {
		this.anioCreacion = anioCreacion;
	}

	/**
	 * Accedente del número de integrantes que conforman el Artista.
	 * 
	 * @return el número de integrantes que conforman el Artista
	 */
	public byte getNumIntegrantes() {
		return numIntegrantes;
	}

	/**
	 * Mutador del número de integrantes que conforman el Artista
	 * 
	 * @param numIntegrantes el número de integrantes que conforman el Artista
	 */
	public void setNumIntegrantes(byte numIntegrantes) {
		this.numIntegrantes = numIntegrantes;
	}

}
