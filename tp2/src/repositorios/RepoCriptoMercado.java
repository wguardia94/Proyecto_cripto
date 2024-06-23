package repositorios;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import archivos.Archivo;
import criptoMoneda.CriptoMercado;
import criptoMoneda.CriptoMoneda;

public class RepoCriptoMercado {

	
	private ArrayList<CriptoMercado> listCriptoMercado;

	public RepoCriptoMercado() {
		listCriptoMercado=new ArrayList<CriptoMercado>();
		CriptoMercado cmer1=new CriptoMercado("BTC", 8800, "30%", "+10%");
		CriptoMercado cmer2=new CriptoMercado("ETH", 400, "20%", "+30%");
		
		listCriptoMercado.add(cmer1);
		listCriptoMercado.add(cmer2);
		
	}
	
	public RepoCriptoMercado(String nombreArch) throws FileNotFoundException {
		listCriptoMercado=new ArrayList<CriptoMercado>();
	
		
List<String> registros=Archivo.leer("src/datos/"+nombreArch);
		
		cargarLista(registros);

		
	}
	
	public void cargarLista(List<String> registros) {
		listCriptoMercado = new ArrayList<CriptoMercado>();
		for(String reg:registros) {
			
			String[] div=reg.split(";");
			
			listCriptoMercado.add(new CriptoMercado(div[0], Double.parseDouble(div[1]),div[2],div[3]));
			
		}
	}
	
	
	public boolean agregar(String simbolo) {
		listCriptoMercado.add(new CriptoMercado(simbolo, 500, "+1%", "+1%"));
		
		return true;
	}
	
	
	public void modificarSimbolo(String antSimbolo,String newSimbolo) {
		
		int indiceMercado = buscarXsimboloMercado(antSimbolo);
		
		listCriptoMercado.get(indiceMercado).setSimbolo(newSimbolo);
	}
	
public ArrayList<CriptoMercado> getListCriptoMercado() {
		return listCriptoMercado;
	}
public CriptoMercado getCriptoMercadoIndice(int ind) {
	return listCriptoMercado.get(ind);
}

public void modificar(String antSimbolo,CriptoMercado cmer) {
		
		int indiceMercado = buscarXsimboloMercado(antSimbolo);
		
		listCriptoMercado.set(indiceMercado, cmer);
	}
	
	
	
	
	public int buscarXsimboloMercado(String simbolo) {

		for (CriptoMercado cm : listCriptoMercado) {
			if (cm.getSimbolo().equals(simbolo))

				return listCriptoMercado.indexOf(cm);
		}

		return -1;
	}
	
	public CriptoMercado getCriptoMercadoXsimbolo(String simbolo) {
		return listCriptoMercado.get(buscarXsimboloMercado(simbolo));
	}



	public void eliminar(String simbolo) {
		
		listCriptoMercado.remove(buscarXsimboloMercado( simbolo));
		
		
		
	}
	
	

	
	
}
