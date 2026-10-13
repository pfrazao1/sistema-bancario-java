package banco;

public class Conta {
	
	private int numero;
	private Cliente cliente;
	private double saldo;
	
	public Conta(int numero, Cliente cliente) {
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = 0;
	}

	
	
	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public Cliente getCliente() {
		return cliente;
	}


	public double getSaldo() {
		return saldo;
	}


	public boolean depositar(double valor) {
		if (!Double.isFinite(valor) || valor <= 0) {
			return false;
		}
		this.saldo += valor;
		return true;
	}
	public boolean sacar(double valor) {
		if (!Double.isFinite(valor) || valor <= 0 || valor > this.saldo) {
			return false;
		}
		this.saldo -= valor;
		return true;
	}
	public void extrato() {
		System.out.println("=====EXTRATO=====");
		System.out.println("Conta:" + numero);
		System.out.println("Titular: " + cliente.getNome());
		System.out.println("Saldo: R$" + this.saldo);
		System.out.println("==================");
	}
	
}
