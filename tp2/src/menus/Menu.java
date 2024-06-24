package menus;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import repositorios.RepoCriptoMercado;
import repositorios.RepoCriptoMoneda;
import repositorios.RepoUsers;
import users.Administrador;
import users.Trader;
import users.User;

public class Menu {
	public String usuario;

	public int i = 0;
	public int salida = 0;
	public ArrayList<User> listaUser;
	public RepoCriptoMercado repoMer;
	public RepoCriptoMoneda repoMon;

	public Menu(RepoUsers repoUsers, RepoCriptoMoneda repoMon, RepoCriptoMercado repoMer) throws IOException {
		this.listaUser = repoUsers.getListUsers();
		this.repoMer = repoMer;
		this.repoMon = repoMon;
		mostrarMenuInicio();

	}

	public void mostrarMenuInicio() throws IOException {

		Scanner entradaMenu = new Scanner(System.in);
		System.out.println("Menú principal");
		System.out.println("-----------------------");
		System.out.println("Ingrese el Usuario");
		this.usuario = entradaMenu.nextLine();
		System.out.println("Su ingreso es: " + this.usuario);

		Administrador A1;
		for (; this.i < listaUser.size() && this.salida == 0; ++this.i) {
			PrintStream var10000 = System.out;
			Object var10001 = listaUser.get(this.i);
			var10000.println("por aca" + ((User) var10001).getNombre());
			
			if (this.usuario.compareTo(((User) listaUser.get(this.i)).getNombre()) == 0) {
				A1 = new Administrador(((User) listaUser.get(this.i)).getNombre(), "Administrador");
				System.out.println("evaluo" + A1.getNombre());
				if (((User) listaUser.get(this.i)).getClass().getSimpleName().equalsIgnoreCase("administrador")) {
					new MenuAdministrador(A1,repoMer,repoMon);
					this.salida = 1;
				} else {
					User trader=listaUser.get(this.i);
					new MenuTrader(trader,repoMer,repoMon);
					this.salida = 1;
				}
			}
		}

		if (this.salida == 0) {
			do {
				System.out.println("¿que desea crear?");
				System.out.println("1) Administrador");
				System.out.println("2) Trader");
				System.out.println("3) Salir");
				this.salida = entradaMenu.nextInt();
				switch (this.salida) {
				case 1:
					System.out.println("Crearemos un Administrador LLamado" + this.usuario);
					A1 = new Administrador(this.usuario, "Administrador");
					listaUser.add(A1);
					break;
				case 2:
					System.out.println("Crearemos un Trader");
					User T1 = new Trader(this.usuario, 6789, "Banco Nacion", 500500.0D);
					listaUser.add(T1);
					break;
				case 3:
					System.out.println("Saliendo del Menu");
					break;
				default:
					System.out.println("El numero ingresado no es válido");
				}
			} while (this.salida != 3);
		}

		System.out.println("Saliendo del Programa Menu");
		entradaMenu.close();

	}

}
