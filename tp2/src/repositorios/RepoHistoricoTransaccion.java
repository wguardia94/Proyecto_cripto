package repositorios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import archivos.Archivo;
import comparadores.CompararTransacciones;
import criptoMoneda.CriptoMoneda;
import historico.HistoricoTransaccion;
import users.Administrador;
import users.Trader;
import users.User;

public class RepoHistoricoTransaccion {

	private ArrayList<HistoricoTransaccion> listHistTr;
private String pathFile;
	public RepoHistoricoTransaccion() {
		listHistTr = new ArrayList<HistoricoTransaccion>();

		listHistTr.add(new HistoricoTransaccion("BTC", "Compra", 45));
		listHistTr.add(new HistoricoTransaccion("BTC", "Venta", 15));
		listHistTr.add(new HistoricoTransaccion("DOGE", "Venta", 14));
	}

	
	public RepoHistoricoTransaccion(String path) throws FileNotFoundException {
		listHistTr = new ArrayList<HistoricoTransaccion>();
pathFile=path;
		List<String> registros = Archivo.leer(pathFile);

		cargarLista(registros);
		
		
		
	
	}
	
	
public void guardarArchivo() throws IOException {
		
		Archivo.grabar(toCsvString(),pathFile);
			
		}



		public List<String> toCsvString() {
			List<String>registros=new ArrayList<String>();
			for (HistoricoTransaccion h:listHistTr) {
				
			registros.add(h.getSimbolo()+";"+h.getTipo()+";"+h.getCantidad());
			}

			return registros;
		}
	
	
	
	
	public ArrayList<HistoricoTransaccion> getListHistTr() {
		return listHistTr;
	}


	private void cargarLista(List<String> registros) {
		listHistTr = new ArrayList<HistoricoTransaccion>();
		for (String reg : registros) {

			String[] div = reg.split(";");

			listHistTr.add(new HistoricoTransaccion(div[0], div[1],Integer.parseInt(div[2])));
			
		}
		
	}

	
	
	
	
	
	
	
	


	public boolean actualizar(HistoricoTransaccion newHt) {

		listHistTr.add(newHt);

		return true;
	}

	
	
	
	
	
	
	
	
	
	public ArrayList<HistoricoTransaccion> consultarHistorico() {

		ArrayList<HistoricoTransaccion> aux = new ArrayList<HistoricoTransaccion>(listHistTr);

		aux.sort(new CompararTransacciones());

		for(HistoricoTransaccion ht:aux) {
			System.out.println(ht);
		}
		
		
		return aux;

	}

}
