package poker;

/**
 * Created by jsalido on 11/19/15.
 */
public enum TipoDeCarta {

    AS(1, "A"),
    DOS(2, "2"),
    TRES(3, "3"),
    CUATRO(4, "4"),
    CINCO(5, "5"),
    SEIS(6, "6"),
    SIETE(7, "7"),
    OCHO(8, "8"),
    NUEVE(9, "9"),
    DIEZ(10, "10"),
    JOTO(11, "J"),
    REINA(12, "Q"),
    REY(13, "K");

    private int valor;
    private String simbolo;

    TipoDeCarta(int valor, String simbolo) {
        this.valor = valor;
        this.simbolo = simbolo;
    }

    public int getValor() {
        return valor;
    }

    public String getSimbolo() {
        return simbolo;
    }

}
