import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Telefonia {
    private PrePago[] prepagos;
    private int numPrePagos;
    private PosPago[] pospagos;
    private int numPosPagos;

    public Telefonia() {
        this.prepagos = new PrePago[90];
        this.pospagos = new PosPago[90];
        this.numPrePagos = 0;
        this.numPosPagos = 0;
    }

    public void cadastrarAssinante(int opcao, String nome, long cpf, int numero, float assinatura) {
        if (opcao == 1) {
            this.numPosPagos++;
            for (int i = 0; i < numPosPagos; i++) {
                if (this.pospagos[i] == null) {
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
        System.out.println("Assinantes pré pagos: ");
        for (int i = 0; i < numPrePagos; i++) {
            if (this.prepagos[i] != null) {
                System.out.println(this.prepagos[i].toString());
            }
        }
        System.out.println();
        System.out.println("Assinantes pós pagos: ");
        for (int i = 0; i < numPosPagos; i++) {
            if (this.pospagos[i] != null) {
                System.out.println(this.pospagos[i].toString());
            }
        }
        System.out.println();
    }

    public void fazerChamada(int opcao, long cpf, GregorianCalendar data, int duracao) {
        if (opcao == 1) {
            if (this.localizarPosPago(cpf) != null) {
                PosPago cham = this.localizarPosPago(cpf);
                Chamada chamada = new Chamada(data, duracao);
                cham.fazerChamada(chamada);
                System.out.println("A chamada foi realizada.");
            } else {
                System.out.println("O assinante não foi encontrado no sistema.");
            }
        } else if (opcao == 2) {
            if (this.localizarPrePago(cpf) != null) {
                PrePago cham = this.localizarPrePago(cpf);
                Chamada chamada = new Chamada(data, duracao);
                cham.fazerChamada(chamada);
                System.out.println("A chamada foi realizada.");
            } else {
                System.out.println("O assinante não foi encontrado no sistema.");
            }
        } else {
            System.out.println("Escolha outra opção.");
        }
    }


    public void fazerRecarga(long cpf, float valor, GregorianCalendar data) {
        PrePago prep = localizarPrePago(cpf);
        if (prep != null) {
            Recarga recarga = new Recarga(data, valor);
            prep.fazerRecarga(recarga);
            System.out.println("Recarga realizada.");
        } else {
            System.out.println("O assinante não foi encontrado no sistema.");
        }
    }

    public PrePago localizarPrePago(long cpf) {
        for (int i = 0; i < numPrePagos; i++) {
            if (this.prepagos[i] != null) {
                if (this.prepagos[i].getCpf() == cpf) {
                    return this.prepagos[i];
                }
            }
        }
        return null;
    }

    public PosPago localizarPosPago(long cpf) {
        for (int i = 0; i < numPosPagos; i++) {
            if (this.pospagos[i] != null) {
                if (this.pospagos[i].getCpf() == cpf) {
                    return this.pospagos[i];
                }
            }
        }
        return null;
    }

    public void imprimirFaturas(int mes) {
        DecimalFormat formatador = new DecimalFormat("0.00");

        System.out.println("Faturas assinantes pré pagos:");
        for (int i = 0; i < numPrePagos; i++) {
            if (this.prepagos[i] != null) {
                this.prepagos[i].imprimirFatura(mes);
                System.out.println("Créditos: R$" + formatador.format(this.prepagos[i].getCreditos()));
            }
            System.out.println();
        }

        System.out.println("Faturas assinantes pós pagos:");
        for (int i = 0; i < numPosPagos; i++) {
            if (this.pospagos[i] != null) {
                this.pospagos[i].imprimirFatura(mes);
                System.out.println("Assinatura: R$" + formatador.format(this.pospagos[i].getAssinatura()));
                System.out.println("Valor da fatura: R$" + formatador.format(this.pospagos[i].getValorFatura()));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Telefonia t = new Telefonia();
        GregorianCalendar d = new GregorianCalendar();

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
            System.out.println("|========= Seja Bem Vindo a FATEC Telefonia =========|");
            System.out.println("Digite uma opção: ");
            System.out.println("1 - Cadastrar assinante");
            System.out.println("2 - Listar assinantes");
            System.out.println("3 - Fazer chamada");
            System.out.println("4 - Fazer recarga");
            System.out.println("5 - Imprimir faturas");
            System.out.println("6 - Sair");
            op = s.nextInt();

            if (op == 1) {
                System.out.println("A assinatura será de: ");
                System.out.println("1 - Pós Pago");
                System.out.println("2 - Pré Pago");
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
                    System.out.println("Nome: ");
                    nome = s.nextLine();
                    System.out.println("CPF: ");
                    cpf = s.nextLong();
                    System.out.println("Número: ");
                    numero = s.nextInt();
                }

                t.cadastrarAssinante(pp, nome, cpf, numero, assinatura);
            } else if (op == 2) {
                t.listarAssinantes();
            } else if (op == 3) {
                System.out.println("Digite uma opção: ");
                System.out.println("1 - Pós Pago");
                System.out.println("2 - Pré Pago");
                pp = s.nextInt();
                System.out.println("Digite o CPF: ");
                cpf = s.nextLong();
                System.out.println("Digite a duração da chamada em minutos: ");
                duracao = s.nextInt();

                t.fazerChamada(pp, cpf, d, duracao);
            } else if (op == 4) {
                System.out.println("Digite o CPF: ");
                cpf = s.nextLong();
                System.out.println("Digite o valor da recarga: ");
                rec = s.nextFloat();
                t.fazerRecarga(cpf, rec, d);
            } else if (op == 5) {
                System.out.println("Digite o mês para imprimir as faturas: ");
                mes = s.nextInt();
                t.imprimirFaturas(mes);
            } else if (op == 6) {
                System.out.println("O programa foi encerrado.");
            }
        }
        s.close();
    }
}