
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testit pelin pelaamiseen vaadittaville toiminnoille.
 *
 * @author Oskari Koskinen
 */
public class PeliJUnitTest {

    Peli peli;

    public PeliJUnitTest() {
        this.peli = new Peli();
    }

    @Test
    public void loppuPisteet1() {

        int[] pelaajat = new int[]{3, 4, 5};

        Lista tiedot = new Lista();

        Pelaaja pelaaja3 = new Pelaaja(3, false, false, false);
        Pelaaja pelaaja4 = new Pelaaja(4, false, false, false);
        Pelaaja pelaaja5 = new Pelaaja(5, false, false, false);

        tiedot.add(pelaaja3);
        tiedot.add(pelaaja4);
        tiedot.add(pelaaja5);

        int[][] peli1 = new int[][]{
            {1, 2, 2, 2, 1, 2, 2},
            {1, 2, 2, 2, 1, 2, 2},
            {1, 2, 2, 2, 1, 2, 2},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 2, 1, 2, 2, 2},
            {0, 2, 2, 1, 2, 2, 2},
            {1, 1, 1, 1, 2, 2, 2}
        };

        boolean[][] kaydyt = new boolean[peli1.length][peli1.length];

        peli.loppuPisteet(pelaajat, peli1, kaydyt, tiedot);

        pelaaja4 = (Pelaaja) tiedot.get(1);
        int pelaajan4Pisteet = pelaaja4.getPisteet();
        int pelaajan4PisteetOdotus = 0;

        assertEquals(pelaajan4PisteetOdotus, pelaajan4Pisteet);

        pelaaja5 = (Pelaaja) tiedot.get(1);
        int pelaajan5Pisteet = pelaaja5.getPisteet();
        int pelaajan5PisteetOdotus = 0;

        assertEquals(pelaajan5PisteetOdotus, pelaajan5Pisteet);

    }

    @Test
    public void loppuPisteet2() {

        int[] pelaajat = new int[]{3, 4, 5};

        Lista tiedot = new Lista();

        Pelaaja pelaaja3 = new Pelaaja(3, false, false, false);
        Pelaaja pelaaja4 = new Pelaaja(4, false, false, false);
        Pelaaja pelaaja5 = new Pelaaja(5, false, false, false);

        pelaaja3.asetaSeuraajienMaara(7);
        pelaaja4.asetaSeuraajienMaara(5);
        pelaaja5.asetaSeuraajienMaara(6);

        tiedot.add(pelaaja3);
        tiedot.add(pelaaja4);
        tiedot.add(pelaaja5);

        int[][] peli1 = new int[][]{
            {1, 2, 2, 3, 1, 4, 2},
            {1, 2, 3, 2, 1, 2, 4},
            {1, 3, 2, 2, 1, 4, 2},
            {0, 1, 1, 1, 1, 1, 1},
            {0, 0, 4, 1, 2, 5, 2},
            {0, 4, 2, 0, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2}
        };

        boolean[][] kaydyt = new boolean[peli1.length][peli1.length];

        peli.paivita(pelaajat, peli1, kaydyt, tiedot);

        peli.loppuPisteet(pelaajat, peli1, kaydyt, tiedot);

        pelaaja4 = (Pelaaja) tiedot.get(1);
        int pelaajan4Pisteet = pelaaja4.getPisteet();
        int pelaajan4PisteetOdotus = 9;

        assertEquals(pelaajan4PisteetOdotus, pelaajan4Pisteet);

        pelaaja5 = (Pelaaja) tiedot.get(1);
        int pelaajan5Pisteet = pelaaja5.getPisteet();
        int pelaajan5PisteetOdotus = 9;

        assertEquals(pelaajan5PisteetOdotus, pelaajan5Pisteet);

        boolean[][] boolean1Odotus = new boolean[][]{
            {false, true, true, true, false, true, true},
            {false, true, true, true, false, true, true},
            {false, true, true, true, false, true, true},
            {false, false, false, false, false, false, false},
            {false, false, true, false, true, true, true},
            {false, true, true, false, true, true, true},
            {false, false, false, false, true, true, true}
        };

        Assert.assertArrayEquals(kaydyt, boolean1Odotus);
    }

    @Test
    public void vaihdaVuoro() {

        int vuoro1 = 0;

        int[] pelaajat = new int[]{3, 4, 5, 6};

        int seuraavaVuoro1 = peli.vaihdaVuoro(vuoro1, pelaajat);

        int seuraavaVuoro1Odotus = 1;

        assertEquals(seuraavaVuoro1, seuraavaVuoro1Odotus);

        int vuoro2 = 3;

        int seuraavaVuoro2 = peli.vaihdaVuoro(vuoro2, pelaajat);

        int seuraavaVuoro2odotus = 0;

        assertEquals(seuraavaVuoro2, seuraavaVuoro2odotus);

    }

    @Test
    public void vahennaSeuraajaJosAsetettu() {

        Lista tiedot = new Lista();

        Pelaaja pelaaja3 = new Pelaaja(3, false, false, false);
        Pelaaja pelaaja4 = new Pelaaja(4, false, false, false);
        Pelaaja pelaaja5 = new Pelaaja(5, false, false, false);

        pelaaja3.asetaSeuraajienMaara(7);
        pelaaja4.asetaSeuraajienMaara(5);
        pelaaja5.asetaSeuraajienMaara(6);

        tiedot.add(pelaaja3);
        tiedot.add(pelaaja4);
        tiedot.add(pelaaja5);

        int[][] peli1EnnenSiirtoa = new int[][]{
            {1, 2, 2, 3, 1, 4, 2},
            {1, 2, 3, 2, 1, 2, 4},
            {1, 3, 2, 2, 1, 4, 2},
            {0, 1, 1, 1, 1, 1, 1},
            {0, 0, 4, 1, 2, 5, 2},
            {0, 4, 2, 0, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2}
        };

        int[][] peli1SiirronJalkeen = new int[][]{
            {1, 2, 2, 3, 1, 4, 2},
            {1, 2, 3, 2, 1, 2, 4},
            {1, 3, 2, 2, 1, 4, 2},
            {3, 1, 1, 1, 1, 1, 1},
            {0, 0, 4, 1, 2, 5, 2},
            {0, 4, 2, 0, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2}
        };

        peli.vahennaSeuraajaJosAsetettu(3, 0, peli1EnnenSiirtoa, peli1SiirronJalkeen, tiedot);

        Pelaaja p1 = (Pelaaja) tiedot.get(0);
        int seuraajat = p1.getSeuraajat();
        assertEquals(seuraajat, 6);

        int[][] peli2EnnenSiirtoa = new int[][]{
            {1, 2, 2, 3, 1, 4, 2},
            {1, 2, 3, 2, 1, 2, 4},
            {1, 3, 2, 2, 1, 4, 2},
            {3, 1, 1, 1, 1, 1, 1},
            {0, 0, 4, 1, 2, 5, 2},
            {0, 4, 2, 0, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2}
        };

        int[][] peli2SiirronJalkeen = new int[][]{
            {1, 2, 2, 3, 1, 4, 2},
            {1, 2, 3, 2, 1, 2, 4},
            {1, 3, 2, 2, 1, 4, 2},
            {3, 1, 1, 1, 1, 1, 1},
            {2, 0, 4, 1, 2, 5, 2},
            {0, 4, 2, 0, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2}
        };

        peli.vahennaSeuraajaJosAsetettu(3, 0, peli2EnnenSiirtoa, peli2SiirronJalkeen, tiedot);

        int seuraajat2 = p1.getSeuraajat();
        assertEquals(seuraajat2, 6);

    }

    @Test
    public void paivita() {

        int[] pelaajat = new int[]{3, 4, 5};

        Lista tiedot = new Lista();

        Pelaaja pelaaja3 = new Pelaaja(3, false, false, false);
        Pelaaja pelaaja4 = new Pelaaja(4, false, false, false);
        Pelaaja pelaaja5 = new Pelaaja(5, false, false, false);

        pelaaja3.asetaSeuraajienMaara(7);
        pelaaja4.asetaSeuraajienMaara(5);
        pelaaja5.asetaSeuraajienMaara(6);

        tiedot.add(pelaaja3);
        tiedot.add(pelaaja4);
        tiedot.add(pelaaja5);

        int[][] peli1 = new int[][]{
            {1, 2, 2, 3, 1, 4, 2},
            {1, 2, 3, 2, 1, 2, 4},
            {1, 3, 2, 2, 1, 4, 2},
            {0, 1, 1, 1, 1, 1, 1},
            {0, 0, 4, 1, 2, 5, 2},
            {0, 4, 2, 0, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2}
        };

        boolean[][] kaydyt = new boolean[peli1.length][peli1.length];

        peli.paivita(pelaajat, peli1, kaydyt, tiedot);

        int[][] odotus1 = new int[][]{
            {1, 2, 2, 2, 1, 2, 2},
            {1, 2, 2, 2, 1, 2, 2},
            {1, 2, 2, 2, 1, 2, 2},
            {0, 1, 1, 1, 1, 1, 1},
            {0, 0, 4, 1, 2, 5, 2},
            {0, 4, 2, 0, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2}
        };

        Assert.assertArrayEquals(odotus1, peli1);

        boolean[][] odotus1Boolean = new boolean[][]{
            {false, true, true, true, false, true, true},
            {false, true, true, true, false, true, true},
            {false, true, true, true, false, true, true},
            {false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false}
        };

        Assert.assertArrayEquals(odotus1Boolean, kaydyt);

        Pelaaja p1 = (Pelaaja) tiedot.get(0);
        int p1pisteet = p1.getPisteet();
        int p1seuraajat = p1.getSeuraajat();

        int p1pisteetOdotus = 9;
        int p1seuraajatOdotus = 10;

        assertEquals(p1pisteetOdotus, p1pisteet);
        assertEquals(p1seuraajatOdotus, p1seuraajat);

    }
}
