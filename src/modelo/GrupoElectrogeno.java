package modelo;

public class GrupoElectrogeno extends Equipamiento{
	//ATRIBUTOS
	private String marca;
	private String modelo;
	private double capacidad;
	
	//CONSTRUCTOR
	public GrupoElectrogeno(int id, String marca, String modelo, double capacidad) {
		super(id);
		this.marca = marca;
		this.modelo = modelo;
		this.capacidad = capacidad;
	}

	//METODOS
	@Override
	public String toString() {
		return "GrupoElectrogeno [id="+getId()+", marca=" + marca + ", modelo=" + modelo + ", capacidad=" + capacidad + " KVA]";
	}

	
}
