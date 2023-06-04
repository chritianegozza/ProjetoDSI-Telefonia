import java.util.GregorianCalendar;

public abstract class Assinante {
    protected String cpf;
    protected String nome;
    protected String numero;
    protected Chamada[] chamadas;
    protected int numChamadas;

    public Assinante(String cpf, String nome, String numero) {
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
        this.chamadas = new Chamada[100]; // Tamanho máximo do vetor de chamadas
        this.numChamadas = 0;
    }

    public abstract void fazerChamada(GregorianCalendar data, int duracao);

    public abstract void imprimirFatura(int mes);

    // Getters e Setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
