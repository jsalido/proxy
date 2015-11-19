package poker;

/**
 * Created by jsalido on 11/19/15.
 */
public enum Palo {

    CORAZONES('\u2665'),
    TREBOLES('\u2663'),
    DIAMANTES('\u2666'),
    PICAS('\u2660');

    private char simbolo;

    Palo(char simbolo) {
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return simbolo;
    }

}
