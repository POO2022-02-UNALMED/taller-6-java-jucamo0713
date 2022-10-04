package vehiculos;

import java.util.ArrayList;

public class Vehiculo {
	private String placa;
	private int puertas;
	private double velocidadMaxima;
	private String nombre;
	private double precio;
	private double peso;
	private String traccion;
	private Fabricante fabricante;
	private static int CantidadVehiculos=0;
	private static ArrayList<Class<? extends Vehiculo>> childrens = new ArrayList<Class<? extends Vehiculo>>();
	public Vehiculo() {
		this(null,0,0,null,0,0,null,null);
	}
	public Vehiculo(String placa, int puertas, double velocidadMaxima, String nombre, double precio, double peso,
			String traccion, Fabricante fabricante) {
		this.placa = placa;
		this.puertas = puertas;
		this.velocidadMaxima = velocidadMaxima;
		this.nombre = nombre;
		this.precio = precio;
		this.peso = peso;
		this.traccion = traccion;
		this.setFabricante(fabricante);
		Vehiculo.CantidadVehiculos++;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getPuertas() {
		return puertas;
	}
	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}
	public double getVelocidadMaxima() {
		return velocidadMaxima;
	}
	public void setVelocidadMaxima(double velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getTraccion() {
		return traccion;
	}
	public void setTraccion(String traccion) {
		this.traccion = traccion;
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		if(this.fabricante != null) {
			this.fabricante.removeVentas(1);
		}
		this.fabricante = fabricante;
		if(fabricante != null) {
			fabricante.addVentas(1);
		}
		
	}
	public static int getCantidadVehiculos() {
		return CantidadVehiculos;
	}
	public static void setCantidadVehiculos(int cantidadVehiculos) {
		CantidadVehiculos = cantidadVehiculos;
	}
	public static String vehiculosPorTipo() {
		String response = "";
		for (int i = 0; i < Vehiculo.childrens.size(); i++) {
			Class<? extends Vehiculo> x = Vehiculo.childrens.get(i);
			try {
				String plural = (String) x.getField("plural").get(x);
				int total = (int) x.getDeclaredMethod("getCantidad" + plural).invoke(x);
				response += plural + ": " + total;
				if (i + 1 != Vehiculo.childrens.size()) {
					response += "\n";
				}
			} catch (Exception e) {
			}
		}
		return response;
	}
	static {
		Class<? extends Vehiculo> m = Automovil.class.asSubclass(Vehiculo.class);
		Vehiculo.childrens.add(m);
		Class<? extends Vehiculo> a = Camioneta.class.asSubclass(Vehiculo.class);
		Vehiculo.childrens.add(a);
		Class<? extends Vehiculo> r = Camion.class.asSubclass(Vehiculo.class);
		Vehiculo.childrens.add(r);
	}
}
