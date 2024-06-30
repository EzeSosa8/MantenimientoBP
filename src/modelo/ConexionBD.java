package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConexionBD {
	
	static Connection conexion;
	
	public static Connection conectar() {
		try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mantenimientoBP", "root", "");	
        } catch (SQLException e) {
        System.err.println("Error de conexion a la Base de Datos: " + e.getMessage());
        }
		
		return conexion;
	}
	
	public static void insertarEdificio(int id, String nombre, String localidad, String direccion) {
		try {
			Connection conexion = ConexionBD.conectar();
			String consultaSQL = "INSERT INTO edificio (id_edificio, nombre, localidad, direccion) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = conexion.prepareStatement(consultaSQL);
			statement.setInt(1, id);
			statement.setString(2, nombre);
			statement.setString(3, localidad);
			statement.setString(4, direccion);
			statement.executeUpdate();
			conexion.close();
			System.out.println("***NUEVO EDIFICIO AGREGADO***\n");
		}catch (SQLException e) {
	        System.err.println("Error al agregar a la Base de Datos: " + e.getMessage());
        }
	}
	
	public static void insertarEquipamiento(int id, String tipo, String marca, String modelo, double capacidad) {
		try {
			Connection conexion = ConexionBD.conectar();
			String consultaSQL = "INSERT INTO equipamiento (tipo, marca, modelo, capacidad, id_edificio) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = conexion.prepareStatement(consultaSQL);
			statement.setString(1, tipo);
			statement.setString(2, marca);
			statement.setString(3, modelo);
			statement.setDouble(4, capacidad);
			statement.setInt(5, id);
			statement.executeUpdate();
			conexion.close();
		}catch (SQLException e) {
	        System.err.println("Error al agregar a la Base de Datos: " + e.getMessage());
        }
	}
	
	public static List<Edificio> EdificiosBDtoList() {
		List<Edificio> listaEdificios = new ArrayList<Edificio>();
		try {
			Connection conexion = ConexionBD.conectar();
			String consultaSQL = "SELECT * FROM edificio";
			PreparedStatement statement = conexion.prepareStatement(consultaSQL);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
                int id = resultSet.getInt("id_edificio");
                String nombre = resultSet.getString("nombre");
                String localidad = resultSet.getString("localidad");
                String direccion = resultSet.getString("direccion");
                
                List<Equipamiento> equipamiento = EquipamientoBDtoList(id); 

                Edificio edificio = new Edificio(id, nombre, localidad, direccion, equipamiento);
                listaEdificios.add(edificio);
            }
			
			conexion.close();
			
		}catch (SQLException e) {
	        System.err.println("Error al agregar a la Base de Datos: " + e.getMessage());
        }
		
		return listaEdificios;
	}
	
	public static List<Equipamiento> EquipamientoBDtoList(int id_edificio) {
		List<Equipamiento> equipamiento = new ArrayList<Equipamiento>();
		try {
			Connection conexion = ConexionBD.conectar();
			
			//Agregar a la Lista Aire Acondicionado
			String consultaSQL = "SELECT * FROM equipamiento WHERE id_edificio=? and tipo='AA'";
			PreparedStatement statement = conexion.prepareStatement(consultaSQL);
			statement.setInt(1, id_edificio);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
                int id = resultSet.getInt("id_equipamiento");
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                Double capacidad = resultSet.getDouble("capacidad");
                Equipamiento equipo = new EquipoAA(id, marca, modelo, capacidad);
                equipamiento.add(equipo);
            }
			
			//Agregar a la Lista Ascensor
			consultaSQL = "SELECT * FROM equipamiento WHERE id_edificio=? and tipo='Ascensor'";
			statement = conexion.prepareStatement(consultaSQL);
			statement.setInt(1, id_edificio);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
                int id = resultSet.getInt("id_equipamiento");
                String marca = resultSet.getString("marca");
                Double capacidad = resultSet.getDouble("capacidad");

                Equipamiento equipo = new Ascensor(id, marca, capacidad);
                equipamiento.add(equipo);
            }
			
			//Agregar a la Lista Grupo Electrogeno
			consultaSQL = "SELECT * FROM equipamiento WHERE id_edificio=? and tipo='GE'";
			statement = conexion.prepareStatement(consultaSQL);
			statement.setInt(1, id_edificio);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
                int id = resultSet.getInt("id_equipamiento");
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                Double capacidad = resultSet.getDouble("capacidad");

                Equipamiento equipo = new GrupoElectrogeno(id, marca, modelo, capacidad);
                equipamiento.add(equipo);
            }
			
			//Agregar a la Lista Sistema Solar
			consultaSQL = "SELECT * FROM equipamiento WHERE id_edificio=? and tipo='Solar'";
			statement = conexion.prepareStatement(consultaSQL);
			statement.setInt(1, id_edificio);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
                int id = resultSet.getInt("id_equipamiento");
                String marca = resultSet.getString("marca");
                Double capacidad = resultSet.getDouble("capacidad");

                Equipamiento equipo = new SistemaSolar(id, marca, capacidad);
                equipamiento.add(equipo);
            }
			
			conexion.close();
			
		}catch (SQLException e) {
	        System.err.println("Error al agregar a la Base de Datos: " + e.getMessage());
        }
		
		return equipamiento;
	}

	public static void modificarEdificio(int id, String nombre, String localidad, String direccion) {
		try {
			Connection conexion = ConexionBD.conectar();
			String consultaSQL = "UPDATE edificio SET nombre=?, localidad=?, direccion=? WHERE id_edificio=?";
			PreparedStatement statement = conexion.prepareStatement(consultaSQL);
			statement.setString(1, nombre);
			statement.setString(2, localidad);
			statement.setString(3, direccion);
			statement.setInt(4, id);
			statement.executeUpdate();
			conexion.close();
			System.out.println("***EDIFICIO MODIFICADO***\n");
		}catch (SQLException e) {
	        System.err.println("Error al modificar en la Base de Datos: " + e.getMessage());
        }
	}
	
}
