package Model;

public class Pessoa {

    private String nome;
    private Saldo saldo = new Saldo(0);
    
	public Pessoa(String nome) {
		super();
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSaldo() {
		return saldo.getSaldo();
	}
	public void setSaldo(Saldo saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", saldo=" + saldo + "]";
	}

    
}
