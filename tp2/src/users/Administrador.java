package users;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import criptoMoneda.CriptoMercado;
import criptoMoneda.CriptoMoneda;
import historico.HistoricoTransaccion;
import repositorios.RepoCriptoMercado;
import repositorios.RepoCriptoMoneda;

public class Administrador extends User {

	public String perfil;

	public Administrador(String nombre, String perfil) {
		super(nombre);
		this.perfil = perfil;
	}

	@Override
	public boolean darAlta(RepoCriptoMoneda repoCm, RepoCriptoMercado repoCmerc, CriptoMoneda criptoMoneda) {

		return repoCm.agregarCriptoMoneda(criptoMoneda, repoCmerc);
	}

	@Override
	public boolean modificarCripto(RepoCriptoMercado repoCmerc, RepoCriptoMoneda repoCmoneda, CriptoMoneda criptoMoneda,
			int indice) {
		return repoCmoneda.modificarCripto(repoCmerc, criptoMoneda, indice);
	}

	@Override
	public boolean eliminarCripto(RepoCriptoMercado repoCripMer, RepoCriptoMoneda repoCmon, int indice) {
		return repoCmon.eliminarCripto(repoCripMer, indice);
	}

	@Override
	public String consultarCripto(int indice, RepoCriptoMercado repoCripMer, RepoCriptoMoneda repoCmon) {

		return repoCmon.infoCripto(indice, repoCripMer);

	}

	public void verMercadoActual(RepoCriptoMercado repoCripMer) {

		for (CriptoMercado cMerc : repoCripMer.getListCriptoMercado()) {

			System.out.println(cMerc);
		}

	}

	@Override
	public ArrayList<HistoricoTransaccion> consultarHistorico() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean comprarCripto(int indice, RepoCriptoMercado repoCripMerc, RepoCriptoMoneda repoCripMoneda,
			int cantidad) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean vender(int cantDisp, int cantVender, int indice, RepoCriptoMercado recoCmerc,
			RepoCriptoMoneda repoCmon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String obtenerRecomendacion(RepoCriptoMercado repoCmerc, RepoCriptoMoneda repoCmon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHistoricos() throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
