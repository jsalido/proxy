package poker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jsalido on 11/19/15.
 */
public class Mano {

    private List<Carta> cartas;

    public Mano() {
        cartas = new ArrayList<>();
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }
}
