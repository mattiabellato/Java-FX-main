package application;

import java.util.ArrayList;

public class Distributore {

	
	ArrayList <ContoMacchinetta> lista;
	
	public Distributore() {
		
		lista = new ArrayList<>();
	}
	
	
	public void addConto(ContoMacchinetta c1) {
		
		lista.add(c1);
	}
	
	public boolean check(String codice) {
		boolean ok = false;
		
for (ContoMacchinetta c1: lista) {
			
			if (c1.getCodice().equals(codice) ) {
				
				ok = true;
			}}

 return ok;
		
	}
	
	
	
	public void erogaCoffe(String codice) {
		
		for (ContoMacchinetta c1: lista) {
			
			if (c1.getCodice().equals(codice) ) {
				
				if (c1.getCredito() >= 2) {
					
					int newCredito = c1.getCredito();
					
					c1.setCredito(newCredito - 2);
				}
			}
			
			
		}
	}
	
public void erogaThe(String codice) {
		
	for (ContoMacchinetta c1: lista) {
		
		if (c1.getCodice().equals(codice) ) {
			
			if (c1.getCredito() >= 3) {
				
				int newCredito = c1.getCredito();
				
				c1.setCredito(newCredito - 3);
			}
		}
		
		
	}
	}

public void erogaAcqua(String codice) {
	
	for (ContoMacchinetta c1: lista) {
		
		if (c1.getCodice().equals(codice) ) {
			
			if (c1.getCredito() >= 1) {
				
				int newCredito = c1.getCredito();
				
				c1.setCredito(newCredito - 1);
			}
		}
		
		
	}
	}

public int getCredito(String codice) {
	
	int credito = 0;
	
for (ContoMacchinetta c1: lista) {
		
		if (c1.getCodice().equals(codice) ) {
			
			credito = c1.getCredito();
		}
	
	
}

return credito;
}
}