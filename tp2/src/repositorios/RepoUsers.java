package repositorios;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import archivos.Archivo;
import users.Administrador;
import users.Trader;
import users.User;

public class RepoUsers {

	private ArrayList<User> listUsers;

	public RepoUsers(String nombreArch) throws FileNotFoundException {

		List<String> registros = Archivo.leer("src/datos/" + nombreArch);

		cargarLista(registros);


}

	
	
	
	
	public void cargarLista(List<String> registros) {
		listUsers = new ArrayList<User>();
		for (String reg : registros) {

			String[] div = reg.split(";");

			if (div[1].equals("administrador")) {
				listUsers.add(new Administrador(div[0], div[1]));

			} else {
				listUsers.add(new Trader(div[0], Integer.parseInt(div[1]), div[2], Double.parseDouble(div[3])));
			}

		}
	}
	
	public User getUserxInd(int ind) {
		
		
		return listUsers.get(ind);
	}
	
	 
	

}
