package controlador;

import java.util.InputMismatchException;

import modelo.Edificio;
import modelo.Equipamiento;
import vista.VistaMantenimientoBP;

public class MantenimientoBP {
	//MAIN
	public static void main(String[] args) {
		controlMenuPrincipal();
	}
	
	//METODOS
	public static void controlMenuPrincipal() {

		try {
			int opcion = VistaMantenimientoBP.vistaMenuPrincipal();
			
			switch(opcion) {
				case 1:  {   
					Edificio.agregarEdificio();
					controlMenuPrincipal();
	            break;
				}
				
				case 2:  {   
					Edificio.listadoEdificios();
					controlMenuPrincipal();
	            break;
				}
				
				case 3:  {   
					Edificio.modificarEdificio();
					controlMenuPrincipal();
	            break;
				}
				
				case 4:  {   
					Equipamiento.agregarEquipamiento();
					controlMenuPrincipal();
	            break;
				}
				
				case 5:  {   
					Equipamiento.mostrarEquipamiento();
					controlMenuPrincipal();
	            break;
				}
				
				case 9:  {   
					System.out.println("\n***PROGRAMA FINALIZADO***");
					System.exit(0);
	            break;
				}
				
				default: {
					System.out.println("\nOpcion incorrecta, por favor ingresar un numero valido!!!\n");
					controlMenuPrincipal();
				}
			}
		}catch(InputMismatchException e) {
			System.out.println("\nEntrada no valida, por favor ingrese un número.\n");
            controlMenuPrincipal();
		}
	}
}
