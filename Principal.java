package banco;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Banco banco = new Banco();
	int op;
	
	do { 
		System.out.println("\n=====MENU PRINCIPAL=====");
		System.out.println("1 - Cadastrar Cliente e Abrir Conta");
		System.out.println("2 - Depositar");
		System.out.println("3 - Sacar");
		System.out.println("4 - Exibir Extrato de uma Conta");
		System.out.println("5 - Listar Todas as Contas e Clientes");
		System.out.println("6 - Transferência entre contas");
		System.out.println("0 - Sair");
		System.out.println("Escolha uma opção: ");
		
		if (sc.hasNextInt()) {
			op = sc.nextInt();
			sc.nextLine();
			} else {
				System.out.println("Opção inválida! Digite um número.");
				sc.nextLine();
				op = -1;
				continue;
			}
		
	switch(op) {
	
	case 1:
	    System.out.println("\n--- ABERTURA DE CONTA ---");
	    System.out.println("Nome do titular: ");
	    String nome = sc.nextLine();

	    System.out.println("CPF do Titular: ");
	    String cpf = sc.nextLine();

	    int idGerado = banco.cadastrarClientes(nome, cpf);

	    if (idGerado != -1) {
	        int numeroConta = banco.criarConta(idGerado);

	        System.out.println("\n>>> Conta aberta com sucesso!");
	        System.out.println(">>> Nome: " + nome);
	        System.out.println(">>> O NÚMERO DA SUA CONTA É: " + numeroConta);
	    } else {
	        System.out.println(">>> Não foi possível abrir a conta: CPF já cadastrado.");
	    }

	    break;
		
	case 2: 
		System.out.println("Digite o número da conta para depósito: ");
		int contaDep = sc.nextInt();
		System.out.println("Valor do depósito: R$ ");
		double valorDep = sc.nextDouble();
		
		if (banco.depositar(contaDep, valorDep)) {
			System.out.println("Depósito realizado com sucesso!");
		}
		else {
			System.out.println("Erro: Conta não encontrada ou valor inválido.");
		}
		break;
	
	case 3:
		System.out.println("Digite o número da conta para saque: ");
		int contaSaque = sc.nextInt();
		System.out.println("Valor do Saque: R$ ");
		double valorSaque = sc.nextDouble();	
		
		if(banco.sacar(contaSaque, valorSaque)) {
			System.out.println("Saque realizado com sucesso!");
		}
		else {
			System.out.println("Erro: Saldo insuficiente, conta não encontrada ou valor inválido.");
			
		}
		break;
	
	case 4: 
		System.out.println("Digite o número da conta para ver o extrato.");
		int contaExtrato = sc.nextInt();
		
		if(!banco.exibirExtrato(contaExtrato)) {
			System.out.println("Erro: Conta não encontrada.");
		}
		break;
	
	case 5:
		System.out.println("\n--- RELATÓRIO DO BANCO ---");
		banco.listarContas();
		banco.listarClientes();
		break;
	
	case 6:
	    System.out.println("\n--- TRANSFERÊNCIA ---");

	    System.out.println("Número da conta de origem: ");
	    int contaOrigem = sc.nextInt();

	    System.out.println("Número da conta de destino: ");
	    int contaDest = sc.nextInt();

	    System.out.println("Valor a transferir: R$ ");
	    double valorTransf = sc.nextDouble();

	    if (banco.transferir(contaOrigem, contaDest, valorTransf)) {
	        System.out.println("Transferência de R$ " + valorTransf + " realizada com sucesso!");
	    } else {
	        System.out.println("Não foi possível realizar a transferência. Verifique as contas, o valor e o saldo.");
	    }

	    break;
	
	case 0: 
		System.out.println("Encerrando o sistema.");
		break;
	default: 
		System.out.println("Opção inválida");
		break;
	
	}

} while (op != 0);

	
	
	
	
	
	
	
	
	
	
	
	}
	
}