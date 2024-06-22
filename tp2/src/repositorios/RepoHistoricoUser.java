package repositorios;

import java.util.ArrayList;

import historico.HistoricoUser;

public class RepoHistoricoUser {

	
	
	private ArrayList<HistoricoUser> listHistUser;

	public RepoHistoricoUser() {
		listHistUser=new ArrayList<HistoricoUser>();
		
		listHistUser.add(new HistoricoUser("BTC", 30));
		
		
	}
	
}
