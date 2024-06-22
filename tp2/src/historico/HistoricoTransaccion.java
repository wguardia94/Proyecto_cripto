package historico;

public class HistoricoTransaccion {

	
	private String simbolo;
	private String tipo;
	private int cantidad;
	public HistoricoTransaccion(String simbolo, String tipo, int cantidad) {
		super();
		this.simbolo = simbolo;
		this.tipo = tipo;
		this.cantidad = cantidad;
	}
	public String getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	public String getTipo() {
		return tipo;
	}
	@Override
	public String toString() {
		return "HistoricoTransaccion [simbolo=" + simbolo + ", tipo=" + tipo + ", cantidad=" + cantidad + "]";
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
