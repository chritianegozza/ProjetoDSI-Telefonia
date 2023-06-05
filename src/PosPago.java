import java.util.Date;
import java.text.DecimalFormat;

public class PosPago extends Assinante{
	protected float assinatura;
	

	public PosPago(int numero, long cpf, String nome, float assinatura) {
		super(numero, cpf, nome);
		this.assinatura = assinatura;
	}
	
	public void fazerChamada(Date data, int duracao) { 
		numChamadas++;
		
		for(int i = 0; i < numChamadas; i++) {
				Chamada chamada = new Chamada(data, duracao);
				this.chamadas[i] = chamada;
		}
	}
	
	@SuppressWarnings("deprecation")
	public void imprimirFatura(int mes) {
		DecimalFormat formatador = new DecimalFormat("0.00");
		float valor = 0;
		float somaValor = 0;
		float fatura = 0;
		System.out.println("Fatura assinante pós pago:");
		for(int i = 0; i < numChamadas; i ++) {
			if(this.chamadas[i] != null) {
			if(this.chamadas[i].getData().getMonth() == mes) {
				valor = this.chamadas[i].getDuracao() * 1.04f;
				somaValor = valor + somaValor;
				System.out.println(this.toString());
				System.out.println("Valor da ligação: R$" + formatador.format(valor));
				System.out.println(this.chamadas[i]);
			}
			fatura = somaValor + assinatura;
			}
		}
		System.out.println("Assinatura: R$" + formatador.format(this.assinatura));
		System.out.println("Valor da fatura: R$" + formatador.format(fatura));
		System.out.println();
	}
}
