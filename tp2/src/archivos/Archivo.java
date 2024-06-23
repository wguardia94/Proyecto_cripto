package archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Archivo {

	public static List<String> leer(String archivo) throws FileNotFoundException {
	List<String> registros = new ArrayList<>();
try {
	Scanner sc = new Scanner(new File(archivo));

		while (sc.hasNextLine()) {

			registros.add(sc.nextLine());
		}
		sc.close();
		
} catch (Exception e) {
	// TODO: handle exception
}
return registros;
	

	}

	public static void grabar(String linea) throws IOException {

		PrintWriter arch = new PrintWriter(new FileWriter("salida.out"));
		arch.println(linea);
		arch.close();

	}

}
