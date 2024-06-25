package menus;

import java.io.IOException;
import java.util.Scanner;

import criptoMoneda.CriptoMercado;
import criptoMoneda.CriptoMoneda;
import historico.HistoricoUser;
import repositorios.RepoCriptoMercado;
import repositorios.RepoCriptoMoneda;
import users.User;

public class MenuTrader {
	private int numero;

	private User user;
	RepoCriptoMercado repoMer;
	RepoCriptoMoneda repoMon;

	public MenuTrader(User trader, RepoCriptoMercado repoMer, RepoCriptoMoneda repoMon) throws IOException {

		user = trader;
		user.setHistoricos();
		this.repoMer = repoMer;
		this.repoMon = repoMon;

		verMenu();

	}

	private void verMenu() throws IOException {
		Scanner entrada = new Scanner(System.in);

		do {
			System.out.println("Menú de opciones");
			System.out.println("-----------------------");
			System.out.println("\t1) Comprar Criptomonedas");
			System.out.println("\t2) Vender Criptomonedas");
			System.out.println("\t3) Consultar Criptomoneda");
			System.out.println("\t4) Recomendar Criptomonedas.");
			System.out.println("\t5) Consultar estado actual del mercado");
			System.out.println("\t6) Visualizar archivo de transacciones (histórico).");
			System.out.println("\t7) Salir");
			System.out.println("Ingrese su opción (1 - 7 )_");
			this.numero = entrada.nextInt();
			switch (this.numero) {
			case 1:
				System.out.println("Se está comprando cripto, saldo actual: "+user.getSaldo());
				comprarCripto();
				break;
			case 2:
				System.out.println("Se está vendiendo cripto");
				venderCripto();
				break;
			case 3:
				System.out.println("Se está consultando cripto");
				consultarCripto();
				break;
			case 4:
				System.out.println("Se está recomendando cripto");
				criptoRecomendada();
				break;
			case 5:
				System.out.println("Se está consultando estado del mercado");
				consultarMercado();
				break;
			case 6:
				System.out.println("Elarchivo de transacciones es:");
				verTransacciones();
				break;
			case 7:
				System.out.println("Saliendo del Programa Menu Trader");
				salir();
				break;
			default:
				System.out.println("El numero ingresado no es válido");
			}
		} while (this.numero != 7);

		entrada.close();
	}

	private void salir() throws IOException {
		user.cerrarSesion();
		repoMer.guardarArchivo();
		repoMon.guardarArchivo();

	}

	private void verTransacciones() {
		user.consultarHistorico();

	}

	private void consultarMercado() {
		user.verMercadoActual(repoMer);

	}

	private void criptoRecomendada() {
		System.out.println(user.obtenerRecomendacion(repoMer, repoMon));

	}

	private void consultarCripto() {
		int ind = 0, opcion;
		Scanner entrada = new Scanner(System.in);

		for (CriptoMoneda cm : repoMon.getListCriptoMoneda()) {
			System.out.println(ind + ")" + cm.getNombre());
			ind++;
		}

		System.out.println("Ingrese cual cripto moneda desea consultar");
		opcion = entrada.nextInt();
		entrada.nextLine();

		if (opcion >= 0 && opcion < ind + 1)
			System.out.println(user.consultarCripto(opcion, repoMer, repoMon));
		else
			System.out.println("Ingreso erroneo");

	}

	private void venderCripto() {
		int ind = 0, opcion, cantidad;
		Scanner entrada = new Scanner(System.in);
		System.out.println("Monedas para vender");
		for (HistoricoUser hU : user.getHistoricoUser()) {

			System.out.println(ind + ")" + hU.getSimbolo() + "stock: " + hU.getCantidad());
			ind++;

		}
		
		do {
			System.out.println("Seleccione moneda a vender");
			opcion = entrada.nextInt();
			entrada.nextLine();
		
		if(opcion<0||opcion>=ind) {
			System.out.println("Ingrese una opcion valida");
		}
		} while (opcion<0||opcion>=ind);
		
		
		
		
		System.out.println("Ingrese cantidad a vender");
		cantidad = entrada.nextInt();
		entrada.nextLine();

		if (user.vender(user.getHistoricoUser().get(opcion), cantidad, repoMer, repoMon))
			System.out.println("Se vendio exitosamente");
		else
			System.out.println("No se pudo realizar la venta");

	}

	private void comprarCripto() {
		int ind = 0, opcion;

		Scanner entrada = new Scanner(System.in);
		CriptoMercado cmerAux;
		CriptoMoneda cMonAux;
		for (CriptoMoneda cm : repoMon.getListCriptoMoneda()) {
			cmerAux = repoMer.getCriptoMercadoXsimbolo(cm.getSimbolo());
			System.out.println(ind + ")" + cm.toString() + ",Stock: " + cmerAux.getCapacidad());
			ind++;
		}
		
		
		do {
			System.out.println("Seleccione moneda a comprar ");
		opcion = entrada.nextInt();
		entrada.nextLine();
		
		if(opcion<0||opcion>=ind) {
			System.out.println("Ingrese una opcion valida");
		}
		} while (opcion<0||opcion>=ind);
		
		
		System.out.println("Ingrese cantidad a comprar");
		int cantidad = entrada.nextInt();
		entrada.nextLine();

		if (user.comprarCripto(opcion, repoMer, repoMon, cantidad))
			System.out.println("Se realizo la compra");
		else
			System.out.println("No se pudo realizar la compra");

	}
}