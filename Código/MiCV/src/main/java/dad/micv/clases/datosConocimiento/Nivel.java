package dad.micv.clases.datosConocimiento;

public enum Nivel {
	
	BASICO("Básico", 1),
	MEDIO("Medio", 2),
	AVANZADO("Avanzado", 3);
	
	private final int value;
	private final String text;
	
	private Nivel(final String newText, final int newValue) {
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
