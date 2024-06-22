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
		
		
		
		
		CriptoMoneda cm1=new CriptoMoneda("Bitcoin", "BTC", 1500);
		CriptoMoneda cm2=new CriptoMoneda("Ethereum", "ETH", 1000);
		
		ArrayList<CriptoMoneda>listCripMoneda=new ArrayList<CriptoMoneda>();
		listCripMoneda.add(cm1);
		listCripMoneda.add(cm2);
		
		CriptoMercado cmer1=new CriptoMercado("BTC", 300, "+30%", "+10%");
		CriptoMercado cmer2=new CriptoMercado("ETH", 400, "+20%", "+30%");
		
		ArrayList<CriptoMercado>listCripMercado=new ArrayList<CriptoMercado>();
		listCripMercado.add(cmer1);
		listCripMercado.add(cmer2);
		
		
		usuario=listUsers.get(0) ;
		//usuario.darAlta(listCripMercado,listCripMoneda,new CriptoMoneda("Tether","USDt",750));
//	System.out.println(usuario.consultarCripto(1, listCripMercado, listCripMoneda));
		
		/*String v="+100%";
		double num=Double.parseDouble(v.replaceAll("[+%]", ""));
		num=num*1.05;
		System.out.println(" numero: "+num);
		*/
		/*
		ArrayList<CriptoMoneda> aux=new ArrayList<CriptoMoneda>(listCripMoneda) ;
		
		aux.sort(new CompararXvalor());
		
		Collections.sort(listCripMoneda, new CompararXvalor());
		*/
		ArrayList<HistoricoTransaccion> aux=usuario.consultarHistorico();
		
		for (HistoricoTransaccion cm:aux) {
			System.out.println(cm);
			
		}
		
		
		
	}

}
