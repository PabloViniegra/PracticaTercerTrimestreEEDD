package modelo;

public class Cancion {
	public enum Genero {
		ROCK,FOLK,POP,REGGAETON,ELECTR�NICA,JAZZ,METAL,BLUES,FUNK,ALTERNATIVO,CLASICA,AMBIENTE
	}
	
	private int idCancion;
	private String nombreCancion;
	private int duracion;
	private Genero genero;
	private int idArtista;
	private int idDisco;
	
	//Constructor con Par�metros
	public Cancion (int idCancion,String nombreCancion,int duracion,Genero genero,int idArtista,int idDisco) {
		this.idCancion=idCancion;
		this.nombreCancion=nombreCancion;
		this.duracion=duracion;
		this.genero=genero;
		this.idArtista=idArtista;
		this.idDisco=idDisco;
	}
	
	//Getters and Setters
	public int getIdCancion() {
		return idCancion;
	}
	public void setIdCancion(int idCancion) {
		this.idCancion = idCancion;
	}
	public String getNombreCancion() {
		return nombreCancion;
	}
	public void setNombreCancion(String nombreCancion) {
		this.nombreCancion = nombreCancion;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public int getIdArtista() {
		return idArtista;
	}
	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}
	public int getIdDisco() {
		return idDisco;
	}
	public void setIdDisco(int idDisco) {
		this.idDisco = idDisco;
	}
	
	
	
}
