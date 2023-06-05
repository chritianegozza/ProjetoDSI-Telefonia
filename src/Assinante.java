

public class Assinante {

	protected Chamada[] chamadas;
	protected int numChamadas;
	private long cpf; 
	private String nome;
	private int numero;
	
	public Assinante(int numero, long cpf, String nome) {
		
		this.chamadas = new Chamada[100];
		this.cpf = cpf;
		this.nome = nome;
		this.numero = numero;
		}
	
	public long getCpf() {
		return this.cpf;
	}
	@Override
	public String toString() {
		return "Assinante [Nome:" + nome + ", Número:" + numero + ", CPF:" + cpf + "]";
	}
}
