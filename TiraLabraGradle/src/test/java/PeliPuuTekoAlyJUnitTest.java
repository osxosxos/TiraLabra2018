
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliPuuTekoAlyJUnitTest {

    PeliPuuTekoAly aly;

    public PeliPuuTekoAlyJUnitTest() {
        this.aly = new PeliPuuTekoAly();
    }

    @Test
    public void sijoitaLinna() {

        int pelaaja = 3;
        int[] pelaajat = new int[]{3, 4, 5};

        int[][] peli1 = new int[][]{
            {1, 2, 2, 3, 1, 5, 2},
            {1, 2, 3, 2, 0, 2, 4},
            {0, 3, 2, 2, 1, 3, 2},
            {0, 0, 1, 1, 1, 0, 1},
            {3, 2, 4, 1, 2, 5, 2},
            {2, 4, 2, 0, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2}
        };

        int[][] odotus1 = new int[][]{
            {1, 2, 2, 3, 1, 5, 2},
            {1, 2, 3, 2, 0, 2, 4},
            {0, 3, 2, 2, 1, 3, 2},
            {0, 2, 1, 1, 1, 0, 1},
            {3, 2, 4, 1, 2, 5, 2},
            {2, 4, 2, 0, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2}
        };

        int[][] tulos1 = aly.sijoitaLinna(pelaaja, 5, pelaajat, peli1);

        Assert.assertArrayEquals(odotus1, tulos1);

        int[][] peli2 = new int[][]{
            {0, 2, 2, 3, 1, 2, 3},
            {1, 2, 3, 2, 1, 3, 2},
            {1, 3, 2, 2, 1, 1, 1},
            {1, 1, 1, 1, 2, 2, 2},
            {3, 1, 4, 1, 2, 5, 2},
            {2, 4, 2, 1, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 0}
        };

        int[][] odotus2 = new int[][]{
            {0, 2, 2, 3, 1, 2, 3},
            {1, 2, 3, 2, 1, 3, 2},
            {1, 3, 2, 2, 1, 1, 1},
            {1, 1, 1, 1, 2, 2, 2},
            {3, 1, 4, 1, 2, 5, 2},
            {2, 4, 2, 1, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2}
        };

        int[][] tulos2 = aly.sijoitaLinna(5, 4, pelaajat, peli2);

        Assert.assertArrayEquals(odotus2, tulos2);

        int[][] peli3 = new int[][]{
            {2, 2, 2, 3, 1, 2, 3},
            {1, 2, 3, 2, 1, 3, 2},
            {1, 3, 2, 2, 1, 1, 1},
            {1, 1, 1, 1, 2, 2, 2},
            {3, 1, 4, 1, 2, 5, 2},
            {2, 4, 2, 1, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2}
        };

        int[][] odotus3 = new int[][]{
            {2, 2, 2, 3, 1, 2, 3},
            {1, 2, 3, 2, 1, 3, 2},
            {1, 3, 2, 2, 1, 1, 1},
            {1, 1, 1, 1, 2, 2, 2},
            {3, 1, 4, 1, 2, 5, 2},
            {2, 4, 2, 1, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2}
        };

        int[][] tulos3 = aly.sijoitaLinna(5, 4, pelaajat, peli3);

        Assert.assertArrayEquals(tulos3, odotus3);

        int[][] peli4 = new int[][]{
            {1, 1, 1, 1, 1, 1, 1},
            {1, 2, 5, 2, 1, 3, 2},
            {1, 5, 2, 2, 1, 1, 1},
            {0, 0, 1, 1, 2, 2, 2},
            {0, 1, 4, 1, 2, 5, 2},
            {2, 5, 2, 1, 5, 2, 0},
            {1, 1, 1, 1, 2, 0, 0}
        };

        int[][] odotus4 = new int[][]{
            {1, 1, 1, 1, 1, 1, 1},
            {1, 2, 5, 2, 1, 3, 2},
            {1, 5, 2, 2, 1, 1, 1},
            {5, 0, 1, 1, 2, 2, 2},
            {0, 1, 4, 1, 2, 5, 2},
            {2, 5, 2, 1, 5, 2, 0},
            {1, 1, 1, 1, 2, 0, 0}
        };

        int[][] tulos4 = aly.sijoitaLinna(5, 5, pelaajat, peli4);

        Assert.assertArrayEquals(odotus4, tulos4);

    }

    @Test
    public void sijoitaPelto() {

        int pelaaja = 3;
        int[] pelaajat = new int[]{3, 4, 5};

        int[][] peli = new int[][]{
            {1, 2, 2, 3, 1, 5, 2},
            {1, 2, 3, 2, 0, 2, 4},
            {0, 3, 2, 2, 1, 3, 2},
            {0, 0, 1, 1, 1, 0, 1},
            {3, 2, 4, 1, 2, 5, 2},
            {2, 4, 2, 0, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2},};

        int[][] odotus = new int[][]{
            {1, 2, 2, 3, 1, 5, 2},
            {1, 2, 3, 2, 0, 2, 4},
            {0, 3, 2, 2, 1, 3, 2},
            {0, 0, 1, 1, 1, 1, 1},
            {3, 2, 4, 1, 2, 5, 2},
            {2, 4, 2, 0, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2},};

        int[][] tulos = aly.sijoitaPelto(pelaaja, pelaajat, peli);

        Assert.assertArrayEquals(odotus, tulos);

        int[][] peli2 = new int[][]{
            {1, 2, 2, 4, 1, 3, 2},
            {1, 2, 3, 2, 0, 2, 3},
            {0, 3, 2, 2, 1, 3, 2},
            {1, 0, 1, 1, 5, 1, 1},
            {3, 2, 3, 1, 2, 5, 2},
            {2, 3, 2, 0, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2},};

        int[][] odotus2 = new int[][]{
            {1, 2, 2, 4, 1, 3, 2},
            {1, 2, 3, 2, 0, 2, 3},
            {1, 3, 2, 2, 1, 3, 2},
            {1, 0, 1, 1, 5, 1, 1},
            {3, 2, 3, 1, 2, 5, 2},
            {2, 3, 2, 0, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2},};

        int[][] tulos2 = aly.sijoitaPelto(pelaaja, pelaajat, peli2);

        Assert.assertArrayEquals(odotus2, tulos2);

        int[][] peli3 = new int[][]{
            {1, 2, 2, 4, 1, 3, 2},
            {1, 2, 3, 2, 1, 2, 3},
            {1, 3, 2, 2, 1, 3, 2},
            {1, 1, 1, 1, 5, 1, 1},
            {3, 2, 3, 1, 2, 5, 2},
            {2, 3, 2, 1, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2}
        };

        int[][] odotus3 = new int[][]{
            {1, 2, 2, 4, 1, 3, 2},
            {1, 2, 3, 2, 1, 2, 3},
            {1, 3, 2, 2, 1, 3, 2},
            {1, 1, 1, 1, 5, 1, 1},
            {3, 2, 3, 1, 2, 5, 2},
            {2, 3, 2, 1, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2}
        };
        
        int[][] tulos3 = aly.sijoitaPelto(pelaaja, pelaajat, peli3);
        
        Assert.assertArrayEquals(odotus3, tulos3);
        
    }

    @Test
    public void linnanSijoitusMatriisi() {

        int pelaaja = 3;
        int[] pelaajat = new int[]{3, 4, 5};

        int[][] peli = new int[][]{
            {1, 2, 2, 3, 1, 1, 1},
            {1, 2, 3, 2, 1, 0, 1},
            {0, 3, 2, 2, 1, 1, 1},
            {0, 0, 1, 1, 1, 0, 1},
            {3, 2, 4, 1, 2, 5, 2},
            {2, 4, 2, 0, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2},};

        int[][] tulos = aly.linnanSijoitusMatriisi(pelaaja, pelaajat, peli);

        int arvo20 = aly.ruudunArvo(2, 0, 2, pelaaja, pelaajat, peli);
        int arvo31 = aly.ruudunArvo(3, 1, 2, pelaaja, pelaajat, peli);

        assertEquals(arvo20, tulos[2][0]);
        assertEquals(arvo31, tulos[3][1]);

    }

    @Test
    public void pellonSijoitusMatriisi() {

        int pelaaja = 3;

        int[] pelaajat = new int[]{3, 4, 5};

        int[][] peli = new int[][]{
            {1, 2, 2, 3, 1, 1, 1},
            {1, 2, 3, 2, 0, 0, 1},
            {0, 3, 2, 2, 1, 1, 1},
            {0, 0, 1, 1, 1, 0, 1},
            {3, 2, 3, 1, 2, 5, 2},
            {2, 3, 2, 0, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2},};

        int[][] tulos = aly.pellonSijoitusMartiisi(pelaaja, pelaajat, peli);

        int arvo20 = aly.ruudunArvo(2, 0, 1, pelaaja, pelaajat, peli);
        int arvo53 = aly.ruudunArvo(5, 3, 1, pelaaja, pelaajat, peli);

        assertEquals(tulos[2][0], arvo20);
        assertEquals(tulos[5][3], arvo53);
    }

    @Test
    public void arvo() {

        int rivi1 = 1;
        int sarake1 = 4;
        int laatta1 = 2;
        int pelaaja1 = 3;
        int[] pelaajat1 = new int[]{3, 4, 5};

        int[][] peli1 = new int[][]{
            {1, 2, 2, 3, 1, 2, 4},
            {1, 2, 3, 2, 0, 4, 2},
            {0, 3, 2, 2, 1, 2, 4},
            {0, 1, 1, 1, 1, 0, 1},
            {1, 1, 1, 1, 2, 4, 2},
            {1, 1, 1, 1, 5, 2, 5},
            {1, 1, 1, 1, 2, 4, 2},};

        int odotus1 = -28;

        int tulos1 = aly.ruudunArvo(rivi1, sarake1, laatta1, pelaaja1, pelaajat1, peli1);

        assertEquals(odotus1, tulos1);

        int rivi2 = 5;
        int sarake2 = 3;
        int laatta2 = 1;
        int pelaaja2 = 3;
        int[] pelaajat2 = new int[]{3, 4, 5};

        int[][] peli2 = new int[][]{
            {1, 2, 2, 3, 1, 1, 1},
            {1, 2, 3, 2, 0, 0, 1},
            {0, 3, 2, 2, 1, 1, 1},
            {0, 0, 1, 1, 1, 0, 1},
            {3, 2, 3, 1, 2, 5, 2},
            {2, 3, 2, 0, 5, 2, 5},
            {1, 1, 1, 1, 2, 5, 2},};

        int odotus2 = 11;
        int tulos2 = aly.ruudunArvo(rivi2, sarake2, laatta2, pelaaja2, pelaajat2, peli2);

        assertEquals(odotus2, tulos2);

        int[][] peli3 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {1, 2, 5, 2, 1, 3, 2},
            {0, 5, 2, 2, 1, 1, 1},
            {0, 0, 1, 1, 2, 2, 2},
            {3, 1, 4, 1, 2, 5, 2},
            {2, 5, 2, 1, 5, 2, 0},
            {1, 1, 1, 1, 2, 0, 0},};

        int[][] odotus3 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {1, 2, 5, 2, 1, 3, 2},
            {2, 5, 2, 2, 1, 1, 1},
            {0, 0, 1, 1, 2, 2, 2},
            {3, 1, 4, 1, 2, 5, 2},
            {2, 5, 2, 1, 5, 2, 0},
            {1, 1, 1, 1, 2, 0, 0},};

        int[][] tulos3 = aly.sijoitaLinna(5, 0, pelaajat2, peli3);

        Assert.assertArrayEquals(odotus3, tulos3);
    }

    @Test
    public void yksiSiirtoEteenpain() {

        int[] pelaajat = new int[]{3, 4, 5, 6};
        int pelaaja = 3;

        int[][] peli1 = new int[][]{
            {2, 2, 3, 1, 1},
            {3, 2, 2, 0, 1},
            {2, 2, 3, 0, 1},
            {0, 1, 1, 2, 5},
            {1, 1, 1, 5, 2}
        };

        int[][] odotus1 = new int[][]{
            {2, 2, 3, 1, 1},
            {3, 2, 2, 0, 1},
            {2, 2, 3, 2, 1},
            {0, 1, 1, 2, 5},
            {1, 1, 1, 5, 2}
        };

        int[][] tulos1 = aly.yksiSiirtoEteenpain(pelaaja, 2, 2, 3, pelaajat, peli1);

        Assert.assertArrayEquals(odotus1, tulos1);

        int[][] odotus2 = new int[][]{
            {2, 2, 3, 1, 1},
            {3, 2, 2, 0, 1},
            {2, 2, 3, 1, 1},
            {0, 1, 1, 2, 5},
            {1, 1, 1, 5, 2}
        };

        int[][] tulos2 = aly.yksiSiirtoEteenpain(pelaaja, 1, 2, 3, pelaajat, peli1);

        Assert.assertArrayEquals(odotus2, tulos2);

        int[][] peli2 = new int[][]{
            {2, 2, 3, 1, 1},
            {3, 2, 2, 1, 1},
            {2, 2, 3, 1, 1},
            {0, 1, 1, 2, 5},
            {1, 1, 1, 5, 2}
        };

        int[][] odotus3 = new int[][]{
            {2, 2, 3, 1, 1},
            {3, 2, 2, 1, 1},
            {2, 2, 3, 1, 1},
            {1, 1, 1, 2, 5},
            {1, 1, 1, 5, 2}
        };

        int[][] tulos3 = aly.yksiSiirtoEteenpain(3, 1, 3, 0, pelaajat, peli2);

        Assert.assertArrayEquals(odotus3, tulos3);

        int[][] peli3 = new int[][]{
            {2, 2, 3, 1, 1},
            {3, 2, 2, 1, 1},
            {2, 2, 3, 1, 1},
            {1, 1, 0, 2, 5},
            {1, 1, 1, 5, 2}
        };

        int[][] odotus4 = new int[][]{
            {2, 2, 3, 1, 1},
            {3, 2, 2, 1, 1},
            {2, 2, 3, 1, 1},
            {1, 1, 2, 2, 5},
            {1, 1, 1, 5, 2}
        };

        int[][] tulos4 = aly.yksiSiirtoEteenpain(pelaaja, 2, 3, 2, pelaajat, peli3);

        Assert.assertArrayEquals(odotus4, tulos4);

        int[][] peli5 = new int[][]{
            {2, 2, 3, 1, 1},
            {3, 2, 2, 1, 1},
            {2, 2, 3, 1, 1},
            {1, 1, 1, 0, 0},
            {1, 1, 1, 0, 2}
        };

        int[][] odotus5 = new int[][]{
            {2, 2, 3, 1, 1},
            {3, 2, 2, 1, 1},
            {2, 2, 3, 1, 1},
            {1, 1, 1, 3, 0},
            {1, 1, 1, 0, 2}
        };

        int[][] tulos5 = aly.yksiSiirtoEteenpain(3, 2, 3, 3, pelaajat, peli5);

        Assert.assertArrayEquals(odotus5, tulos5);

        int[][] peli6 = new int[][]{
            {3, 2, 2, 2, 3, 2, 2, 1, 2, 2},
            {2, 3, 2, 3, 2, 3, 2, 0, 1, 2},
            {2, 2, 3, 2, 2, 2, 3, 1, 2, 2},
            {2, 2, 2, 3, 2, 3, 2, 0, 1, 1},
            {2, 2, 2, 2, 3, 2, 2, 1, 2, 2},
            {0, 1, 1, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 0, 2, 2},
            {2, 1, 0, 1, 1, 0, 1, 0, 1, 0},
            {2, 0, 2, 2, 2, 0, 2, 2, 2, 0},
            {2, 2, 2, 0, 2, 2, 2, 0, 2, 3}
        };

        int[][] odotus6 = new int[][]{
            {3, 2, 2, 2, 3, 2, 2, 1, 2, 2},
            {2, 3, 2, 3, 2, 3, 2, 0, 1, 2},
            {2, 2, 3, 2, 2, 2, 3, 1, 2, 2},
            {2, 2, 2, 3, 2, 3, 2, 0, 1, 1},
            {2, 2, 2, 2, 3, 2, 2, 1, 2, 2},
            {0, 1, 1, 0, 0, 0, 0, 2, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 0, 2, 2},
            {2, 1, 0, 1, 1, 0, 1, 0, 1, 0},
            {2, 0, 2, 2, 2, 0, 2, 2, 2, 0},
            {2, 2, 2, 0, 2, 2, 2, 0, 2, 3}
        };

        int[][] tulos6 = aly.yksiSiirtoEteenpain(pelaaja, 2, 5, 7, pelaajat, peli6);

        Assert.assertArrayEquals(odotus6, tulos6);

    }

    @Test
    public void erotus() {

        int[] pelaajat = new int[]{3, 4, 5};

        int pelaaja1 = 3;

        int[][] peli1 = new int[][]{
            {2, 2, 3, 1, 1},
            {3, 2, 2, 0, 1},
            {2, 2, 3, 0, 1},
            {0, 1, 1, 2, 5},
            {1, 1, 1, 5, 2}
        };

        int odotus1 = 5;
        int tulos1 = aly.erotus(pelaaja1, pelaajat, peli1);

        assertEquals(odotus1, tulos1);

    }
}
