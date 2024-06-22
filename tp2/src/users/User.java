package users;

import java.util.ArrayList;

import criptoMoneda.CriptoMercado;
import criptoMoneda.CriptoMoneda;
import historico.HistoricoTransaccion;
import repositorios.RepoCriptoMercado;
import repositorios.RepoCriptoMoneda;

public abstract class User {


public String nombre;
	public User( String nombre) {

	this.nombre = nombre;
}
	public String getNombre() {
		return nombre;
	}


public abstract boolean darAlta(RepoCriptoMoneda repoCm,RepoCriptoMercado repoCmerc,
		CriptoMoneda criptoMoneda);
public abstract boolean modificarCripto(RepoCriptoMercado repoCmerc, RepoCriptoMoneda repoCmoneda,
		CriptoMoneda criptoMoneda, int indice);
public abstract boolean eliminarCripto(RepoCriptoMercado repoCripMer,
		 RepoCriptoMoneda repoCmon,int indice) ;
public abstract String consultarCripto(int indice, RepoCriptoMercado repoCripMer,
		 RepoCriptoMoneda repoCmon);
public abstract ArrayList<HistoricoTransaccion> consultarHistorico();
public abstract boolean comprarCripto(int indice, ArrayList<CriptoMercado> listCripMercado,
		ArrayList<CriptoMoneda> listCripMoneda, double cantidad);
public abstract boolean vender(int cantDisp,int cantVender,int indice, ArrayList<CriptoMercado> listCripMercado,
		ArrayList<CriptoMoneda> listCripMoneda );
public abstract String obtenerRecomendacion(ArrayList<CriptoMercado> listCripMercado,
		ArrayList<CriptoMoneda> listCripMoneda);


}