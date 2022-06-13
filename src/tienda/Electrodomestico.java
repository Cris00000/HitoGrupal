package tienda;

public class Electrodomestico {
	public String fechaFabricacion;
	public int anyosGarantia;
	private Motor motor;
	
	public Electrodomestico(String fechaFabricacion, int anyosGarantia, String material, double capacidad) {
		super();
		this.fechaFabricacion = fechaFabricacion;
		this.anyosGarantia = anyosGarantia;
		this.motor = new Motor(material, capacidad);
	}

	public String getFechaFabricacion() {
		return fechaFabricacion;
	}
		
	public void setFechaFabricacion(String fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}
	public int getAnyosGarantia() {
		return anyosGarantia;
	}
	public void setAnyosGarantia(int anyosGarantia) {
		this.anyosGarantia = anyosGarantia;
	}
	public Motor getMotor() {
		return motor;
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	@Override
	public String toString() {
		return "Electrodomestico [fechaFabricacion=" + fechaFabricacion + ", anyosGarantia=" + anyosGarantia
				+ ", motor=" + motor + "]";
	}
	
	
}
