package poker;

/**
 * Created by jsalido on 11/19/15.
 */
public class Carta {

    private Palo palo;
    private TipoDeCarta tipoDeCarta;

    public Carta(Palo palo, TipoDeCarta tipoDeCarta) {
        this.palo = palo;
        this.tipoDeCarta = tipoDeCarta;
    }

    @Override
    public String toString() {
        return tipoDeCarta.getSimbolo() +
                palo.getSimbolo();
    }

}
