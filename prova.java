package application;

public class prova {

	public static void main(String[] args) {
		
		
		ContoCorrente c1 = new ContoCorrente(1234, 50000);
		
		Bancomat b1 = new Bancomat();
		
		b1.aggiungiConto(c1);
		
		b1.preleva(1234, 5000);
		
		//System.out.println(b1.getConti().get(0));
		
		
		
	}

}
