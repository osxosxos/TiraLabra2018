
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Lista -tietorakenteen testaus.
 *
 * @author Oskari Koskinen
 */
public class ListaJUnitTest {

    public ListaJUnitTest() {

    }

    @Test
    public void numeroLista() {

        Lista lista = new Lista();

        int odotusKoko1 = 0;
        int tulosKoko1 = lista.size();

        assertEquals(odotusKoko1, tulosKoko1);

        for (int i = 1; i <= 30; i++) {
            lista.add(i);
        }

        int odotus2 = 2;
        int odotus17 = 17;
        int odotus30 = 30;
        int tulos2 = (int) lista.get(1);
        int tulos17 = (int) lista.get(16);
        int tulos30 = (int) lista.get(29);

        assertEquals(odotus2, tulos2);
        assertEquals(odotus17, tulos17);
        assertEquals(odotus30, tulos30);

    }

    @Test
    public void taulukkoLista() {

        Lista lista = new Lista();

        for (int i = 1; i <= 1000; i++) {
            int[][] uusi = new int[][]{
                {i, i + 1},
                {i + 1, i}
            };
            
            lista.add(uusi);
        }

        int[][] odotus1 = new int[][]{
            {1, 2},
            {2, 1}
        };

        int[][] odotus578 = new int[][]{
            {578, 579},
            {579, 578}
        };

        int[][] tulos1 = (int[][]) lista.get(0);
        int[][] tulos578 = (int[][]) lista.get(577);

        Assert.assertArrayEquals(odotus1, tulos1);
        Assert.assertArrayEquals(odotus578, tulos578);

    }

}
