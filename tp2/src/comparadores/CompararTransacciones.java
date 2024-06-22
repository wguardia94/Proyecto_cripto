package comparadores;

import java.util.Comparator;

import historico.HistoricoTransaccion;

public class CompararTransacciones implements Comparator<HistoricoTransaccion> {

	@Override
	public int compare(HistoricoTransaccion o1, HistoricoTransaccion o2) {

if(o1.getSimbolo().compareTo(o2.getSimbolo())!=0)
	
		return o1.getSimbolo().compareTo(o2.getSimbolo());
else 
	return o2.getCantidad()-o1.getCantidad();

	}

}
