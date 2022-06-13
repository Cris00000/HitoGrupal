package tienda;

import javax.swing.JFrame;

public class Principal {
	private static JFrame ventana;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		crearVentana();
		
	

	}
	
	public static void crearVentana() {
		ventana = new JFrame("Ventana Producto");
		ventana.setSize(500,500);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
	
	

}
