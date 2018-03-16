
import java.util.Random;

/**
 * Tästä luokasta löytyvät pelissä tarvittavat toiminnot.
 *
 * @author Oskari Koskinen
 */
public class Funktiot {

    public Funktiot() {

    }

    /**
     * Funktio arpoo pelin aluksi satunnaisen määrän linnoja ja peltoja pinoon.
     * Pelto on numero 1 ja linna on 2.
     *
     * @param koko Kertoo pelissä olevien laattojen määrän.
     * @return Funktio palauttaa valmiiksi sekoitetun pinon.
     */
    public Pino taytaPakka(int koko) {

        Pino laatat = new Pino();

        Random random = new Random();

        for (int i = 0; i < koko; i++) {

            int pala = random.nextInt(2);

            if (pala == 0) {
                laatat.push(1);
            }

            if (pala == 1) {
                laatat.push(2);
            }

        }

        return laatat;
    }

    /**
     * Tarkistaa, että ruutu ei ole ruudukon ulkopuolella.
     *
     * @param rivi Rivi, johon halutaan mennä.
     * @param sarake Sarake, johon halutaan mennä.
     * @param koko Laudan koko.
     * @return Palauttaa boolean arvon, joka kertoo onko ruutu pelilaudan
     * ulkopuolella.
     */
    public boolean voikoMenna(int rivi, int sarake, int koko) {
        return (rivi >= 0 && rivi < koko && sarake >= 0 && sarake < koko);
    }

    /**
     * Tarkistaa, että ruutu on tyhjä, eli siinä ei ole linnaa tai peltoa.
     *
     * @param rivi Rivi jossa ruutu sijaitsee.
     * @param sarake Sarake, jossa ruutu sijaitsee.
     * @param lauta Pelin tilanne.
     * @return Palauttaa boolean arvon, joka kertoo onko ruudun arvo nolla.
     */
    public boolean onkoVapaa(int rivi, int sarake, int[][] lauta) {
        return lauta[rivi][sarake] == 0;
    }

    /**
     * Asettaa laatan kartalle
     *
     * @param rivi Rivi, johon laatta halutaan asettaa.
     * @param sarake Sarake, johon laatta halutaan asettaa.
     * @param laatta Laatta, joka halutaan pelata, pelto(1) tai linna(2).
     * @param lauta Pelin tilanne ennne laatan asettamista.
     * @return Palauttaa pelitilanteen laatan sijoittamisen jälkeen.
     */
    public int[][] asetaLaatta(int rivi, int sarake, int laatta, int[][] lauta) {
        lauta[rivi][sarake] = laatta;
        return lauta;
    }

    /**
     * Funktio asettaa kartalle pelaajan numeroa vastaavan seuraajan.
     *
     * @param rivi Rivi, jossa haluttu ruutu on.
     * @param sarake Sarake, jossa halutta ruutu on.
     * @param pelaaja Minkä pelaajan seuraaja ruutuun ollaan asettamassa.
     * @param lauta Pelitilanne ennen seuraajan asettamista.
     * @return Palauttaa pelitilanteen johon on laitettu pelaajan seuraaja.
     */
    public int[][] asetaSeuraaja(int rivi, int sarake, int pelaaja, int[][] lauta) {
        lauta[rivi][sarake] = pelaaja;
        return lauta;
    }

    /**
     * Funktio saa syötteeksi kaksirivisen taulun. Ensimmäisellä rivillä on
     * pelaajien numerot, toisella heidän seuraajien määrät. Funktio poistaa
     * annetulta pelaajata yhden seuraajan.
     *
     * @param pelaaja Pelaaja, jolta seuraaja pitää poistaa.
     * @param pelaajia Pelissä olevien pelaajien määrä.
     * @param seuraajat Taulu, joka kertoo pelaajilla olevien seuraajien määrät.
     * @return Palauttaa taulun, josta parametrina annetulta pelaajalta on
     * poistettu yksi seuraaja.
     */
    public int[][] otaPelaajaltaSeuraaja(int pelaaja, int pelaajia, int[][] seuraajat) {

        int pelaajanSeuraajat = 0;

        for (int i = 0; i < pelaajia; i++) {
            if (seuraajat[0][i] == pelaaja) {
                pelaajanSeuraajat = seuraajat[1][i];
            }
        }

        if (pelaajanSeuraajat > 0) {
            for (int i = 0; i < pelaajia; i++) {
                if (seuraajat[0][i] == pelaaja) {
                    pelaajanSeuraajat = seuraajat[1][i] - 1;
                    seuraajat[1][i] = pelaajanSeuraajat;
                }
            }
        }

        return seuraajat;
    }

    /**
     * Tulostaa pelitilanteen.
     *
     * @param lauta Tämän hetkinen pelitilanne.
     */
    public void tulostaKartta(int[][] lauta) {

        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                System.out.format("%5d", lauta[i][j]);
            }
            System.out.println();
        }

    }

    /**
     * Luo kopion pelilaudasta, jotta alkuperäinen ei muuttuisi.
     *
     * @param lauta
     * @return Palauttaa kopion pelilaudasta.
     */
    public int[][] kopioiKartta(int[][] lauta) {

        int[][] kopio = new int[lauta.length][lauta.length];

        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                kopio[i][j] = lauta[i][j];
            }
        }

        return kopio;
    }

    /**
     * Luo kopion boolean ruudukosta, jotta alkuperäinen ei muuttuisi.
     *
     * @param kaydyt
     * @return palauttaa kopioidun boolean ruudukon.
     */
    public boolean[][] kopioiBoolean(boolean[][] kaydyt) {

        boolean[][] kopio = new boolean[kaydyt.length][kaydyt.length];

        for (int i = 0; i < kaydyt.length; i++) {
            for (int j = 0; j < kaydyt.length; j++) {
                kopio[i][j] = kaydyt[i][j];
            }
        }

        return kopio;
    }

    /**
     * Luo taulun, jossa on pelaajien numerot.
     *
     * @param pelaajat
     * @return Palauttaa taulun, jossa on pelaajien numerot.
     */
    public int[] luoPelaajaTaulu(int pelaajat) {

        int[] pelaajaTaulu = new int[pelaajat];

        int k = 3;

        for (int i = 0; i < pelaajat; i++) {
            pelaajaTaulu[i] = k;
            k++;
        }

        return pelaajaTaulu;
    }

    /**
     * Luo uuden taulun, jossa ensimmäisellä rivillä on pelaanjien numerot.
     * Toisella rivillä on mielivaltaista informaatiota tilanteen mukaan. Muu
     * informaatio annetaan muissa funktioissa, tässä se on nollaa.
     *
     * @param pelaajat
     * @return Palauttaa taulun, jossa ensimmäisellä rivillä on pelaajien
     * numerot ja toisella nollia.
     */
    public int[][] luoPistetaulu(int[] pelaajat) {
        int[][] pistetaulu = new int[2][pelaajat.length];
        for (int i = 0; i < pelaajat.length; i++) {
            pistetaulu[0][i] = pelaajat[i];
        }
        return pistetaulu;
    }

    /**
     * Tulostaa käytyjen ruutujen ruudukon.
     *
     * @param lauta Tämän hetkinen pelitilanne.
     */
    public void tulostaBoolean(boolean[][] lauta) {

        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                if (lauta[i][j] == true) {
                    System.out.print("T  ");
                } else {
                    System.out.print("F  ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Funktio tarkistaa, että linnassa ei ole kenenkään pelaajan seuraajia.
     *
     * @param rivi Rivi, josta lähdetään.
     * @param sarake Sarake, josta lähdetään.
     * @param lauta Pelitilanne, jota tarkastellaan.
     * @return Paluttaa true, jos linnasta löytyy arvo, joka on > 2.
     */
    public boolean onkoLinnassaJoSeuraaja(int rivi, int sarake, int[][] lauta) {

        if (lauta[rivi][sarake] > 2) {
            return true;
        }

        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];

        Pino pino = new Pino();

        int[] eka = new int[]{rivi, sarake};

        pino.push(eka);

        int[] rivit = new int[]{1, 0, -1, 0};
        int[] sarakkeet = new int[]{0, 1, 0, -1};

        while (!pino.empty()) {

            int[] edellinen = (int[]) pino.pop();

            kaydyt[edellinen[0]][edellinen[1]] = true;

            for (int i = 0; i < rivit.length; i++) {

                int uusiRivi = edellinen[0] + rivit[i];
                int uusiSarake = edellinen[1] + sarakkeet[i];

                if (voikoMenna(uusiRivi, uusiSarake, lauta.length)) {

                    if (lauta[uusiRivi][uusiSarake] > 2) {
                        return true;
                    } else if (lauta[uusiRivi][uusiSarake] == 2) {
                        int[] uusi = new int[]{uusiRivi, uusiSarake};
                        if (kaydyt[uusi[0]][uusi[1]] == false) {
                            pino.push(uusi);
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Apumetodi, joka merkitsee, että linna on jo pisteytetty. Funktio
     * merkitsee arvon true jokaiseen kohtaan, josta pelaajat ovat saaneet jo
     * pisteet. 
     *
     * @param rivi Rivi, josta lähdetään.
     * @param sarake Sarake, josta lähdetään.
     * @param lauta Pelitilanne, jota tarkastellaan.
     * @param kaydyt Pisteytetyt ruudut ennen funktion kutsua.
     * @return Palauttaa pisteytysruudukon, jossa linna on jo merkitty
     * pisteytetyksi.
     */
    public boolean[][] merkitseLinnaPisteytetyksi(int rivi, int sarake, int[][] lauta, boolean[][] kaydyt) {

        Pino pino = new Pino();

        int[] eka = new int[]{rivi, sarake};

        pino.push(eka);

        int[] rivit = new int[]{1, 0, -1, 0};
        int[] sarakkeet = new int[]{0, 1, 0, -1};

        while (!pino.empty()) {
            int[] edellinen = (int[]) pino.pop();

            if (kaydyt[edellinen[0]][edellinen[1]] == false) {
                kaydyt[edellinen[0]][edellinen[1]] = true;
            }

            for (int i = 0; i < rivit.length; i++) {

                int uusiRivi = edellinen[0] + rivit[i];
                int uusiSarake = edellinen[1] + sarakkeet[i];

                if (voikoMenna(uusiRivi, uusiSarake, lauta.length)) {
                    if (kaydyt[uusiRivi][uusiSarake] == false) {
                        if (lauta[uusiRivi][uusiSarake] > 1) {
                            int[] uusi = new int[]{uusiRivi, uusiSarake};
                            pino.push(uusi);
                        }
                    }
                }
            }

        }

        return kaydyt;
    }

    /**
     * Apumetodi, joka laskee yksittäisen linnan pisteet. Pisteitä saa yhden
     * jokaista ruutua kohden.
     *
     * @param rivi Rivi, josta lähdetään liikkeelle.
     * @param sarake Sarake, josta lähdetään liikkeelle.
     * @param lauta Pelitilanne, ennen funktion kutsumista.
     * @return Palauttaa lähtöruudusta lähtevän linnan pisteet, eli linnan koon
     * ruutuina.
     */
    public int linnanPisteet(int rivi, int sarake, int[][] lauta) {

        if (lauta[rivi][sarake] < 2) {
            return 0;
        }

        int pisteet = 0;

        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];

        Pino pino = new Pino();

        int[] eka = new int[]{rivi, sarake};

        pino.push(eka);

        int[] rivit = new int[]{1, 0, -1, 0};
        int[] sarakkeet = new int[]{0, 1, 0, -1};

        while (!pino.empty()) {
            int[] edellinen = (int[]) pino.pop();

            if (kaydyt[edellinen[0]][edellinen[1]] == false) {
                pisteet++;
            }

            kaydyt[edellinen[0]][edellinen[1]] = true;

            for (int i = 0; i < rivit.length; i++) {

                int uusiRivi = edellinen[0] + rivit[i];
                int uusiSarake = edellinen[1] + sarakkeet[i];

                if (voikoMenna(uusiRivi, uusiSarake, lauta.length)) {
                    if (kaydyt[uusiRivi][uusiSarake] == false) {
                        if (lauta[uusiRivi][uusiSarake] > 1) {
                            int[] uusi = new int[]{uusiRivi, uusiSarake};
                            pino.push(uusi);
                        }
                    }
                }

            }
        }

        return pisteet;
    }

    /**
     * Pelin aikana linnoja tulee valmiiksi ja niistä poistetaan seuraajat. Tämä
     * funktio ainoastaan poistaa linnasta seuraajat. Seuraajien palauttaminen
     * pelaajille on muiden funktioiden vastuulla.
     *
     * @param rivi Rivi, josta linna alkaa.
     * @param sarake Sarake, josta linna alkaa.
     * @param lauta Pelitilanne, ennen kuin seuraajia aletaan poistamaan.
     * @return Palauttaa päivitetyn pelitilanteen, josta parametrina annetusta
     * linnasta on poistettu seuraajat, eli jokainen ruutu, jonka arvo > 2.
     */
    public int[][] poistaSeuraajat(int rivi, int sarake, int[][] lauta) {

        if (lauta[rivi][sarake] < 2) {
            return lauta;
        }

        if (!onValmis(rivi, sarake, lauta)) {
            return lauta;
        }

        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];

        Pino pino = new Pino();

        int[] eka = new int[]{rivi, sarake};

        pino.push(eka);

        int[] rivit = new int[]{1, 0, -1, 0};
        int[] sarakkeet = new int[]{0, 1, 0, -1};

        while (!pino.empty()) {
            int[] edellinen = (int[]) pino.pop();

            if (lauta[edellinen[0]][edellinen[1]] > 2) {
                lauta[edellinen[0]][edellinen[1]] = 2;
            }

            kaydyt[edellinen[0]][edellinen[1]] = true;

            for (int i = 0; i < rivit.length; i++) {

                int uusiRivi = edellinen[0] + rivit[i];
                int uusiSarake = edellinen[1] + sarakkeet[i];

                if (voikoMenna(uusiRivi, uusiSarake, lauta.length)) {
                    if (kaydyt[uusiRivi][uusiSarake] == false) {
                        if (lauta[uusiRivi][uusiSarake] > 1) {
                            int[] uusi = new int[]{uusiRivi, uusiSarake};
                            pino.push(uusi);
                        }
                    }
                }

            }
        }

        return lauta;
    }

    /**
     * Funktio tarkistaa, että lähtöruudusta lähtevä linna on kokonaan peltojen,
     * eli ruutujen joiden arvo on 1, ympäröimä.
     *
     * @param rivi Rivi, josta lähtetään liikkeelle.
     * @param sarake Sarake, josta lähdetään liikkeelle.
     * @param lauta Pelitilanne tällä hetkellä.
     * @return Funktio palauttaa arvon true, jos ei löydy yhtään sellaista
     * ruutua, jonka ylä, ala, vasemmalla ja oikealla puolella ei olisi arvoa 1.
     */
    public boolean onValmis(int rivi, int sarake, int[][] lauta) {
        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];

        if (lauta[rivi][sarake] < 2) {
            return false;
        }

        Pino pino = new Pino();

        int[] eka = new int[]{rivi, sarake};

        pino.push(eka);

        int[] rivit = new int[]{1, 0, -1, 0};
        int[] sarakkeet = new int[]{0, 1, 0, -1};

        while (!pino.empty()) {

            int[] edellinen = (int[]) pino.pop();

            kaydyt[edellinen[0]][edellinen[1]] = true;

            for (int i = 0; i < rivit.length; i++) {

                int uusiRivi = edellinen[0] + rivit[i];
                int uusiSarake = edellinen[1] + sarakkeet[i];

                if (voikoMenna(uusiRivi, uusiSarake, lauta.length)) {
                    if (lauta[uusiRivi][uusiSarake] == 0) {
                        return false;
                    } else if (kaydyt[uusiRivi][uusiSarake] == false) {
                        if (lauta[uusiRivi][uusiSarake] > 1) {
                            int[] uusi = new int[]{uusiRivi, uusiSarake};
                            pino.push(uusi);
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Tulostaa pistetaulun, jossa ensimmäisellä rivillä on pelaajien numerot ja
     * toisella jotain muuta tarpeellista numeerista tietoa, kuten pisteitä.
     *
     * @param pisteet Parametrina annettava pistetaulu.
     */
    public void tulostaPistetaulu(int[][] pisteet) {

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                System.out.format("%4d", pisteet[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Funktio laskee montako seuraajaa kullakin pelaajalla on linnassa.
     * Pisteitä saavat pelaajat, joilla on eniten seuraajia linnassa. Muut
     * pelaajat saavat nolla pistettä.
     *
     * @param rivi Rivi, josta linna lähtee.
     * @param sarake Sarake, josta linna lähtee.
     * @param pelaajat Pelissä mukana olevat pelaajat.
     * @param lauta Tämän hetkinen pelitilanne.
     * @return Palauttaa kaksiulotteisen taulun, jonka ensimmäisellä rivillä on
     * pelaajien numerot ja toisella paljonko pisteitä he saavat.
     */
    public int[][] pelaajillePisteetLinnassa(int rivi, int sarake, int[] pelaajat, int lauta[][]) {

        int[][] pisteTaulu = luoPistetaulu(pelaajat);

        int[][] seuraajaTaulu = linnassaOlevatSeuraajat(rivi, sarake, pelaajat, lauta);

        int pisteet = linnanPisteet(rivi, sarake, lauta);

        int maxSeuraajat = 0;

        for (int i = 0; i < pelaajat.length; i++) {

            if (seuraajaTaulu[1][i] > maxSeuraajat) {
                maxSeuraajat = seuraajaTaulu[1][i];
            }
        }

        for (int i = 0; i < pelaajat.length; i++) {
            if (seuraajaTaulu[1][i] == maxSeuraajat) {
                pisteTaulu[1][i] = pisteet;
            }
        }
        return pisteTaulu;
    }

    /**
     * Funktio kertoo kuinka monta seuraajaa kullakin pelaajalla on linnassa.
     *
     * @param rivi Rivi, josta linna alkaa.
     * @param sarake Sarake, josta linna alkaa.
     * @param pelaajat Pelissä mukana olevat pelaajat.
     * @param lauta Pelitilanne ennen funktion kutsua.
     * @return Palauttaa pistetaulun, jonka ensimmäisellä rivillä on pelaajien
     * numerot ja toisella montako seuraajaa heillä on lähtöruutuna annetussa
     * linnassa.
     */
    public int[][] linnassaOlevatSeuraajat(int rivi, int sarake, int[] pelaajat, int[][] lauta) {

        int[][] pistetaulu = luoPistetaulu(pelaajat);

        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];

        Pino pino = new Pino();

        int[] eka = new int[]{rivi, sarake};

        pino.push(eka);

        int[] rivit = new int[]{1, 0, -1, 0};
        int[] sarak = new int[]{0, 1, 0, -1};

        while (!pino.empty()) {

            int[] edellinen = (int[]) pino.pop();

            int luku = lauta[edellinen[0]][edellinen[1]];

            if (luku > 2 && kaydyt[edellinen[0]][edellinen[1]] == false) {
                int seuraajienmaara = pistetaulu[1][luku - 3];
                pistetaulu[1][luku - 3] = seuraajienmaara + 1;
            }

            kaydyt[edellinen[0]][edellinen[1]] = true;

            for (int i = 0; i < rivit.length; i++) {

                int uusiRivi = edellinen[0] + rivit[i];
                int uusiSarake = edellinen[1] + sarak[i];

                if (voikoMenna(uusiRivi, uusiSarake, lauta.length)) {
                    if (lauta[uusiRivi][uusiSarake] != 0 && lauta[uusiRivi][uusiSarake] != 1) {
                        if (kaydyt[uusiRivi][uusiSarake] == false) {
                            int[] uusi = new int[]{uusiRivi, uusiSarake};
                            pino.push(uusi);
                        }
                    }
                }
            }
        }
        return pistetaulu;
    }

    /**
     * Funktio laskee ruudun vieressä olevien linnojen pisteet yhteen.
     *
     * @param rivi Rivi, jossa ruutu on.
     * @param sarake Sarake, jossa ruutu on.
     * @param lauta Pelitilanne, josta ruutu halutaan.
     * @return Palauttaa kaikkien vieressä olevien linnojen pisteiden summan.
     */
    public int viereistenLinnojenPisteet(int rivi, int sarake, int[][] lauta) {

        int pisteet = 0;

        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];

        int[] rivit = new int[]{1, 0, -1, 0};
        int[] sarakkeet = new int[]{0, 1, 0, -1};

        for (int i = 0; i < rivit.length; i++) {

            int uusiRivi = rivi + rivit[i];
            int uusiSarake = sarake + sarakkeet[i];

            if (voikoMenna(uusiRivi, uusiSarake, lauta.length)) {
                if (kaydyt[uusiRivi][uusiSarake] == false && lauta[uusiRivi][uusiSarake] > 1) {
                    pisteet = pisteet + linnanPisteet(uusiRivi, uusiSarake, lauta);
                    kaydyt = merkitseLinnaPisteytetyksi(uusiRivi, uusiSarake, lauta, kaydyt);
                }
            }

        }

        return pisteet;
    }

    /**
     * Funktio laskee ruudun kulmissa olevien linnojen pisteet yhteen.
     *
     * @param rivi Rivi, jossa ruutu on.
     * @param sarake Sarake, jossa ruutu on.
     * @param lauta Pelitilanne, josta ruutu halutaan.
     * @return Palauttaa kaikkien kulmissa olevien linnojen pisteiden summan.
     */
    public int kulmittaistenLinnojenPisteet(int rivi, int sarake, int[][] lauta) {

        int pisteet = 0;

        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];

        int[] rivit = new int[]{1, 1, -1, -1};
        int[] sarakkeet = new int[]{1, -1, 1, -1};

        for (int i = 0; i < rivit.length; i++) {

            int uusiRivi = rivi + rivit[i];
            int uusiSarake = sarake + sarakkeet[i];

            if (voikoMenna(uusiRivi, uusiSarake, lauta.length)) {
                if (kaydyt[uusiRivi][uusiSarake] == false && lauta[uusiRivi][uusiSarake] > 1) {
                    pisteet = pisteet + linnanPisteet(uusiRivi, uusiSarake, lauta);
                    kaydyt = merkitseLinnaPisteytetyksi(uusiRivi, uusiSarake, lauta, kaydyt);
                }
            }

        }
        return pisteet;
    }

    /**
     * Funktio laskee pisteiden määrät linnoissa, jotka ovat tämän ruudun
     * vieressä tai kulmissa.
     *
     * @param rivi Rivi, jossa ruutu sijaitsee.
     * @param sarake Sarake, jossa ruutu sijaitsee.
     * @param lauta Pelitilanne ennen pisteiden laskemista.
     * @return Palauttaa kaikkien ruudun vieressä ja kulmissa olevien linnojen
     * pisteiden summan.
     */
    public int pisteetVieressaJaKulmissa(int rivi, int sarake, int[][] lauta) {
        int pist = 0;

        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];

        int[] rivit = new int[]{1, -1, -1, 1, 1, 0, -1, 0};
        int[] sarak = new int[]{1, -1, 1, -1, 0, 1, 0, -1};

        for (int i = 0; i < rivit.length; i++) {
            int r = rivi + rivit[i];
            int s = sarake + sarak[i];

            if (voikoMenna(r, s, lauta.length)) {
                if (kaydyt[r][s] == false && lauta[r][s] > 1) {
                    pist = pist + linnanPisteet(r, s, lauta);
                    kaydyt = merkitseLinnaPisteytetyksi(r, s, lauta, kaydyt);
                }
            }

        }

        return pist;
    }

    /**
     * Funktio seuraajien määrät linnoissa, jotka ovat tämän ruudun vieressä tai
     * kulmissa.
     *
     * @param rivi Rivi, jossa ruutu sijaitsee.
     * @param sarake Sarake, jossa ruutu sijaitsee.
     * @param pelaajat Pelissä mukana olevat pelaajat.
     * @param lauta Pelitilanne ennen pisteiden laskemista.
     * @return Palauttaa kaikkien ruudun vieressä ja kulmissa olevien linnojen
     * seuraajien määrän. Palautus on kaksiulotteinen taulu, jonka ensimmäisellä
     * rivillä on pelaaja ja toisella pelaajan seuraajat.
     */
    public int[][] seuraajatVieressaJaKulmissa(int rivi, int sarake, int[] pelaajat, int[][] lauta) {

        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];

        int[][] pistetaulu = luoPistetaulu(pelaajat);

        int[] rivit = new int[]{1, -1, -1, 1, 1, 0, -1, 0};
        int[] sarak = new int[]{1, -1, 1, -1, 0, 1, 0, -1};

        for (int i = 0; i < rivit.length; i++) {
            int r = rivi + rivit[i];
            int s = sarake + sarak[i];

            if (voikoMenna(r, s, lauta.length)) {

                if (kaydyt[r][s] == false && lauta[r][s] > 1) {

                    int[][] p = linnassaOlevatSeuraajat(r, s, pelaajat, lauta);

                    kaydyt = merkitseLinnaPisteytetyksi(r, s, lauta, kaydyt);

                    for (int j = 0; j < pelaajat.length; j++) {
                        int x = pistetaulu[1][j];
                        pistetaulu[1][j] = x + p[1][j];
                    }

                }

            }

        }

        return pistetaulu;
    }

    /**
     * Funktio kertoo ruudun vieressä olevien linnojen seuraajien yhteismäärän.
     *
     * @param rivi Rivi, jonka vieressä haluttu ruutu on.
     * @param sarake Sarake, jonka vieressä haluttu ruutu on.
     * @param pelaajat Pelissä mukana olevat pelaajat.
     * @param lauta Pelitilanne.
     * @return Palautus on kaksiulotteinen taulu, jonka ensimmäisellä rivillä on
     * pelaaja ja toisella pelaajan seuraajat.
     */
    public int[][] ruudunViereistenLinnojenSeuraajat(int rivi, int sarake, int[] pelaajat, int[][] lauta) {

        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];

        int[][] pistetaulu = luoPistetaulu(pelaajat);

        int[] rivit = new int[]{1, 0, -1, 0};
        int[] sarak = new int[]{0, 1, 0, -1};

        for (int i = 0; i < rivit.length; i++) {
            int r = rivi + rivit[i];
            int s = sarake + sarak[i];

            if (voikoMenna(r, s, lauta.length)) {
                if (kaydyt[r][s] == false && lauta[r][s] > 1) {
                    int[][] p = linnassaOlevatSeuraajat(r, s, pelaajat, lauta);
                    kaydyt = merkitseLinnaPisteytetyksi(r, s, lauta, kaydyt);
                    for (int j = 0; j < pelaajat.length; j++) {
                        int x = pistetaulu[1][j];
                        pistetaulu[1][j] = x + p[1][j];
                    }
                }
            }
        }
        return pistetaulu;
    }

    /**
     * Funktio laskee ruudun kulmassa olevien linnojen seuraajien määrät.
     *
     * @param rivi Rivi, jossa aloitusruutu sijaitsee.
     * @param sarake Sarake, jossa aloitusruutu sijaitsee.
     * @param pelaajat Pelissä mukana olevat pelaajat.
     * @param lauta Pelitilanne.
     * @return Funktio palauttaa kaksiulotteisen taulukon, jonka ensimmäisellä
     * rivillä on pelaajien numerot ja toisella kulmissa olevien linnojen
     * seuraajien yhteenlaskettu määrä.
     */
    public int[][] seuraajatKulmittainLinnoissa(int rivi, int sarake, int[] pelaajat, int[][] lauta) {

        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];

        int[][] pistetaulu = luoPistetaulu(pelaajat);

        int[] rivit = new int[]{1, -1, -1, 1};
        int[] sarak = new int[]{1, -1, 1, -1};

        for (int i = 0; i < rivit.length; i++) {
            int r = rivi + rivit[i];
            int s = sarake + sarak[i];

            if (voikoMenna(r, s, lauta.length)) {

                if (kaydyt[r][s] == false && lauta[r][s] > 1) {
                    int[][] p = linnassaOlevatSeuraajat(r, s, pelaajat, lauta);
                    kaydyt = merkitseLinnaPisteytetyksi(r, s, lauta, kaydyt);
                    for (int j = 0; j < pelaajat.length; j++) {
                        int x = pistetaulu[1][j];
                        pistetaulu[1][j] = x + p[1][j];
                    }
                }
            }
        }
        return pistetaulu;
    }

    /**
     * Funktio kertoo onko ruudun kulmassa tai vieressä linna.
     *
     * @param rivi Rivi, jossa kohteena oleva ruutu on.
     * @param sarake Sarake, jossa kohteena oleva ruutu on.
     * @param lauta Pelitilanne ennn funktion kutsumista.
     * @return Palauttaa arvon true, jos jossain ruudun kulmassa tai vieressä on
     * linna.
     */
    public boolean kulmassaTaiVieressaOnLinna(int rivi, int sarake, int[][] lauta) {

        int[] rivit = new int[]{1, -1, -1, 1, 1, 0, -1, 0};
        int[] sarakkeet = new int[]{1, -1, 1, -1, 0, 1, 0, -1};

        for (int i = 0; i < rivit.length; i++) {

            int uusiRivi = rivi + rivit[i];
            int uusiSarake = sarake + sarakkeet[i];

            if (voikoMenna(uusiRivi, uusiSarake, lauta.length)) {
                if (lauta[uusiRivi][uusiSarake] > 1) {
                    return true;
                }
            }

        }

        return false;

    }

    /**
     * Funktio kertoo onko annetun ruudun jossain kulmassa linna.
     *
     * @param rivi Rivi, jossa kohderuutu on.
     * @param sarake Sarake, jossa kohderuutu on.
     * @param lauta Pelitilanne ennen funktion kutsumista.
     * @return Palauttaa arvon true, jos ruudun kulmasta löytyy linna.
     */
    public boolean kulmassaOnLinna(int rivi, int sarake, int[][] lauta) {

        int[] rivit = new int[]{1, -1, -1, 1};
        int[] sarakkeet = new int[]{1, -1, 1, -1};

        for (int i = 0; i < rivit.length; i++) {

            int uusiRivi = rivi + rivit[i];
            int uusiSarake = sarake + sarakkeet[i];

            if (voikoMenna(uusiRivi, uusiSarake, lauta.length)) {
                if (lauta[uusiRivi][uusiSarake] > 1) {
                    return true;
                }
            }

        }

        return false;
    }

    /**
     * Kertoo onko ruudun vieressä linna.
     *
     * @param rivi Rivi, jossa kohderuutu on.
     * @param sarake Sarake, jossa kohderuutu on.
     * @param lauta Pelitilanne ennen funktion kutsumista.
     * @return Palauttaa arvon true, jossain viereisistä ruuduista on linna.
     */
    public boolean vieressaOnLinna(int rivi, int sarake, int[][] lauta) {

        int[] rivit = new int[]{1, 0, -1, 0};
        int[] sarakkeet = new int[]{0, 1, 0, -1};

        for (int i = 0; i < rivit.length; i++) {

            int uusiRivi = rivi + rivit[i];
            int uusiSarake = sarake + sarakkeet[i];

            if (voikoMenna(uusiRivi, uusiSarake, lauta.length)) {
                if (lauta[uusiRivi][uusiSarake] > 1) {
                    return true;
                }
            }

        }

        return false;
    }

    /**
     * Kopioi parametrina annetun kaksiulotteisen pistetaulun.
     *
     * @param pelaajat Pelissä mukana olevat pelaajat.
     * @param kopioitava Taulu, joka pitää kopioida.
     * @return Palauttaa kopion syötetystä taulusta.
     */
    public int[][] kopioiPisteTaulu(int[] pelaajat, int[][] kopioitava) {

        int[][] kopio = luoPistetaulu(pelaajat);

        for (int i = 0; i < pelaajat.length; i++) {
            kopio[1][i] = kopioitava[1][i];
        }

        return kopio;
    }

    /**
     * Kopioi listan pelilaudoista.
     *
     * @param laudat Lista pelilaudoista.
     * @return Palauttaa kopion pelilautalistasta.
     */
    public Lista kopioiLautaLista(Lista laudat) {

        Lista kopio = new Lista();

        for (int i = 0; i < laudat.size(); i++) {
            kopio.add(laudat.get(i));
        }

        return kopio;
    }

    /**
     * Korvaa pistetaulun pisteet mielivaltaisella vakiolla.
     *
     * @param pelaajat Pelissä mukana olevat pelaajat.
     * @param pisteet Taulu, jossa on pelaajien pisteet.
     * @param arvo Arvo, johon pisteet tulee asettaa.
     * @return Palauttaa taulun, jossa pisteet on korvattu vakiolla.
     */
    public int[][] lisaaPisteitaVakiomaara(int[] pelaajat, int[][] pisteet, int arvo) {

        for (int i = 0; i < pelaajat.length; i++) {
            pisteet[1][i] = arvo;
        }

        return pisteet;
    }

}
