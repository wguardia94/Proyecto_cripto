import users.User;
import users.Administrador;
import users.Trader;

import java.util.ArrayList;
import java.util.Collections;

import comparadores.CompararXvalor;
import criptoMoneda.CriptoMercado;
import criptoMoneda.CriptoMoneda;
import historico.HistoricoTransaccion;



public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
User usuario;
		
		
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

		
	}

}
