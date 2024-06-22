package criptoMoneda;

public class CriptoMoneda {

	
	@Override
	public String toString() {
		return "CriptoMoneda [nombre=" + nombre + ", simbolo=" + simbolo + ", precioBase=" + precioBase + "]";
	}
	private String nombre;
	private String simbolo;
	private double precioBase;
	
	public CriptoMoneda(String nombre, String simbolo, double precioBase) {
			this.nombre = nombre;
		this.simbolo = simbolo;
		this.precioBase = precioBase;
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

	
	
	
	
	
}
