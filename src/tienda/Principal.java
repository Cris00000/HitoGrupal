package tienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		int respuesta=0;
		
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
			System.out.println("Error en la conexión con la BD");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha establecido la conexión con la Base de datos");
		
		do {
		
		System.out.println("Lista de electrodomésticos");
		System.out.println(" ");
		System.out.println("Código de producto - Nombre - Precio - Fecha de fabricación - Años de garantía");
		
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
		System.out.println("Código de producto - Nombre - Precio sin IVA - Fecha de caducidad");
		
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
		System.out.println("Selecciona una opción");
		System.out.println(" ");
		System.out.println("1. Añadir productos");
		System.out.println("2. Quitar productos");
		System.out.println("3. Modificar productos");
		System.out.println("4. Salir");
		System.out.println("----------------------");
		
		respuesta= lector.nextInt();
		
		switch(respuesta) {
		case 1:
			System.out.println(" ");
			System.out.println("Has seleccionado añadir un producto");
			System.out.println(" ");
			System.out.println("Selecciona la categoría del producto");
			System.out.println("1. Comida");
			System.out.println("2. Electrodoméstico");
			int categoria=lector.nextInt();
			String basura=lector.nextLine();
			System.out.println("Inserta el codigo del producto");
			String codigoProducto= lector.nextLine();
			System.out.println("Inserta el nombre del producto");
			String nombre= lector.nextLine();
			System.out.println("Inserta el precio del producto");
			String precio= lector.nextLine();
			if(categoria==1) {
				System.out.println("Inserta la fecha de caducidad del producto");
				String fechaCaducidad= lector.nextLine();
				try {
					Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					ResultSet rs = sentencia.executeQuery("select * from producto");
					rs.moveToInsertRow(); 
					rs.updateString("codigoProducto", codigoProducto); 
					rs.updateString("nombre", nombre); 
					rs.updateString("precio", precio); 
					rs.insertRow();
					ResultSet rs2 = sentencia.executeQuery("select * from comida");
					rs2.moveToInsertRow(); 
					rs2.updateString("fechaCaducidad", fechaCaducidad);
					rs2.updateString("codigoProducto", codigoProducto); 
					rs2.insertRow();
					
				} catch (SQLException e) {
					System.out.println("Se ha producido un error");
					System.out.println(e.getMessage());
				}
			} else if(categoria==2) {
				System.out.println("Inserta la fecha de fabricación del producto");
				String fechaFabricacion= lector.nextLine();
				System.out.println("Inserta los años de garantía del producto");
				int anyosGarantia= lector.nextInt();
				basura=lector.nextLine();
				System.out.println("Inserta el material del motor");
				String material= lector.nextLine();
				System.out.println("Inserta la capacidad del motor");
				int capacidad= lector.nextInt();
				try {
					Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					ResultSet rs = sentencia.executeQuery("select * from producto");
					rs.moveToInsertRow(); 
					rs.updateString("codigoProducto", codigoProducto); 
					rs.updateString("nombre", nombre); 
					rs.updateString("precio", precio); 
					rs.insertRow();
					ResultSet rs2 = sentencia.executeQuery("select * from motor");
					rs2.moveToInsertRow(); 
					rs2.updateString("material", material); 
					rs2.updateInt("capacidad", capacidad);
					rs2.insertRow();
					ResultSet maxMotor=sentencia.executeQuery("select max(id) from motor");
					int idMotor = maxMotor.getInt(1);
					ResultSet rs3 = sentencia.executeQuery("select * from electrodomestico");
					rs3.moveToInsertRow(); 
					rs3.updateString("fechaFabricacion", fechaFabricacion); 
					rs3.updateInt("anyosGarantia", anyosGarantia);
					rs3.updateInt("motor", idMotor);
					rs3.updateString("codigoProducto", codigoProducto);
					rs3.insertRow();
				} catch (SQLException e) {
					System.out.println("Se ha producido un error");
					System.out.println(e.getMessage());
				}
			}
			break;
		case 2:
			System.out.println(" ");
			System.out.println("Has seleccionado quitar un producto");
			System.out.println(" ");
			System.out.println("Inserta el id del producto");
			basura=lector.nextLine();
			String idProducto=lector.nextLine();
			try {
				Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = sentencia.executeQuery("select * from comida where codigoProducto='"+idProducto+"'");
				boolean existe = rs.next();
				if (existe) {
					rs.deleteRow();
				}
				ResultSet rs2 = sentencia.executeQuery("select * from electrodomestico inner join motor on electrodomestico.motor=motor.id where codigoProducto='"+idProducto+"'");
				existe = rs2.next();
				if (existe) {
					rs2.deleteRow();
				}
				ResultSet rs3 = sentencia.executeQuery("select * from producto where codigoProducto='"+idProducto+"'");
				existe = rs3.next();
				if (existe) {
					rs3.deleteRow();
				}
				
				
			} catch (SQLException e) {
				System.out.println("Se ha producido un error");
				System.out.println(e.getMessage());
			}
			break;
		case 3:
			System.out.println(" ");
			System.out.println("Has seleccionado quitar un producto");
			System.out.println(" ");
			System.out.println("Inserta el id del producto");
			basura=lector.nextLine();
			idProducto=lector.nextLine();
			System.out.println(" ");
			System.out.println("Selecciona lo que quieres modificar");
			System.out.println("--------------------------");
			System.out.println("1. Nombre");
			System.out.println("2. Precio");
			System.out.println("--------------------------");
			int respuestaModificar=lector.nextInt();
			if(respuestaModificar==1) {
				System.out.println("Inserta un nombre nuevo");
				basura=lector.nextLine();
				String nombreNuevo=lector.nextLine();
				try {
					Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					ResultSet rs = sentencia.executeQuery("select * from producto where codigoProducto = '"+idProducto+"'");
					boolean existe = rs.next();
					if (existe) {
						rs.updateString("nombre", nombreNuevo);
						rs.updateRow();
					}
				} catch (SQLException e) {
					System.out.println("Se ha producido un error");
					System.out.println(e.getMessage());
				}
			}  else if(respuestaModificar==2) {
				System.out.println("Inserta un precio nuevo");
				Double precioNuevo=lector.nextDouble();
				try {
					Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					ResultSet rs = sentencia.executeQuery("select * from producto where codigoProducto = '"+idProducto+"'");
					boolean existe = rs.next();
					if (existe) {
						rs.updateDouble("precio", precioNuevo);
						rs.updateRow();
					}
				} catch (SQLException e) {
					System.out.println("Se ha producido un error");
					System.out.println(e.getMessage());
				}
			}
			
			break;
		case 4:
			break;
		default:
			System.out.println("Opción incorrecta. Inténtalo de nuevo");
		}
		
		
		} while (respuesta!=4);
		
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("No se ha podido cerrar la conexión con la BD");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Gracias por usar el programa");
	}
}
