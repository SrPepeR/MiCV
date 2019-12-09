package dad.micv.clases.datosConocimiento;

public enum Nivel {
	
	BASICO(1),
	MEDIO(2),
	AVANZADO(3);
	
	private final int value;
	
	private Nivel(final int newValue) {
		this.value = newValue;
	}
	
	public int get() {
		return this.value;
	}
	
}
