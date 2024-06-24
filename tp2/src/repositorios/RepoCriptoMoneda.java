package repositorios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import archivos.Archivo;
import comparadores.CompararXvalor;
import criptoMoneda.CriptoMercado;
import criptoMoneda.CriptoMoneda;
import historico.HistoricoTransaccion;

public class RepoCriptoMoneda {

	private ArrayList<CriptoMoneda> listCriptoMoneda;
	private String pathFile;

	public RepoCriptoMoneda() {

		this.listCriptoMoneda = new ArrayList<CriptoMoneda>();

		CriptoMoneda cm1 = new CriptoMoneda("Bitcoin", "BTC", 1500);
		CriptoMoneda cm2 = new CriptoMoneda("Ethereum", "ETH", 1000);

		listCriptoMoneda.add(cm1);
		listCriptoMoneda.add(cm2);
	}

	public RepoCriptoMoneda(String nombreArch) throws FileNotFoundException {

		pathFile = "src/datos/" + nombreArch;

		List<String> registros = Archivo.leer(pathFile);

		cargarLista(registros);

	}

	public void cargarLista(List<String> registros) {
		this.listCriptoMoneda = new ArrayList<CriptoMoneda>();
		for (String reg : registros) {

			String[] div = reg.split(";");

			listCriptoMoneda.add(new CriptoMoneda(div[0], div[1], Double.parseDouble(div[2])));

		}

	}

	public void guardarArchivo() throws IOException {

		Archivo.grabar(toCsvString(), pathFile);

	}

	public List<String> toCsvString() {
		List<String> registros = new ArrayList<String>();
		for (CriptoMoneda cm : listCriptoMoneda) {

			registros.add(cm.getNombre() + ";" + cm.getSimbolo() + ";" + cm.getPrecioBase());
		}

		return registros;
	}

	public boolean agregarCriptoMoneda(CriptoMoneda cm, RepoCriptoMercado repoCmerc) {

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

	public boolean modificarCripto(RepoCriptoMercado repoCmerc, CriptoMoneda criptoMoneda, int indice) {
		CriptoMoneda ant = listCriptoMoneda.get(indice);

		listCriptoMoneda.set(indice, criptoMoneda);

		if (!ant.getSimbolo().equals(criptoMoneda.getSimbolo())) {

			repoCmerc.modificarSimbolo(ant.getSimbolo(), criptoMoneda.getSimbolo());
		}
		return true;
	}

	public ArrayList<CriptoMoneda> getListCriptoMoneda() {
		return listCriptoMoneda;
	}

	public CriptoMoneda getCriptoMonedaXindice(int indice) {
		return listCriptoMoneda.get(indice);
	}

	public void setListCriptoMoneda(ArrayList<CriptoMoneda> listCriptoMoneda) {
		this.listCriptoMoneda = listCriptoMoneda;
	}

	public boolean eliminarCripto(RepoCriptoMercado repoCripMer, int indice) {
		CriptoMoneda cmElim = listCriptoMoneda.get(indice);
		listCriptoMoneda.remove(indice);
		repoCripMer.eliminar(cmElim.getSimbolo());

		return true;
	}

	public String infoCripto(int indice, RepoCriptoMercado repoCripMer) {

		CriptoMoneda cm = listCriptoMoneda.get(indice);

		CriptoMercado cMer = repoCripMer.getCriptoMercadoXsimbolo(cm.getSimbolo());
		String info = "Nombre:" + cm.getNombre() + "\t" + "Simbolo:" + cm.getSimbolo() + "\t" + "Precio en dolares:"
				+ cm.getPrecioBase() + "\n" + "Capacidad:" + cMer.getCapacidad() + "\t" + "Volumen en ultimas 24 horas:"
				+ cMer.getVolumen24Hs() + "\t" + "Variacion 7 ultimos dias" + cMer.getVariacion7Dias();

		return info;

	}

	public boolean realizarCompra(RepoCriptoMercado repoCripMer, int cantidad, int indice) {

		CriptoMoneda cm = getCriptoMonedaXindice(indice);

		CriptoMercado cMer = repoCripMer.getCriptoMercadoXsimbolo(cm.getSimbolo());
		cMer.setCapacidad(cMer.getCapacidad() - cantidad);

		double antVal = aDouble(cMer.getVariacion7Dias());
		cMer.setVariacion7Dias("+" + antVal * 1.05 + "%");

		antVal = aDouble(cMer.getVolumen24Hs());
		cMer.setVolumen24Hs("+" + antVal * 1.05 + "%");
		repoCripMer.modificar(cMer.getSimbolo(), cMer);

		//// cambiar archivp mercado

		if (cantidad > 1000) {
			antVal = cm.getPrecioBase();
			cm.setPrecioBase(antVal * 1.1);
			listCriptoMoneda.set(indice, cm);

			// cambiar archivo cripto

		}

		return true;
	}

	public boolean realizarVenta(int cantDisp, int cantVender, String simbolo, RepoCriptoMercado repoCmerc) {

		if (cantDisp < cantVender)
			return false;

		int indiceMercado = repoCmerc.buscarXsimboloMercado(simbolo);
		CriptoMercado aux = repoCmerc.getCriptoMercadoIndice(indiceMercado);
		aux.setCapacidad(aux.getCapacidad() + cantVender);
		double auxDouble = aDouble(aux.getVariacion7Dias());
		String auxStr = "+" + auxDouble * 0.93 + "%";
		aux.setVariacion7Dias(auxStr);
		auxDouble = aDouble(aux.getVolumen24Hs());
		auxStr = auxDouble * 0.93 + "%";
		aux.setVolumen24Hs(auxStr);
		repoCmerc.modificar(aux.getSimbolo(), aux);

		return true;
	}

	public CriptoMoneda darRecomendacion(RepoCriptoMercado repoCmerc) {
		ArrayList<CriptoMoneda> aux = new ArrayList<CriptoMoneda>(listCriptoMoneda);
		aux.sort(new CompararXvalor(repoCmerc.getListCriptoMercado()));

		return aux.get(0);

	}

	public int encontrarXnombre(String nombre) {

		for (CriptoMoneda cm : listCriptoMoneda) {
			if (cm.getNombre().equals(nombre))

				return listCriptoMoneda.indexOf(cm);
		}

		return -1;
	}
	
	
	public CriptoMoneda getXSimbolo(String simbolo) {

		for (CriptoMoneda cm : listCriptoMoneda) {
			if (cm.getSimbolo().equals(simbolo))

				return cm;
		}

		return null;
	}

	public double aDouble(String str) {

		return Double.parseDouble(str.replaceAll("[+%]", ""));

	}

}
