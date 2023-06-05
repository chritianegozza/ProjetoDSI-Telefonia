import java.util.Objects;
import java.util.Date;

public class Chamada {
	 private Date data;
	 private Integer duracao;
	 
	 public Chamada(Date data, Integer duracao) {
		 super();
		 this.data = data;
		 this.duracao = duracao;
	 }
	 
	 public Date getData() {
		 return data;
	 }
	 
	 public Integer getDuracao() {
		 return duracao;
	 }
	 
	 @Override
	 public String toString() {
		 return "Chamada [data=" + data + ", duracao=" + duracao + "]";
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
