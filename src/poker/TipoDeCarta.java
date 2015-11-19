package poker;

/**
 * Created by jsalido on 11/19/15.
 */
public enum TipoDeCarta {

    AS("A"),
    DOS("2"),
    TRES("3"),
    CUATRO("4"),
    CINCO("5"),
    SEIS("6"),
    SIETE("7"),
    OCHO("8"),
    NUEVE("9"),
    DIEZ("10"),
    JOTO("J"),
    REINA("Q"),
    REY("K");

    private String simbolo;

    TipoDeCarta(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }

}
