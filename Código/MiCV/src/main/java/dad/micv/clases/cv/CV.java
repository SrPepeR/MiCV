package dad.micv.clases.cv;

import java.util.ArrayList;

import dad.micv.clases.datosContacto.Contacto;
import dad.micv.clases.datosExperiencia.Experiencia;
import dad.micv.clases.datosPersonales.Personal;

public class CV {
	
	private Personal personal;
	private Contacto contacto;
	private ArrayList<Experiencia> habilidades = new ArrayList<Experiencia>();
	private ArrayList<Experiencia> experiencias = new ArrayList<Experiencia>();
	private ArrayList<Experiencia> formacion = new ArrayList<Experiencia>();
	
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
	public ArrayList<Experiencia> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(Experiencia conocimiento) {
		this.habilidades.add(conocimiento);
	}
	public ArrayList<Experiencia> getEsperiencias() {
		return experiencias;
	}
	public void setEsperiencias(Experiencia esperiencia) {
		this.experiencias.add(esperiencia);
	}
	public ArrayList<Experiencia> getFormacion() {
		return formacion;
	}
	public void setFormacion(Experiencia titulo) {
		this.formacion.add(titulo);
	}
	
	public CV get() {
		return this;
	}
	
}
