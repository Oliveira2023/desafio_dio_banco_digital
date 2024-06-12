package desafio_dio_banco_digital;


public abstract class Conta implements Iconta {
	
	protected static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	private Cliente cliente;
	protected TipoConta tipoConta;
	
	
	public Conta(Cliente cliente, TipoConta tipoConta) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.tipoConta = tipoConta;
		
	}
	
	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	public String getCliente() {
		return cliente.getNome();
	}
	

	@Override
	public void depositar( double valor) {
				
		saldo += valor; 
		
	}

	@Override
	public void transferir(double valor) {
//		this.sacar(valor);
//		contaDestino.depositar(valor);
		sacar(valor);
		depositar(valor);
		
	}

	@Override
	public void sacar(double valor) {
		if(saldo>=valor) {
			saldo -= valor; 
		}else {
			System.out.println("Saldo Insuficiente");
		}
		 
		
	}
	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
