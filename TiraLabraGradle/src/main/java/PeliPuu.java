
/**
 * Pelipuu -tietorakenne pelipuuhun perustuvan tekoälyn käyttöön.
 *
 * @author Löllö
 */
public class PeliPuu {

    int pelaaja;
    int vuorossaOlevaPelaaja;
    Lista laudat;
    Funktiot funktiot;

    public PeliPuu(int pelaaja, int vuorossaOlevaPelaaja, Lista laudat) {
        this.pelaaja = pelaaja;
        this.vuorossaOlevaPelaaja = vuorossaOlevaPelaaja;
        this.laudat = laudat;
        this.funktiot = new Funktiot();
    }

    /**
     * Kertoo kuka pelaajista tekee seuraavan siirron.
     *
     * @return
     */
    public int getVuorossaOlevaPelaaja() {
        return vuorossaOlevaPelaaja;
    }

    /**
     * Palauttaa pelitilanteiden listan, josta voi tarkastella miten peli on
     * edennyt.
     *
     * @return
     */
    public Lista getLaudat() {
        return laudat;
    }

}
