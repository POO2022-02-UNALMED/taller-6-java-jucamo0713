package vehiculos;

public class Automovil extends Vehiculo {
	public final static String plural = "Automoviles";
	private static int cantidadAutomoviles = 0;
	private int puestos;

	public Automovil() {
		this(null, null, 0,0,null,0);
	}

	public Automovil(String placa, String nombre, double precio, double peso,
			Fabricante fabricante, int puestos) {
		super(placa, 4, 100, nombre, precio, peso, "FWD", fabricante);
		this.puestos = puestos;
		Automovil.cantidadAutomoviles++;
	}

	public int getPuestos() {
		return puestos;
	}

	public void setPuestos(int puestos) {
		this.puestos = puestos;
	}

	public static int getCantidadAutomoviles() {
		return cantidadAutomoviles;
	}
	
}
