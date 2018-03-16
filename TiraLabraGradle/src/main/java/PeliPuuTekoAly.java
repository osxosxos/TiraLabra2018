
/**
 * Pelipuuhun perustuva tekoäly, joka tekee päätöksensä laskemalla pelin kulkua
 * eteenpäin. Päätöksen aikavaativuus on eksponentiaalinen.
 *
 * @author Oskari Koskinen
 */
public class PeliPuuTekoAly {

    Funktiot funktiot;

    public PeliPuuTekoAly() {
        this.funktiot = new Funktiot();
    }

    /**
     * Tällä funktiolla pelipuuhun perustuva tekoäly sijoittaa linna-laatan.
     * Tekoäly etsii ensimmäisen ruudun joka on vapaa ja omaa suurimman arvon
     * matriisissa, joka lasketaan ruudun arvo funktiolla. Tämän jälkeen se
     * sijoittaa siihen linna-laatan.
     *
     * @param pelaaja Tekoälyn numero, jonka eduksi päätöstä tehdään.
     * @param seuraajat Tekoälyllä olevien seuraajien määrä.
     * @param pelaajat Pelissä mukana olevat pelaajat.
     * @param lauta Pelitilanne ennen laatan asettamista.
     * @return Palauttaa laudan, johon tekoäly on sijoittanut linnan.
     */
    public int[][] sijoitaLinna(int pelaaja, int seuraajat, int[] pelaajat, int[][] lauta) {

        int[][] matriisi = linnanSijoitusMatriisi(pelaaja, pelaajat, lauta);

        Lista vapaat = new Lista();
        
        // Lisätään vapaat ruudut listalle.
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                if (lauta[i][j] == 0) {
                    vapaat.add(new int[]{i, j, matriisi[i][j]});
                }
            }
        }

        int suurin = Integer.MIN_VALUE;
        
        // Etsitään listan suurin vapaa ruutu. 
        for (int i = 0; i < vapaat.size(); i++) {
            int[] taulu = (int[]) vapaat.get(i);
            if (taulu[2] >= suurin) {
                suurin = taulu[2];
            }
        }
        // Pelataan parhaaseen ruutuun linnalaatta.
        for (int i = 0; i < vapaat.size(); i++) {
            int[] taulu = (int[]) vapaat.get(i);
            if (taulu[2] == suurin) {
                lauta = funktiot.asetaLaatta(taulu[0], taulu[1], 2, lauta);
                if (seuraajat > 0) {
                    if (!funktiot.onkoLinnassaJoSeuraaja(taulu[0], taulu[1], lauta)) {
                        lauta = funktiot.asetaSeuraaja(taulu[0], taulu[1], pelaaja, lauta);
                    }
                }
                break;
            }
        }

        return lauta;

    }

    /**
     * Tällä funktiolla pelipuuhun perustuva tekoäly sijoittaa peltolaatan.
     * Tekoäly etsii ensimmäisen ruudun joka on vapaa ja omaa suurimman arvon.
     * Tämän jälkeen se sijoittaa siihen peltolaatan.
     *
     * @param pelaaja Vuorossa olevan pelaajan, eli tekoälyn numero.
     * @param pelaajat Kaikki pelissä olevat pelaajat.
     * @param lauta Pelitilanne ennen laatan sijoitusta.
     * @return Funktio palauttaa pelitilanteen pellon sijoittamisen jälkeen.
     */
    public int[][] sijoitaPelto(int pelaaja, int pelaajat[], int[][] lauta) {

        int[][] matriisi = pellonSijoitusMartiisi(pelaaja, pelaajat, lauta);

        Lista vapaat = new Lista();
        
        // Etsitään vapaat ruudut ja lisätään listalle.
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                if (lauta[i][j] == 0) {
                    vapaat.add(new int[]{i, j, matriisi[i][j]});
                }
            }
        }
        
        int suurin = Integer.MIN_VALUE;

        // Etsitään paras tapaus. 
        for (int i = 0; i < vapaat.size(); i++) {
            int[] taulu = (int[]) vapaat.get(i);
            if (taulu[2] >= suurin) {
                suurin = taulu[2];
            }
        }

        // Pelataan pelto parasta tapausta vastaavaan ruutuun. 
        for (int i = 0; i < vapaat.size(); i++) {
            int[] taulu = (int[]) vapaat.get(i);
            if (taulu[2] == suurin) {
                lauta = funktiot.asetaLaatta(taulu[0], taulu[1], 1, lauta);
                break;
            }
        }

        return lauta;
    }

    /**
     * Tämän matriisin avulla tekoäly sijoittaa peltolaatan laudalle. Mitä
     * suurempi matriisin arvo on, sitä parempi sijoitus tämä ruutu on. Funktio
     * tutkii vain ruudut, joiden vieressä tai kulmassa on linna. Jos funktio
     * tutkisi aivan kaiken, aikaa kuluisi todella paljon, varsinkin pelin
     * alussa.
     *
     * @param pelaaja Pelaaja, jonka pistesaavutusten perusteella matriisia
     * lasketaan.
     * @param pelaajat Kaikki pelissä mukana olevat pelaajat.
     * @param lauta Pelitilanne, jonka perusteella paikat lasketaan.
     * @return Funktio palauttaa matriisin, joka kertoo mihin pelto kannattaa
     * pelata.
     */
    public int[][] pellonSijoitusMartiisi(int pelaaja, int[] pelaajat, int[][] lauta) {

        int[][] matriisi = new int[lauta.length][lauta.length];

        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                if (lauta[i][j] == 0) {
                    if (funktiot.kulmassaTaiVieressaOnLinna(i, j, lauta)) {
                        matriisi[i][j] = ruudunArvo(i, j, 1, pelaaja, pelaajat, lauta);
                    }
                }
            }
        }

        return matriisi;
    }

    /**
     * Tämän matriisin avulla tekoäly sijoittaa linnalaatan laudalle. Mitä
     * suurempi matriisin arvo on, sitä parempi sijoitus tämä ruutu on. Funktio
     * tutkii vain ruudut, joiden vieressä tai kulmassa on linna. Jos funktio
     * tutkisi aivan kaiken, aikaa kuluisi todella paljon, varsinkin pelin
     * alussa.
     *
     * @param pelaaja Pelaaja, jonka pistesaavutusten perusteella matriisia
     * lasketaan.
     * @param pelaajat Kaikki pelissä mukana olevat pelaajat.
     * @param lauta Pelitilanne, jonka perusteella paikat lasketaan.
     * @return Funktio palauttaa matriisin, joka kertoo mihin linna kannattaa
     * pelata.
     */
    public int[][] linnanSijoitusMatriisi(int pelaaja, int[] pelaajat, int[][] lauta) {

        int[][] matriisi = new int[lauta.length][lauta.length];

        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {

                if (lauta[i][j] == 0) {
                    if (funktiot.kulmassaTaiVieressaOnLinna(i, j, lauta)) {
                        matriisi[i][j] = ruudunArvo(i, j, 2, pelaaja, pelaajat, lauta);
                    }
                }
            }
        }

        return matriisi;
    }

    /**
     * Siirtää peliä sääntöjen mukaan yhden siirron eteenpäin.
     *
     * @param pelaaja Pelaaja, jonka vuoro on tehdä siirto.
     * @param laatta Laatta, jonka pelaaja on saanut pakasta.
     * @param rivi Rivi, johon laatta asetetaan.
     * @param sarake Sarake, johon laatta asetetaan.
     * @param pelaajat Pelissä mukana olevat pelaajat.
     * @param edellinen Pelitilanne ennen siirron tekemistä.
     * @return Funktio palauttaa pelitilanteen, jota on siirretty haluttu siirto
     * eteenpäin.
     */
    public int[][] yksiSiirtoEteenpain(int pelaaja, int laatta, int rivi, int sarake, int pelaajat[], int[][] edellinen) {

        // Asetetaan aluksi kaikille pelaajille maksimimäärä seuraajia. 
        int[][] seuraajat = funktiot.luoPistetaulu(pelaajat);
        seuraajat = funktiot.lisaaPisteitaVakiomaara(pelaajat, seuraajat, 10);

        int[][] seuraava = funktiot.kopioiKartta(edellinen);
        
        // Jos laatta on pelto, mitään ei tarvitse tehdä, paitsi sijoittaa se.
        if (laatta == 1) {
            seuraava = funktiot.asetaLaatta(rivi, sarake, laatta, seuraava);
        }

        // Jos laatta on linna, lasketaan käytössä olevien seuraajien todellinen 
        // määrä linnoista, jotka eivät ole valmiita. 
        if (laatta == 2) {
            
            // Pelataan toki ensin linnalaatta.
            seuraava = funktiot.asetaLaatta(rivi, sarake, laatta, seuraava);

            boolean[][] kaydyt = new boolean[seuraava.length][seuraava.length];

            for (int i = 0; i < seuraava.length; i++) {
                for (int j = 0; j < seuraava.length; j++) {

                    if (seuraava[i][j] > 1 && kaydyt[i][j] == false) {
                        if (!funktiot.onValmis(i, j, seuraava)) {

                            kaydyt = funktiot.merkitseLinnaPisteytetyksi(i, j, seuraava, kaydyt);

                            int[][] seuraajatLinnassa = funktiot.linnassaOlevatSeuraajat(i, j, pelaajat, seuraava);

                            for (int k = 0; k < pelaajat.length; k++) {
                                seuraajat[1][k] = seuraajat[1][k] - seuraajatLinnassa[1][k];
                            }
                        }
                    }
                }
            }
            
            // Katsotaan onko riviä ja saraketta vastaavassa linnassa jo seuraajaa.
            boolean linnassaSeuraaja = funktiot.onkoLinnassaJoSeuraaja(rivi, sarake, seuraava);

            // Jos ei ole ja pelaajalla on ylimääräinen, asetetaan linnaan seuraaja. 
            if (!linnassaSeuraaja) {
                int pelaajanSeuraajat = 0;
                for (int i = 0; i < pelaajat.length; i++) {
                    if (seuraajat[0][i] == pelaaja) {
                        pelaajanSeuraajat = seuraajat[1][i];
                    }
                }
                if (pelaajanSeuraajat > 0) {
                    seuraava = funktiot.asetaSeuraaja(rivi, sarake, pelaaja, seuraava);
                }
            }

        }

        return seuraava;

    }

    /**
     * Funktio kertoo paljonko tähän ruutuun laatan pelaamalla voidaan saada tai
     * menettää pisteitä pahimmillaan. Arvo lasketaan vain ruuduille, joiden
     * vieressä tai kulmassa on linna. Tämä on kompromissi, jonka tarkoitus on
     * hieman vähentää eksponentiaalisen algoritmin kuluttamaa aikaa. Pelipuun
     * syvyydeksi on tässä rajoitettu korkeintaan viisi. Syynä on jälleen kerran
     * algoritmin eksponentiaalinen aikavaativuus. Algoritmi tutkii kuitenkin
     * vain haarat, jotka ovat parempia tai pahempia kuin aikaisemmat tapaukset.
     *
     * @param rivi Rivi, johon laatta pelataan.
     * @param sarake Sarake, johon laatta pelataan.
     * @param laatta Pelattava laatta.
     * @param pelaaja Pelaaja, jonka pisteiden muutoksesta ollaan
     * kiinnostuneita.
     * @param pelaajat Kaikki pelissä muukana olevat pelaajat.
     * @param lauta Pelitilanne, josta peliä aletaan laskemaan eteenpäin.
     * @return Palauttaa saatujen tai menetettyjen pisteiden määrän, riippuen
     * siitä kumpi on suurempi itseisarvoltaan.
     */
    public int ruudunArvo(int rivi, int sarake, int laatta, int pelaaja, int[] pelaajat, int[][] lauta) {

        int paras = 0;
        int pahin = 0;

        Lista laudat = new Lista();

        int[][] ensimmainen = yksiSiirtoEteenpain(pelaaja, laatta, rivi, sarake, pelaajat, lauta);
        laudat.add(ensimmainen);

        PeliPuu ensimmainenPuu = new PeliPuu(pelaaja, pelaaja, laudat);

        Pino peliPuuPino = new Pino();
        peliPuuPino.push(ensimmainenPuu);

        while (!peliPuuPino.empty()) {
            
            PeliPuu edellinen = (PeliPuu) peliPuuPino.pop();
            
            int seuraavaPelaaja = edellinen.getVuorossaOlevaPelaaja();
            
            // Vaihdetaan vuorossa oleva pelaaja.
            if (seuraavaPelaaja == pelaajat.length + 2) {
                seuraavaPelaaja = 3;
            } else {
                seuraavaPelaaja = seuraavaPelaaja + 1;
            }
            
            // Otetaan kopio puun viimeisestä laudasta.
            int viimeinen = edellinen.getLaudat().size() - 1;
            int[][] edellinenLauta = (int[][]) edellinen.getLaudat().get(viimeinen);

            for (int i = 0; i < edellinenLauta.length; i++) {
                for (int j = 0; j < edellinenLauta.length; j++) {
                    
                    // Tutkitaan ruutuja joilla on merkitys, eli ruutuja joiden
                    // vieressä tai kulmassa on linna. 
                    if (edellinenLauta[i][j] == 0 && funktiot.kulmassaTaiVieressaOnLinna(i, j, edellinenLauta)) {

                        Lista edelliset = edellinen.getLaudat();
                        Lista edellisetKopio1 = funktiot.kopioiLautaLista(edelliset);
                        Lista edellisetKopio2 = funktiot.kopioiLautaLista(edelliset);

                        int viimeinen1 = edellisetKopio1.size() - 1;
                        int viimeinen2 = edellisetKopio2.size() - 1;

                        int[][] viimeinenLautaKopio1 = (int[][]) edellinen.getLaudat().get(viimeinen1);
                        int[][] viimeinenLautaKopio2 = (int[][]) edellinen.getLaudat().get(viimeinen2);

                        // Siirretään kahta tunnettua viimeistä pelitilannetta 
                        // kahdella tavalla eteenpäin.
                        viimeinenLautaKopio1 = yksiSiirtoEteenpain(seuraavaPelaaja, 1, i, j, pelaajat, viimeinenLautaKopio1);
                        viimeinenLautaKopio2 = yksiSiirtoEteenpain(seuraavaPelaaja, 2, i, j, pelaajat, viimeinenLautaKopio2);
                        
                        // Lasketaan erotukset, jotta tiedetään ollaanko 
                        // löydetty pahempi tai parempi tapaus kuin aikaisemmin 
                        // tunnetut. 
                        int arvo1 = erotus(pelaaja, pelaajat, viimeinenLautaKopio1);
                        int arvo2 = erotus(pelaaja, pelaajat, viimeinenLautaKopio2);
                        
                        // Jatketaan puuta vain, jos pahempi/parempi tapaus on 
                        // löytynyt. 
                        
                        if (edellisetKopio1.size() <= 5) {
                            if (arvo1 > paras) {
                                paras = arvo1;
                                edellisetKopio1.add(viimeinenLautaKopio1);
                                PeliPuu puu1 = new PeliPuu(pelaaja, seuraavaPelaaja, edellisetKopio1);
                                peliPuuPino.push(puu1);
                            }
                            if (arvo1 < pahin) {
                                pahin = arvo1;
                                edellisetKopio1.add(viimeinenLautaKopio1);
                                PeliPuu puu1 = new PeliPuu(pelaaja, seuraavaPelaaja, edellisetKopio1);
                                peliPuuPino.push(puu1);
                            }
                        }

                        if (edellisetKopio2.size() <= 5) {
                            if (arvo2 > paras) {
                                paras = arvo2;
                                edellisetKopio2.add(viimeinenLautaKopio2);
                                PeliPuu puu2 = new PeliPuu(pelaaja, seuraavaPelaaja, edellisetKopio2);
                                peliPuuPino.push(puu2);
                            }
                            if (arvo2 < pahin) {
                                pahin = arvo2;
                                edellisetKopio2.add(viimeinenLautaKopio2);
                                PeliPuu puu2 = new PeliPuu(pelaaja, seuraavaPelaaja, edellisetKopio2);
                                peliPuuPino.push(puu2);
                            }
                        }
                    }
                }
            }
        }

        // Palautetaan itseisarvoltaan suurempi arvo. 
        
        if (paras >= Math.abs(pahin)) {
            return paras;
        }

        return pahin;

    }

    /**
     * Funktio saa syötteekseen pelipuun viimeisen pelitilanteen. Tästä
     * lasketaan siirron kannattavuus tekoälylle.
     *
     * @param pelaaja Tekoalyn pelaajatunnus.
     * @param pelaajat Kaikki pelissä olevat pelaajat.
     * @param loppu Pelipuun lopputilanne.
     * @return Funktio palauttaa pelaajan ja eniten pisteitä keränneen
     * vastustajan pisteiden erotuksen viimeisimmän pelitilanteen perusteella.
     */
    public int erotus(int pelaaja, int[] pelaajat, int loppu[][]) {

        int[][] pisteet = funktiot.luoPistetaulu(pelaajat);

        boolean[][] kaydyt = new boolean[loppu.length][loppu.length];

        // Lasketaan jaossa potentiaalisesti olevat pisteet.
        // Huomaa, että valmiista linnoista ei saa tässä pisteitä, koska niissä
        // ei ole seuraajia. 
        
        for (int i = 0; i < loppu.length; i++) {
            for (int j = 0; j < loppu.length; j++) {

                if (loppu[i][j] > 1 && kaydyt[i][j] == false) {

                    int[][] pisteetLinnasta = funktiot.pelaajillePisteetLinnassa(i, j, pelaajat, loppu);
                    kaydyt = funktiot.merkitseLinnaPisteytetyksi(i, j, loppu, kaydyt);

                    for (int k = 0; k < pelaajat.length; k++) {
                        pisteet[1][k] = pisteet[1][k] + pisteetLinnasta[1][k];
                    }

                }
            }
        }

        int pelaajanPisteet = 0;
        int parhaatPisteet = 0;
        
        // Lasketaan montako pistettä pahin kilpailija on tienannut ja verrataan
        // näitä tekoälyn pisteisiin. Palautetaan erotus. 
        
        for (int i = 0; i < pelaajat.length; i++) {
            if (pisteet[0][i] == pelaaja) {
                pelaajanPisteet = pisteet[1][i];
            }
            if (pisteet[1][i] > parhaatPisteet && pisteet[0][i] != pelaaja) {
                parhaatPisteet = pisteet[1][i];
            }
        }

        return pelaajanPisteet - parhaatPisteet;
    }

}
