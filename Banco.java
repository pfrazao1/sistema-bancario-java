package banco;

import java.util.ArrayList;

public class Banco {
	
	private ArrayList <Cliente> listaClientes;
	private ArrayList<Conta> listaContas;
	
	private int idCliente;
	private int numeroConta;
	
public Banco() {
	listaClientes = new ArrayList<Cliente>();
	listaContas = new ArrayList<Conta>();
	
	idCliente = 1;
	numeroConta = 1;
}

public int cadastrarClientes (String nome, String cpf) {
	for (Cliente cliente : listaClientes) {
		if(cliente.getCpf().equals(cpf)) {
			System.out.println("Erro: CPF já cadastrado!");
			return -1;
		}
	}
	
	Cliente cliente = new Cliente(idCliente, nome, cpf);
	listaClientes.add(cliente);
	idCliente++;
	
	return cliente.getId();	
}

public int criarConta(Cliente cliente) {
	Conta conta = new Conta(numeroConta, cliente);
	listaContas.add(conta);
	numeroConta++;
	return conta.getNumero();
}

public void listarClientes() {
	for (Cliente clienteAtual: listaClientes) {
		clienteAtual.mostrarDados();
	}
}

public void listarContas() {
	for(Conta contaAtual: listaContas) {
		contaAtual.extrato();
	}
}

private Cliente buscarCliente (int id) {
	for (Cliente clienteAtual: listaClientes) {
		if (clienteAtual.getId() == id) {
			return clienteAtual;
		}
	}
	return null;
}

private Conta buscarConta(int numero) {
	for (Conta contaAtual: listaContas) {
		if (contaAtual.getNumero() == numero) {
			return contaAtual;
		}
	}
	return null;
}

public int criarConta(int id) {
	Cliente cliente = buscarCliente(id);
	
	if (cliente == null) {
		return -1;
	}
	Conta conta = new Conta(numeroConta, cliente);
	listaContas.add(conta);
	numeroConta++;
	return conta.getNumero();
}
public boolean depositar(int numero, double valor) {
	Conta conta = buscarConta(numero);
		if (conta == null) {
			return false;
		}
		return conta.depositar(valor);
}
public boolean sacar(int numero, double valor) {
	Conta conta = buscarConta(numero);
		if (conta == null) {
			return false;
		}
		return conta.sacar(valor);
}

public boolean exibirExtrato (int numero) {
	Conta conta = buscarConta(numero);
		if (conta == null) {
			return false;
		}
		conta.extrato();	
		return true;
}

public boolean transferir(int contaOrigem, int contaDestino, double valor) {
	if (contaOrigem == contaDestino || valor <= 0) {
		return false;
	}

	if (sacar(contaOrigem, valor)) {
		if (depositar(contaDestino, valor)) {
			return true;
		} else {
			depositar (contaOrigem, valor);
			return false;
		}
	}
	return false;
}



}
