package poker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jsalido on 11/19/15.
 */
public class Baraja {

    public List<Carta> cartas;

    public Baraja() {
        cartas = new ArrayList<>();
        for (Palo palo: Palo.values()) {
            for (TipoDeCarta tipoDeCarta: TipoDeCarta.values()) {
                cartas.add(new Carta(palo, tipoDeCarta));
            }
        }
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Carta c: cartas) {
            sb.append(c).append(" ");
        }
        return sb.toString();
    }

}
