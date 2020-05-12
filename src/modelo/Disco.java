package modelo;

public class Disco {
	private int idDisco;
	private String imgPortada;
	private float precio;
	private String nombreDisco;
	
	//Constructor por parámetros
	public Disco (int idDisco, String imgPortada,float precio,String nombreDisco) {
		this.idDisco=idDisco;
		this.imgPortada=imgPortada;
		this.precio=precio;
		this.nombreDisco=nombreDisco;
	}
	
	//Getters and Setters
	public int getIdDisco() {
		return idDisco;
	}
	public void setIdDisco(int idDisco) {
		this.idDisco = idDisco;
	}
	public String getImgPortada() {
		return imgPortada;
	}
	public void setImgPortada(String imgPortada) {
		this.imgPortada = imgPortada;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getNombreDisco() {
		return nombreDisco;
	}
	public void setNombreDisco(String nombreDisco) {
		this.nombreDisco = nombreDisco;
	}
	
	

}
