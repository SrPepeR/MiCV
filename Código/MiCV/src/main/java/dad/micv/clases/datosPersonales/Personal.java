package dad.micv.clases.datosPersonales;

import java.time.LocalDate;
import java.util.ArrayList;

public class Personal {
	
	private String identificacion;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private String direccion;
	private String codigoPostal;
	private String localidad;
	private String pais;
	private ArrayList<Nacionalidad> nacionalidades = new ArrayList<Nacionalidad>();
	
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
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
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public ArrayList<Nacionalidad> getNacionalidades() {
		return nacionalidades;
	}
	public void setNacionalidades(Nacionalidad nacionalidad) {
		this.nacionalidades.add(nacionalidad);
	}
	
	public Personal get() {
		return this;
	}
	
}
