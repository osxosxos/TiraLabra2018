
/**
 * Pino -tietorakenne pelin funktioiden ja tekoälyjen käyttöön.
 *
 * @author Oskari Koskinen
 */
public class Pino {

    private Object[] taulukko;
    private int paallimmainen;
    private int kapasiteetti;

    public Pino() {
        this.paallimmainen = -1;
        this.taulukko = new Object[10];
        this.kapasiteetti = 10;
    }

    /**
     * Ottaa pinosta päällimmäisen objektin.
     *
     * @return Palauttaa pinon päällimmäisen objektin.
     */
    public Object pop() {
        Object pois = this.taulukko[paallimmainen];
        this.paallimmainen--;
        return pois;
    }

    /**
     * Laittaa pinon päälle uuden objektin.
     *
     * @param object Pinoon laitettava objekti.
     */
    public void push(Object object) {
        if (this.paallimmainen + 1 == this.kapasiteetti) {
            Object[] uusi = new Object[this.kapasiteetti + 10];
            for (int i = 0; i < this.taulukko.length; i++) {
                uusi[i] = taulukko[i];
            }
            this.taulukko = uusi;
            this.kapasiteetti = this.kapasiteetti + 10;
        }

        this.paallimmainen++;
        this.taulukko[paallimmainen] = object;
    }

    /**
     * Kertoo onko pino tyhjä.
     *
     * @return Palauttaa arvon true, jos pino on tyhjä
     */
    public boolean empty() {
        return this.paallimmainen == -1;
    }

    /**
     * Kertoo montako objektia pinossa on
     *
     * @return
     */
    public int size() {
        return this.paallimmainen + 1;
    }

}
