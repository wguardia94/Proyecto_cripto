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
import historico.HistoricoUser;
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

		
		usuario=repoUsers.getUserxInd(2);
		//usuario.darAlta(repoM, repoMerc, new CriptoMoneda("Doge", "DG", 3500));
		//usuario.modificarCripto(repoMerc, repoM, new CriptoMoneda("Doge", "NewDG", 200), 2);
		//usuario.eliminarCripto(repoMerc, repoM, 2);
		//System.out.println(usuario.consultarCripto(0, repoMerc, repoM));
		//usuario.verMercadoActual(repoMerc);
		usuario.setHistoricos();
		
		//usuario.comprarCripto(0, repoMerc, repoM, 10);
	//	usuario.vender(new HistoricoUser("BTC", 40), 10, repoMerc, repoM);
	//	System.out.println(	usuario.obtenerRecomendacion(repoMerc, repoM));
	
		
		
		//usuario.consultarHistorico();
			
			
		
		
		
		
		repoM.guardarArchivo();
		repoMerc.guardarArchivo();
		usuario.cerrarSesion();
repoUsers.guardarArchivo();
		
		
	}

}
