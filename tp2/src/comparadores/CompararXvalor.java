package comparadores;

import java.util.ArrayList;
import java.util.Comparator;

import criptoMoneda.CriptoMercado;
import criptoMoneda.CriptoMoneda;




public class CompararXvalor implements Comparator<CriptoMoneda> {

	CriptoMercado cmer1=new CriptoMercado("BTC", 300, "+30%", "+10%");
CriptoMercado cmer2=new CriptoMercado("ETH", 10, "+20%", "+30%");	
	
ArrayList<CriptoMercado>listCripMercado=new ArrayList<CriptoMercado>();	

	
public int buscarXsimboloMercado(ArrayList<CriptoMercado> listMercado, String simbolo) {

	for (CriptoMercado cm : listMercado) {
		if (cm.getSimbolo().equals(simbolo))

			return listMercado.indexOf(cm);
	}

	return -1;
}
	

	
	@Override
	public int compare(CriptoMoneda o1, CriptoMoneda o2) {


 listCripMercado.add(cmer1);
 listCripMercado.add(cmer2);
 
CriptoMercado cmer1=listCripMercado.get(buscarXsimboloMercado(listCripMercado,  o1.getSimbolo()));
CriptoMercado cmer2=listCripMercado.get(buscarXsimboloMercado(listCripMercado,  o2.getSimbolo()));
	
  double porc1=(cmer1.getCapacidad()/o1.getPrecioBase())*100;
 double porc2=(cmer2.getCapacidad()/o2.getPrecioBase())*100;
if (porc1>porc2)
				return -1;
				else if(porc1<porc2)
					return 1;
				else
					return 0;

			}


}
