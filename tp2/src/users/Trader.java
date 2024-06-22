package users;

import java.util.ArrayList;

import comparadores.CompararTransacciones;
import comparadores.CompararXvalor;
import criptoMoneda.CriptoMercado;
import criptoMoneda.CriptoMoneda;
import historico.HistoricoUser;
import repositorios.RepoCriptoMercado;
import repositorios.RepoCriptoMoneda;
import repositorios.RepoHistoricoTransaccion;
import repositorios.RepoHistoricoUser;
import historico.HistoricoTransaccion;

public class Trader extends User {

	public int nroCtaBancaria;
	public String nombreBanco;
	public double saldo;
	public ArrayList<HistoricoUser> listHistorico = new ArrayList<HistoricoUser>();
	public ArrayList<HistoricoTransaccion> listHistoricoTran = new ArrayList<HistoricoTransaccion>();
	public RepoHistoricoUser repoHistUser;
	public RepoHistoricoTransaccion repoHistTr;

	public Trader(String nombre, int nroCtaBancaria, String nombreBanco, double saldo) {
		super(nombre);
		this.nroCtaBancaria = nroCtaBancaria;
		this.nombreBanco = nombreBanco;
		this.saldo = saldo;

		repoHistTr = new RepoHistoricoTransaccion();
		repoHistUser = new RepoHistoricoUser();

		listHistorico.add(new HistoricoUser("BTC", 30));

		listHistoricoTran.add(new HistoricoTransaccion("BTC", "Compra", 45));
		listHistoricoTran.add(new HistoricoTransaccion("BTC", "Venta", 15));
		listHistoricoTran.add(new HistoricoTransaccion("DOGE", "Venta", 14));
	}

	
	
	
	
	public boolean comprarCripto(int indice, ArrayList<CriptoMercado> listCripMercado,
			ArrayList<CriptoMoneda> listCripMoneda, double cantidad) {
		CriptoMoneda cm = listCripMoneda.get(indice);

		int indMer = buscarXsimboloMercado(listCripMercado, cm.getSimbolo());
		CriptoMercado cMer = listCripMercado.get(indMer);
		cMer.setCapacidad(cMer.getCapacidad() - cantidad);

		double antVal = aDouble(cMer.getVariacion7Dias());
		cMer.setVariacion7Dias("+" + antVal * 1.05 + "%");
		antVal = aDouble(cMer.getVolumen24Hs());
		cMer.setVolumen24Hs("+" + antVal * 1.05 + "%");
		listCripMercado.set(indMer, cMer);

		//// cambiar archivp mercado

		setSaldo(getSaldo() - cantidad * cm.getPrecioBase());
		if (cantidad > 1000) {
			antVal = cm.getPrecioBase();
			cm.setPrecioBase(antVal * 1.1);
			listCripMoneda.set(indice, cm);

			// cambiar archivo cripto

		}

		return true;
	}

	public boolean vender(int cantDisp, int cantVender, int indice, ArrayList<CriptoMercado> listCripMercado,
			ArrayList<CriptoMoneda> listCripMoneda) {

		if (cantDisp < cantVender)
			return false;

		int indiceMercado = buscarXsimboloMercado(listCripMercado, listHistorico.get(indice).getSimbolo());
		CriptoMercado aux = listCripMercado.get(indiceMercado);
		aux.setCapacidad(aux.getCapacidad() + cantVender);
		double auxDouble = aDouble(aux.getVariacion7Dias());
		String auxStr = "+" + auxDouble * 0.93 + "%";
		aux.setVariacion7Dias(auxStr);
		auxDouble = aDouble(aux.getVolumen24Hs());
		auxStr = auxDouble * 0.93 + "%";
		aux.setVolumen24Hs(auxStr);
		listCripMercado.set(indiceMercado, aux);

		setSaldo(getSaldo() + cantVender + listCripMoneda.get(indice).getPrecioBase());

		actualizarHistorico(aux.getSimbolo(), -cantVender);
		actualizarHistTran(new HistoricoTransaccion(aux.getSimbolo(), "Venta", cantVender));

		//// actualizar archivos

		return true;
	}

	public void actualizarHistTran(HistoricoTransaccion newHt) {
		listHistoricoTran.add(newHt);

	}

	public void actualizarHistorico(String simbolo, int cantidad) {

		int ind = buscarHistorico(simbolo);
		if (ind == -1) {

			listHistorico.add(new HistoricoUser(simbolo, cantidad));
		} else {
			HistoricoUser hAnt = listHistorico.get(ind);
			hAnt.setCantidad(hAnt.getCantidad() + cantidad);
			listHistorico.set(ind, hAnt);
		}

		//// actualizar archivo historico

	}

	public String obtenerRecomendacion(ArrayList<CriptoMercado> listCripMercado,
			ArrayList<CriptoMoneda> listCripMoneda) {
		ArrayList<CriptoMoneda> aux = new ArrayList<CriptoMoneda>(listCripMoneda);
		aux.sort(new CompararXvalor());

		CriptoMoneda cm = aux.get(0);
		return "Recomendacion: " + cm.getNombre();

	}

	public ArrayList<HistoricoTransaccion> consultarHistorico() {

		ArrayList<HistoricoTransaccion> aux = new ArrayList<HistoricoTransaccion>(listHistoricoTran);

		aux.sort(new CompararTransacciones());

		return aux;

	}

	public int buscarHistorico(String simbolo) {

		for (HistoricoUser hu : listHistorico) {
			if (hu.getSimbolo().equals(simbolo))

				return listHistorico.indexOf(hu);
		}

		return -1;
	}

	public double aDouble(String str) {

		return Double.parseDouble(str.replaceAll("[+%]", ""));

	}

	public int buscarXsimboloMercado(ArrayList<CriptoMercado> listMercado, String simbolo) {

		for (CriptoMercado cm : listMercado) {
			if (cm.getSimbolo().equals(simbolo))

				return listMercado.indexOf(cm);
		}

		return -1;
	}

	public int getNroCtaBancaria() {
		return nroCtaBancaria;
	}

	public void setNroCtaBancaria(int nroCtaBancaria) {
		this.nroCtaBancaria = nroCtaBancaria;
	}

	public String getNombreBanco() {
		return nombreBanco;
	}

	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public boolean darAlta(RepoCriptoMoneda repoCm, RepoCriptoMercado repoCmerc, CriptoMoneda criptoMoneda) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarCripto(RepoCriptoMercado repoCmerc, RepoCriptoMoneda repoCmoneda, CriptoMoneda criptoMoneda,
			int indice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarCripto(RepoCriptoMercado repoCripMer, RepoCriptoMoneda repoCmon, int indice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String consultarCripto(int indice, RepoCriptoMercado repoCripMer, RepoCriptoMoneda repoCmon) {
		// TODO Auto-generated method stub
		return null;
	}

}
