import java.util.Date;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Telefonia {
	private PrePago[] prepagos;
	private int numPrePagos;
	private PosPago[] pospagos;
	private int numPosPagos;

	public Telefonia() {
		super();
		this.prepagos = new PrePago[100];
		this.pospagos = new PosPago[100];
	}

	public void cadastrarAssinante(int opcao, String nome, long cpf, int numero, float assinatura) {
		if(opcao == 1) {
			this.numPosPagos++;
			for (int i = 0; i < numPosPagos; i++) {
				if(this.pospagos[i] == null) {
					PosPago posp = new PosPago(numero, cpf, nome, assinatura);
					this.pospagos[i] = posp;
					System.out.println("Seu cadastro foi realizado com sucesso!");
				}
			}
			
		} else if (opcao == 2) {
			this.numPrePagos++;
			for (int i = 0; i < numPrePagos; i++) {
				if (this.prepagos[i] == null) {
					PrePago prep = new PrePago(cpf, nome, numero);
					this.prepagos[i] = prep;
					System.out.println("Seu cadastro foi realizado com sucesso!");
				} 
			}
		}
	}
	
	public void listarAssinantes() {
		System.out.println("Assinantes pre pagos: ");
		for (int i = 0; i < numPrePagos; i++) {
			if (this.prepagos[i] != null){
			System.out.println(this.prepagos[i].toString());
			}
		}
		System.out.println();
		System.out.println("Assinantes pos pagos: ");
		for (int i = 0; i < numPosPagos; i++) {
			if(this.pospagos[i] != null) {
			System.out.println(this.pospagos[i].toString());
			}
		}
		System.out.println();
	}
	
	public void fazerChamada(int opcao, long cpf, Date data, int duracao) {
		if (opcao == 1) { 
			if (this.localizarPosPago(cpf) != null) {
				PosPago cham = this.localizarPosPago(cpf);
				cham.fazerChamada(data, duracao);
				System.out.println("A chamada foi realizada.");
			} else {
				System.out.println("O assinante nao foi encontrado no sistema.");
			}
		} else if (opcao == 2) {
			if (this.localizarPrePago(cpf) != null) {
				PrePago cham = this.localizarPrePago(cpf);
				cham.fazerChamada(data, duracao);
			} else {
				System.out.println("O assinante nao foi encontrado no sistema.");
			}
		} else {
			System.out.println("Escolha outra opçao.");
		}
	}
	
	public void fazerRecarga(long cpf, float valor, Date data) {
		if (this.localizarPrePago(cpf) != null) {
			PrePago rec = this.localizarPrePago(cpf);
			rec.recarregar(data, valor);
			System.out.println("Recarga realizada."); 
		} else {
			System.out.println("O assinante nao foi encontrado no sistema."); 
		}
	}
	
	public PrePago localizarPrePago(long cpf) {
		for (int i = 0; i <= numPrePagos; i++) {
			if (this.prepagos[i] != null) {
				if (this.prepagos[i].getCpf() == cpf) {
					return this.prepagos[i];
			}
			} else {
				i++;
			}
		}
		return null;
	}

	public PosPago localizarPosPago(long cpf) {
		for (int i = 0; i <= numPosPagos; i++) {
			if (this.pospagos[i] != null) {
			if (this.pospagos[i].getCpf() == cpf) {
				return this.pospagos[i];
			} 
			}
			else {
				i++;
			}
		}
		return null;
	}
	
	public void imprimirFaturas(int mes) {
		DecimalFormat formatador = new DecimalFormat("0.00");
		for (int i = 0; i < numPrePagos; i++) {
			if (this.prepagos[i].numChamadas > 0) {
			this.prepagos[i].imprimirFatura(mes);
			} else {
				System.out.println("Fatura assinante pre pago:");
				System.out.println(this.prepagos[i]);
				System.out.println("O assinante não efetuou ligações nesse mes.");
				System.out.println("Creditos: R$" + formatador.format(this.prepagos[i].creditos));
			}
			System.out.println();
		}
		for (int i = 0; i < numPosPagos; i++) {
			if(this.pospagos[i].numChamadas > 0) {
			this.pospagos[i].imprimirFatura(mes);
			}
			else {
				System.out.println("Fatura assinante pos pago:");
				System.out.println(this.pospagos[i]);
				System.out.println("O assinante não efetuou ligações nesse mes.");
				System.out.println("Assinatura: R$" + formatador.format(this.pospagos[i].assinatura));
				System.out.println("Valor da fatura: R$" + formatador.format(this.pospagos[i].assinatura));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Telefonia t = new Telefonia();		
		Date d = new Date();
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int op = 0;
		String nome = "";
		long cpf = 0;
		int numero = 0;
		int duracao = 0;
		int pp = 0;
		float assinatura = 0;
		float rec = 0;
		int mes = 0;
		while (op != 6) {
			System.out.println("|========== Bem vindo ao Telefonia Fatec ===========|");
			System.out.println();
			System.out.println("|===== Menu =====|");
			System.out.println();
			System.out.println("Digite uma opcao: ");
			System.out.println("1 - Cadastrar assinante");
			System.out.println("2 - Listar assinantes");
			System.out.println("3 - Fazer chamada");
			System.out.println("4 - Fazer recarga");
			System.out.println("5 - Imprimir faturas");
			System.out.println("6 - Sair");
			op = s.nextInt();
			if (op == 1) {
				//Cadastrar assinante
				System.out.println("A assinatura será de: ");
				System.out.println("1 - Pos Pago");
				System.out.println("2 - Pre Pago");
				pp = s.nextInt();
				s.nextLine();
				if (pp == 1) {
					System.out.println("Nome: ");
					nome = s.nextLine();
					System.out.println("CPF: ");
					cpf = s.nextLong();
					System.out.println("Número: ");
					numero = s.nextInt();
					System.out.println("Assinatura: ");
					assinatura = s.nextFloat();
					
				} else if (pp == 2) {
					//Listar assinantes
					System.out.println("Nome: ");
					nome = s.nextLine();
					System.out.println("CPF: ");
					cpf = s.nextLong();
					System.out.println("Numero: ");
					numero = s.nextInt();
				} else {
					System.out.println("Escolha outra opcao.");
				}
				t.cadastrarAssinante(pp, nome, cpf, numero, assinatura);
			}
			else if (op == 2) {
				t.listarAssinantes();
			}
			else if (op == 3) {
				//Fazer chamada
				System.out.println("Sua assinatura é: ");
				System.out.println("1 - Pos Pago");
				System.out.println("2 - Pre Pago");
				pp = s.nextInt();
				System.out.println("Digite seu CPF: ");
				cpf = s.nextLong();
				System.out.println("Digite a duraçao da ligacao: ");
				duracao = s.nextInt();
				t.fazerChamada(pp, cpf, d, duracao);
			}
			else if (op == 4) {
				//Fazer recarga
				System.out.println("Digite seu CPF: ");
				cpf = s.nextLong();
				System.out.println("Digite o valor da recarga, em reais: ");
				rec = s.nextFloat();
				t.fazerRecarga(cpf, rec, d);
			}
			else if(op == 5) {
				//Imprimir faturas
				System.out.println("Digite o mes em que deseja visualizar as faturas: ");
				mes = s.nextInt();
				int mesFatura = mes - 1;
				t.imprimirFaturas(mesFatura);
			}
		}
		
	}
}