
import users.Administrador;
import users.Trader;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import archivos.Archivo;
import comparadores.CompararXvalor;
import criptoMoneda.CriptoMercado;
import criptoMoneda.CriptoMoneda;
import historico.HistoricoTransaccion;
import historico.HistoricoUser;
import repositorios.RepoCriptoMercado;
import repositorios.RepoCriptoMoneda;
import repositorios.RepoUsers;
import menus.Menu;


public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
RepoCriptoMercado repoMerc=new RepoCriptoMercado("mercados.csv");
RepoCriptoMoneda repoM=new RepoCriptoMoneda("criptomonedas.csv");
RepoUsers repoUsers=new RepoUsers("usuarios.csv");

		
Menu miMenu=new Menu(repoUsers,repoM,repoMerc);
		
	}

}
