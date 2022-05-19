package tienda;

public class Persona {
 private String nombre;
 private String apellidos;
 private String correo;
 private String dni;
 private String ciudad;
 
public Persona(String nombre, String apellidos, String correo, String dni, String ciudad) {
	super();
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.correo = correo;
	this.dni = dni;
	this.ciudad = ciudad;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellidos() {
	return apellidos;
}

public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}

public String getCorreo() {
	return correo;
}

public void setCorreo(String correo) {
	this.correo = correo;
}

public String getDni() {
	return dni;
}

public void setDni(String dni) {
	this.dni = dni;
}

public String getCiudad() {
	return ciudad;
}

public void setCiudad(String ciudad) {
	this.ciudad = ciudad;
}
 
 
}
