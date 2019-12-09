package dad.micv.clases.datosContacto;

public class Telefono {
	
	private String numero;
	private int tipo;
	private String tipoStr;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(TipoTelefono tipo) {
		this.tipo = tipo.get();
		this.tipoStr = tipo.getText();
	}
	public String getTipoStr() {
		return tipoStr;
	}
	
}
