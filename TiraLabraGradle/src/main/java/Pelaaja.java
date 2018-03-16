
/**
 * Tässä luokassa on tiedot pelaajasta. Pelaajalla on numero, joka kertoo mitkä
 * seuraajat laudalla tuottavat hänelle pisteitä. Pelaajalla on seuraajia aluksi
 * vakiomäärä, eli 10. Tämä määrä vähenee pelin aikana, kun pelaajat asettavat
 * seuraajiaan linnoihin. Pelaajan pisteet ovat aluksi nolla. Niiden määrä
 * kasvaa pelin aikana, kun linnoja tulee valmiiksi. Lopuksi jokainen ei-valmis '
 * linna tuottaa myös pisteitä. Pelaajan boolean/arvot kertovat pelaajan
 * identiteetin, eli funktiot, joita pelaajalla on k
 *
 * @author Oskari Koskinen
 */
public class Pelaaja {

    int numero;
    int seuraajat;
    int pisteet;
    boolean ihminen;
    boolean detTekoAly;
    boolean peliPuuTekoAly;

    public Pelaaja(int numero, boolean ihm, boolean det, boolean puu) {
        this.numero = numero;
        this.seuraajat = 10;
        this.pisteet = 0;
        this.ihminen = ihm;
        this.detTekoAly = det;
        this.peliPuuTekoAly = puu;
    }

    /**
     * Lisää pelaajalle halutun määrän pisteitä.
     *
     * @param x Pisteet, jotka pelaaja tulee saamaan.
     */
    public void lisaaPisteita(int x) {
        this.pisteet = this.pisteet + x;
    }

    /**
     * Asettaa pelaajalle halutun vakiomäärän seuraajia.
     *
     * @param x Seuraajien määrä, joka asetetaan.
     */
    public void asetaSeuraajienMaara(int x) {
        this.seuraajat = x;
    }

    /**
     * Lisää seuraajia halutun määrän.
     *
     * @param x
     */
    public void lisaaSeuraajia(int x) {
        this.seuraajat = this.seuraajat + x;
    }

    /**
     * Palauttaa pelaajan seuraajien määrän.
     *
     * @return Pelaajalla olevien seuraajien määrä.
     */
    public int getSeuraajat() {
        return seuraajat;
    }

    /**
     * Kertoo pelaajan numeron.
     *
     * @return Palauttaa pelaajan numerotunnuksen.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Kertoo onko pelaaja ihminen.
     *
     * @return Palauttaa arvon true, jos pelaaja on ihminen. Muulloin false.
     */
    public boolean isIhminen() {
        return ihminen;
    }

    /**
     * Kertoo onko pelaaja determistinen tekoäly.
     *
     * @return Palauttaa arvon true, jos pelaaja on determistinen tekoäly.
     * Muulloin palauttaa arvon false.
     */
    public boolean isDetTekoAly() {
        return detTekoAly;
    }

    /**
     * Kertoo onko pelaaja pelipuutekoäly.
     *
     * @return Palauttaa arvon true, jos pelaaja on pelipuutekoäly. Muulloin
     * palauttaa arvon false.
     */
    public boolean isPeliPuuTekoAly() {
        return peliPuuTekoAly;
    }
    
    /**
     * Palauttaa pelaajan pisteet. 
     * @return Palauttaa int muuttujan, joka on pelaajan pisteet. 
     */
    public int getPisteet() {
        return pisteet;
    }

}
