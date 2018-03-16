/**
 * Lista -tietorakenne pelin funktioiden ja tekoälyjen käyttöön.
 *
 * @author Oskari Koskinen
 */
public class Lista {

    private int kapasiteetti;
    private Object[] taulukko;
    private int viimeinen;

    public Lista() {
        this.kapasiteetti = 10;
        this.taulukko = new Object[this.kapasiteetti];
        this.viimeinen = -1;
    }

    /**
     * Kertoo paljonko tavaraa listalla on.
     *
     * @return Palauttaa listan koon.
     */
    public int size() {
        return this.viimeinen + 1;
    }

    /**
     * Laittaa listalle uuden objektin. Kasvattaa listan kokoa jos ei mahdu.
     * @param objekti Listaan lisättävä alkio
     */
    public void add(Object objekti) {
        if (this.size() == this.kapasiteetti) {
            Object[] uusi = new Object[this.kapasiteetti + 10];
            for (int i = 0; i < this.taulukko.length; i++) {
                uusi[i] = taulukko[i];
            }
            this.taulukko = uusi;
            this.kapasiteetti = this.kapasiteetti + 10;
        }
        viimeinen++;
        this.taulukko[viimeinen] = objekti;
    }

    /**
     * Palauttaa listalta objektin indeksin perusteella. 
     * 
     * @param i palautettavan objektin indeksi.
     * @return 
     */
    public Object get(int i) {
        Object palautus = taulukko[i];
        return palautus;
    }
    
}