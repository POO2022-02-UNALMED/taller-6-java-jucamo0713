package vehiculos;

public class Camioneta extends Vehiculo {
	public final static String plural = "Camionetas";
	private static int cantidadCamionetas = 0;
	private boolean volco;
	
	public Camioneta() {
		this(null,0,null,0,0,null,false);
	}

	public Camioneta(String placa, int puertas, String nombre, double precio, double peso,
			Fabricante fabricante, boolean volco) {
		super(placa, puertas, 90, nombre, precio, peso, "4X4", fabricante);
		this.volco= volco;
		Camioneta.cantidadCamionetas++;
	}

	public boolean isVolco() {
		return volco;
	}

	public void setVolco(boolean volco) {
		this.volco = volco;
	}

	public static int getCantidadCamionetas() {
		return cantidadCamionetas;
	}

}
