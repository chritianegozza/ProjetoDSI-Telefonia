/* Trabalho de DSI FATEC Rubens Lara
 * @autores: Christiane Natacha Gozza 
 * Telefonia
 * Curso: SI 4° Semestre
 * */

import java.util.GregorianCalendar;

public class Recarga {
    private GregorianCalendar data;
    private double valor;

    public Recarga(GregorianCalendar data, double valor) {
        this.data = data;
        this.valor = valor;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Recarga [data=" + data + ", valor=" + valor + "]";
    }
}
