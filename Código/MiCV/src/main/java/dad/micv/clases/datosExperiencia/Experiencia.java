package dad.micv.clases.datosExperiencia;

import java.time.LocalDate;

public class Experiencia {
	
	private LocalDate desde;
	private LocalDate hasta;
	private String denominacion;
	private String empleador;
	
	public LocalDate getDesde() {
		return desde;
	}
	public void setDesde(LocalDate desde) {
		this.desde = desde;
	}
	public LocalDate getHasta() {
		return hasta;
	}
	public void setHasta(LocalDate hasta) {
		this.hasta = hasta;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	public String getEmpleador() {
		return empleador;
	}
	public void setEmpleador(String empleador) {
		this.empleador = empleador;
	}
	
	public Experiencia get() {
		return this;
	}
	
}
