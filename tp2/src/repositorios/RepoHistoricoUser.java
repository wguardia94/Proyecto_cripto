package repositorios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import archivos.Archivo;
import criptoMoneda.CriptoMoneda;
import historico.HistoricoTransaccion;
import historico.HistoricoUser;

public class RepoHistoricoUser {

	
	
	private ArrayList<HistoricoUser> listHistUser;
private String pathFile;
	public RepoHistoricoUser() {
		listHistUser=new ArrayList<HistoricoUser>();
		
		listHistUser.add(new HistoricoUser("BTC", 30));
		
		
	}
	public RepoHistoricoUser(String path) throws FileNotFoundException {
		listHistUser=new ArrayList<HistoricoUser>();
		pathFile=path;
		List<String> registros = Archivo.leer(pathFile);

		cargarLista(registros);
		
		
	}
	
	
public void guardarArchivo() throws IOException {
		
		Archivo.grabar(toCsvString(),pathFile);
			
		}



		public List<String> toCsvString() {
			List<String>registros=new ArrayList<String>();
			for (HistoricoUser h:listHistUser) {
				
			registros.add(h.getSimbolo()+";"+h.getCantidad());
			}

			return registros;
		}
	
	
	
	
	
	private void cargarLista(List<String> registros) {
		listHistUser = new ArrayList<HistoricoUser>();
		for (String reg : registros) {

			String[] div = reg.split(";");

			listHistUser.add(new HistoricoUser(div[0],Integer.parseInt(div[1])));
			
		}
		
		
	}
	

	public boolean actualizar(String simbolo, int cantidad) {
		
		int ind = buscarIndicexSimbolo(simbolo);
		if (ind == -1) {

			listHistUser.add(new HistoricoUser(simbolo, cantidad));
		} else {
			HistoricoUser hAnt = listHistUser.get(ind);
			hAnt.setCantidad(hAnt.getCantidad() + cantidad);
			listHistUser.set(ind, hAnt);
		}
		
		
		return true;
	}
	
	
	
	public int buscarIndicexSimbolo(String simbolo) {

		for (HistoricoUser hu : listHistUser) {
			if (hu.getSimbolo().equals(simbolo))

				return listHistUser.indexOf(hu);
		}

		return -1;
	}
	
	
	
}
