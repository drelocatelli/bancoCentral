package Model;

public class Saldo {

	private double saldo;

	public Saldo(double saldo) {
		super();
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return String.format("R$ %.2f", saldo);
	}


}
