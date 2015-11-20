package poker;

import java.util.ArrayList;
import java.util.Collections;
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

    public void ordenarMano() {
        Collections.sort(cartas);
    }

    private int buscarPorNumero(int numero) {
        int paresEncontrados = 0;
        for (TipoDeCarta tipo : TipoDeCarta.values()) {
            int encontradas = 0;
            for (Carta c : cartas) {
                if (c.getTipoDeCarta().equals(tipo)) {
                    encontradas++;
                }
            }
            if (encontradas == numero) {
                paresEncontrados++;
            }
        }
        return paresEncontrados;
    }

    public int contarPares() {
        return 0;
    }

    public int contarTercias() {
        return 0;
    }

    public int contarPoker() {
        return 0;
    }

    public boolean checarStraight() {
        return false;
    }

    public boolean checarFlush() {
        return false;
    }

    public boolean checarStraightFlush() {
        return false;
    }

    public boolean checarFullHouse() {
        return false;
    }

    public boolean checarRoyalFlush() {
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Carta c : cartas) {
            sb.append(c).append(" ");
        }
        return sb.toString();
    }



}
