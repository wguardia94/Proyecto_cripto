package users;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

	public RepoHistoricoUser repoHistUser;
	public RepoHistoricoTransaccion repoHistTr;

	public Trader(String nombre, int nroCtaBancaria, String nombreBanco, double saldo) {
		super(nombre);
		this.nroCtaBancaria = nroCtaBancaria;
		this.nombreBanco = nombreBanco;
		this.saldo = saldo;

	
		// repoHistTr = new RepoHistoricoTransaccion();
		// repoHistUser = new RepoHistoricoUser();

	}



	public void setHistoricos() throws FileNotFoundException {
		repoHistTr = new RepoHistoricoTransaccion("src/datos/transacciones/" + nombre + "_transacciones.csv");
		repoHistUser = new RepoHistoricoUser("src/datos/historicos/" + nombre + "_historico.csv");

	}

	public boolean comprarCripto(int indice, RepoCriptoMercado repoCripMerc, RepoCriptoMoneda repoCripMoneda,
			int cantidad) {

		CriptoMoneda cmAnt = repoCripMoneda.getCriptoMonedaXindice(indice);
		
		if((saldo>=cantidad * cmAnt.getPrecioBase())&&repoCripMoneda.realizarCompra(repoCripMerc, cantidad, indice))
		
		{
		setSaldo(getSaldo() - cantidad * cmAnt.getPrecioBase());

		/// actualizarHistorico

		repoHistUser.actualizar(cmAnt.getSimbolo(), cantidad);
		repoHistTr.actualizar(new HistoricoTransaccion(cmAnt.getSimbolo(), "Compra", cantidad));

		return true;	
		}

		return false;
	}

	public boolean vender(HistoricoUser cmVender, int cantVender, RepoCriptoMercado recoCmerc,
			RepoCriptoMoneda repoCmon) {

		if (cantVender <= cmVender.getCantidad()) {

			CriptoMoneda aux = repoCmon.getXSimbolo(cmVender.getSimbolo());
			repoCmon.realizarVenta(cmVender.getCantidad(), cantVender, cmVender.getSimbolo(), recoCmerc);

			setSaldo(getSaldo() + cantVender * aux.getPrecioBase());

			repoHistUser.actualizar(aux.getSimbolo(), -cantVender);
			repoHistTr.actualizar(new HistoricoTransaccion(aux.getSimbolo(), "Venta", cantVender));

			return true;

		}

		return false;

	}

	public String obtenerRecomendacion(RepoCriptoMercado repoCmerc, RepoCriptoMoneda repoCmon) {

		return "Recomendacion: " + repoCmon.darRecomendacion(repoCmerc).getNombre();

	}

	public ArrayList<HistoricoTransaccion> consultarHistorico() {

		return repoHistTr.consultarHistorico();

	}

	public ArrayList<HistoricoUser> getHistoricoUser() {
		return repoHistUser.getListHistUser();
	}

	public void cerrarSesion() throws IOException {

		repoHistTr.guardarArchivo();
		repoHistUser.guardarArchivo();

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

		return repoCmon.infoCripto(indice, repoCripMer);

	}

	@Override
	public void verMercadoActual(RepoCriptoMercado repoCripMer) {
		for (CriptoMercado cMerc : repoCripMer.getListCriptoMercado()) {

			System.out.println(cMerc);
		}

	}

	@Override
	public String toCsvString() {

		return getNombre() + ";" + getNroCtaBancaria() + ";" + getNombreBanco() + ";" + getSaldo();
	}

}
