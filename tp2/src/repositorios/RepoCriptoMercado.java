package repositorios;

import java.util.ArrayList;

import criptoMoneda.CriptoMercado;

public class RepoCriptoMercado {

	
	private ArrayList<CriptoMercado> listCriptoMercado;

	public RepoCriptoMercado() {
		listCriptoMercado=new ArrayList<CriptoMercado>();
		CriptoMercado cmer1=new CriptoMercado("BTC", 8800, "30%", "+10%");
		CriptoMercado cmer2=new CriptoMercado("ETH", 400, "20%", "+30%");
		
		listCriptoMercado.add(cmer1);
		listCriptoMercado.add(cmer2);
		
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
