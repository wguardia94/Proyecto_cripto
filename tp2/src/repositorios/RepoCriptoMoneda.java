package repositorios;

import java.util.ArrayList;

import criptoMoneda.CriptoMercado;
import criptoMoneda.CriptoMoneda;

public class RepoCriptoMoneda {

	
	
	private ArrayList<CriptoMoneda>listCriptoMoneda;

	public RepoCriptoMoneda() {
		
		this.listCriptoMoneda = new ArrayList<CriptoMoneda>();
		
		CriptoMoneda cm1=new CriptoMoneda("Bitcoin", "BTC", 1500);
		CriptoMoneda cm2=new CriptoMoneda("Ethereum", "ETH", 1000);
		
		listCriptoMoneda.add(cm1);
		listCriptoMoneda.add(cm2);
	}
	
	
	public boolean agregarCriptoMoneda(CriptoMoneda cm,RepoCriptoMercado repoCmerc) {
		

		
		if (encontrarXnombre(cm.getNombre()) != -1)

		{
			System.out.println("repetido");
			return false;
		}

		else {

			listCriptoMoneda.add(cm);
			repoCmerc.agregar(cm.getSimbolo());
			
			// modificar archivos

			return true;
		}
		
	}
	
	
	public boolean modificarCripto(RepoCriptoMercado repoCmerc,
			CriptoMoneda criptoMoneda, int indice) {
		CriptoMoneda ant = listCriptoMoneda.get(indice);

		listCriptoMoneda.set(indice, criptoMoneda);
		
		if (!ant.getSimbolo().equals(criptoMoneda.getSimbolo())) {
			
			repoCmerc.modificar(ant.getSimbolo(), criptoMoneda.getSimbolo());
		}

		return true;
	}
	
	
	public boolean eliminarCripto(RepoCriptoMercado repoCripMer,
			int indice) {
		CriptoMoneda cmElim = listCriptoMoneda.get(indice);
		listCriptoMoneda.remove(indice);
		repoCripMer.eliminar(cmElim.getSimbolo());
		
		return true;
	}
	
	
	public String infoCripto(int indice, RepoCriptoMercado repoCripMer) {
		
		CriptoMoneda cm=listCriptoMoneda.get(indice);
		CriptoMercado cMer=repoCripMer.getCriptoMercado(cm.getSimbolo());
		
		String info="Nombre:"+cm.getNombre()+"\t"+"Simbolo:"+cm.getSimbolo()+"\t"+"Precio en dolares:"+cm.getPrecioBase()+
				"\n"+"Capacidad:"+cMer.getCapacidad()+"\t"+"Volumen en ultimas 24 horas:"+cMer.getVolumen24Hs()+"\t"+
				"Variacion 7 ultimos dias"+cMer.getVariacion7Dias();
		
		return info;
	
	}
	
	public int encontrarXnombre(String nombre) {

		for (CriptoMoneda cm : listCriptoMoneda) {
			if (cm.getNombre().equals(nombre))

				return listCriptoMoneda.indexOf(cm);
		}

		return -1;
	}
	
	
	
	
}
