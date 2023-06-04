import java.util.Objects;// são pacote da java.util
import java.util.GregorianCalendar;


public class Chamada {
	//representa a data e hora da chamada e é do tipo GegorianCalendar
	private GregorianCalendar data;
    private Integer duracao;
     
    public Chamada(GregorianCalendar data, Integer duracao) {
    	//construtor da classe Chamada
        super();
        this.data = data;
        this.duracao = duracao;
    }
    
    //métodos getter que retornam os valores dos atributos data e duracao, respectivamente.
    public GregorianCalendar getData() {
        return data;
    }
    
    public Integer getDuracao() {
        return duracao;
    }
     
    @Override
    public String toString() {
        return "Chamada [data=" + data.getTime() + ", duracao=" + duracao + "]";
    }
     
    @Override
    public int hashCode() {
        return Objects.hash(data, duracao);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Chamada other = (Chamada) obj;
        return Objects.equals(data, other.data) && Objects.equals(duracao, other.duracao);
    }
}
