import users.User;
import users.Administrador;
import users.Trader;

import java.util.ArrayList;
import java.util.Collections;

import comparadores.CompararXvalor;
import criptoMoneda.CriptoMercado;
import criptoMoneda.CriptoMoneda;
import historico.HistoricoTransaccion;
import repositorios.RepoCriptoMercado;
import repositorios.RepoCriptoMoneda;



public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
User usuario;
		
RepoCriptoMercado repoMerc=new RepoCriptoMercado();
RepoCriptoMoneda repoM=new RepoCriptoMoneda();
		
		User a1=new Administrador("admin1","administrador");
		User a2=new Administrador("admin2","administrador");

		User t1=new Trader("trader1", 12345,"Banco Nacion", 800000);
		User t2=new Trader("trader2", 6789,"Banco Nacion", 500500);	
		ArrayList<User>listUsers=new ArrayList<User>();
		listUsers.add(t1);
		listUsers.add(t2);
		listUsers.add(a1);
		listUsers.add(a2);

		usuario=listUsers.get(0) ;
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
		usuario.vender(30, 10, 0, repoMerc, repoM);
		usuario.consultarHistorico();
		System.out.println(usuario.obtenerRecomendacion(repoMerc, repoM));
	}

}
