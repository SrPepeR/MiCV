package dad.micv.clases.datosTitulo;

import java.time.LocalDate;

public class Titulo {
	
	private LocalDate desde;
	private LocalDate hasta;
	private String denominacion;
	private String organizador;
	
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
	public String getOrganizador() {
		return organizador;
	}
	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}
	
	public Titulo get() {
		return this;
	}
	
}
