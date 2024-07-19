package application;


import java.util.ArrayList;

public class Bancomat {
    private ArrayList<ContoCorrente> conti;

    public Bancomat() {
        conti = new ArrayList<>();
    }

    public void aggiungiConto(ContoCorrente conto) {
        conti.add(conto);
    }

    public boolean check(int pin) {
    	boolean check1 = false;
    	for(int i=0; i<conti.size(); i++) {
    		if (conti.get(i).getPin() == pin) {
    			check1 = true;
    			i=conti.size()+1;
    	}
    	}
    		return check1;
    	}
    public double saldo(int pin) {
    	double saldo = -1;
    	for(int i=0; i<conti.size(); i++) {
    		if (conti.get(i).getPin() == pin) {
    			saldo = conti.get(i).getSaldo();
    			i=conti.size()+1;
    	}
    	}
    		return saldo;
    	}
    
    	public boolean preleva(int pin, double importo) {
    		
    			for(int i=0; i<conti.size(); i++) {
    				if (conti.get(i).getPin() == pin) {
    					if (conti.get(i).getSaldo() >= importo) {
    					conti.get(i).setSaldo(conti.get(i).getSaldo()-importo);
    					i=conti.size()+1;
    					
    					return true;
    				}
    					
    				
    		}
    	}	
    			return false;
    			
    	}

    	public void versa(int pin, double importo) {
    		
    		for(int i=0; i<conti.size(); i++) {
				if (conti.get(i).getPin() == pin) {
					conti.get(i).setSaldo(conti.get(i).getSaldo()+importo);
					i=conti.size()+1;
				}
			}
    	}
    	public ArrayList<ContoCorrente> getConti() {
			return conti;
		}
    	
}

