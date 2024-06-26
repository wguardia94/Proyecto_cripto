package users;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import criptoMoneda.CriptoMercado;
import criptoMoneda.CriptoMoneda;
import historico.HistoricoTransaccion;
import historico.HistoricoUser;
import repositorios.RepoCriptoMercado;
import repositorios.RepoCriptoMoneda;

public abstract class User {

	public String nombre;

	public User(String nombre) {

		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public abstract boolean darAlta(RepoCriptoMoneda repoCm, RepoCriptoMercado repoCmerc, CriptoMoneda criptoMoneda);

	public abstract boolean modificarCripto(RepoCriptoMercado repoCmerc, RepoCriptoMoneda repoCmoneda,
			CriptoMoneda criptoMoneda, int indice);

	public abstract boolean eliminarCripto(RepoCriptoMercado repoCripMer, RepoCriptoMoneda repoCmon, int indice);

	public abstract String consultarCripto(int indice, RepoCriptoMercado repoCripMer, RepoCriptoMoneda repoCmon);
	public abstract void verMercadoActual(RepoCriptoMercado repoCripMer);
	public abstract ArrayList<HistoricoTransaccion> consultarHistorico();

	public abstract boolean comprarCripto(int indice, RepoCriptoMercado repoCripMerc, RepoCriptoMoneda repoCripMoneda,
			int cantidad);
	public abstract ArrayList<HistoricoUser> getHistoricoUser();
	public abstract boolean vender(HistoricoUser cmVender, int cantVender, RepoCriptoMercado recoCmerc,
			RepoCriptoMoneda repoCmon);

	public abstract String obtenerRecomendacion(RepoCriptoMercado repoCmerc, RepoCriptoMoneda repoCmon);
	public abstract void setHistoricos()throws FileNotFoundException;
	public abstract String toCsvString();
	public abstract double getSaldo();
	public abstract void cerrarSesion() throws IOException;
	
}