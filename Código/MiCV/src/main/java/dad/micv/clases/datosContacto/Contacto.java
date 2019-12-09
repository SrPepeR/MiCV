package dad.micv.clases.datosContacto;

import java.util.ArrayList;

public class Contacto {
	
	private ArrayList<Telefono> telefonos = new ArrayList<Telefono>();
	private ArrayList<Email> emails = new ArrayList<Email>();
	private ArrayList<Web> webs = new ArrayList<Web>();
	
	public ArrayList<Telefono> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(Telefono telefono) {
		this.telefonos.add(telefono);
	}
	public ArrayList<Email> getEmails() {
		return emails;
	}
	public void setEmails(Email email) {
		this.emails.add(email);
	}
	public ArrayList<Web> getWebs() {
		return webs;
	}
	public void setWebs(Web web) {
		this.webs.add(web);
	}
	
	public Contacto get() {
		return this;
	}
	
}
