package comparadores;

import java.util.ArrayList;
import java.util.Comparator;

import criptoMoneda.CriptoMercado;
import criptoMoneda.CriptoMoneda;

public class CompararXvalor implements Comparator<CriptoMoneda> {

	private ArrayList<CriptoMercado> listCripMercado = new ArrayList<CriptoMercado>();

	public CompararXvalor(ArrayList<CriptoMercado> listCripMercado) {

		this.listCripMercado = listCripMercado;
	}

	public CriptoMercado buscarXsimboloMercado(String simbolo) {

		for (CriptoMercado cm : listCripMercado) {
			if (cm.getSimbolo().equals(simbolo))

				return cm;
		}
		return null;
	}

	@Override
	public int compare(CriptoMoneda o1, CriptoMoneda o2) {

		CriptoMercado cmer1 = buscarXsimboloMercado(o1.getSimbolo());
		CriptoMercado cmer2 = buscarXsimboloMercado(o2.getSimbolo());

		double porc1 = (cmer1.getCapacidad() / o1.getPrecioBase()) * 100;
		double porc2 = (cmer2.getCapacidad() / o2.getPrecioBase()) * 100;
		if (porc1 > porc2)
			return -1;
		else if (porc1 < porc2)
			return 1;
		else
			return 0;

	}

}
