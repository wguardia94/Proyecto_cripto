package menus;

import java.io.IOException;

import java.util.Scanner;

import repositorios.RepoCriptoMercado;
import repositorios.RepoCriptoMoneda;
import repositorios.RepoUsers;
import users.Administrador;
import users.Trader;
import users.User;

public class Menu {
	public int salida = 0;
	public RepoCriptoMercado repoMer;
	public RepoCriptoMoneda repoMon;
	public RepoUsers repoUsers;

	public Menu(RepoUsers repoUsers, RepoCriptoMoneda repoMon, RepoCriptoMercado repoMer) throws IOException {
		this.repoUsers = repoUsers;
		this.repoMer = repoMer;
		this.repoMon = repoMon;
		

	}

	public void mostrarMenuInicio() throws IOException {
		String userName;
		Scanner entradaMenu = new Scanner(System.in);
		int opcion;

		System.out.println("Menú principal");
		System.out.println("-----------------------");
		System.out.println("Ingrese el Usuario");
		userName = entradaMenu.nextLine();
		System.out.println("El usuario ingresado es: " + userName);

		User user = repoUsers.getUserxNombre(userName);
		if (user != null) {

			if (user.getClass().getSimpleName().equalsIgnoreCase("administrador")) {
				new MenuAdministrador(user, repoMer, repoMon);

			} else {

				new MenuTrader(user, repoMer, repoMon);

			}

		}

		else {
			System.out.println("No se encontro el usuario, se creara uno con el nombre: "+userName);

			do {
				System.out.println("¿que tipo de usuario desea crear?");
				System.out.println("1) Administrador");
				System.out.println("2) Trader");
				System.out.println("3) Salir/no crear");
				opcion = entradaMenu.nextInt();
				entradaMenu.nextLine();
				switch (opcion) {
				case 1:
					System.out.println("Crearemos un Administrador");
					crearAdministrador(userName);
					opcion=3;//para salir luego de crear usuario
					break;
				case 2:
					System.out.println("Crearemos un Trader");
					crearTrader(userName);
					opcion=3;
					break;
				case 3:
					System.out.println("Saliendo del Menu");
					break;
				default:
					System.out.println("El numero ingresado no es válido");
				}
			} while (opcion != 3);
		}

		System.out.println("Saliendo del Programa Menu");
		repoUsers.guardarArchivo();
		entradaMenu.close();

	}

	private void crearTrader(String username) throws IOException {
		String nombreBanco;
		int nroCuenta;
		double saldo;
		Scanner entrada = new Scanner(System.in);
		/*System.out.println("Ingrese nombre del nuevo trader");
		nombreNew = entrada.nextLine();
*/
		System.out.println("Ingrese nombre del banco del nuevo trader");
		nombreBanco = entrada.nextLine();
		System.out.println("Ingrese nro de cuenta del nuevo trader");
		nroCuenta = entrada.nextInt();
		entrada.nextLine();
		System.out.println("Ingrese saldo del nuevo trader");
		saldo = entrada.nextDouble();
		entrada.nextLine();

		repoUsers.agregarUsuario(new Trader(username, nroCuenta, nombreBanco, saldo));
		System.out.println("Trader creado con exito");

	}

	private void crearAdministrador(String userName) throws IOException {
		/*Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese nombre del nuevo administrador");
		String nombreNew = entrada.nextLine();
*/
		repoUsers.agregarUsuario(new Administrador(userName, "administrador"));
		System.out.println("Administrador creado con exito");

	}

}
