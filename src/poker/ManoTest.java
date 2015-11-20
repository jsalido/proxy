package poker;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jsalido on 11/19/15.
 */
public class ManoTest {

    @Test
    public void testAgregarCarta()  {
        Mano mano = new Mano();
        Carta carta = new Carta(Palo.CORAZONES, TipoDeCarta.AS);
        mano.agregarCarta(carta);
        assertEquals(carta, mano.getCartas().get(0));
    }

}