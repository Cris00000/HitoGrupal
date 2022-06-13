package tienda;

public class Motor {
	public String material;
	public double capacidad;
	
	// getter & setter
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public double getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}

	//Metodos
	@Override
	public String toString() {
		return "Motor: [material=" + material + ", capacidad=" + capacidad + "]";
	}
	
	
}
