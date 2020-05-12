package modelo;

public class Artista {
	
	private int idArtista;
	private String nombreArtista;
	private int anioCreacion;
	private byte numIntegrantes;
	
	//Constructor por parámetros
	public Artista (int idArtista,String nombreArtista,int anioCreacion,byte numIntegrantes) {
		this.idArtista=idArtista;
		this.nombreArtista=nombreArtista;
		this.anioCreacion=anioCreacion;
		this.numIntegrantes=numIntegrantes;
	}
	
	//Getters and Setters
	public int getIdArtista() {
		return idArtista;
	}
	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}
	public String getNombreArtista() {
		return nombreArtista;
	}
	public void setNombreArtista(String nombreArtista) {
		this.nombreArtista = nombreArtista;
	}
	public int getAnioCreacion() {
		return anioCreacion;
	}
	public void setAnioCreacion(int anioCreacion) {
		anioCreacion = anioCreacion;
	}
	public byte getNumIntegrantes() {
		return numIntegrantes;
	}
	public void setNumIntegrantes(byte numIntegrantes) {
		this.numIntegrantes = numIntegrantes;
	}
	
	
}
