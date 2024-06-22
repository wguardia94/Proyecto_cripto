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

	public boolean comprarCripto(int indice, RepoCriptoMercado repoCripMerc, RepoCriptoMoneda repoCripMoneda,
			int cantidad) {

		CriptoMoneda cmAnt = repoCripMoneda.getCriptoMonedaXindice(indice);
		repoCripMoneda.realizarCompra(repoCripMerc, cantidad, indice);
		setSaldo(getSaldo() - cantidad * cmAnt.getPrecioBase());

		/// actualizarHistorico

		repoHistUser.actualizar(cmAnt.getSimbolo(), cantidad);
		repoHistTr.actualizar(new HistoricoTransaccion(cmAnt.getSimbolo(), "Compra", cantidad));

		return true;
	}

	public boolean vender(int cantDisp, int cantVender, int indice, RepoCriptoMercado recoCmerc,
			RepoCriptoMoneda repoCmon) {
		CriptoMoneda aux = repoCmon.getCriptoMonedaXindice(indice);
		repoCmon.realizarVenta(cantDisp, cantVender, indice, recoCmerc);

		setSaldo(getSaldo() + cantVender + aux.getPrecioBase());

		repoHistUser.actualizar(aux.getSimbolo(), -cantVender);
		repoHistTr.actualizar(new HistoricoTransaccion(aux.getSimbolo(), "Venta", cantVender));

		//// actualizar archivos

		return true;
	}

	public String obtenerRecomendacion(RepoCriptoMercado repoCmerc, RepoCriptoMoneda repoCmon) {

		return "Recomendacion: " + repoCmon.darRecomendacion(repoCmerc).getNombre();

	}

	public ArrayList<HistoricoTransaccion> consultarHistorico() {

		
		 return repoHistTr.consultarHistorico();
		
		

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
