package vehiculos;

import java.util.ArrayList;

public class Pais {
	private String nombre;
	private static ArrayList<Pais> paises = new ArrayList<Pais>();
	private int ventas=0;
	public Pais(){
		this(null);
	}
	public Pais(String nombre) {
		this.nombre = nombre;
		Pais.paises.add(this);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVentas() {
		return ventas;
	}
	public void addVentas( int ventas) {
		this.ventas= this.ventas + ventas;
	}
	public void removeVentas( int ventas) {
		this.ventas= this.ventas - ventas;
	}
	public static Pais paisMasVendedor() {
		Pais max = null;
		int maxN = -1;
		for(int i =0; i< Pais.paises.size(); i++) {
			Pais pais = Pais.paises.get(i);
			if(pais.getVentas() >  maxN){
				max = pais;
				maxN = pais.getVentas();
			}
		}
		return max;
	}
}
