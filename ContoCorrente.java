package application;

public class ContoCorrente {
	
	private int pin;
	
	private double saldo;

	public ContoCorrente(int pin, double saldo) {
		
		this.pin = pin;
		this.saldo = saldo;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "ContoCorrente [pin=" + pin + ", saldo=" + saldo + "]";
	}
	
	
	
	

	
	
	
	

}
