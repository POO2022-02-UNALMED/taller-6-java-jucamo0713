package vehiculos;

public class Camion extends Vehiculo {
	public final static String plural = "Camiones";
	private static int cantidadCamiones = 0;
	private int ejes;
	
	public Camion() {
		this(null, null, 0,0,null,0);
	}

	public Camion(String placa, String nombre, double precio, double peso,
			 Fabricante fabricante, int ejes) {
		super(placa, 2, 80, nombre, precio, peso, "4X2", fabricante);
		this.ejes = ejes;
		Camion.cantidadCamiones++;
	}

	public int getEjes() {
		return ejes;
	}

	public void setEjes(int ejes) {
		this.ejes = ejes;
	}

	public static int getCantidadCamiones() {
		return cantidadCamiones;
	}

}
