package menus;

import java.io.IOException;
import java.util.Scanner;

import criptoMoneda.CriptoMoneda;
import repositorios.RepoCriptoMercado;
import repositorios.RepoCriptoMoneda;
import users.Administrador;
import users.User;

public class MenuAdministrador {
   private int numero;
   private Administrador user;
private RepoCriptoMercado repoMer;
private RepoCriptoMoneda repoMon;
   public MenuAdministrador(Administrador user,RepoCriptoMercado repoMer, RepoCriptoMoneda repoMon) throws IOException {
     this.user=user;
	   this.repoMer=repoMer;
	   this.repoMon=repoMon;
	   
	   Scanner entrada = new Scanner(System.in);

      do {
         System.out.println("Menú de opciones");
         System.out.println("-----------------------");
         System.out.println("\t1) Crear Criptomoneda");
         System.out.println("\t2) Modificar Criptomoneda");
         System.out.println("\t3) Eliminar Criptomoneda");
         System.out.println("\t4) Consultar Criptomoneda");
         System.out.println("\t5) Consultar estado actual del mercado");
         System.out.println("\t6) Salir");
         System.out.println("Ingrese su opción (1 - 6 )_");
         this.numero = entrada.nextInt();
         switch(this.numero) {
         case 1:
            System.out.println("Se está creando Criptomoneda");
            crearCriptoMoneda();
            break;
         case 2:
            System.out.println("Se está modificando Criptomoneda");
            modificarCriptoMoneda();
            break;
         case 3:
            System.out.println("Se está eliminando Criptomoneda");
            eliminarCriptoMoneda();
            break;
         case 4:
            System.out.println("Se está consultando Criptomoneda");
            consultarCriptoMoneda();
            break;
         case 5:
            System.out.println("Se está consultando estado del mercado");
            consultarMercado();
            break;
         case 6:
            System.out.println("Saliendo del Programa Menu Administrador");
            
            break;
         default:
            System.out.println("El numero ingresado no es válido");
         }
      } while(this.numero != 6);
salir();
   }

private void salir() throws IOException {
	user.cerrarSesion();
	repoMer.guardarArchivo();
	repoMon.guardarArchivo();
	
}

private void consultarMercado() {
	user.verMercadoActual(repoMer);
	
}

private void consultarCriptoMoneda() {
	System.out.println(user.consultarCripto(0, repoMer, repoMon));
	
}

private void eliminarCriptoMoneda() {
	user.eliminarCripto(repoMer, repoMon, 2);
	
}

private void modificarCriptoMoneda() {
	user.modificarCripto(repoMer, repoMon, new CriptoMoneda("Doge", "NewDG", 200), 2);
	
}

private void crearCriptoMoneda() {
	user.darAlta(repoMon, repoMer, new CriptoMoneda("Doge", "DG", 3500));
	
}
}
