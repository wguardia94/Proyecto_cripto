package repositorios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import archivos.Archivo;
import criptoMoneda.CriptoMoneda;
import users.Administrador;
import users.Trader;
import users.User;

public class RepoUsers {

	public ArrayList<User> getListUsers() {
		return listUsers;
	}

	private ArrayList<User> listUsers;
private String pathFile;
	public RepoUsers(String nombreArch) throws FileNotFoundException {
pathFile="src/datos/" + nombreArch;
		List<String> registros = Archivo.leer(pathFile);

		cargarLista(registros);


}

public void guardarArchivo() throws IOException {
		
		Archivo.grabar(toCsvString(),pathFile);
			
		}



		public List<String> toCsvString() {
			List<String>registros=new ArrayList<String>();
			for (User u:listUsers) {
				registros.add(u.toCsvString());

			}

			return registros;
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
	
	public User getUserxNombre(String nombre) {

		for(User user:listUsers) {
			
			if(user.getNombre().equals(nombre))
			return user;
		}

		return null;
	}
	

}
