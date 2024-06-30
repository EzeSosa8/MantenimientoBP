package modelo;

public class Ascensor extends Equipamiento{
	//ATRIBUTOS
	private String marca;
	private double potenciaMotor;
	
	//CONSTRUCTOR
	public Ascensor(int id, String marca, double potenciaMotor) {
		super(id);
		this.marca = marca;
		this.potenciaMotor = potenciaMotor;
	}

	//METODOS
	@Override
	public String toString() {
		return "Ascensor [id="+getId()+", marca=" + marca + ", potenciaMotor=" + potenciaMotor + " HP]";
	}

	
}
