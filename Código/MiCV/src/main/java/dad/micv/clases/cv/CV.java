package dad.micv.clases.cv;

import java.util.ArrayList;

import dad.micv.clases.datosConocimiento.Conocimiento;
import dad.micv.clases.datosContacto.Contacto;
import dad.micv.clases.datosExperiencia.Experiencia;
import dad.micv.clases.datosPersonales.Personal;
import dad.micv.clases.datosTitulo.Titulo;

public class CV {
	
	private Personal personal;
	private Contacto contacto;
	private ArrayList<Conocimiento> habilidades = new ArrayList<Conocimiento>();
	private ArrayList<Experiencia> esperiencias = new ArrayList<Experiencia>();
	private ArrayList<Titulo> formacion = new ArrayList<Titulo>();
	
	public Personal getPersonal() {
		return personal;
	}
	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	public Contacto getContacto() {
		return contacto;
	}
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	public ArrayList<Conocimiento> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(Conocimiento conocimiento) {
		this.habilidades.add(conocimiento);
	}
	public ArrayList<Experiencia> getEsperiencias() {
		return esperiencias;
	}
	public void setEsperiencias(Experiencia esperiencia) {
		this.esperiencias.add(esperiencia);
	}
	public ArrayList<Titulo> getFormacion() {
		return formacion;
	}
	public void setFormacion(Titulo titulo) {
		this.formacion.add(titulo);
	}
	
	public CV get() {
		return this;
	}
	
}
