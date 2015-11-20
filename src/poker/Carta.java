package poker;

/**
 * Created by jsalido on 11/19/15.
 */
public class Carta implements Comparable {

    private Palo palo;
    private TipoDeCarta tipoDeCarta;

    public Carta(Palo palo, TipoDeCarta tipoDeCarta) {
        this.palo = palo;
        this.tipoDeCarta = tipoDeCarta;
    }

    public Carta(TipoDeCarta tipoDeCarta, Palo palo) {
        this.palo = palo;
        this.tipoDeCarta = tipoDeCarta;
    }

    public Palo getPalo() {
        return palo;
    }

    public TipoDeCarta getTipoDeCarta() {
        return tipoDeCarta;
    }

    @Override
    public String toString() {
        return tipoDeCarta.getSimbolo() +
                palo.getSimbolo();
    }

    @Override
    public int compareTo(Object o) {
        return this.getTipoDeCarta().getValor() - ((Carta)o).getTipoDeCarta().getValor();
    }

}
