package tienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver para MySQL");
			return;
		}
		
		System.out.println("Se ha cargado el Driver de MySQL");
		String cadenaConexion = "jdbc:mysql://localhost:3306/tienda";
		String user = "root";
		String pass = ""; 
		Connection con;
		try {
			con = DriverManager.getConnection(cadenaConexion, user, pass);
		} catch (SQLException e) {
			System.out.println("Error en la conexi�n con la BD");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha establecido la conexi�n con la Base de datos");
		
		System.out.println("Lista de electrodom�sticos");
		System.out.println(" ");
		System.out.println("C�digo de producto - Nombre - Precio - Fecha de fabricaci�n - A�os de garant�a");
		
		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("select * from producto right join electrodomestico on producto.codigoProducto = electrodomestico.codigoProducto");
			while (rs.next()) {
				System.out.print(rs.getString("codigoProducto"));
				System.out.print(" - "); 
				System.out.print(rs.getString("nombre"));
				System.out.print(" - "); 
				System.out.print(rs.getString("precio"));
				System.out.print(" - "); 
				System.out.print(rs.getString("fechaFabricacion"));
				System.out.print(" - "); 
				System.out.print(rs.getString("anyosGarantia"));
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("Error al realizar el listado de productos");
			System.out.println(e.getMessage());
		}
		
		System.out.println(" ");
		System.out.println("Lista de comida");
		System.out.println(" ");
		System.out.println("C�digo de producto - Nombre - Precio sin IVA - Fecha de caducidad");
		
		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("select * from producto right join comida on producto.codigoProducto = comida.codigoProducto");
			while (rs.next()) {
				System.out.print(rs.getString("codigoProducto"));
				System.out.print(" - "); 
				System.out.print(rs.getString("nombre"));
				System.out.print(" - "); 
				System.out.print(rs.getString("precio"));
				System.out.print(" - "); 
				System.out.print(rs.getString("fechaCaducidad"));
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("Error al realizar el listado de productos");
			System.out.println(e.getMessage());
		}
		
		System.out.println(" ");
		System.out.println("Selecciona una opci�n");
		System.out.println(" ");
		System.out.println("1. A�adir productos");
		System.out.println("2. Quitar productos");
		System.out.println("3. Modificar productos");
		System.out.println("4. Salir");
		System.out.println("----------------------");
		
		
		
		
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("No se ha podido cerrar la conexi�n con la BD");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha cerrado la base de datos");
	}
}