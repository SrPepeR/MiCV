package dad.micv.clases.datosContacto;

public enum TipoTelefono {
	DOMICILIO("Domicilio", 1),
	MOVIL("Movil", 2);
	
	private final int value;
	private final String text;
	
	private TipoTelefono(final String newText, final int newValue) {
		this.value = newValue;
		this.text = newText;
	}
	
	public int get() {
		return this.value;
	}
	
	public String getText() {
		return this.text;
	}
	
}
