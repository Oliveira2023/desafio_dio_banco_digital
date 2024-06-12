package desafio_dio_banco_digital;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

	public static void main(String[] args) {
		
		Banco digital = new Banco();
		
		Cliente Luciano = new Cliente();
		Luciano.setNome("Luciano");
		
		Cliente Carla = new Cliente();
		Carla.setNome("Carla");
		
		Cliente Jose = new Cliente();
		Jose.setNome("José");
		
		Conta ccL = new ContaCorrente(Luciano);
		Conta poupancaL = new ContaPoupanca(Luciano);
		
		Conta ccC = new ContaCorrente(Carla);
		Conta poupancaC = new ContaPoupanca(Carla);
		
		Conta ccJ = new ContaCorrente(Jose);
		Conta poupancaJ = new ContaPoupanca(Jose);
		
		List<Conta> contasAdicionar = new ArrayList<>();
		contasAdicionar.add(ccL);
		contasAdicionar.add(ccC);
		contasAdicionar.add(ccJ);
		contasAdicionar.add(poupancaL);
		contasAdicionar.add(poupancaC);
		contasAdicionar.add(poupancaJ);
		
		digital.setContas(contasAdicionar);
		
		Scanner sc = new Scanner(System.in);
		final boolean[] sair = {false};
		AtomicInteger tentativas = new AtomicInteger(0);
		final boolean[] nomeValido = {false};
		final String[] usuarioAtual = {""};
		
		if(!nomeValido[0]) {
			while(tentativas.get()<3) {
				System.out.println("Entre com nome da sua conta:");
				String nomeCliente = sc.next();
				digital.getContas().forEach(conta -> {
					if(conta.getCliente().equals(nomeCliente)) {
						System.out.println("conta do cliente: ");
						System.out.println(conta.numero + "-" + conta.tipoConta);
						nomeValido[0] = true;
						tentativas.set(3);
						usuarioAtual[0] = nomeCliente; 
					}
					
				});
				tentativas.incrementAndGet();

				
		}
		}
		if(nomeValido[0]) {
			while(!sair[0]) {
				
	            System.out.println("1. Depositar");
	            System.out.println("2. Sacar");
	            System.out.println("3. Consultar saldo");
	            System.out.println("4. Transferir");
	            System.out.println("0. Encerrar");
	            
	            int opcao = sc.nextInt();
	            
	            switch (opcao) {
	            
	            case 1 -> {
	            	System.out.println("Digite o numero da conta:");
	            	int numeroConta = sc.nextInt();
	            	System.out.println("Digite o valor do depósito:");
	            	double valorDeposito = sc.nextDouble();
	            	
	            	digital.getContas().forEach(conta -> {
	            		if(conta.getNumero() == numeroConta) {
	            			conta.depositar(valorDeposito);
	            		}
	            	});
	            	
	            	break;
	            }
	            case 2 -> {
	            	System.out.println("case sacar");
	            	System.out.println("Digite o numero da conta:");
	            	int numeroConta = sc.nextInt();
	            	System.out.println("Digite o valor do saque:");
	            	double valorSaque = sc.nextDouble();
	            	
	            	digital.getContas().forEach(conta -> {
	            		if(conta.getNumero() == numeroConta) {
	            			conta.sacar(valorSaque);
	            		}
	            	});
	            	break;
	            }
	            case 3 -> {
	            	// extratos
	            	digital.getContas().forEach(conta -> {
	            		if(conta.getCliente().equals(usuarioAtual[0])) {
	            			conta.imprimirExtrato();
	            		}
	            	});
	            	break;
	            }
	            case 4 -> {
	            	//Transferencia
	            	System.out.println("Transferência");
	            	System.out.println("Digite o numero da conta de destino:");
	            	int contaDestino = sc.nextInt();
	            	System.out.println("Digite o valor da transferência:");
	            	double valorTransf = sc.nextDouble();
	            	
	            	
	            	digital.getContas().forEach(conta -> {

	            		if(conta.getCliente().equals(usuarioAtual[0]) && conta.tipoConta == TipoConta.CC) {
	            			conta.sacar(valorTransf);
	            			System.out.println(usuarioAtual);
	            			digital.getContas().forEach(contaT -> {
	            				if(contaT.getNumero() == contaDestino) {
	            					contaT.depositar(valorTransf);
	            					contaT.imprimirExtrato();
	            				}
	            			});

	            		}
	            		
	            	});
	            }
	            case 0 -> {
	            	System.out.println("Você Saiu!");
	            	sair[0] = true;
	            	break;
	            }
	            default -> System.out.println("Opção Inválida!");
	            
	            }
				}
		}

			sc.close();

		}
	
	
}
