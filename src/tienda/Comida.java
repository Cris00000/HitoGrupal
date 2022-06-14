package tienda;

public class Comida extends Producto {

	private String fechaCaducidad;
	
	public Comida(String nombre, String codigoProducto, double precio, String fechaCaducidad) {
		super(nombre, codigoProducto, precio);
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	@Override
	public String toString() {
		return "Comida [fechaCaducidad=" + fechaCaducidad + "]";
	}
	
	public double precioIVA() {
		return this.precio*0.16;
	}

}
