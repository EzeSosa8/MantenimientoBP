package vista;

import java.util.Scanner;

public class VistaMantenimientoBP {
	
	public static int vistaMenuPrincipal () {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("***********GESTION MANTENIMIENTO BP************");
		System.out.println("****Menu Principal****");
		System.out.println("1- Agregar Edificio");
		System.out.println("2- Lista de Edificios");
		System.out.println("3- Modificar Edificio (Nombre, Localidad y Direccion)");
		System.out.println("4- Agregar Equipamiento");
		System.out.println("5- Mostrar Equipamiento por Nro de Edificio");
		System.out.println("9- Salir");
		System.out.println("**********************************************");
		
		System.out.println("Elija una opcion: ");
		
		return scanner.nextInt();
	}
	
	public static int vistaMenuEquipos() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("***********TIPO DE EQUIPO************");
		System.out.println("1- Aire Acondicionado");
		System.out.println("2- Grupo Electrogeno");
		System.out.println("3- Sistema de Energia Solar");
		System.out.println("4- Ascensor");
		System.out.println("9- Volver");
		System.out.println("Ingrese la opcion que desea: ");
		
		return scanner.nextInt();
	}
	
	public static int solicitarIdEdificio() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingrese el numero de edificio: ");
		int id = scanner.nextInt();
		return id;
	}
	
	public static String solicitarNombreEdificio() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingrese el nombre del edificio: ");
		String nombre = scanner.next();
		return nombre;
	}
	
	public static String solicitarLocalidadEdificio() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese la localidad del edificio: ");
		String localidad = scanner.next();
		return localidad;
	}
	
	public static String solicitarDireccionEdificio() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese la direccion del edificio: ");
		String direccion = scanner.next();
		return direccion;
	}
	
	public static String solicitarMarcaEquipo() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese la marca del equipo: ");
		String marca = scanner.next();
		return marca;
	}
	
	public static String solicitarModeloEquipo() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese el modelo del equipo: ");
		String modelo = scanner.next();
		return modelo;
	}
	
	public static double solicitarCapacidadEquipo() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese la capacidad del equipo: ");
		double capacidad = scanner.nextDouble();
		return capacidad;
	}

}
