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
        return buscarPorNumero(2);
    }

    public int contarTercias() {
        return buscarPorNumero(3);
    }

    public int contarPoker() {
        return buscarPorNumero(4);
    }

    public boolean checarFlush() {
        Carta primera = cartas.get(0);
        for (Carta c : cartas) {
            if (!c.getPalo().equals(primera.getPalo())) return false;
        }
        return true;
    }

    public boolean checarFullHouse() {
        return (contarPares() == 1 && contarTercias() == 1);
    }

    public boolean checarStraightFlush() {
        return checarFlush() && checarStraight();
    }

    public boolean checarStraight() {
        ordenarMano();
        Carta primera = cartas.get(0);
        Carta ultima = cartas.get(cartas.size() - 1);
        int valor = primera.getTipoDeCarta().getValor();
        if (primera.getTipoDeCarta().equals(TipoDeCarta.AS)
                && ultima.getTipoDeCarta().equals(TipoDeCarta.REY)) {
            valor = 9;
        }
        for (Carta c : cartas) {
            if (c.equals(primera)) continue;
            if (c.getTipoDeCarta().getValor() != valor + 1) return false;
            valor++;
        }
        return true;
    }

    public boolean checarRoyalFlush() {
        this.ordenarMano();
        return checarStraight()
                && checarFlush()
                && (cartas.get(0).getTipoDeCarta().equals(TipoDeCarta.AS))
                && (cartas.get(cartas.size() - 1).getTipoDeCarta().equals(TipoDeCarta.REY)
        );
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
