package tiralabrapeli;

import java.util.ArrayDeque;
import java.util.Scanner;

// Lauta-taulu pitää yllä pelitilanteen
// Pisteytys-taulu pitää huolen, että jokainen ruutu pisteytetään vain kerran.
// Pelaajat-taulussa on tallessa pelaajien numerot.
// Pisteet-taulussa on pelaajien numerot ja niitä vastaavat pisteet.
// Jonossa on laatat, joita pelin aikana pelataan.
public class Peli {

    Scanner scanner;
    Funktiot funktiot;
    int[][] lauta;
    boolean[][] kaydyt;
    int pelaajat[];
    int[][] pisteet;
    Pelaaja[] pelaajienTiedot;
    ArrayDeque<Integer> laatat;
    // Tämä on ihmispelaajan funktioiden kutsumiseksi;
    Ihminen ihminen;
    // Tämä on Determistisen tekoälyn funktioiden kutsumiseksi. 
    DetermistinenTekoaly aly;

    // Konstruktorimme, koska Java. 
    // Täällä on tallessa pelaajien pisteet ja numerot pelin aikana. 
    public Peli() {
        this.funktiot = new Funktiot();
        this.scanner = new Scanner(System.in);
        this.lauta = new int[0][0];
        this.kaydyt = new boolean[0][0];
        this.pelaajat = new int[0];
        this.pisteet = new int[0][0];
        this.pelaajienTiedot = new Pelaaja[0];
        this.laatat = new ArrayDeque();
        this.ihminen = new Ihminen();
        this.aly = new DetermistinenTekoaly();
    }

    // Tämä funktio hoitaa pelin alkuvalmistelut.
    // Funktio ei päästä eteenpäin ennen kuin parametrit ovat kelvolliset. 
    public void asetaPelinAsetukset() {
        System.out.println("--------tervetuloa pelaamaan!----------");
        System.out.println("peli jatkuu niin kauan kuin laattoja on");
        System.out.println("---------------------------------------");
        System.out.println("");
        System.out.println("anna laudan koko");

        int koko = Integer.parseInt(scanner.nextLine());
        int koko2 = koko * koko;

        this.lauta = new int[koko][koko];
        this.kaydyt = new boolean[koko][koko];

        int laattoja = 0;

        while (true) {
            System.out.println("laattojen määrän maksimi on: " + koko2);
            System.out.println("anna laattojen määrä:");
            laattoja = Integer.parseInt(scanner.nextLine());
            if (laattoja <= koko2) {
                break;
            } else {
                System.out.println("laattojen määrä on liian suuri!");
            }
        }

        this.laatat = funktiot.taytaPakka(laattoja);

        int pelaajia = 0;

        System.out.println("");
        System.out.println("anna pelaajien määrä, pelaajia voi olla 1-4.");

        while (true) {
            pelaajia = Integer.parseInt(scanner.nextLine());
            if (pelaajia >= 1 && pelaajia <= 4) {
                break;
            } else {
                System.out.println("pelaajien määrä ei ole kelvollinen luku!");
            }
        }

        this.pelaajat = funktiot.luoPelaajaTaulu(pelaajia);
        this.pisteet = funktiot.luoPistetaulu(pelaajat);
        this.pelaajienTiedot = new Pelaaja[pelaajia];

        System.out.println("");
        System.out.println("määritetään pelaajien identiteetti");

        int k = 0;
        int a = 3;

        while (k < pelaajia) {
            System.out.println("määritä pelaajan " + a + "identiteetti:");
            System.out.println("1 = ihminen, 2 = determistinen tekoäly");
            int identiteetti = Integer.parseInt(scanner.nextLine());
            if (identiteetti == 1) {
                Pelaaja ihminen = new Pelaaja(true, false, a);
                pelaajienTiedot[k] = ihminen;
                k++;
                a++;
            } else if (identiteetti == 2) {
                Pelaaja tekoaly = new Pelaaja(false, true, a);
                pelaajienTiedot[k] = tekoaly;
                k++;
                a++;
            } else {
                System.out.println("syöte ei ole kelvollinen");
            }
        }
        System.out.println("");
        System.out.println("kaikki on nyt valmista");
        System.out.println("peli alkaa!");
        System.out.println("");
        pelaa();
    }

    public void pelaa() {
        // Pelin aloittaa pelaaja numero 3.
        // Joka löytyy pelaajataulun kohdasta 0. 
        int vuoro = 0;

        // Peliä jatketaan, kunnes laattoja ei enää ole.
        while (!this.laatat.isEmpty()) {
            //System.out.println("nyt on pelaajan: " + (vuoro+3) + " vuoro");
            //System.out.println("peli on nyt:");
            //funktiot.tulostaKartta(lauta);
            //System.out.println("");
            //System.out.print("laattoja on jäljellä: ");
            //System.out.println(this.laatat.size());
            // Otetaan esiin vuorossa olevan pelaajan tiedot.
            // Oleellista tietoa ovat jäljellä olevien seuraajien määrä
            // ja pelaajan tunnusluku. 
            int pSeuraajat = pelaajienTiedot[vuoro].seuraajat;
            int pNumero = pelaajienTiedot[vuoro].numero;
            int seuraava = this.laatat.poll();
            // Katsotaan mikä on vuorossa olevan pelaajan identiteetti ja
            // toteutetaan identiteein mukainen siirto
            if (pelaajienTiedot[vuoro].detTekoAly == true) {
                if (seuraava == 1) {
                    this.lauta = this.aly.pelaaPelto(this.lauta, pNumero, this.pelaajat);
                } else {
                    this.lauta = this.aly.pelaaLinna(lauta, pNumero, pSeuraajat, pelaajat);
                }
            } else if (pelaajienTiedot[vuoro].ihminen == true) {
                if (seuraava == 1) {
                    this.lauta = this.ihminen.pelaaPelto(this.lauta);
                } else {
                    this.lauta = this.ihminen.pelaaLinna(pNumero, pSeuraajat, this.lauta);
                }
            }

            // Kun pelaaja on tehtyt siirtonsa käydään lauta läpi.
            // Tarkistetaan onko valmiita linnoja.
            // Jos valmis linna löytyy:
            // 1. Pisteytetään linna.
            // 2. Annetaan pelaajalle, jolla/joilla on eniten seuraajia pisteet.
            // 3. Poistetaan seuraajat linnasta
            // 4. Palautetaan seuraajat pelaajille uudelleen käyttöön.
            // 5. Merkitään kyseinen linna pisteytetyksi.          
            for (int i = 0; i < lauta.length; i++) {
                for (int j = 0; j < lauta.length; j++) {
                    if (this.kaydyt[i][j] == false && this.lauta[i][j] > 1) {
                        // Katsotaan onko tästä alkava linna valmis
                        if (funktiot.onValmis(i, j, lauta)) {
                            // Lasketaan pisteet, lasketaan eri pelaajien
                            // seuraajien määrä ja suurin seuraajien määrä. 
                            int pist = funktiot.linnanPisteet(i, j, lauta);
                            int[][] seuraajat = funktiot.linnassaOlevatSeuraajat(i, j, this.pelaajat, this.lauta);
                            int max = 0;
                            // Etsitään seuraajien maksimimäärä ja palautetaan
                            // seuraajat oikeille pelaajille. 
                            for (int k = 0; k < seuraajat.length; k++) {
                                pelaajienTiedot[k].setSeuraajat(seuraajat[1][k]);
                                if (seuraajat[1][k] > max) {
                                    max = seuraajat[1][k];
                                }
                            }
                            // Annetaan pisteet pelaajille, joilla on eniten 
                            // seuraajia kyseisessä linnassa. 
                            for (int k = 0; k < seuraajat.length; k++) {
                                if (seuraajat[1][k] == max) {
                                    pelaajienTiedot[k].setPisteet(pist);
                                }
                            }

                            // Poistetaan seuraajat linnasta.
                            this.lauta = funktiot.poistaSeuraajat(i, j, this.lauta);
                            // Merkitään linna pisteytetyksi.
                            this.kaydyt = funktiot.merkitseLinnaPisteytetyksi(i, j, lauta, kaydyt);
                        }
                    }
                }
            }

            // Kun tämä kaikki on tehty, vaihdetaan vuoroa.
            // Jos vuorossa on viiminen pelaaja, siirrytään ensimmäiseen.
            // Muulloin vaihdetaan vuoroa. 
            if (vuoro == pelaajat.length - 1) {
                vuoro = 0;
            } else {
                vuoro++;
            }
        }
        // Lopuksi vielä pisteytetään linnat, jotka eivät ole valmiita.
        // Jonka jälkeen julistetaan voittaja. 
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                if (this.kaydyt[i][j] == false && this.lauta[i][j] > 1) {
                    // Lasketaan pisteet, lasketaan eri pelaajien
                    // seuraajien määrä ja suurin seuraajien määrä. 
                    int pist = funktiot.linnanPisteet(i, j, lauta);
                    int[][] seuraajat = funktiot.linnassaOlevatSeuraajat(i, j, this.pelaajat, this.lauta);
                    int max = 0;
                    // Etsitään seuraajien maksimimäärä ja palautetaan
                    // seuraajat oikeille pelaajille. 
                    for (int k = 0; k < seuraajat.length; k++) {
                        pelaajienTiedot[k].setSeuraajat(seuraajat[1][k]);
                        if (seuraajat[1][k] > max) {
                            max = seuraajat[1][k];
                        }
                    }
                    // Annetaan pisteet pelaajille, joilla on eniten 
                    // seuraajia kyseisessä linnassa. 
                    for (int k = 0; k < seuraajat.length; k++) {
                        if (seuraajat[1][k] == max) {
                            pelaajienTiedot[k].setPisteet(pist);
                        }
                    }

                    // Poistetaan seuraajat linnasta.
                    this.lauta = funktiot.poistaSeuraajat(i, j, this.lauta);
                    // Merkitään linna pisteytetyksi.
                    this.kaydyt = funktiot.merkitseLinnaPisteytetyksi(i, j, lauta, kaydyt);
                }
            }
        }
        funktiot.tulostaKartta(this.lauta);
        System.out.println("Peli on nyt loppu!");
        System.out.println("pisteet ovat seuraavat:");
        for (int k = 0; k < pelaajat.length; k++) {
            System.out.println("pelaajan " + this.pelaajienTiedot[k].numero
            + "pisteet ovat " + this.pelaajienTiedot[k].pisteet);
        }
    }

}
