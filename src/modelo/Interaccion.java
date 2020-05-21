package modelo;

/**
 * Es una clase funcional. Su principal utilidad es la de almacenar todos los
 * atributos del resto de clases y ser volcados de forma más cómoda. Permite
 * construir un objeto Interaccion.
 * 
 * @author Pablo, Jonatan y Clara
 *
 */
public class Interaccion {
	private String nombreArtista;
	private int anioCreacion;
	private int numIntegrantes;
	private String nombreDisco;
	private float precio;
	private String imgPortada;
	private String nombreCancion;
	private int duracion;
	private String genero;

	// Getter and Setters
	/**
	 * Accedente del nombre del Artista.
	 * 
	 * @return el nombre del Artista
	 */
	public String getNombreArtista() {
		return nombreArtista;
	}

	/**
	 * Mutador del Artista.
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
	public int getNumIntegrantes() {
		return numIntegrantes;
	}

	/**
	 * Mutador del número de integrantes que conforman el Artista.
	 * 
	 * @param numIntegrantes el número de integrantes que conforman el Artista
	 */
	public void setNumIntegrantes(int numIntegrantes) {
		this.numIntegrantes = numIntegrantes;
	}

	/**
	 * Accedente del nombre del Disco.
	 * 
	 * @return el nombre del Disco
	 */
	public String getNombreDisco() {
		return nombreDisco;
	}

	/**
	 * Mutador del nombre del Disco.
	 * 
	 * @param nombreDisco el nombre del Disco
	 */
	public void setNombreDisco(String nombreDisco) {
		this.nombreDisco = nombreDisco;
	}

	/**
	 * Accedente del precio del Disco.
	 * 
	 * @return el precio del Disco
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * Mutador del precio del Disco.
	 * 
	 * @param precio el precio del Disco
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * Accedente de la imagen de portada del Disco.
	 * 
	 * @return la imagen de portada del Disco
	 */
	public String getImgPortada() {
		return imgPortada;
	}

	/**
	 * Mutador de la imagen de portada del Disco
	 * 
	 * @param imgPortada la imagen de portada del Disco
	 */
	public void setImgPortada(String imgPortada) {
		this.imgPortada = imgPortada;
	}

	/**
	 * Accedente del nombre de la Cancion.
	 * 
	 * @return el nombre de la Cancion
	 */
	public String getNombreCancion() {
		return nombreCancion;
	}

	/**
	 * Mutador del nombre de la Cancion.
	 * 
	 * @param nombreCancion el nombre de la Cancion
	 */
	public void setNombreCancion(String nombreCancion) {
		this.nombreCancion = nombreCancion;
	}

	/**
	 * Accedente de la duración de la Cancion.
	 * 
	 * @return la duración de la Cancion
	 */
	public int getDuracion() {
		return duracion;
	}

	/**
	 * Mutador de la duración de la Cancion.
	 * 
	 * @param duracion la duración de la Cancion
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	/**
	 * Accedente del género al que pertenece la Cancion.
	 * 
	 * @return el género al que pertenece la Cancion
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Mutador del género al que pertenece la Cancion.
	 * 
	 * @param genero al que pertenece la Cancion
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

}
