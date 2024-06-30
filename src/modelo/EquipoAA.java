package modelo;

public class EquipoAA extends Equipamiento {
	//ATRIBUTOS
	private String marca;
	private String modelo;
	private double capacidad;
	
	//CONSTRUCTOR
	public EquipoAA(int id, String marca, String modelo, double capacidad) {
		super(id);
		this.marca = marca;
		this.modelo = modelo;
		this.capacidad = capacidad;
	}

	//METODOS
	@Override
	public String toString() {
		return "EquipoAA [id="+getId()+", marca=" + marca + ", modelo=" + modelo + ", capacidad=" + capacidad + " frig/h]";
	}

	
}
