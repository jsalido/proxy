package poker;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jsalido on 11/19/15.
 */
public class ManoTest {

    @Test
    public void testAgregarCarta() {
        Mano mano = new Mano();
        Carta carta = new Carta(Palo.CORAZONES, TipoDeCarta.AS);
        mano.agregarCarta(carta);
        assertEquals(carta, mano.getCartas().get(0));
    }

    @Test
    public void probarTenerUnPar() {
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.NUEVE, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.OCHO, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.SIETE, Palo.CORAZONES));

        assertEquals(1, mano.contarPares());

        mano.agregarCarta(new Carta(TipoDeCarta.SIETE, Palo.CORAZONES));
        assertEquals(2, mano.contarPares());
    }

    @Test
    public void probarTenerDosPares() {
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.NUEVE, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.SIETE, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.SIETE, Palo.CORAZONES));
        assertEquals(2, mano.contarPares());
    }

    @Test
    public void probarNoHayPares() {
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.JOTO, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.NUEVE, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REY, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.SIETE, Palo.CORAZONES));
        assertEquals("No jala", 0, mano.contarPares());
    }

    @Test
    public void probarNoHayParesHayTercia() {
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REY, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.SIETE, Palo.CORAZONES));
        assertEquals("No jala", 0, mano.contarPares());
    }

    @Test
    public void probarTercia() {
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REY, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.SIETE, Palo.CORAZONES));
        assertEquals(1, mano.contarTercias());
    }

    @Test
    public void probarPoker() {
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REY, Palo.CORAZONES));
        assertEquals(1, mano.contarPoker());
    }

    @Test
    public void probarOrdenar() {
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(TipoDeCarta.SEIS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.CUATRO, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REY, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.JOTO, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.TRES, Palo.CORAZONES));
        System.out.println(mano);
        mano.ordenarMano();
        System.out.println(mano);
        assertEquals(TipoDeCarta.TRES, mano.getCartas().get(0).getTipoDeCarta());
        assertEquals(TipoDeCarta.CUATRO, mano.getCartas().get(1).getTipoDeCarta());
        assertEquals(TipoDeCarta.SEIS, mano.getCartas().get(2).getTipoDeCarta());
        assertEquals(TipoDeCarta.JOTO, mano.getCartas().get(3).getTipoDeCarta());
        assertEquals(TipoDeCarta.REY, mano.getCartas().get(4).getTipoDeCarta());
    }

    @Test
    public void probarStraight() {
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(TipoDeCarta.SEIS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.CUATRO, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.TRES, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.CINCO, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.SIETE, Palo.CORAZONES));
        assertTrue(mano.checarStraight());
    }

    @Test
    public void probarStraightAsPrimero() {
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.DOS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.TRES, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.CUATRO, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.CINCO, Palo.CORAZONES));
        assertTrue(mano.checarStraight());
    }

    @Test
    public void probarStraightAsUltimo() {
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.DIEZ, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.JOTO, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REINA, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REY, Palo.CORAZONES));
        System.out.println(mano);
        assertTrue(mano.checarStraight());
    }

    @Test
    public void probarFlush() {
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.DIEZ, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.JOTO, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REINA, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REY, Palo.CORAZONES));
        System.out.println(mano);
        assertTrue(mano.checarFlush());
    }

    @Test
    public void probarStraightFlush() {
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.DIEZ, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.JOTO, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REINA, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REY, Palo.CORAZONES));
        System.out.println(mano);
        assertTrue(mano.checarStraightFlush());
    }

    @Test
    public void probarNoStraightFlush() {
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.TREBOLES));
        mano.agregarCarta(new Carta(TipoDeCarta.DIEZ, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.JOTO, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REINA, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REY, Palo.CORAZONES));
        System.out.println(mano);
        assertFalse(mano.checarStraightFlush());
    }

    @Test
    public void probarFullHouse() {
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.TREBOLES));
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REY, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REY, Palo.CORAZONES));
        assertTrue(mano.checarFullHouse());
    }

    @Test
    public void probarNoFullHouse() {
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.TREBOLES));
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.SIETE, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REY, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REY, Palo.CORAZONES));
        assertFalse(mano.checarFullHouse());
    }

    @Test
    public void checarRoyalFlush() {
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.DIEZ, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.JOTO, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REINA, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REY, Palo.CORAZONES));
        assertTrue(mano.checarRoyalFlush());
    }

    @Test
    public void checarNoRoyalFlushUnaDiferentePalo() {
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(TipoDeCarta.AS, Palo.TREBOLES));
        mano.agregarCarta(new Carta(TipoDeCarta.DIEZ, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.JOTO, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REINA, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REY, Palo.CORAZONES));
        assertFalse(mano.checarRoyalFlush());
    }

    @Test
    public void checarNoRoyalFlushNoRoyal() {
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(TipoDeCarta.NUEVE, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.DIEZ, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.JOTO, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REINA, Palo.CORAZONES));
        mano.agregarCarta(new Carta(TipoDeCarta.REY, Palo.CORAZONES));
        assertFalse(mano.checarRoyalFlush());
    }

}