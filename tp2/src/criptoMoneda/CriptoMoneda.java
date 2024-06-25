package criptoMoneda;

public class CriptoMoneda {

	
	
	private String nombre;
	private String simbolo;
	private double precioBase;
	
	public CriptoMoneda(String nombre, String simbolo, double precioBase) {
			this.nombre = nombre;
		this.simbolo = simbolo;
		this.precioBase = precioBase;
	}
	
	
	public CriptoMoneda(CriptoMoneda cm) {
		this.nombre = cm.nombre;
	this.simbolo = cm.simbolo;
	this.precioBase = cm.precioBase;
}
	
	
	
	
	
	public String getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	public double getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "[nombre=" + nombre + ", simbolo=" + simbolo + ", precio=" + precioBase + "]";
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
