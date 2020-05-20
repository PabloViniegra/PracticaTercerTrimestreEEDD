package modelo;
/**
 * Permite construir un objeto Disco.
 * @author Pablo, Jonatan y Clara
 *
 */
public class Disco {
	private int idDisco;
	private String imgPortada;
	private float precio;
	private String nombreDisco;
	
	
	//Getters and Setters
	/**
	 * Accedente del identificador del Disco.
	 * @return el identificador del Disco
	 */
	public int getIdDisco() {
		return idDisco;
	}
	/**
	 * Mutador del identificador del Disco.
	 * @param idDisco el identificador del Disco
	 */
	public void setIdDisco(int idDisco) {
		this.idDisco = idDisco;
	}
	/**
	 * Accedente de la imagen de portada del Disco (es un String porque recibe el nombre del archivo que va a llevar la imagen).
	 * @return la imagen de portada del Disco
	 */
	public String getImgPortada() {
		return imgPortada;
	}
	/**
	 * Mutador de la imagen de portada del Disco (es un String porque recibe el nombre del archivo que va a llevar la imagen).
	 * @param imgPortada la imagen de portada del Disco
	 */
	public void setImgPortada(String imgPortada) {
		this.imgPortada = imgPortada;
	}
	/**
	 * Accedente del precio del Disco.
	 * @return el precio del Disco
	 */
	public float getPrecio() {
		return precio;
	}
	/**
	 * Mutador del precio del Disco.
	 * @param precio el precio del Disco
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	/**
	 * Accedente del nombre del Disco.
	 * @return el nombre del Disco
	 */
	public String getNombreDisco() {
		return nombreDisco;
	}
	/**
	 * Mutador del nombre del Disco.
	 * @param nombreDisco el nombre del Disco
	 */
	public void setNombreDisco(String nombreDisco) {
		this.nombreDisco = nombreDisco;
	}
	
	

}
