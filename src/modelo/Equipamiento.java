package modelo;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import controlador.MantenimientoBP;
import vista.VistaMantenimientoBP;

public abstract class Equipamiento {
	//ATRIBUTOS
	private int id;
	
	//CONSTRUCTOR
	public Equipamiento(int id) {
		this.id = id;
	}

	//METODOS
	@Override
	public String toString() {
		return "Equipamiento [id=" + getId() + "]";
	}
	
	public static void agregarEquipamiento() {
		List<Edificio> listaEdificios = ConexionBD.EdificiosBDtoList();
		int posicion = Edificio.buscarEdificio();

		if(posicion==-1) {
			System.out.println("****Nro DE EDIFICIO NO EXISTE****\n");
			MantenimientoBP.controlMenuPrincipal();
		}else {
			int id = listaEdificios.get(posicion).getIdEdificio();
			try {
				int opcion = VistaMantenimientoBP.vistaMenuEquipos();
				switch(opcion) {
			case 1:  {  
				String marca = VistaMantenimientoBP.solicitarMarcaEquipo();
				String modelo = VistaMantenimientoBP.solicitarModeloEquipo();
				double capacidad = VistaMantenimientoBP.solicitarCapacidadEquipo();
				
				ConexionBD.insertarEquipamiento(id, "AA", marca, modelo, capacidad);
				
				System.out.println("***Aire Acondicionado AGREGADO***\n");
				MantenimientoBP.controlMenuPrincipal();
            break;
			}
			
			case 2:  {   
				String marca = VistaMantenimientoBP.solicitarMarcaEquipo();
				String modelo = VistaMantenimientoBP.solicitarModeloEquipo();
				double capacidad = VistaMantenimientoBP.solicitarCapacidadEquipo();
				
				ConexionBD.insertarEquipamiento(id, "GE", marca, modelo, capacidad);
				
				System.out.println("***Grupo Electrogeno AGREGADO***\n");
				MantenimientoBP.controlMenuPrincipal();
            break;
			}
			
			case 3:  {   
				String marca = VistaMantenimientoBP.solicitarMarcaEquipo();
				double capacidad = VistaMantenimientoBP.solicitarCapacidadEquipo();
				
				ConexionBD.insertarEquipamiento(id, "Solar", marca, "", capacidad);
				
				System.out.println("***Sistema de Energia Solar AGREGADO***\n");
				MantenimientoBP.controlMenuPrincipal();
            break;
			}
			
			case 4:  {   
				String marca = VistaMantenimientoBP.solicitarMarcaEquipo();
				double capacidad = VistaMantenimientoBP.solicitarCapacidadEquipo();
				
				ConexionBD.insertarEquipamiento(id, "Ascensor", marca, "", capacidad);
				
				System.out.println("***Ascensor AGREGADO***\n");
				MantenimientoBP.controlMenuPrincipal();
            break;
			}
			
			case 9:  {   
				MantenimientoBP.controlMenuPrincipal();
            break;
			}
			
			default: {
				System.out.println("\nOpcion incorrecta, por favor ingresar un numero valido!!!\n");
				MantenimientoBP.controlMenuPrincipal();
			}
			}
			}catch(InputMismatchException e) {
				System.out.println("\nEntrada no valida, por favor ingrese un numero.\n");
	            MantenimientoBP.controlMenuPrincipal();
			}
		}
	}
	
	public static void mostrarEquipamiento() {
		List<Edificio> listaEdificios = ConexionBD.EdificiosBDtoList();
		int posicion = Edificio.buscarEdificio();
		
		if(posicion==-1) {
			System.out.println("****Nro DE EDIFICIO NO EXISTE****\n");
			MantenimientoBP.controlMenuPrincipal();
		}else {
			List<Equipamiento> equipamiento = listaEdificios.get(posicion).getEquipamiento();
			for(Equipamiento e:equipamiento) {
				System.out.println(e.toString());
			}
			System.out.println("*********************************\n");
		}
	}

	public int getId() {
		return id;
	}
}
