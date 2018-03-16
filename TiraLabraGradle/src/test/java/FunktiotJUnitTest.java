
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class FunktiotJUnitTest {

    Funktiot funktiot;

    public FunktiotJUnitTest() {
        this.funktiot = new Funktiot();
    }
    
    @Test
    public void seuraajatVieressaJaKulmissa() {
        
       int[] pelaajat = new int[]{3, 4, 5, 6};

        int[][] peli1 = new int[][]{
            {4, 2, 2, 1, 2, 2, 6},
            {2, 3, 2, 1, 2, 5, 2},
            {2, 2, 4, 0, 6, 2, 2},
            {0, 0, 0, 0, 0, 0, 1},
            {0, 0, 2, 2, 6, 1, 1},
            {0, 0, 4, 2, 2, 1, 0},
            {1, 1, 2, 2, 2, 0, 0}
        };

        int[][] odotus1 = new int[][]{
            {3, 4, 5, 6},
            {1, 3, 1, 3}
        };

        int[][] tulos1 = funktiot.seuraajatVieressaJaKulmissa(3, 3, pelaajat, peli1);
        
        Assert.assertArrayEquals(odotus1, tulos1);
        
        int[][] odotus2 = new int[][]{
            {3, 4, 5, 6},
            {0, 0, 0, 0}
        };

        int[][] tulos2 = funktiot.seuraajatVieressaJaKulmissa(6, 0, pelaajat, peli1);
        
        Assert.assertArrayEquals(odotus2, tulos2);        
        
    }

    @Test
    public void tulostaPistetaulu() {
        int[][] pisteet = new int[][]{
            {3,4,5,6},
            {234,545,654,323}
        };

        PrintStream oldOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        funktiot.tulostaPistetaulu(pisteet);

        System.setOut(oldOut);
        String output = new String(baos.toByteArray());

        assertTrue(output.contains("   3   4   5   6" + System.lineSeparator() +
                " 234 545 654 323"));
    }

    @Test
    public void tulostaBoolean() {

        boolean[][] lauta = new boolean[][]{
            {true, false},
            {false, true}
        };

        PrintStream oldOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        funktiot.tulostaBoolean(lauta);

        System.setOut(oldOut);
        String output = new String(baos.toByteArray());

        assertTrue(output.contains("T  F  "
                + System.lineSeparator() + "F  T  "));

    }

    @Test
    public void tulostaKartta() {

        int[][] lauta = new int[][]{
            {24, 45},
            {12, 67}
        };

        PrintStream oldOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        funktiot.tulostaKartta(lauta);

        System.setOut(oldOut);
        String output = new String(baos.toByteArray());

        assertTrue(output.contains("   24   45"
                + System.lineSeparator() + "   12   67"));

    }

    @Test
    public void kopioiKartta() {

        int[][] kartta = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] uusi = funktiot.kopioiKartta(kartta);

        Assert.assertArrayEquals(kartta, uusi);

    }

    @Test
    public void kopioiBoolean() {

        boolean[][] boolean1 = new boolean[][]{
            {true, false},
            {false, true}
        };

        boolean[][] uusi1 = funktiot.kopioiBoolean(boolean1);

        Assert.assertArrayEquals(boolean1, uusi1);

    }

    @Test
    public void kopioiLautaLista() {

        Lista laudat = new Lista();

        int[][] lauta1 = new int[][]{
            {1, 2},
            {3, 4}
        };

        int[][] lauta2 = new int[][]{
            {5, 6},
            {7, 8}
        };

        laudat.add(lauta1);
        laudat.add(lauta2);

        Lista kopio = funktiot.kopioiLautaLista(laudat);

        int[][] kopio1 = (int[][])kopio.get(0);
        int[][] kopio2 = (int[][])kopio.get(1);

        Assert.assertArrayEquals(lauta1, kopio1);
        Assert.assertArrayEquals(lauta2, kopio2);
    }

    @Test
    public void kopioiPisteTaulu() {

        int[] pelaajat = new int[]{3, 4, 5};

        int[][] odotus1 = new int[][]{
            {3, 4, 5},
            {6, 7, 8}
        };

        int[][] tulos1 = funktiot.kopioiPisteTaulu(pelaajat, odotus1);

        Assert.assertArrayEquals(odotus1, tulos1);

    }

    @Test
    public void pisteetVieressaJaKulmissa() {

        int[][] peli1 = new int[][]{
            {2, 2, 2, 2, 2, 2, 2},
            {2, 3, 2, 2, 2, 5, 2},
            {2, 2, 4, 2, 6, 2, 3},
            {0, 0, 0, 0, 0, 0, 1},
            {2, 2, 2, 1, 2, 2, 2},
            {2, 2, 2, 0, 2, 5, 2},
            {2, 2, 2, 0, 2, 2, 2}
        };

        int odotus1 = 39;
        int tulos1 = funktiot.pisteetVieressaJaKulmissa(3, 3, peli1);

        assertEquals(odotus1, tulos1);

        int[][] peli2 = new int[][]{
            {0, 2, 2, 2, 2, 2, 2},
            {0, 3, 2, 2, 2, 5, 2},
            {0, 2, 4, 2, 6, 2, 3},
            {0, 0, 0, 0, 0, 0, 1},
            {2, 2, 2, 1, 2, 2, 2},
            {2, 2, 2, 0, 2, 5, 2},
            {2, 2, 2, 0, 2, 2, 2}
        };

        int odotus2 = 18;
        int tulos2 = funktiot.pisteetVieressaJaKulmissa(0, 0, peli2);

        assertEquals(odotus2, tulos2);

    }

    @Test
    public void lisaaPisteitaVakiomaara() {

        int pelaajia = 4;
        int[] pelaajat = funktiot.luoPelaajaTaulu(pelaajia);
        int[][] pisteet = funktiot.luoPistetaulu(pelaajat);

        int[][] odotus = new int[][]{
            {3, 4, 5, 6},
            {5, 5, 5, 5}
        };

        int[][] tulos = funktiot.lisaaPisteitaVakiomaara(pelaajat, pisteet, 5);

        Assert.assertArrayEquals(odotus, tulos);

    }

    @Test
    public void ruudunViereistenLinnojenSeuraajat() {

        int[] pelaajat = new int[]{3, 4, 5, 6};

        int[][] peli1 = new int[][]{
            {0, 0, 2, 1, 2, 0, 0},
            {0, 3, 2, 1, 2, 5, 0},
            {2, 2, 4, 0, 6, 2, 3},
            {0, 0, 0, 0, 0, 0, 1},
            {2, 3, 2, 1, 6, 2, 4},
            {0, 2, 4, 0, 2, 5, 0},
            {0, 0, 2, 0, 2, 0, 0}
        };

        int[][] odotus1 = new int[][]{
            {3, 4, 5, 6},
            {0, 0, 0, 0}
        };

        int[][] tulos1 = funktiot.ruudunViereistenLinnojenSeuraajat(0, 0, pelaajat, peli1);

        Assert.assertArrayEquals(odotus1, tulos1);

        int[][] odotus2 = new int[][]{
            {3, 4, 5, 6},
            {1, 2, 1, 1}
        };

        int[][] tulos2 = funktiot.ruudunViereistenLinnojenSeuraajat(5, 3, pelaajat, peli1);

        Assert.assertArrayEquals(odotus2, tulos2);

        int[][] peli2 = new int[][]{
            {1, 1, 2, 2, 2, 1, 1},
            {1, 3, 2, 2, 2, 5, 1},
            {2, 2, 4, 2, 6, 2, 3},
            {2, 2, 2, 0, 2, 2, 2},
            {2, 3, 2, 2, 6, 2, 4},
            {1, 2, 4, 2, 2, 5, 1},
            {1, 1, 2, 2, 2, 1, 1}
        };

        int[][] odotus3 = new int[][]{
            {3, 4, 5, 6},
            {3, 3, 2, 2}
        };

        int[][] tulos3 = funktiot.ruudunViereistenLinnojenSeuraajat(3, 3, pelaajat, peli2);

        Assert.assertArrayEquals(odotus3, tulos3);

    }

    @Test
    public void seuraajatKulmittainLinnoissa() {

        int[] pelaajat = new int[]{3, 4, 5, 6};

        int[][] peli1 = new int[][]{
            {0, 0, 2, 1, 2, 0, 0},
            {0, 3, 2, 1, 2, 5, 0},
            {2, 2, 4, 0, 6, 2, 3},
            {0, 0, 0, 0, 0, 0, 1},
            {2, 3, 2, 1, 6, 2, 4},
            {0, 2, 4, 1, 2, 5, 0},
            {0, 0, 2, 0, 2, 0, 0}
        };

        int[][] odotus1 = new int[][]{
            {3, 4, 5, 6},
            {3, 3, 2, 2}
        };

        int[][] tulos1 = funktiot.seuraajatKulmittainLinnoissa(3, 3, pelaajat, peli1);

        Assert.assertArrayEquals(odotus1, tulos1);

        int[][] odotus2 = new int[][]{
            {3, 4, 5, 6},
            {1, 1, 0, 0}
        };

        int[][] tulos2 = funktiot.seuraajatKulmittainLinnoissa(0, 0, pelaajat, peli1);

        Assert.assertArrayEquals(odotus2, tulos2);

        int[][] peli2 = new int[][]{
            {0, 0, 2, 2, 2, 0, 0},
            {0, 3, 2, 2, 2, 5, 0},
            {2, 2, 4, 0, 6, 2, 3},
            {0, 0, 0, 0, 0, 2, 1},
            {2, 3, 2, 1, 0, 2, 4},
            {0, 2, 4, 1, 2, 5, 0},
            {0, 0, 2, 0, 6, 0, 0}
        };

        int[][] odotus3 = new int[][]{
            {3, 4, 5, 6},
            {3, 3, 2, 2}
        };

        int[][] tulos3 = funktiot.seuraajatKulmittainLinnoissa(3, 3, pelaajat, peli2);

        Assert.assertArrayEquals(odotus3, tulos3);

        int[][] peli3 = new int[][]{
            {0, 0, 2, 1, 2, 0, 0},
            {0, 3, 2, 1, 2, 5, 0},
            {2, 2, 2, 0, 0, 2, 3},
            {0, 0, 0, 0, 0, 0, 1},
            {2, 3, 0, 1, 0, 2, 4},
            {0, 2, 4, 1, 2, 5, 0},
            {0, 0, 2, 0, 2, 0, 0}
        };

        int[][] odotus4 = new int[][]{
            {3, 4, 5, 6},
            {1, 0, 0, 0}
        };

        int[][] tulos4 = funktiot.seuraajatKulmittainLinnoissa(3, 3, pelaajat, peli3);

        Assert.assertArrayEquals(odotus4, tulos4);

        int[][] peli4 = new int[][]{
            {1, 1, 2, 2, 2, 1, 1},
            {1, 3, 2, 2, 2, 5, 1},
            {2, 2, 4, 2, 6, 2, 3},
            {2, 2, 2, 0, 2, 2, 2},
            {2, 3, 2, 2, 6, 2, 4},
            {1, 2, 4, 2, 2, 5, 1},
            {1, 1, 2, 2, 2, 1, 1}
        };

        int[][] odotus5 = new int[][]{
            {3, 4, 5, 6},
            {3, 3, 2, 2}
        };

        int[][] tulos5 = funktiot.seuraajatKulmittainLinnoissa(3, 3, pelaajat, peli4);

        Assert.assertArrayEquals(odotus5, tulos5);

    }

    @Test
    public void kulmassaTaiVieressaOnLinna() {

        int[][] peli1 = new int[][]{
            {0, 0, 2, 1, 2, 2, 3},
            {0, 4, 2, 1, 2, 2, 0},
            {2, 2, 2, 0, 2, 0, 0},
            {2, 2, 2, 0, 0, 0, 0},
            {2, 2, 2, 1, 2, 0, 0},
            {2, 2, 4, 1, 2, 0, 0},
            {2, 3, 2, 0, 2, 0, 0}
        };

        boolean odotus1 = true;
        boolean tulos1 = funktiot.kulmassaTaiVieressaOnLinna(0, 0, peli1);
        assertEquals(odotus1, tulos1);

        boolean odotus2 = false;
        boolean tulos2 = funktiot.kulmassaTaiVieressaOnLinna(6, 6, peli1);
        assertEquals(odotus2, tulos2);

    }

    @Test
    public void otaPelaajaltaSeuraaja() {

        int pelaaja = 7;
        int pelaajia = 5;

        int[][] seuraajat1 = new int[][]{
            {3, 4, 5, 6, 7},
            {2, 1, 1, 1, 2}
        };

        int[][] odotus1 = new int[][]{
            {3, 4, 5, 6, 7},
            {2, 1, 1, 1, 1}
        };

        int[][] tulos1 = funktiot.otaPelaajaltaSeuraaja(pelaaja, pelaajia, seuraajat1);

        Assert.assertArrayEquals(odotus1, tulos1);

        int[][] seuraajat2 = new int[][]{
            {3, 4, 5, 6, 7},
            {2, 1, 1, 1, 0}
        };

        int[][] odotus2 = new int[][]{
            {3, 4, 5, 6, 7},
            {2, 1, 1, 1, 0}
        };

        int[][] tulos2 = funktiot.otaPelaajaltaSeuraaja(pelaaja, pelaajia, seuraajat2);

        Assert.assertArrayEquals(odotus2, tulos2);

    }

    @Test
    public void asetaSeuraaja() {

        int pelaaja = 4;

        int[][] peli1 = new int[][]{
            {0, 0, 2, 1, 2, 2, 3},
            {0, 2, 2, 1, 2, 2, 0},
            {2, 2, 2, 0, 2, 0, 0},
            {2, 2, 2, 0, 0, 0, 0},
            {2, 2, 2, 1, 2, 0, 0},
            {2, 2, 4, 1, 2, 0, 0},
            {2, 3, 2, 0, 2, 0, 0}
        };

        int[][] odotus1 = new int[][]{
            {0, 0, 2, 1, 2, 2, 3},
            {0, 4, 2, 1, 2, 2, 0},
            {2, 2, 2, 0, 2, 0, 0},
            {2, 2, 2, 0, 0, 0, 0},
            {2, 2, 2, 1, 2, 0, 0},
            {2, 2, 4, 1, 2, 0, 0},
            {2, 3, 2, 0, 2, 0, 0}
        };

        int[][] tulos1 = funktiot.asetaSeuraaja(1, 1, pelaaja, peli1);

        Assert.assertArrayEquals(odotus1, tulos1);

    }

    @Test
    public void asetaLaatta() {

        int[][] peli1 = new int[][]{
            {0, 0, 2, 1, 2, 2, 3},
            {0, 2, 2, 1, 2, 2, 0},
            {2, 2, 2, 0, 2, 0, 0},
            {2, 2, 2, 0, 0, 0, 0},
            {2, 2, 2, 1, 2, 0, 0},
            {2, 2, 4, 1, 2, 0, 0},
            {2, 3, 2, 0, 2, 0, 0}
        };

        int laatta = 1;

        int[][] odotus1 = new int[][]{
            {1, 0, 2, 1, 2, 2, 3},
            {0, 2, 2, 1, 2, 2, 0},
            {2, 2, 2, 0, 2, 0, 0},
            {2, 2, 2, 0, 0, 0, 0},
            {2, 2, 2, 1, 2, 0, 0},
            {2, 2, 4, 1, 2, 0, 0},
            {2, 3, 2, 0, 2, 0, 0}
        };

        int[][] tulos1 = funktiot.asetaLaatta(0, 0, laatta, peli1);

        Assert.assertArrayEquals(odotus1, tulos1);

    }

    @Test
    public void taytaPakka() {

        Pino pino = funktiot.taytaPakka(50);
        int odotus1 = 50;
        int tulos1 = pino.size();

        assertEquals(odotus1, tulos1);

        boolean tulos2 = true;

        while (!pino.empty()) {
            int seuraava = (int) pino.pop();
            if (seuraava < 0 || seuraava > 2) {
                tulos2 = false;
            }
        }

        boolean odotus2 = true;

        assertEquals(odotus2, tulos2);

    }

    @Test
    public void kulmassaOnLinna() {

        int[][] peli1 = new int[][]{
            {0, 0, 2, 1, 2, 2, 3},
            {0, 2, 2, 1, 2, 2, 0},
            {2, 2, 2, 0, 2, 0, 0},
            {2, 2, 2, 0, 0, 0, 0},
            {2, 2, 2, 1, 2, 0, 0},
            {2, 2, 4, 1, 2, 0, 0},
            {2, 3, 2, 0, 2, 0, 0}
        };

        boolean odotus1 = true;
        boolean tulos1 = funktiot.kulmassaOnLinna(0, 0, peli1);
        assertEquals(odotus1, tulos1);

        boolean odotus2 = false;
        boolean tulos2 = funktiot.kulmassaOnLinna(6, 6, peli1);
        assertEquals(odotus2, tulos2);

    }

    @Test
    public void vieressaOnLinna() {

        int[][] peli1 = new int[][]{
            {0, 2, 2, 1, 2, 2, 3},
            {2, 2, 2, 1, 2, 2, 0},
            {2, 2, 2, 0, 2, 0, 0},
            {2, 2, 2, 0, 0, 0, 0},
            {2, 2, 2, 1, 2, 0, 0},
            {2, 2, 4, 1, 2, 2, 0},
            {2, 3, 2, 0, 2, 2, 0}
        };

        boolean odotus1 = false;
        boolean tulos1 = funktiot.vieressaOnLinna(3, 5, peli1);
        assertEquals(odotus1, tulos1);

        boolean odotus2 = true;
        boolean tulos2 = funktiot.vieressaOnLinna(3, 4, peli1);
        assertEquals(odotus2, tulos2);

        boolean odotus3 = true;
        boolean tulos3 = funktiot.vieressaOnLinna(0, 0, peli1);
        assertEquals(odotus3, tulos3);

        boolean odotus4 = true;
        boolean tulos4 = funktiot.vieressaOnLinna(6, 6, peli1);
        assertEquals(odotus4, tulos4);

    }

    @Test
    public void luoPelaajaTaulu() {

        int pelaajat1 = 1;
        int[] odotus1 = new int[]{3};
        int[] tulos1 = funktiot.luoPelaajaTaulu(pelaajat1);
        Assert.assertArrayEquals(odotus1, tulos1);

        int pelaajat2 = 2;
        int[] odotus2 = new int[]{3, 4};
        int[] tulos2 = funktiot.luoPelaajaTaulu(pelaajat2);
        Assert.assertArrayEquals(odotus2, tulos2);

        int pelaajat3 = 4;
        int[] odotus3 = new int[]{3, 4, 5, 6};
        int[] tulos3 = funktiot.luoPelaajaTaulu(pelaajat3);
        Assert.assertArrayEquals(odotus3, tulos3);

    }

    @Test
    public void kulmittaistenLinnojenPisteet() {

        int[][] peli1 = new int[][]{
            {0, 4, 2, 3, 2, 5, 2},
            {0, 0, 2, 2, 2, 2, 3},
            {0, 0, 0, 5, 2, 2, 2},
            {2, 0, 0, 0, 3, 2, 4},
            {2, 4, 0, 0, 0, 2, 2},
            {2, 2, 2, 0, 0, 0, 5},
            {3, 2, 4, 2, 0, 0, 0},};

        int odotus1 = 31;
        int tulos1 = funktiot.kulmittaistenLinnojenPisteet(3, 2, peli1);
        assertEquals(odotus1, tulos1);

        int[][] peli2 = new int[][]{
            {1, 4, 2, 3, 2, 5, 2},
            {2, 1, 2, 2, 2, 2, 3},
            {2, 3, 0, 5, 2, 2, 2},
            {2, 2, 2, 0, 3, 2, 4},
            {2, 4, 2, 5, 0, 2, 2},
            {2, 2, 2, 2, 3, 1, 5},
            {3, 2, 4, 2, 2, 3, 1},};

        int odotus2 = 42;
        int tulos2 = funktiot.kulmittaistenLinnojenPisteet(3, 3, peli2);
        assertEquals(odotus2, tulos2);

        int[][] peli3 = new int[][]{
            {1, 4, 2, 3, 2, 5, 2},
            {2, 1, 2, 2, 2, 0, 3},
            {4, 2, 0, 5, 0, 2, 2},
            {2, 3, 2, 0, 3, 2, 4},
            {2, 2, 1, 2, 0, 2, 2},
            {5, 1, 2, 2, 2, 0, 5},
            {0, 5, 2, 2, 2, 4, 0},};

        int odotus3 = 0;
        int tulos3 = funktiot.kulmittaistenLinnojenPisteet(3, 3, peli3);
        assertEquals(odotus3, tulos3);

        int[][] peli4 = new int[][]{
            {0, 4, 2, 3, 2, 2, 0},
            {0, 0, 3, 2, 2, 0, 0},
            {0, 0, 1, 2, 1, 0, 2},
            {0, 1, 0, 0, 0, 0, 0},
            {0, 0, 2, 1, 2, 4, 2},
            {0, 2, 4, 1, 0, 2, 5},
            {2, 3, 2, 0, 0, 0, 2}
        };

        int odotus4 = 12;
        int tulos4 = funktiot.kulmittaistenLinnojenPisteet(3, 3, peli4);
        assertEquals(odotus4, tulos4);

        int[][] peli5 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 2, 2, 2, 2, 2, 3},
            {0, 2, 2, 5, 2, 2, 2},
            {0, 2, 2, 2, 3, 2, 4},
            {0, 4, 2, 2, 2, 2, 2},
            {0, 2, 2, 2, 2, 2, 5},
            {0, 2, 4, 2, 2, 2, 2},};

        int odotus5 = 36;
        int tulos5 = funktiot.kulmittaistenLinnojenPisteet(0, 0, peli5);
        assertEquals(odotus5, tulos5);

        int[][] peli6 = new int[][]{
            {2, 2, 2, 1, 2, 2, 3},
            {2, 2, 2, 1, 2, 2, 0},
            {2, 2, 2, 0, 2, 0, 2},
            {2, 2, 2, 0, 0, 0, 0},
            {2, 2, 2, 1, 2, 0, 0},
            {2, 2, 4, 1, 2, 2, 0},
            {2, 3, 2, 0, 2, 2, 2}
        };

        int odotus6 = 33;
        int tulos6 = funktiot.kulmittaistenLinnojenPisteet(3, 3, peli6);
        assertEquals(odotus6, tulos6);

    }

    @Test
    public void viereistenLinnojenPisteet() {

        int[][] peli1 = new int[][]{
            {0, 4, 2, 3, 2, 5, 2},
            {0, 0, 2, 2, 2, 2, 3},
            {0, 0, 0, 5, 2, 2, 2},
            {0, 0, 0, 0, 3, 2, 4},
            {0, 0, 0, 0, 0, 2, 2},
            {0, 0, 0, 0, 0, 0, 5},
            {0, 0, 0, 0, 0, 0, 0}
        };

        int odotus1 = 21;
        int tulos1 = funktiot.viereistenLinnojenPisteet(0, 0, peli1);

        assertEquals(odotus1, tulos1);

        int[][] peli2 = new int[][]{
            {0, 0, 2, 2, 2, 0, 0},
            {0, 1, 2, 5, 2, 0, 0},
            {0, 0, 3, 2, 2, 1, 0},
            {2, 2, 2, 0, 3, 2, 4},
            {2, 2, 2, 1, 2, 2, 2},
            {2, 2, 2, 0, 2, 2, 5},
            {0, 1, 0, 0, 1, 0, 0},};

        int odotus2 = 27;
        int tulos2 = funktiot.viereistenLinnojenPisteet(3, 3, peli2);

        assertEquals(odotus2, tulos2);

        int[][] peli3 = new int[][]{
            {0, 0, 2, 2, 2, 0, 0},
            {0, 1, 2, 5, 2, 0, 0},
            {2, 2, 0, 2, 0, 2, 2},
            {2, 2, 2, 0, 3, 2, 4},
            {2, 2, 0, 2, 0, 2, 2},
            {0, 0, 2, 2, 2, 0, 0},
            {0, 1, 2, 2, 2, 0, 0},};

        int odotus3 = 28;
        int tulos3 = funktiot.viereistenLinnojenPisteet(3, 3, peli3);

        assertEquals(odotus3, tulos3);

        int odotus4 = 0;
        int tulos4 = funktiot.viereistenLinnojenPisteet(0, 0, peli3);

        assertEquals(odotus4, tulos4);

        int[][] peli5 = new int[][]{
            {0, 4, 2, 3, 2, 5, 2},
            {0, 0, 2, 2, 2, 2, 3},
            {0, 0, 0, 5, 2, 2, 2},
            {0, 0, 0, 0, 3, 2, 4},
            {0, 0, 0, 0, 0, 2, 2},
            {0, 0, 0, 0, 0, 0, 5},
            {0, 0, 0, 0, 0, 0, 0}
        };

        int odotus5 = 0;
        int tulos5 = funktiot.viereistenLinnojenPisteet(1, 0, peli5);
        assertEquals(odotus5, tulos5);

    }

    @Test
    public void onkoVapaa() {

        int[][] peli1 = new int[][]{
            {0, 1, 2, 1, 0},
            {1, 1, 4, 1, 1},
            {2, 5, 2, 5, 2},
            {1, 1, 4, 1, 1},
            {0, 1, 2, 1, 0}
        };

        boolean odotus1 = false;
        boolean tulos1 = funktiot.onkoVapaa(2, 2, peli1);

        assertEquals(odotus1, tulos1);

        boolean odotus2 = true;
        boolean tulos2 = funktiot.onkoVapaa(0, 0, peli1);

        assertEquals(odotus2, tulos2);

    }

    @Test
    public void poistaSeuraajat() {

        int[][] peli1 = new int[][]{
            {0, 1, 2, 1, 0},
            {1, 1, 4, 1, 1},
            {2, 5, 2, 5, 2},
            {1, 1, 4, 1, 1},
            {0, 1, 2, 1, 0}
        };

        int[][] odotus1 = new int[][]{
            {0, 1, 2, 1, 0},
            {1, 1, 2, 1, 1},
            {2, 2, 2, 2, 2},
            {1, 1, 2, 1, 1},
            {0, 1, 2, 1, 0}
        };

        int[][] tulos1 = funktiot.poistaSeuraajat(2, 2, peli1);

        Assert.assertArrayEquals(odotus1, tulos1);

        int[][] peli2 = new int[][]{
            {0, 0, 4, 0, 0},
            {0, 2, 2, 2, 0},
            {5, 2, 3, 2, 5},
            {0, 2, 2, 2, 0},
            {0, 0, 4, 0, 0}
        };

        int[][] odotus2 = new int[][]{
            {0, 0, 4, 0, 0},
            {0, 2, 2, 2, 0},
            {5, 2, 3, 2, 5},
            {0, 2, 2, 2, 0},
            {0, 0, 4, 0, 0}
        };

        int[][] tulos2 = funktiot.poistaSeuraajat(2, 2, peli2);

        Assert.assertArrayEquals(odotus2, tulos2);

        int[][] peli3 = new int[][]{
            {0, 0, 4, 0, 0},
            {0, 2, 2, 2, 0},
            {5, 2, 3, 2, 5},
            {0, 2, 2, 2, 0},
            {0, 0, 4, 0, 0}
        };

        int[][] odotus3 = new int[][]{
            {0, 0, 4, 0, 0},
            {0, 2, 2, 2, 0},
            {5, 2, 3, 2, 5},
            {0, 2, 2, 2, 0},
            {0, 0, 4, 0, 0}
        };

        int[][] tulos3 = funktiot.poistaSeuraajat(0, 0, peli3);

        Assert.assertArrayEquals(odotus3, tulos3);
    }

    @Test
    public void pelaajillePisteetLinnasta() {

        int[] pelaajat1 = new int[]{3, 4, 5};

        int[][] peli1 = new int[][]{
            {3, 1, 1, 1, 1},
            {4, 2, 1, 1, 1},
            {5, 3, 2, 1, 0},
            {4, 2, 1, 1, 1},
            {3, 1, 0, 0, 0},};

        int[][] odotus1 = new int[][]{
            {3, 4, 5},
            {9, 0, 0}
        };

        int[][] tulos1 = funktiot.pelaajillePisteetLinnassa(0, 0, pelaajat1, peli1);
        Assert.assertArrayEquals(odotus1, tulos1);

        int[] pelaajat2 = new int[]{3, 4, 5, 6};

        int[][] peli2 = new int[][]{
            {0, 1, 1, 1, 0},
            {5, 2, 3, 2, 6},
            {2, 3, 2, 6, 2},
            {5, 2, 3, 2, 6},
            {0, 1, 1, 1, 0},};

        int[][] odotus2 = new int[][]{
            {3, 4, 5, 6},
            {15, 0, 0, 15}
        };

        int[][] tulos2 = funktiot.pelaajillePisteetLinnassa(2, 0, pelaajat2, peli2);
        Assert.assertArrayEquals(odotus2, tulos2);

        int[] pelaajat3 = new int[]{3, 4, 5, 6, 7};

        int[][] peli3 = new int[][]{
            {4, 2, 2, 2, 2, 2, 3, 0, 0, 2},
            {2, 5, 2, 2, 2, 3, 2, 0, 0, 2},
            {2, 2, 6, 2, 3, 2, 2, 0, 0, 2},
            {2, 2, 2, 7, 2, 2, 2, 0, 0, 2},
            {2, 2, 3, 2, 6, 2, 2, 0, 0, 2},
            {2, 3, 2, 2, 2, 5, 2, 0, 0, 2},
            {3, 2, 2, 2, 2, 2, 4, 0, 0, 2},
            {0, 0, 0, 0, 0, 0, 0, 2, 2, 3},
            {0, 0, 0, 0, 0, 0, 0, 2, 3, 2},
            {2, 2, 2, 2, 2, 2, 2, 3, 2, 3},};

        int[][] odotus3 = new int[][]{
            {3, 4, 5, 6, 7},
            {49, 0, 0, 0, 0}
        };

        int[][] tulos3 = funktiot.pelaajillePisteetLinnassa(0, 0, pelaajat3, peli3);
        Assert.assertArrayEquals(odotus3, tulos3);

        int[] pelaajat4 = new int[]{3, 4, 5, 6, 7};

        int[][] peli4 = new int[][]{
            {4, 2, 2, 2, 2, 2, 2, 1, 0, 2},
            {2, 5, 2, 2, 2, 2, 2, 1, 0, 2},
            {2, 2, 1, 1, 1, 2, 2, 1, 0, 2},
            {2, 2, 1, 0, 1, 2, 2, 1, 0, 2},
            {2, 2, 1, 1, 1, 2, 2, 1, 0, 2},
            {2, 2, 2, 2, 2, 5, 2, 1, 0, 2},
            {2, 2, 2, 2, 2, 2, 4, 1, 0, 2},
            {1, 1, 1, 1, 1, 1, 1, 0, 0, 3},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 3, 2, 3},};

        int[][] odotus4 = new int[][]{
            {3, 4, 5, 6, 7},
            {0, 40, 40, 0, 0}
        };

        int[][] tulos4 = funktiot.pelaajillePisteetLinnassa(0, 0, pelaajat4, peli4);
        Assert.assertArrayEquals(odotus4, tulos4);
    }

    @Test
    public void onValmis() {

        int[][] peli1 = new int[][]{
            {2, 0, 1, 0, 2},
            {0, 1, 3, 1, 0},
            {1, 4, 2, 6, 1},
            {0, 1, 5, 1, 0},
            {2, 0, 1, 0, 2},};

        boolean odotus1 = true;
        boolean tulos1 = funktiot.onValmis(2, 2, peli1);
        assertEquals(odotus1, tulos1);

        int[][] peli2 = new int[][]{
            {0, 1, 1, 1, 0},
            {1, 4, 2, 4, 1},
            {1, 2, 3, 2, 1},
            {1, 5, 2, 3, 1},
            {0, 1, 1, 1, 0},};

        boolean odotus2 = true;
        boolean tulos2 = funktiot.onValmis(2, 2, peli2);
        assertEquals(odotus2, tulos2);

        int[][] peli3 = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 3, 1, 0},
            {0, 1, 2, 1, 0},
            {0, 2, 4, 2, 0},};

        boolean odotus3 = false;
        boolean tulos3 = funktiot.onValmis(2, 2, peli3);
        assertEquals(odotus3, tulos3);

        int[][] peli4 = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 2, 2, 2, 0},
            {0, 2, 3, 2, 0},
            {0, 2, 2, 2, 0},
            {0, 0, 0, 0, 0},};

        boolean odotus4 = false;
        boolean tulos4 = funktiot.onValmis(2, 2, peli4);
        assertEquals(odotus4, tulos4);

        int[][] peli5 = new int[][]{
            {0, 1, 1, 0, 0},
            {1, 2, 2, 2, 0},
            {1, 2, 3, 2, 0},
            {0, 2, 2, 2, 0},
            {0, 0, 0, 0, 0},};

        boolean odotus5 = false;
        boolean tulos5 = funktiot.onValmis(2, 2, peli5);
        assertEquals(odotus5, tulos5);

        int[][] peli6 = new int[][]{
            {0, 0, 0, 0, 0},
            {1, 1, 0, 1, 1},
            {1, 2, 3, 2, 1},
            {1, 1, 2, 1, 1},
            {2, 4, 2, 5, 2},};

        boolean odotus6 = false;
        boolean tulos6 = funktiot.onValmis(2, 2, peli6);
        assertEquals(odotus6, tulos6);

        int[][] peli7 = new int[][]{
            {1, 1, 1, 1, 1},
            {1, 1, 0, 1, 1},
            {1, 1, 3, 1, 1},
            {1, 2, 2, 1, 1},
            {2, 4, 2, 5, 2},};

        boolean odotus7 = false;
        boolean tulos7 = funktiot.onValmis(4, 4, peli7);
        assertEquals(odotus7, tulos7);

        boolean odotus8 = false;
        boolean tulos8 = funktiot.onValmis(0, 0, peli7);
        assertEquals(odotus8, tulos8);

    }

    @Test
    public void onkoLinnassaJoSeuraaja() {

        int[][] peli1 = new int[][]{
            {3, 2, 1, 1, 2},
            {2, 1, 2, 1, 2},
            {1, 2, 2, 2, 2},
            {2, 1, 2, 1, 2},
            {2, 3, 1, 1, 2},};

        boolean odotus1 = false;
        boolean tulos1 = funktiot.onkoLinnassaJoSeuraaja(4, 4, peli1);
        assertEquals(odotus1, tulos1);

        int[][] peli2 = new int[][]{
            {1, 1, 1, 2, 3},
            {1, 2, 2, 2, 1},
            {2, 2, 2, 2, 1},
            {2, 2, 2, 1, 1},
            {2, 1, 1, 1, 1},};

        boolean odotus2 = true;
        boolean tulos2 = funktiot.onkoLinnassaJoSeuraaja(4, 0, peli2);
        assertEquals(odotus2, tulos2);

        int[][] peli3 = new int[][]{
            {2, 2, 2, 2, 2},
            {2, 1, 1, 1, 2},
            {2, 1, 4, 0, 2},
            {2, 1, 2, 1, 2},
            {2, 2, 2, 1, 4},};

        boolean odotus3 = true;
        boolean tulos3 = funktiot.onkoLinnassaJoSeuraaja(0, 0, peli3);
        assertEquals(odotus3, tulos3);

        int[][] peli4 = new int[][]{
            {3, 1, 2, 1, 4},
            {0, 2, 2, 2, 1},
            {2, 2, 2, 2, 2},
            {0, 2, 2, 2, 1},
            {6, 0, 2, 1, 5},};

        boolean odotus4 = false;
        boolean tulos4 = funktiot.onkoLinnassaJoSeuraaja(2, 2, peli4);
        assertEquals(odotus4, tulos4);

        int[][] peli5 = new int[][]{
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 0, 2, 2, 2, 2, 2, 2, 2, 0},
            {2, 0, 2, 0, 2, 0, 2, 0, 0, 3},};

        boolean odotus5 = false;
        boolean tulos5 = funktiot.onkoLinnassaJoSeuraaja(0, 0, peli5);
        assertEquals(odotus5, tulos5);

        int[][] peli6 = new int[][]{
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 0, 2, 2, 2, 0, 2, 2, 2, 0},
            {2, 2, 2, 0, 2, 2, 2, 0, 2, 5},};

        boolean odotus6 = true;
        boolean tulos6 = funktiot.onkoLinnassaJoSeuraaja(0, 0, peli6);
        assertEquals(odotus6, tulos6);

    }

    @Test
    public void linnassaOlevatSeuraajat() {

        int[] pelaajat1 = new int[]{3, 4, 5};

        int[][] peli1 = new int[][]{
            {3, 1, 0, 0, 0},
            {4, 2, 1, 1, 1},
            {5, 3, 2, 2, 2},
            {4, 2, 1, 1, 1},
            {3, 1, 0, 0, 0},};

        int[][] odotus1 = new int[][]{
            {3, 4, 5},
            {3, 2, 1}
        };

        int[][] tulos1 = funktiot.linnassaOlevatSeuraajat(0, 0, pelaajat1, peli1);
        Assert.assertArrayEquals(odotus1, tulos1);

        int[] pelaajat2 = new int[]{3, 4, 5, 6};

        int[][] peli2 = new int[][]{
            {0, 1, 1, 1, 2},
            {2, 2, 3, 2, 6},
            {5, 2, 2, 3, 3},
            {2, 3, 2, 2, 6},
            {0, 1, 1, 1, 2},};

        int[][] odotus2 = new int[][]{
            {3, 4, 5, 6},
            {4, 0, 1, 2}
        };

        int[][] tulos2 = funktiot.linnassaOlevatSeuraajat(2, 2, pelaajat2, peli2);
        Assert.assertArrayEquals(odotus2, tulos2);

        int[] pelaajat3 = new int[]{3, 4, 5, 6, 7, 8};

        int[][] peli3 = new int[][]{
            {2, 8, 2, 7, 2, 6, 2, 5, 2, 2},
            {8, 2, 7, 2, 6, 2, 5, 2, 4, 0},
            {2, 7, 2, 6, 2, 5, 2, 4, 0, 0},
            {7, 2, 6, 2, 5, 2, 4, 0, 0, 0},
            {2, 6, 2, 5, 2, 4, 0, 0, 0, 0},
            {6, 2, 5, 2, 4, 0, 0, 0, 0, 0},
            {2, 5, 2, 4, 0, 0, 0, 0, 0, 1},
            {5, 2, 4, 0, 0, 0, 0, 0, 1, 3},
            {2, 4, 0, 0, 0, 0, 0, 1, 3, 2},
            {2, 0, 0, 0, 0, 0, 1, 3, 2, 3},};

        int[][] odotus3 = new int[][]{
            {3, 4, 5, 6, 7, 8},
            {0, 8, 8, 6, 4, 2}
        };

        int[][] tulos3 = funktiot.linnassaOlevatSeuraajat(2, 2, pelaajat3, peli3);
        Assert.assertArrayEquals(odotus3, tulos3);

        int[] pelaajat4 = new int[]{3, 4, 5, 6, 7};

        int[][] peli4 = new int[][]{
            {4, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 5, 2, 2, 2, 2, 2, 0, 0, 2},
            {2, 2, 6, 2, 2, 2, 2, 0, 0, 2},
            {2, 2, 2, 7, 2, 2, 2, 0, 0, 2},
            {2, 2, 2, 2, 6, 2, 2, 0, 0, 2},
            {2, 2, 2, 2, 2, 5, 2, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 4, 0, 0, 2},
            {0, 0, 0, 0, 0, 0, 0, 2, 2, 3},
            {0, 0, 0, 0, 0, 0, 0, 2, 3, 2},
            {2, 2, 2, 2, 2, 2, 2, 3, 2, 3},};

        int[][] odotus4 = new int[][]{
            {3, 4, 5, 6, 7},
            {4, 2, 2, 2, 1}
        };

        int[][] tulos4 = funktiot.linnassaOlevatSeuraajat(2, 2, pelaajat4, peli4);
        Assert.assertArrayEquals(odotus4, tulos4);

    }

    @Test
    public void merkitseLinnaPisteytetyksi() {

        int[][] peli1 = new int[][]{
            {3, 2, 1, 0, 0},
            {2, 1, 2, 1, 0},
            {1, 2, 2, 2, 1},
            {0, 1, 2, 1, 0},
            {0, 0, 1, 0, 0},};

        boolean[][] odotus1 = new boolean[][]{
            {false, false, false, false, false},
            {false, false, true, false, false},
            {false, true, true, true, false},
            {false, false, true, false, false},
            {false, false, false, false, false}
        };

        boolean[][] uusi1 = new boolean[peli1.length][peli1.length];
        boolean[][] tulos1 = funktiot.merkitseLinnaPisteytetyksi(2, 2, peli1, uusi1);
        Assert.assertArrayEquals(odotus1, tulos1);

        int[][] peli2 = new int[][]{
            {1, 1, 1, 2, 3},
            {1, 2, 2, 2, 1},
            {2, 2, 2, 2, 1},
            {2, 2, 2, 0, 1},
            {2, 1, 1, 1, 1},};

        boolean[][] odotus2 = new boolean[][]{
            {false, false, false, true, true},
            {false, true, true, true, false},
            {true, true, true, true, false},
            {true, true, true, false, false},
            {true, false, false, false, false}
        };

        boolean[][] uusi2 = new boolean[peli1.length][peli1.length];
        boolean[][] tulos2 = funktiot.merkitseLinnaPisteytetyksi(4, 0, peli2, uusi2);
        Assert.assertArrayEquals(odotus2, tulos2);

        int[][] peli3 = new int[][]{
            {2, 2, 2, 2, 2},
            {2, 1, 1, 1, 2},
            {2, 1, 2, 0, 2},
            {2, 1, 2, 1, 2},
            {2, 2, 2, 1, 3},};

        boolean[][] odotus3 = new boolean[][]{
            {true, true, true, true, true},
            {true, false, false, false, true},
            {true, false, true, false, true},
            {true, false, true, false, true},
            {true, true, true, false, true}
        };

        boolean[][] uusi3 = new boolean[peli1.length][peli1.length];
        boolean[][] tulos3 = funktiot.merkitseLinnaPisteytetyksi(4, 0, peli3, uusi3);
        Assert.assertArrayEquals(odotus3, tulos3);
    }

    @Test
    public void linnanPisteet() {
        int[][] peli1 = new int[][]{
            {3, 2, 2, 0, 0},
            {2, 2, 2, 1, 0},
            {2, 2, 2, 0, 1},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0},};

        int odotus1 = 9;
        int tulos1 = funktiot.linnanPisteet(0, 0, peli1);
        assertEquals(odotus1, tulos1);

        int[][] peli2 = new int[][]{
            {1, 1, 1, 2, 3},
            {1, 2, 2, 2, 1},
            {2, 2, 4, 2, 1},
            {5, 2, 2, 0, 1},
            {2, 1, 1, 1, 1},};

        int odotus2 = 13;
        int tulos2 = funktiot.linnanPisteet(4, 0, peli2);
        assertEquals(odotus2, tulos2);

        int[][] peli3 = new int[][]{
            {2, 2, 2, 2, 2},
            {2, 1, 1, 1, 2},
            {2, 1, 2, 0, 2},
            {2, 1, 2, 1, 2},
            {2, 2, 2, 1, 3},};

        int odotus3 = 17;
        int tulos3 = funktiot.linnanPisteet(4, 4, peli3);
        assertEquals(odotus3, tulos3);

        int[][] peli4 = new int[][]{
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 1, 1, 0, 1, 2},
            {2, 4, 2, 2, 2, 5, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 1, 1, 1, 0, 0},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 2},
            {2, 4, 2, 2, 2, 5, 2, 2, 2, 2},
            {2, 0, 1, 1, 0, 0, 1, 1, 0, 0},
            {2, 1, 2, 2, 2, 2, 2, 2, 2, 0},
            {2, 1, 2, 0, 2, 0, 2, 0, 0, 3}
        };

        int odotus4 = 46;
        int tulos4 = funktiot.linnanPisteet(0, 0, peli4);
        assertEquals(odotus4, tulos4);

        int[][] peli5 = new int[][]{
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 0, 2, 2, 2, 0, 2, 2, 2, 0},
            {2, 2, 2, 0, 2, 2, 2, 0, 2, 3}
        };

        int odotus5 = 59;
        int tulos5 = funktiot.linnanPisteet(0, 0, peli5);
        assertEquals(odotus5, tulos5);

        int odotus6 = 0;
        int tulos6 = funktiot.linnanPisteet(1, 1, peli5);
        assertEquals(odotus6, tulos6);

    }

}
