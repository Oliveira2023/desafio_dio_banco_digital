package desafio_dio_banco_digital;

public class ContaPoupanca extends Conta{
	

	public ContaPoupanca(Cliente cliente) {
		super(cliente, TipoConta.PP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupança ===");
		super.imprimirInfosComuns();
	}


}
