import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testiluokka itsetehdylle pino -tietorakenteelle.
 *
 * @author Oskari Koskinen
 */
public class PinoJUnitTest {

    public PinoJUnitTest() {

    }

    @Test
    public void intPino() {

        Pino pino = new Pino();

        boolean odotusBool1 = true;
        boolean tulosBool1 = pino.empty();

        assertEquals(odotusBool1, tulosBool1);

        pino.push(1);
        pino.push(2);
        pino.push(3);

        boolean odotusBool2 = false;
        boolean tulosBool2 = pino.empty();

        assertEquals(odotusBool2, tulosBool2);

        int odotus1 = 3;
        int odotus2 = 2;
        int odotus3 = 1;

        int tulos1 = (int) pino.pop();
        int tulos2 = (int) pino.pop();
        int tulos3 = (int) pino.pop();

        assertEquals(odotus1, tulos1);
        assertEquals(odotus2, tulos2);
        assertEquals(odotus3, tulos3);
        
        for (int i = 1; i <= 1000; i++) {
            pino.push(i);
        }
        
        int tulos1000 = (int)pino.pop();
        assertEquals(1000,tulos1000);

    }

    @Test
    public void tauluPino() {

        Pino pino = new Pino();

        pino.push(new int[]{1, 2, 3});
        pino.push(new int[]{4, 5, 6});
        pino.push(new int[]{7, 8, 9});

        int[] odotus3 = new int[]{1, 2, 3};
        int[] odotus2 = new int[]{4, 5, 6};
        int[] odotus1 = new int[]{7, 8, 9};

        int[] tulos1 = (int[]) pino.pop();
        int[] tulos2 = (int[]) pino.pop();
        int[] tulos3 = (int[]) pino.pop();

        Assert.assertArrayEquals(odotus1, tulos1);
        Assert.assertArrayEquals(odotus2, tulos2);
        Assert.assertArrayEquals(odotus3, tulos3);
    }

}
