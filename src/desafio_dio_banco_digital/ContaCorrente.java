package desafio_dio_banco_digital;

public class ContaCorrente extends Conta{

	
	
	public ContaCorrente(Cliente cliente) {
		super(cliente, TipoConta.CC);

	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}
	
	
}
