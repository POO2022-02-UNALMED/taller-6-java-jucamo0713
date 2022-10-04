package vehiculos;

import java.util.ArrayList;

public class Fabricante {
	private String nombre;
	private Pais pais;
	private int ventas = 0;
	private static ArrayList<Fabricante> fabricantes = new ArrayList<Fabricante>();
	public Fabricante() {
		this(null, null);
	}
	public Fabricante(String nombre, Pais pais) {
		this.nombre = nombre;
		this.pais = pais;
		Fabricante.fabricantes.add(this);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		if(this.pais != null) {
			this.pais.removeVentas(this.ventas);
		}
		this.pais = pais;
		if(pais != null) {
			pais.addVentas(this.ventas);
		}
	}
	public int getVentas() {
		return ventas;
	}
	public void addVentas(int ventas) {
		this.ventas = this.ventas+ ventas;
		if(this.pais != null) {
			this.pais.addVentas(ventas);
		}
	}
	public void removeVentas(int ventas) {
		this.ventas = this.ventas- ventas;
		if(this.pais != null) {
			this.pais.removeVentas(ventas);
		}
	}
	public static Fabricante fabricaMayorVentas() {
		Fabricante max = null;
		int maxN = -1;
		for(int i =0; i< Fabricante.fabricantes.size(); i++) {
			Fabricante fabricante = Fabricante.fabricantes.get(i);
			if(fabricante.getVentas() >  maxN){
				max = fabricante;
				maxN = fabricante.getVentas();
			}
		}
		return max;
	}
}
