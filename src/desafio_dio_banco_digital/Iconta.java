package desafio_dio_banco_digital;

public interface Iconta {

	void depositar(double valor);
	
	void transferir(double valor);

	void sacar(double valor);
	
	void imprimirExtrato();
}
