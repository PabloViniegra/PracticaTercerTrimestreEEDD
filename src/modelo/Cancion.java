package modelo;

public class Cancion {
	public enum Genero {
		ROCK,FOLK,POP,REGGAETON,ELECTRÓNICA,JAZZ,METAL,BLUES,FUNK,ALTERNATIVO,CLASICA,AMBIENTE
	}
	
	private int idCancion;
	private String nombreCancion;
	private int duracion;
	private Genero genero;
	private int idArtista;
	private int idDisco;
	

	
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
