package historico;

import java.util.Objects;

public class HistoricoUser {

	
	@Override
	public int hashCode() {
		return Objects.hash(cantidad, simbolo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoricoUser other = (HistoricoUser) obj;
		return cantidad == other.cantidad && Objects.equals(simbolo, other.simbolo);
	}


	private String simbolo;
	private int cantidad;
	
	
	public HistoricoUser(String simbolo, int cantidad) {
		super();
		this.simbolo = simbolo;
		this.cantidad = cantidad;
	}


	public String getSimbolo() {
		return simbolo;
	}


	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
	
}
