package repositorios;

import java.util.ArrayList;

import comparadores.CompararTransacciones;
import historico.HistoricoTransaccion;

public class RepoHistoricoTransaccion {

	private ArrayList<HistoricoTransaccion> listHistTr;

	public RepoHistoricoTransaccion() {
		listHistTr = new ArrayList<HistoricoTransaccion>();

		listHistTr.add(new HistoricoTransaccion("BTC", "Compra", 45));
		listHistTr.add(new HistoricoTransaccion("BTC", "Venta", 15));
		listHistTr.add(new HistoricoTransaccion("DOGE", "Venta", 14));
	}

	public boolean actualizar(HistoricoTransaccion newHt) {

		listHistTr.add(newHt);

		return true;
	}

	public ArrayList<HistoricoTransaccion> consultarHistorico() {

		ArrayList<HistoricoTransaccion> aux = new ArrayList<HistoricoTransaccion>(listHistTr);

		aux.sort(new CompararTransacciones());

		return aux;

	}

}
