package dad.micv.clases.datosConocimiento;

public class Conocimiento extends Idioma {
	
	private String denominacion;
	private int nivel;
	private String nivelStr;
	
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel.get();
		this.nivelStr = nivel.getText();
	}
	public String getNivelStr() {
		return nivelStr;
	}
	
	public Conocimiento get() {
		return this;
	}
	
}
