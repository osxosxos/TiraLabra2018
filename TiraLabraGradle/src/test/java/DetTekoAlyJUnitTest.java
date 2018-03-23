
import org.junit.Assert;
import org.junit.Test;

public class DetTekoAlyJUnitTest {

    DetermistinenTekoaly aly;

    public DetTekoAlyJUnitTest() {
        this.aly = new DetermistinenTekoaly();
    }

    @Test
    public void pelaaPelto() {

        int[] pelaajat = new int[]{3, 4, 5};

        int[][] peli1 = new int[][]{
            {1, 2, 2, 3, 0, 1, 1},
            {1, 2, 3, 2, 0, 0, 0},
            {0, 2, 2, 2, 1, 0, 2},
            {0, 1, 2, 0, 0, 2, 4},
            {1, 0, 0, 0, 2, 4, 2},
            {1, 0, 0, 2, 5, 2, 5},
            {0, 1, 2, 4, 2, 4, 2}
        };

        int[][] odotus1 = new int[][]{
            {1, 2, 2, 3, 0, 1, 1},
            {1, 2, 3, 2, 0, 0, 0},
            {0, 2, 2, 2, 1, 0, 2},
            {0, 1, 2, 1, 0, 2, 4},
            {1, 0, 0, 0, 2, 4, 2},
            {1, 0, 0, 2, 5, 2, 5},
            {0, 1, 2, 4, 2, 4, 2}
        };

        int[][] tulos1 = aly.pelaaPelto(peli1, 3, pelaajat);

        Assert.assertArrayEquals(odotus1, tulos1);

        int[][] peli2 = new int[][]{
            {5, 2, 2, 5, 0, 1, 1, 0, 0},
            {2, 4, 2, 4, 1, 0, 1, 1, 0},
            {4, 2, 4, 2, 0, 1, 0, 0, 0},
            {2, 5, 2, 5, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 1, 3, 2, 3, 2},
            {1, 1, 1, 1, 1, 2, 3, 2, 2},
            {1, 0, 0, 1, 1, 3, 2, 3, 2},
            {0, 1, 1, 1, 1, 2, 3, 2, 2},
            {1, 1, 1, 1, 1, 3, 2, 3, 0}
        };

        int[][] odotus2 = new int[][]{
            {5, 2, 2, 5, 0, 1, 1, 0, 0},
            {2, 4, 2, 4, 1, 0, 1, 1, 0},
            {4, 2, 4, 2, 0, 1, 0, 0, 0},
            {2, 5, 2, 5, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 1, 3, 2, 3, 2},
            {1, 1, 1, 1, 1, 2, 3, 2, 2},
            {1, 0, 0, 1, 1, 3, 2, 3, 2},
            {0, 1, 1, 1, 1, 2, 3, 2, 2},
            {1, 1, 1, 1, 1, 3, 2, 3, 1}
        };

        int[][] tulos2 = aly.pelaaPelto(peli2, 3, pelaajat);

        Assert.assertArrayEquals(odotus2, tulos2);

        int[][] peli3 = new int[][]{
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 0}
        };

        int[][] odotus3 = new int[][]{
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        int[][] tulos3 = aly.pelaaPelto(peli3, 3, pelaajat);

        Assert.assertArrayEquals(odotus3, tulos3);

        int[][] peli4 = new int[][]{
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        int[][] odotus4 = new int[][]{
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        int[][] tulos4 = aly.pelaaPelto(peli4, 3, pelaajat);

        Assert.assertArrayEquals(odotus4, tulos4);

    }

    @Test
    public void pelaaLinna() {

        int[] pelaajat = new int[]{3, 4, 5};

        int[][] peli1 = new int[][]{
            {2, 4, 2, 3, 2, 0, 2},
            {0, 2, 3, 2, 0, 0, 4},
            {0, 2, 2, 0, 1, 0, 2},
            {0, 1, 2, 0, 0, 2, 3},
            {0, 0, 0, 0, 2, 4, 2},
            {0, 0, 0, 1, 2, 2, 5},
            {0, 1, 0, 0, 3, 2, 2}
        };

        int[][] odotus1 = new int[][]{
            {2, 4, 2, 3, 2, 0, 2},
            {0, 2, 3, 2, 0, 0, 4},
            {0, 2, 2, 0, 1, 0, 2},
            {3, 1, 2, 0, 0, 2, 3},
            {0, 0, 0, 0, 2, 4, 2},
            {0, 0, 0, 1, 2, 2, 5},
            {0, 1, 0, 0, 3, 2, 2}
        };

        int[][] tulos1 = aly.pelaaLinna(peli1, 3, 6, pelaajat);

        Assert.assertArrayEquals(odotus1, tulos1);

        int[][] peli2 = new int[][]{
            {2, 4, 2, 0, 0, 0, 0},
            {5, 2, 5, 1, 1, 0, 3},
            {4, 2, 4, 1, 0, 3, 2},
            {1, 0, 0, 1, 3, 2, 3},
            {0, 0, 0, 2, 1, 3, 2},
            {0, 0, 2, 3, 2, 1, 3},
            {0, 2, 3, 2, 3, 2, 0}
        };

        int[][] odotus2 = new int[][]{
            {2, 4, 2, 0, 0, 0, 0},
            {5, 2, 5, 1, 1, 0, 3},
            {4, 2, 4, 1, 0, 3, 2},
            {1, 0, 0, 1, 3, 2, 3},
            {0, 0, 0, 2, 1, 3, 2},
            {0, 0, 2, 3, 2, 1, 3},
            {0, 2, 3, 2, 3, 2, 2}
        };

        int[][] tulos2 = aly.pelaaLinna(peli2, 3, 10, pelaajat);

        Assert.assertArrayEquals(odotus2, tulos2);

        int[][] peli3 = new int[][]{
            {5, 2, 2, 3, 0, 1, 1, 0, 0},
            {2, 0, 1, 2, 1, 0, 1, 1, 0},
            {2, 1, 2, 2, 0, 1, 0, 0, 0},
            {4, 2, 2, 3, 0, 2, 4, 2, 4},
            {0, 0, 0, 0, 0, 2, 2, 5, 2},
            {4, 2, 2, 3, 0, 2, 3, 2, 2},
            {2, 3, 0, 2, 0, 0, 1, 1, 0},
            {2, 2, 1, 2, 0, 0, 1, 0, 0},
            {5, 2, 2, 3, 0, 0, 0, 0, 0}
        };

        int[][] odotus3 = new int[][]{
            {5, 2, 2, 3, 0, 1, 1, 0, 0},
            {2, 0, 1, 2, 1, 0, 1, 1, 0},
            {2, 1, 2, 2, 0, 1, 0, 0, 0},
            {4, 2, 2, 3, 0, 2, 4, 2, 4},
            {0, 2, 0, 0, 0, 2, 2, 5, 2},
            {4, 2, 2, 3, 0, 2, 3, 2, 2},
            {2, 3, 0, 2, 0, 0, 1, 1, 0},
            {2, 2, 1, 2, 0, 0, 1, 0, 0},
            {5, 2, 2, 3, 0, 0, 0, 0, 0}
        };

        int[][] tulos3 = aly.pelaaLinna(peli3, 3, 4, pelaajat);

        Assert.assertArrayEquals(odotus3, tulos3);

        int[][] peli4 = new int[][]{
            {3, 2, 2, 3, 1, 1, 1, 1, 1},
            {2, 0, 1, 2, 1, 1, 1, 1, 1},
            {2, 1, 3, 2, 1, 1, 1, 1, 1},
            {3, 2, 2, 3, 1, 2, 2, 2, 2},
            {1, 1, 1, 1, 1, 2, 2, 2, 2},
            {3, 0, 1, 0, 1, 2, 2, 2, 2},
            {2, 3, 0, 1, 0, 1, 1, 1, 1},
            {3, 2, 3, 1, 0, 0, 1, 1, 1},
            {0, 3, 2, 3, 0, 1, 1, 1, 1}
        };

        int[][] odotus4 = new int[][]{
            {3, 2, 2, 3, 1, 1, 1, 1, 1},
            {2, 0, 1, 2, 1, 1, 1, 1, 1},
            {2, 1, 3, 2, 1, 1, 1, 1, 1},
            {3, 2, 2, 3, 1, 2, 2, 2, 2},
            {1, 1, 1, 1, 1, 2, 2, 2, 2},
            {3, 0, 1, 0, 1, 2, 2, 2, 2},
            {2, 3, 0, 1, 0, 1, 1, 1, 1},
            {3, 2, 3, 1, 2, 0, 1, 1, 1},
            {0, 3, 2, 3, 0, 1, 1, 1, 1}
        };

        int[][] tulos4 = aly.pelaaLinna(peli4, 3, 0, pelaajat);

        Assert.assertArrayEquals(odotus4, tulos4);

        int[][] peli5 = new int[][]{
            {1, 1, 1, 1},
            {1, 0, 1, 0},
            {0, 0, 1, 0},
            {1, 0, 1, 0}
        };

        int[][] odotus5 = new int[][]{
            {1, 1, 1, 1},
            {1, 3, 1, 0},
            {0, 0, 1, 0},
            {1, 0, 1, 0}
        };

        int[][] tulos5 = aly.pelaaLinna(peli5, 3, 10, pelaajat);

        Assert.assertArrayEquals(odotus5, tulos5);

        int[][] peli6 = new int[][]{
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        int[][] odotus6 = new int[][]{
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        int[][] tulos6 = aly.pelaaLinna(peli6, 3, 4, pelaajat);

        Assert.assertArrayEquals(odotus6, tulos6);

    }

    @Test
    public void linnanSijoitusMatriisi() {

        int pelaaja = 3;

        int[] pelaajat = new int[]{3, 4, 5};

        int[][] peli1 = new int[][]{
            {2, 4, 2, 3, 2, 0, 2},
            {0, 2, 3, 2, 0, 0, 4},
            {0, 2, 2, 0, 1, 0, 2},
            {0, 1, 2, 0, 0, 2, 3},
            {0, 0, 0, 0, 2, 4, 2},
            {0, 0, 0, 1, 2, 2, 5},
            {0, 1, 0, 0, 3, 2, 2},};

        int[][] odotus1 = new int[][]{
            {0, 0, 0, 0, 0, 28, 0},
            {14, 0, 0, 0, 22, 11, 0},
            {25, 0, 0, 17, 0, 3, 0},
            {47, 0, 0, 17, 6, 0, 0},
            {22, 47, 25, 6, 0, 0, 0},
            {11, 14, 14, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };

        int[][] tulos1 = aly.linnanSijoitusMatriisi(pelaajat, peli1, pelaaja);

        Assert.assertArrayEquals(odotus1, tulos1);

        int[][] peli2 = new int[][]{
            {4, 2, 4, 0, 0, 0, 0},
            {2, 4, 2, 1, 1, 0, 3},
            {4, 2, 4, 1, 0, 5, 2},
            {1, 0, 0, 0, 3, 2, 3},
            {0, 1, 0, 2, 0, 5, 2},
            {0, 0, 2, 4, 2, 1, 3},
            {0, 1, 5, 2, 4, 0, 1},};

        int[][] odotus2 = new int[][]{
            {0, 0, 0, -45, 15, 78, 66},
            {0, 0, 0, 0, 0, 78, 0},
            {0, 0, 0, 0, 58, 0, 0},
            {0, -64, -54, 35, 0, 0, 0},
            {-19, 0, -38, 0, 42, 0, 0},
            {-4, -18, 0, 0, 0, 0, 0},
            {-4, 0, 0, 0, 0, -14, 0}
        };

        int[][] tulos2 = aly.linnanSijoitusMatriisi(pelaajat, peli2, pelaaja);

        Assert.assertArrayEquals(odotus2, tulos2);

    }

    @Test
    public void pellonSijoitusMartiisi() {

        int pelaaja = 3;
        int[] pelaajat = new int[]{3, 4, 5};

        int[][] peli1 = new int[][]{
            {1, 2, 2, 3, 0, 1, 1},
            {1, 2, 3, 2, 0, 0, 0},
            {0, 2, 2, 2, 1, 0, 2},
            {0, 1, 2, 0, 0, 2, 4},
            {1, 0, 0, 0, 2, 4, 2},
            {1, 0, 0, 2, 5, 2, 5},
            {0, 1, 2, 4, 2, 4, 2}
        };

        int[][] odotus1 = new int[][]{
            {0, 0, 0, 0, 26, 0, 0},
            {0, 0, 0, 0, 26, 12, 0},
            {26, 0, 0, 0, 0, 72, 0},
            {32, 0, 0, 398, 332, 0, 0},
            {0, 92, 338, 398, 0, 0, 0},
            {0, 72, 138, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };

        int[][] tulos1 = aly.pellonSijoitusMatriisi(pelaajat, peli1, pelaaja);

        Assert.assertArrayEquals(odotus1, tulos1);

        int[][] peli2 = new int[][]{
            {5, 2, 2, 3, 0, 1, 0, 2, 4},
            {2, 2, 3, 4, 1, 0, 0, 1, 2},
            {2, 3, 2, 2, 0, 1, 0, 0, 0},
            {4, 2, 2, 3, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 2, 2, 5, 2},
            {1, 1, 1, 1, 0, 2, 5, 2, 5},
            {0, 0, 0, 1, 0, 2, 2, 5, 2},
            {2, 1, 1, 1, 0, 2, 5, 2, 2},
            {3, 2, 1, 1, 0, 5, 2, 2, 5}
        };

        int[][] odotus2 = new int[][]{
            {0, 0, 0, 0, 64, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 42, 0, 0, 0},
            {0, 0, 0, 0, 448, 0, 0, 0, 0},
            {0, 0, 0, 0, 1578, 789, 0, 0, 0},
            {85, 106, 106, 853, 1557, 0, 0, 0, 0},
            {0, 0, 0, 0, 405, 0, 0, 0, 0},
            {4, 4, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        int[][] tulos2 = aly.pellonSijoitusMatriisi(pelaajat, peli2, pelaaja);

        Assert.assertArrayEquals(odotus2, tulos2);

        int[][] peli3 = new int[][]{
            {3, 2, 2, 3, 0, 4, 2, 2, 4},
            {2, 2, 3, 4, 1, 2, 4, 2, 2},
            {2, 2, 2, 2, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 2, 2, 5, 2},
            {1, 4, 1, 2, 0, 2, 5, 2, 5},
            {2, 2, 2, 4, 2, 2, 2, 5, 2},
            {0, 4, 2, 2, 0, 1, 1, 0, 0},
            {1, 1, 1, 1, 0, 1, 0, 0, 0}
        };

        int[][] odotus3 = new int[][]{
            {0, 0, 0, 0, 240, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 376, 0, 0, 0, 0},
            {36, 0, 36, 0, 488, 216, 0, 0, 0},
            {12, 24, 12, 148, 136, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        int[][] tulos3 = aly.pellonSijoitusMatriisi(pelaajat, peli3, pelaaja);

        Assert.assertArrayEquals(odotus3, tulos3);

        int[][] peli4 = new int[][]{
            {1, 3, 1, 1, 0, 0, 1, 0, 0},
            {3, 2, 3, 0, 1, 0, 0, 1, 0},
            {1, 4, 1, 1, 0, 1, 0, 1, 2},
            {1, 0, 1, 1, 0, 0, 0, 2, 4},
            {0, 0, 0, 0, 0, 1, 2, 5, 2},
            {1, 4, 1, 0, 0, 2, 5, 2, 5},
            {4, 2, 3, 1, 1, 1, 2, 5, 2},
            {0, 4, 0, 0, 0, 1, 1, 3, 2},
            {1, 1, 1, 1, 0, 1, 0, 0, 3}
        };

        int[][] odotus4 = new int[][]{
            {0, 0, 0, 0, 5, 0, 0, 10, 10},
            {0, 0, 0, 15, 0, 10, 10, 0, 32},
            {0, 0, 0, 0, 15, 0, 84, 0, 0},
            {0, 40, 0, 0, 20, 94, 148, 0, 0},
            {35, 60, 40, 30, 57, 0, 0, 0, 0},
            {0, 0, 0, 40, 47, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {15, 0, 20, 20, 5, 0, 0, 0, 0},
            {0, 0, 0, 0, 5, 0, 74, 138, 0}
        };

        int[][] tulos4 = aly.pellonSijoitusMatriisi(pelaajat, peli4, pelaaja);

        Assert.assertArrayEquals(odotus4, tulos4);

    }

}