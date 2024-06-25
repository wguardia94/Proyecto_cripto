package menus;

import java.io.IOException;
import java.util.Scanner;

import criptoMoneda.CriptoMoneda;
import repositorios.RepoCriptoMercado;
import repositorios.RepoCriptoMoneda;
import users.Administrador;
import users.Trader;
import users.User;

public class MenuAdministrador {
	private int numero;
	private Administrador user;
	private RepoCriptoMercado repoMer;
	private RepoCriptoMoneda repoMon;

	public MenuAdministrador(Administrador user, RepoCriptoMercado repoMer, RepoCriptoMoneda repoMon)
			throws IOException {
		this.user = user;
		this.repoMer = repoMer;
		this.repoMon = repoMon;

		Scanner entrada = new Scanner(System.in);

		do {
			System.out.println("Menú de opciones");
			System.out.println("-----------------------");
			System.out.println("\t1) Crear Criptomoneda");
			System.out.println("\t2) Modificar Criptomoneda");
			System.out.println("\t3) Eliminar Criptomoneda");
			System.out.println("\t4) Consultar Criptomoneda");
			System.out.println("\t5) Consultar estado actual del mercado");
			System.out.println("\t6) Salir");
			System.out.println("Ingrese su opción (1 - 6 )_");
			this.numero = entrada.nextInt();
			entrada.nextLine();
			switch (this.numero) {
			case 1:
				System.out.println("Se está creando Criptomoneda");
				crearCriptoMoneda();
				break;
			case 2:
				System.out.println("Se está modificando Criptomoneda");
				modificarCriptoMoneda();
				break;
			case 3:
				System.out.println("Se está eliminando Criptomoneda");
				eliminarCriptoMoneda();
				break;
			case 4:
				System.out.println("Se está consultando Criptomoneda");
				consultarCriptoMoneda();
				break;
			case 5:
				System.out.println("Se está consultando estado del mercado");
				consultarMercado();
				break;
			case 6:
				System.out.println("Saliendo del Programa Menu Administrador");

				break;
			default:
				System.out.println("El numero ingresado no es válido");
			}
		} while (this.numero != 6);
		salir();
	}

	private void salir() throws IOException {
		user.cerrarSesion();
		repoMer.guardarArchivo();
		repoMon.guardarArchivo();

	}

	private void consultarMercado() {
		user.verMercadoActual(repoMer);

	}

	private void consultarCriptoMoneda() {

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

	private void eliminarCriptoMoneda() {
		int ind = 0, opcion;
		Scanner entrada = new Scanner(System.in);

		for (CriptoMoneda cm : repoMon.getListCriptoMoneda()) {
			System.out.println(ind + ")" + cm.toString());
			ind++;
		}

		System.out.println("Ingrese cual cripto moneda desea eliminar");
		opcion = entrada.nextInt();
		entrada.nextLine();

		if (opcion >= 0 && opcion < ind + 1) {
			if (user.eliminarCripto(repoMer, repoMon, opcion))
				;
			System.out.println("Se elimino la cripto moneda exitosamente");
		} else
			System.out.println("Ingreso erroneo");

	}

	private void modificarCriptoMoneda() {
		int ind = 0, opcion;
		double dAux;
		Scanner entrada = new Scanner(System.in);
		CriptoMoneda cmAux;
		String strAux;
		for (CriptoMoneda cm : repoMon.getListCriptoMoneda()) {
			System.out.println(ind + ")" + cm.toString());
			ind++;
		}

		System.out.println("Ingrese cual cripto moneda desea modificar");
		opcion = entrada.nextInt();

		if (opcion >= 0 && opcion< ind + 1) {
			cmAux = repoMon.getCriptoMonedaXindice(opcion);

			do {
				System.out.println("¿Que desea modificar?");

				System.out.println("1)Nombre");
				System.out.println("2)Simbolo");
				System.out.println("3)Precio");
				System.out.println("0)SALIR");
				opcion = entrada.nextInt();
				entrada.nextLine();
				switch (opcion) {
				case 1:
					System.out.println("Ingrese nuevo nombre");
					strAux = entrada.nextLine();
					cmAux.setNombre(strAux);
					break;
				case 2:
					System.out.println("Ingrese nuevo simbolo");
					strAux = entrada.nextLine();
					cmAux.setSimbolo(strAux);
					break;
				case 3:
					System.out.println("Ingrese nuevo precio");
					dAux = entrada.nextInt();
					entrada.nextLine();
					cmAux.setPrecioBase(dAux);
					break;
				case 0:
					break;
				default:
					System.out.println("La opcion ingresada no es válida");
				}

			} while (opcion != 0);

			user.modificarCripto(repoMer, repoMon, cmAux, opcion);

			System.out.println("Se modifico la cripto moneda exitosamente");
		} else
			System.out.println("Ingreso erroneo");

	}

	private void crearCriptoMoneda() {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Ingrese Nombre de nueva cripto moneda");
		String nombre = entrada.nextLine();

		System.out.println("Ingrese simbolo de nueva cripto moneda");
		String simbolo = entrada.nextLine();
		System.out.println("Ingrese Valor en dolares de nueva cripto moneda");
		double valor = entrada.nextDouble();
		entrada.nextLine();

		user.darAlta(repoMon, repoMer, new CriptoMoneda(nombre, simbolo, valor));
		System.out.println("Se creo la moneda exitosamente");

	}
}
