package modelo;

import java.util.List;
import java.util.Scanner;

import controlador.MantenimientoBP;
import vista.VistaMantenimientoBP;

public class Edificio {
	//ATRIBUTOS
		private int id;
		private String nombre;
		private String localidad;
		private String direccion;
		private List<Equipamiento> equipamiento;
		
		//CONSTRUCTOR
		public Edificio(int id, String nombre, String localidad, String direccion, List<Equipamiento> equipamiento) {
			this.id = id;
			this.nombre = nombre;
			this.localidad = localidad;
			this.direccion = direccion;
			this.equipamiento = equipamiento;
		}
		
		//METODOS
		public String mostrarEdificios() {
			return("Edificio Nro: " +id+ " ("+ nombre + ") - Localidad: " + localidad + " - Direccion: " + direccion);
		}
		
		public static void agregarEdificio() {
			
			int id = VistaMantenimientoBP.solicitarIdEdificio();
			String nombre = VistaMantenimientoBP.solicitarNombreEdificio();
			String localidad = VistaMantenimientoBP.solicitarLocalidadEdificio();
			String direccion = VistaMantenimientoBP.solicitarDireccionEdificio();
			
			ConexionBD.insertarEdificio(id, nombre, localidad, direccion);

		}
		
		public static int buscarEdificio() {
			Scanner scanner = new Scanner(System.in);
			List<Edificio> listaEdificios = ConexionBD.EdificiosBDtoList();
			Edificio auxiliar[] = new Edificio[listaEdificios.size()];
			listaEdificios.toArray(auxiliar);
			int posicion = -1;
			
			listadoEdificios();

			System.out.println("\n***Ingrese numero de edificio que desea (-1 para volver a Menu Principal): ");
			int id = scanner.nextInt();
			
			for(int i=0; i<auxiliar.length; i++) {
				if(auxiliar[i].getIdEdificio()==id) {
					posicion = i;
				}
			}
			return posicion;
		}
		
		public static void modificarEdificio() {

			List<Edificio> listaEdificios = ConexionBD.EdificiosBDtoList();
			int posicion = buscarEdificio();
			
			if(posicion==-1) {
				System.out.println("****Nro DE EDIFICIO NO EXISTE****\n");
				MantenimientoBP.controlMenuPrincipal();
			}else {
				int id = listaEdificios.get(posicion).getIdEdificio();
				String nombre = VistaMantenimientoBP.solicitarNombreEdificio();
				String localidad = VistaMantenimientoBP.solicitarLocalidadEdificio();
				String direccion = VistaMantenimientoBP.solicitarDireccionEdificio();
				
				ConexionBD.modificarEdificio(id, nombre, localidad, direccion);

			}
		}
		
		public static void listadoEdificios() {
			List<Edificio> listaEdificios = ConexionBD.EdificiosBDtoList();
			System.out.println("\n****LISTADO DE EDIFICIOS****");
			for(Edificio e:listaEdificios) {
				System.out.println(e.mostrarEdificios());
			}
			System.out.println("***************************\n");
		}
		
		public int getIdEdificio() {
			return id;
		}
		
		public String getNombreEdificio() {
			return nombre;
		}
		
		public String getLocalidadEdificio() {
			return localidad;
		}
		
		public String getDireccionEdificio() {
			return direccion;
		}
		
		public List<Equipamiento> getEquipamiento(){
			return equipamiento;
		}
}
