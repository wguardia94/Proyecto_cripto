package repositorios;

import java.util.ArrayList;

import historico.HistoricoTransaccion;

public class RepoHistoricoTransaccion {

	
	private ArrayList<HistoricoTransaccion> listHistTr;

	public RepoHistoricoTransaccion() {
		listHistTr=new ArrayList<HistoricoTransaccion>();
		
		
		listHistTr.add(new HistoricoTransaccion("BTC", "Compra", 45));
		listHistTr.add(new HistoricoTransaccion("BTC", "Venta", 15));
		listHistTr.add(new HistoricoTransaccion("DOGE", "Venta", 14));
	}
	
	
}
