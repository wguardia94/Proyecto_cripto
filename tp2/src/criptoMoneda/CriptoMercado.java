package criptoMoneda;

public class CriptoMercado {

	@Override
	public String toString() {
		return "[simbolo=" + simbolo + ", capacidad=" + capacidad + ", volumen24Hs=" + volumen24Hs
				+ ", variacion7Dias=" + variacion7Dias + "]";
	}
	private String simbolo;
	private double capacidad;
	private String volumen24Hs;
	private String variacion7Dias;
	public CriptoMercado(String simbolo, double capacidad, String volumen24Hs, String variacion7Dias) {
		super();
		this.simbolo = simbolo;
		this.capacidad = capacidad;
		this.volumen24Hs = volumen24Hs;
		this.variacion7Dias = variacion7Dias;
	}
	public String getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	public double getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}
	public String getVolumen24Hs() {
		return volumen24Hs;
	}
	public void setVolumen24Hs(String volumen24Hs) {
		this.volumen24Hs = volumen24Hs;
	}
	public String getVariacion7Dias() {
		return variacion7Dias;
	}
	public void setVariacion7Dias(String variacion7Dias) {
		this.variacion7Dias = variacion7Dias;
	}
	
	
	
	
}
