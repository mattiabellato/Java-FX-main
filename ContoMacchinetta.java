package application;

public class ContoMacchinetta {

	
	private String codice;
	
	private int credito;

	public ContoMacchinetta(String codice, int credito) {
		
		this.codice = codice;
		this.credito = credito;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public int getCredito() {
		return credito;
	}

	public void setCredito(int credito) {
		this.credito = credito;
	}
	

	
}