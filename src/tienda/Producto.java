package tienda;

public class Producto {
	protected String nombre;
	protected String codigoProducto;
	protected double precio;
	public Producto(String nombre, String codigoProducto, double precio) {
		super();
		this.nombre = nombre;
		this.codigoProducto = codigoProducto;
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", codigoProducto=" + codigoProducto + ", precio=" + precio + "]";
	}
	
	public double precioIVA() {
		return this.precio*0.21;
	}
}
