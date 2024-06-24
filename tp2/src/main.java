import users.User;
import users.Administrador;
import users.Trader;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import archivos.Archivo;
import comparadores.CompararXvalor;
import criptoMoneda.CriptoMercado;
import criptoMoneda.CriptoMoneda;
import historico.HistoricoTransaccion;
import repositorios.RepoCriptoMercado;
import repositorios.RepoCriptoMoneda;
import repositorios.RepoUsers;



public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
User usuario;
		
RepoCriptoMercado repoMerc=new RepoCriptoMercado("mercados.csv");
RepoCriptoMoneda repoM=new RepoCriptoMoneda("criptomonedas.csv");
RepoUsers repoUsers=new RepoUsers("usuarios.csv");

		
		usuario=repoUsers.getUserxInd(0);
	//	usuario.setHistoricos();
		//usuario.consultarHistorico();
		
		
		//usuario=listUsers.get(2) ;
/*
	//System.out.println(usuario.consultarCripto(1, repoMerc, repoM)); ;
		usuario.darAlta(repoM, repoMerc, new CriptoMoneda("Doge", "DG", 3200));
		
	//usuario.modificarCripto(repoMerc, repoM, new CriptoMoneda("Bitcoin", "NewBTC", 3200), 0);
		usuario.eliminarCripto(repoMerc, repoM, 0);
		System.out.println(usuario.consultarCripto(0, repoMerc, repoM));
	
	*/
		
	//	usuario.comprarCripto(0, repoMerc, repoM, 10);
		//System.out.println(usuario);
		/*usuario=listUsers.get(2) ;
		usuario.verMercadoActual(repoMerc);
		*/
	//	usuario.vender(30, 10, 0, repoMerc, repoM);
	//	usuario.consultarHistorico();
		//System.out.println(usuario.obtenerRecomendacion(repoMerc, repoM));
		
		
		//Archivo arch=new Archivo();
		
		
	/*	List <String> lista=Archivo.leer("src/datos/criptomonedas.csv");
		
		for(String s:lista) {
			System.out.println(s);
		}*/
		
	//	System.out.println(repoM.getCriptoMonedaXindice(0));
		
	//	System.out.println(usuario.consultarCripto(0, repoMerc, repoM));
		
		
		
		
		
	}

}
