
import java.util.Scanner;

/**
 * Tässä luokassa on pelin käyttöliittymä ja joitakin oleellisia toimintoja,
 * joita tarvitaan pelin aikana kaikkien siirtojen jälkeen.
 *
 * @author Oskari Koskinen
 */
public class Peli {

    Scanner scanner;
    Funktiot funktiot;
    int[][] lauta;
    boolean[][] kaydyt;
    int pelaajat[];
    Lista pelaajienTiedot;
    Pino laatat;
    Ihminen ihminen;
    DetermistinenTekoaly detAly;
    PeliPuuTekoAly puuAly;

    public Peli() {
        this.funktiot = new Funktiot();
        this.scanner = new Scanner(System.in);
        this.lauta = new int[0][0];
        this.kaydyt = new boolean[0][0];
        this.pelaajat = new int[0];
        this.pelaajienTiedot = new Lista();
        this.laatat = new Pino();
        this.ihminen = new Ihminen();
        this.detAly = new DetermistinenTekoaly();
        this.puuAly = new PeliPuuTekoAly();
    }

    /**
     * Asettaa pelin perus asetukset.
     */
    public void asetaPelinAsetukset() {

        // Kysytään laudan koko ja asetetaan se. 
        int koko = this.kysyLaudanKoko();
        this.lauta = this.asetaLaudanKoko(koko);
        this.kaydyt = this.asetaKaydytKoko(koko);

        // Asetetaan keskelle lautaa yksi linna-laatta. 
        this.lauta[koko / 2][koko / 2] = 2;

        // Asetetaan pakan koko ja sekoitetaan. 
        int pakanKoko = this.kysyPakanKoko(koko);
        this.laatat = this.asetaPakanKoko(pakanKoko - 1);

        // Luodaan taulukko ja lista halutun pelaajamäärän perusteella. 
        int pelaajia = kysyPelaajienMaara();
        this.pelaajat = funktiot.luoPelaajaTaulu(pelaajia);
        this.pelaajienTiedot = new Lista();
        this.maaritaPelaajienIdentiteetit(this.pelaajat, this.pelaajienTiedot);

        // Kerrotaan pelaajalle, että kaikki on valmista. 
        System.out.println("Kaikki on nyt valmista!");
        System.out.println("Peli alkaa!");
        System.out.println("");
    }

    /**
     * Tässä pyörii varsinainen peli, kunnes laatat loppuvat.
     */
    public void pelaa() {

        // Pelin aloittaa pelaaja numero 3, eli listan indeksi 0. 
        int vuoro = 0;

        // Peliä jatketaan, kunnes laattoja ei enää ole.
        while (!this.laatat.empty()) {

            // Raportoidaan pelaajalle tilanne.  
            this.tilanne(vuoro, this.lauta);
            this.valiRaportti(this.pelaajienTiedot);
            System.out.println("laattoja on jäljellä " + this.laatat.size());

            // Otetaan esiin vuorossa olevan pelaajan tiedot.
            Pelaaja vuorossaOleva = (Pelaaja) pelaajienTiedot.get(vuoro);

            // Otetaan esiin pelaajan tunnusluku ja seuraajien määrä.  
            int pSeuraajat = vuorossaOleva.getSeuraajat();
            int pNumero = vuorossaOleva.getNumero();

            // Otetaan jonosta seuraava laatta.
            int seuraava = (int) this.laatat.pop();

            // Kopioidaan pelitilanne.
            int[][] kopio = funktiot.kopioiKartta(lauta);

            // Katsotaan vuorossa olevan pelaajan identiteetti.
            // Kutsutaan haluttuja funktioita ja tehdään siirto. 
            if (vuorossaOleva.isDetTekoAly()) {

                if (seuraava == 1) {
                    this.lauta = this.detAly.pelaaPelto(this.lauta, pNumero, this.pelaajat);
                } else {
                    this.lauta = this.detAly.pelaaLinna(lauta, pNumero, pSeuraajat, pelaajat);
                }

            } else if (vuorossaOleva.isIhminen()) {

                if (seuraava == 1) {
                    this.lauta = this.ihminen.pelaaPelto(this.lauta);
                } else {
                    this.lauta = this.ihminen.pelaaLinna(pNumero, pSeuraajat, this.lauta);
                }

            } else if (vuorossaOleva.isPeliPuuTekoAly()) {

                if (seuraava == 1) {
                    this.lauta = this.puuAly.sijoitaPelto(pNumero, this.pelaajat, this.lauta);
                } else {
                    this.lauta = this.puuAly.sijoitaLinna(pNumero, pSeuraajat, this.pelaajat, this.lauta);
                }

            }

            // Vähennetään seuraaja siirron tehneeltä pelaajalta, jos hän on asettanut seuraajan. 
            this.vahennaSeuraajaJosAsetettu(pNumero, vuoro, kopio, lauta, pelaajienTiedot);

            // Päivitetään pelin tilanne, eli annetaan pisteet valmiista linnoista jne...
            this.paivita(this.pelaajat, this.lauta, this.kaydyt, this.pelaajienTiedot);

            // Vaihdetaan vuorossa olevaa pelajaa. 
            vuoro = this.vaihdaVuoro(vuoro, pelaajat);
        }

        // Lasketaan loppupisteet
        loppuPisteet(this.pelaajat, this.lauta, this.kaydyt, this.pelaajienTiedot);

        // Julistetaan lopputulos. 
        loppuTulos(this.lauta, this.pelaajienTiedot);
    }

    /**
     * Jos vuorossa on viimeinen pelaaja, siirrytään ensimmäiseen, eli arvoon
     * nolla. Muulloin kasvatetaan vuoron arvoa yhdellä.
     *
     * @param vuoro Edellisen vuoron tehnyt pelaaja.
     * @param pelaajat Taulukko, jossa on pelaajien numerot.
     * @return Palauttaa seuraavan vuoron numeron.
     */
    public int vaihdaVuoro(int vuoro, int[] pelaajat) {
        if (vuoro == pelaajat.length - 1) {
            vuoro = 0;
        } else {
            vuoro++;
        }
        return vuoro;
    }

    /**
     * Tämä funktio pisteyttää pelin lopussa linnat, jotka eivät ole valmiita.
     * Linnoista, jotka eivät ole valmiita pelin lopussa, ei poisteta seuraajia,
     * mutta niistä saa pisteitä kaikki, joilla on eniten seuraajia linnassa.
     *
     * @param pelaajat Taulukko, jossa on pelaajien numerot.
     * @param lauta Pelitilanne viimeisen siirron jälkeen.
     * @param kaydyt Ruudut, joista on saatu pisteet pelin aikana.
     * @param tiedot Lista, jossa on pelaajien tiedot.
     */
    public void loppuPisteet(int[] pelaajat, int[][] lauta, boolean[][] kaydyt, Lista tiedot) {

        // Käydään koko ruudukko läpi.
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {

                // Etsitään ruutuja, joita ei ole pisteytetty.
                if (!kaydyt[i][j]) {

                    // Etsitään ruutuja, jotka ovat osa linnaa. 
                    if (lauta[i][j] > 1) {

                        // Jos linnassa on seuraajia, siitä ei ole annettu pisteitä. 
                        if (funktiot.onkoLinnassaJoSeuraaja(i, j, lauta)) {

                            // Lasketaan pisteet.
                            int[][] pisteet = funktiot.pelaajillePisteetLinnassa(i, j, pelaajat, lauta);

                            // Annetaan pisteet pelaajille.
                            for (int k = 0; k < tiedot.size(); k++) {
                                Pelaaja p = (Pelaaja) tiedot.get(k);
                                p.lisaaPisteita(pisteet[1][k]);
                            }

                            // Merkitään linna pisteytetyksi. 
                            kaydyt = funktiot.merkitseLinnaPisteytetyksi(i, j, lauta, kaydyt);

                        }
                    }
                }
            }
        }

    }

    /**
     * Kertoo paljonko eri pelaajilla on seuraajia ja pisteitä ennen seuraavaa
     * siirtoa.
     *
     * @param tiedot Lista, jossa pelaajien tiedot ovat tallennettuina.
     */
    public void valiRaportti(Lista tiedot) {

        for (int k = 0; k < tiedot.size(); k++) {
            Pelaaja p = (Pelaaja) tiedot.get(k);
            System.out.print("Pelaajalla " + p.getNumero());
            System.out.print(" on " + p.getPisteet() + " pistettä ");
            System.out.println("ja " + p.getSeuraajat() + " seuraajaa");
        }

        System.out.println("");

    }

    /**
     * Julistaa pelin lopputuloksen.
     *
     * @param peli Pelitilanne viimeisen siirron jälkeen.
     * @param tiedot Lista, jossa on Pelaaja-objekteja.
     */
    public void loppuTulos(int[][] peli, Lista tiedot) {

        // Tulostetaan lopullinen pelitilanne.
        funktiot.tulostaKartta(this.lauta);

        // Ilmoitetaan käyttäjälle pelin loppumisesta. 
        System.out.println("");
        System.out.println("Peli on nyt loppu!");
        System.out.println("");

        for (int k = 0; k < tiedot.size(); k++) {
            Pelaaja p = (Pelaaja) tiedot.get(k);
            System.out.println("Pelaajalla " + p.getNumero() + " on "
                    + p.getPisteet() + " pistettä");
        }
    }

    /**
     * Kysyy käyttäjältä laudan koon.
     *
     * @return
     */
    public int kysyLaudanKoko() {

        System.out.print("Anna laudan koko:");
        int koko = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("");
        return koko;

    }

    /**
     * Asettaa laudan leveyden ja korkeuden.
     *
     * @param laudanKoko Haluttu korkeus/leveys.
     * @return Palauttaa tyhjän kokonaisluku matriisin, jolla on haluttu koko.
     */
    public int[][] asetaLaudanKoko(int laudanKoko) {
        lauta = new int[laudanKoko][laudanKoko];
        return lauta;
    }

    /**
     * Asettaa pisteytetyistä ruuduista huolehtivan matriisin koon.
     *
     * @param laudanKoko Haluttu korkeus/leveys.
     * @return Palauttaa tyhjän boolean matriisin, jolla on haluttu koko.
     */
    public boolean[][] asetaKaydytKoko(int laudanKoko) {
        kaydyt = new boolean[laudanKoko][laudanKoko];
        return kaydyt;
    }

    /**
     * Kysyy käyttäjältä pelissä olevien laattojen määrän.
     *
     * @param laudanKoko Pelilaudan leveys/korkeus.
     * @return Palauttaa käyttäjän luetun syötteen.
     */
    public int kysyPakanKoko(int laudanKoko) {

        // Lasketaan laattojen maksimimäärä.
        int max = laudanKoko * laudanKoko;
        int laattoja = 0;

        // Kysytään käyttäjältä syötettä, kunnes saadaan kelvollinen. 
        while (true) {

            System.out.println("Laattojen määrän maksimi on: " + max);
            System.out.print("Anna laattojen määrä:");
            laattoja = Integer.parseInt(scanner.nextLine().trim());

            if (laattoja <= max) {
                break;
            } else {
                System.out.println("Laattojen määrä on liian suuri!");
            }

        }

        System.out.println("");

        return laattoja;
    }

    /**
     * Luo pakan, jonka koko on käyttäjän haluama.
     *
     * @param x Pinoon tulevien laattojen määrä.
     * @return Palauttaa pelivalmiin laattapinon.
     */
    public Pino asetaPakanKoko(int x) {
        // Arvotaan pakkaan laattoja haluttu määrä. 
        Pino pino = funktiot.taytaPakka(x);
        return pino;
    }

    /**
     * Kysyy käyttäjältä montako pelaajaa pelissä pitäisi olla.
     *
     * @return Palauttaa kokonaisluvun, joka on 1-4.
     */
    public int kysyPelaajienMaara() {

        int pelaajia = 0;

        // Kysytään käyttäjältä syöte.
        System.out.println("Pelaajia voi olla 1-4.");
        System.out.print("Anna pelaajien määrä:");

        // Kelvollinen määrä on 1-4. Jatketaan kunnes määrä on kelvollinen. 
        while (true) {
            pelaajia = Integer.parseInt(scanner.nextLine().trim());
            if (pelaajia >= 1 && pelaajia <= 4) {
                break;
            } else {
                System.out.println("pelaajien määrä ei ole kelvollinen luku!");
            }
        }

        System.out.println("");

        return pelaajia;
    }

    /**
     * Tällä funktiolla määritetään keitä pelissä olevat pelaajat ovat. He
     * voivat olla ihmisiä tai tekoälyjä.
     *
     * @param pelaajat Taulukko, jossa on pelaajien numerot.
     * @param tiedot Lista, jossa on määrittelemättömiä Pelaaja-objekteja.
     */
    public void maaritaPelaajienIdentiteetit(int[] pelaajat, Lista tiedot) {

        // Muuttuja k on korkeintaan pelaajien määrä - 1.
        // Muuttuja a kuvaa pelaajien numeroita. 
        int k = 0;
        int a = 3;

        // Kysytään käyttäjältä minkä tyyppisiä pelaajia hän haluaa peliin. 
        while (k < pelaajat.length) {

            System.out.println("Määritä pelaajan " + a + " identiteetti.");
            System.out.println("1 = Ihminen");
            System.out.println("2 = Determistinen Tekoäly");
            System.out.println("3 = Pelipuu Tekoäly");
            System.out.println("");
            System.out.print("Syötä pelaajan identiteetti tähän:");

            int identiteetti = Integer.parseInt(scanner.nextLine().trim());

            if (identiteetti == 1) {
                Pelaaja ihminenPelaaja = new Pelaaja(a, true, false, false);
                tiedot.add(ihminenPelaaja);
                k++;
                a++;
            } else if (identiteetti == 2) {
                Pelaaja determistinenPelaaja = new Pelaaja(a, false, true, false);
                tiedot.add(determistinenPelaaja);
                k++;
                a++;
            } else if (identiteetti == 3) {
                Pelaaja puuPelaaja = new Pelaaja(a, false, false, true);
                tiedot.add(puuPelaaja);
                k++;
                a++;
            } else {
                System.out.println("Syöte ei ole kelvollinen, ole hyvä ja yritä uudestaan.");
            }

            System.out.println("");

        }

    }

    /**
     * Vähentää pelaajan seuraajista yhden, jos pelaaja asetti seuraajan
     * johonkin ruutuun viimevuorolla.
     *
     * @param pNumero Vuorossa olevan pelaajan numero.
     * @param vuoro Monesko pelaaja on vuorossa, jos pelaaja on 3, vuoro on 0.
     * @param ennen Pelitilanne ennen siirtoa
     * @param jalkeen Pelitilanne siirron jalkeen.
     * @param tiedot Lista, jossa on pelaajien tiedot.
     */
    public void vahennaSeuraajaJosAsetettu(int pNumero, int vuoro, int[][] ennen, int[][] jalkeen, Lista tiedot) {

        // Käydään koko matriisi läpi ja etsitään ruutua, jonka arvo on muuttunut. 
        for (int i = 0; i < ennen.length; i++) {
            for (int j = 0; j < ennen.length; j++) {

                // Käsitellään muuttunut ruutu, jos sellainen löytyy. 
                if (ennen[i][j] != jalkeen[i][j]) {

                    // Jos muuttuneessa ruudussa on pelaajan numero, vähennetään tältä seuraaja. 
                    if (jalkeen[i][j] == pNumero) {
                        Pelaaja p = (Pelaaja) tiedot.get(vuoro);
                        p.lisaaSeuraajia(-1);
                    }

                }
            }
        }

    }

    /**
     * Jokaisen siirron jälkeen pelin tilanne pitää päivittää. Tarkistetaan siis
     * onko pelissä valmiita linnoja. Jos tälläisiä löytyy, merkitään ne
     * pisteytetyksi ja annetaan pelaajille seuraajat sekä pisteet, jotka
     * valmiissa linnoissa on. Valmiista linnoista myös poistetaan seuraajat.
     *
     * @param pelaajat Taulukko, jossa on pelaajien numerot.
     * @param lauta Pelin tilanne ennen päivitystä.
     * @param kaydyt Ruudut, jotka on jo pisteytetty.
     * @param tiedot Lista, jossa on tiedot Pelaaja -objekteista.
     */
    public void paivita(int[] pelaajat, int[][] lauta, boolean[][] kaydyt, Lista tiedot) {

        // Käydään koko ruudukko läpi ja etsitään valmiita linnoja. 
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {

                // Tarkistetaan, että tässä ei ole vielä käyty ja alue on linna.
                if (!kaydyt[i][j] && lauta[i][j] > 1) {

                    // Katsotaan onko tästä alkava linna valmis
                    if (funktiot.onValmis(i, j, lauta)) {

                        // Pelaajat, joilla on eniten seuraajia linnassa, saavat pisteitä.
                        int[][] pisteet = funktiot.pelaajillePisteetLinnassa(i, j, pelaajat, lauta);

                        // Katsotaan montako seuraajaa kullakin pelaajalla on linnassa. 
                        int[][] seuraajat = funktiot.linnassaOlevatSeuraajat(i, j, pelaajat, lauta);

                        // Palautetaan seuraajat ja annetaan pelaajille pisteet. 
                        for (int k = 0; k < tiedot.size(); k++) {
                            Pelaaja p = (Pelaaja) tiedot.get(k);
                            p.lisaaPisteita(pisteet[1][k]);
                            p.lisaaSeuraajia(seuraajat[1][k]);
                        }

                        // Merkitään linna pisteytetyksi, ettei anneta pisteitä vahingossa useasti. 
                        kaydyt = funktiot.merkitseLinnaPisteytetyksi(i, j, lauta, kaydyt);

                        // Poistetaan linnasta seuraajat:
                        lauta = funktiot.poistaSeuraajat(i, j, lauta);
                    }
                }
            }
        }
    }

    /**
     * Kertoo jokaisen vuoron alussa kenen vuoro on seuraavaksi, miltä
     * pelitilanne näyttää ja paljonko pelattavia laattoja on jäljellä.
     *
     * @param vuoro Vuorossa oleva pelaaja.
     * @param peli Pelitilanne ennen seuraavaa siirtoa.
     */
    public void tilanne(int vuoro, int[][] peli) {

        System.out.println("Nyt on pelaajan: " + (vuoro + 3) + " vuoro");
        System.out.println("");
        System.out.println("Pelitilanne on nyt:");
        funktiot.tulostaKartta(peli);
        System.out.println("");
        System.out.println("laattoja on jäljellä: " + laatat.size());
        System.out.println("");

    }

}
