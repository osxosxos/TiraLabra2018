package tiralabrapeli;

import java.util.ArrayDeque;
import java.util.Random;

public class Funktiot {

    public Funktiot() {

    }

    // Sekoittaa pakan uutta peliä varten.
    public ArrayDeque<Integer> taytaPakka(int koko) {
        ArrayDeque<Integer> laatat = new ArrayDeque();
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

    // Tarkistaa, että ruutu ei ole ruudukon ulkopuolella.
    public boolean voikoMenna(int rivi, int sarake, int koko) {
        return (rivi >= 0 && rivi < koko && sarake >= 0 && sarake < koko);
    }

    // Tarkistaa, että ruutu on tyhjä
    public boolean onkoVapaa(int rivi, int sarake, int[][] lauta) {
        return lauta[rivi][sarake] == 0;
    }

    // Asettaa laatan kartalle
    public int[][] asetaLaatta(int rivi, int sarake, int laatta, int[][] lauta) {
        lauta[rivi][sarake] = laatta;
        return lauta;
    }

    // Metodi asettaa kartalle pelaajan numeroa vastaavan seuraajan.
    public int[][] asetaSeuraaja(int rivi, int sarake, int pelaaja, int[][] lauta) {
        lauta[rivi][sarake] = pelaaja;
        return lauta;
    }

    // Metodi tulostaa kartan.
    public void tulostaKartta(int[][] lauta) {
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                System.out.format("%5d", lauta[i][j]);
            }
            System.out.println();
        }
    }
    
    public int[] luoPelaajaTaulu(int pelaajat) {
        int[]pelaajaTaulu = new int[pelaajat];
        int k = 3;
        for (int i = 0; i < pelaajat; i++) {
            pelaajaTaulu[i] = k;
            k++;
        }
        return pelaajaTaulu;
    }
    
    public int[][] luoPistetaulu(int[] pelaajat) {
        int[][] pistetaulu = new int[2][pelaajat.length];
        for (int i = 0; i < pelaajat.length; i++) {
            pistetaulu[0][i] = pelaajat[i];
        }
        return pistetaulu;
    }
    
    // Tulostaa boolean-kartan.
    public void tulostaBoolean(boolean[][] lauta) {
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                if (lauta[i][j] == true) {
                    System.out.print("T ");
                } else {
                    System.out.print("F ");
                }
            }
            System.out.println();
        }
    }

    // Funktio tarkistaa, että linnassa ei ole kenenkään pelaajan seuraajia.
    // Aikavaativuus pahimmillaan O(n^2), jossa on laudan leveys/korkeus
    public boolean onkoLinnassaJoSeuraaja(int rivi, int sarake, int[][] lauta) {

        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];
        // Käsittelemättömät linna ruudut ovat jonossa
        ArrayDeque<int[]> jono = new ArrayDeque();
        int[] eka = new int[]{rivi, sarake};
        jono.add(eka);

        // Näillä taulukoilla algoritmi navigoi viereisiin ruutuihin
        int[] rivit = new int[]{1, 0, -1, 0};
        int[] sarak = new int[]{0, 1, 0, -1};

        // Käydään jonossa olevat alkiot läpi yksi kerrallaan
        while (!jono.isEmpty()) {

            int[] edellinen = jono.poll();
            kaydyt[edellinen[0]][edellinen[1]] = true;

            for (int i = 0; i < rivit.length; i++) {
                // lasketaan uudet kordinaatit ylos, alas, vasen ja oikea
                int rivi2 = edellinen[0] + rivit[i];
                int sara2 = edellinen[1] + sarak[i];
                if (voikoMenna(rivi2, sara2, lauta.length)) {
                    // Seuraajia ovat kaikki numerot kahdesta ylöspäin.
                    if (lauta[rivi2][sara2] > 2) {
                        return true;
                    } else if (lauta[rivi2][sara2] == 2) {
                        int[] uusi = new int[]{rivi2, sara2};
                        if (kaydyt[uusi[0]][uusi[1]] == false) {
                            jono.add(uusi);
                        }
                    }
                }
            }
        }
        return false;
    }
    
    // Apumetodi, joka merkitsee linnan pisteytetyksi.
    // Käytetään sekä pelin aikana, että lopun pistelaskussa
   // Aikavaativuus pahimmillaan O(n^2), jossa on laudan leveys/korkeus
    public boolean[][] merkitseLinnaPisteytetyksi(int rivi, int sarake, int[][]lauta, boolean[][]kaydyt) {
        
        // Jono pitää sisällään ruudut, joita ei ole vielä merkitty pisteyteiksi        
        ArrayDeque<int[]> jono = new ArrayDeque();
        int[] eka = new int[]{rivi, sarake};
        jono.add(eka);
                
        // Aputaulukko, jolla algoritmi navigoi viereisiin ruutuihin
        int[] rivit = new int[]{1, 0,-1, 0};
        int[] sarak = new int[]{0, 1, 0,-1};

        // Linnaa käydään läpi, kunnes jonossa ei ole enää sinne kuuluvia paloja
        // Koska jonossa ei ole muuta kuin linnaruutuja, kasvatetaan pisteitä
        // välittömästi, kun ruutu otetaan jonosta
        while (!jono.isEmpty()) {
            int[] edellinen = jono.poll();
            
            if (kaydyt[edellinen[0]][edellinen[1]] == false) {
                kaydyt[edellinen[0]][edellinen[1]] = true;
            }
            
            kaydyt[edellinen[0]][edellinen[1]] = true;

            for (int i = 0; i < rivit.length; i++) {
                // Lasketaan uudet sijainnit jonon edellisen palan perusteella
                // Algoritmi navigoi näillä ylos, alas, vasemmalle ja oikealle
                int rivi1 = edellinen[0] + rivit[i];
                int sara1 = edellinen[1] + sarak[i];
                // Tarkistetaan, että ruutu ei ole laudan ulkopuolella
                if (voikoMenna(rivi1, sara1, lauta.length)) {
                    if (kaydyt[rivi1][sara1] == false) {
                        if (lauta[rivi1][sara1] == 2) {
                            int[] uusi = new int[]{rivi1, sara1};
                            jono.add(uusi);
                        } else if (lauta[rivi1][sara1] > 2) {
                            int[] uusi = new int[]{rivi1, sara1};
                            jono.add(uusi);
                        }
                    }
                }
            }
        }
        return kaydyt;
    }

    // Apumetodi, joka laskee yksittäisen linnan pisteet
    // Tätä metodia käytetään vain pelin ollessa käynnissä
    // Pelin lopussa pisteiden laskuun on oma metodinsa
    // Aikavaativuus pahimmillaan O(n^2), jossa n on laudan leveys/korkeus
    public int linnanPisteet(int rivi, int sarake, int[][] lauta) {
        
        // Tarkistetaan, että lähtöruutu, josta linnaa aletaan pisteyttämään
        // on linna, eikä pelto- tai tyhjäruutu 
        if (lauta[rivi][sarake] == 1 || lauta[rivi][sarake] == 0) {
            return 0;
        }
        
        int pisteet = 0;
        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];
        
        // Käsittelemättömät ruudut ovat tässä jonossa
        ArrayDeque<int[]> jono = new ArrayDeque();
        int[] eka = new int[]{rivi, sarake};
        jono.add(eka);

        // Aputaulukko, jolla algoritmi navigoi viereisiin ruutuihin
        int[] rivit = new int[]{1, 0, -1, 0};
        int[] sarak = new int[]{0, 1, 0, -1};

        // Linnaa käydään läpi, kunnes jonossa ei ole enää sinne kuuluvia paloja
        // Koska jonossa ei ole muuta kuin linnaruutuja, kasvatetaan pisteitä
        // välittömästi, kun ruutu otetaan jonosta
        while (!jono.isEmpty()) {
            int[] edellinen = jono.poll();
            if (kaydyt[edellinen[0]][edellinen[1]] == false) {
                pisteet++;
            }
            
            kaydyt[edellinen[0]][edellinen[1]] = true;

            for (int i = 0; i < rivit.length; i++) {
                // Lasketaan uudet sijainnit jonon edellisen palan perusteella
                // Algoritmi navigoi näillä ylos, alas, vasemmalle ja oikealle
                int rivi1 = edellinen[0] + rivit[i];
                int sara1 = edellinen[1] + sarak[i];
                // Tarkistetaan, että ruutu ei ole laudan ulkopuolella
                if (voikoMenna(rivi1, sara1, lauta.length)) {
                    if (kaydyt[rivi1][sara1] == false) {
                        if (lauta[rivi1][sara1] > 1) {
                            int[] uusi = new int[]{rivi1, sara1};
                            jono.add(uusi);
                        } 
                    }
                }
            }
        }
        return pisteet;
    }

    public int[][] poistaSeuraajat(int rivi, int sarake, int[][] lauta) {
        
        // Tarkistetaan, että lähtöruutu, josta linnaa aletaan pisteyttämään
        // on linna, eikä pelto- tai tyhjäruutu 
        if (lauta[rivi][sarake] == 1 || lauta[rivi][sarake] == 0) {
            return lauta;
        }
        
        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];
        
        // Käsittelemättömät ruudut ovat tässä jonossa
        ArrayDeque<int[]> jono = new ArrayDeque();
        int[] eka = new int[]{rivi, sarake};
        jono.add(eka);

        // Aputaulukko, jolla algoritmi navigoi viereisiin ruutuihin
        int[] rivit = new int[]{1, 0, -1, 0};
        int[] sarak = new int[]{0, 1, 0, -1};

        // Linnaa käydään läpi, kunnes jonossa ei ole enää sinne kuuluvia paloja
        // Koska jonossa ei ole muuta kuin linnaruutuja, kasvatetaan pisteitä
        // välittömästi, kun ruutu otetaan jonosta
        while (!jono.isEmpty()) {
            int[] edellinen = jono.poll();
            if (lauta[edellinen[0]][edellinen[1]] > 2) {
                lauta[edellinen[0]][edellinen[1]] = 2;
            }
            
            kaydyt[edellinen[0]][edellinen[1]] = true;

            for (int i = 0; i < rivit.length; i++) {
                // Lasketaan uudet sijainnit jonon edellisen palan perusteella
                // Algoritmi navigoi näillä ylos, alas, vasemmalle ja oikealle
                int rivi1 = edellinen[0] + rivit[i];
                int sara1 = edellinen[1] + sarak[i];
                // Tarkistetaan, että ruutu ei ole laudan ulkopuolella
                if (voikoMenna(rivi1, sara1, lauta.length)) {
                    if (kaydyt[rivi1][sara1] == false) {
                        if (lauta[rivi1][sara1] > 1) {
                            int[] uusi = new int[]{rivi1, sara1};
                            jono.add(uusi);
                        } 
                    }
                }
            }
        }
        return lauta;
    }
       
    // Laskee pelaajan saamat pisteet pelin lopuksi
    // Aikavaativuus pahimmillaan O(n^2), jossa on laudan leveys/korkeus
    public int laskePisteet(int[][] lauta, boolean[][] pisteytys) {
        int pisteet = 0;

        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                // Varmistetaan, että ruutua ei ole jo pisteytetty
                if (pisteytys[i][j] == false) {
                    // Jos ruutu on tyhjä tai pelto
                    // merkitään ruutu käsitellyksi ja siirrytään eteenpäin
                    if (lauta[i][j] == 1 || lauta[i][j] == 0) {
                        pisteytys[i][j] = true;
                        // Jos kyseessä on linna, siirrytään pisteyttämään linnaa    
                    } else {
                        pisteet = pisteet + linnanPisteet(i,j,lauta);
                        pisteytys = merkitseLinnaPisteytetyksi(i,j,lauta,pisteytys);
                    }
                }
            }
        }
        return pisteet;
    }

    // Metodi tarkistaa, että linna on kokonaan peltojen ympäröimä
    // Aikavaativuus pahimmillaan O(n^2), jossa on laudan leveys/korkeus
    public boolean onValmis(int rivi, int sarake, int[][] lauta) {
        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];
        // Jos funktion lähtöruutu ei ole linna, ei ole syytä jatkaa eteenpäin
        if (lauta[rivi][sarake] == 0 || lauta[rivi][sarake] == 1) {
            System.out.println("kelvoton ruutu");
            return false;
        }

        // Käsittelemättömät ruudut ovat tässä jonossa
        // Aluksi jonoon laitetaan vain aloitusruutu
        ArrayDeque<int[]> jono = new ArrayDeque();
        int[] eka = new int[]{rivi, sarake};
        jono.add(eka);

        // Aputaulukko, jolla algoritmi navigoi viereisiin linna ruutuihin
        int[] rivit = new int[]{1, 0, -1, 0};
        int[] sarak = new int[]{0, 1, 0, -1};

        while (!jono.isEmpty()) {
            int[] edellinen = jono.poll();
            kaydyt[edellinen[0]][edellinen[1]] = true;

            // Tarkistetaan, että jonosta vedetty linnaruutu on ylhäältä, 
            // oikealta, vasemmalta ja alhaalta muiden ruutujen ympäröimä
            for (int i = 0; i < rivit.length; i++) {

                int r1 = edellinen[0] + rivit[i];
                int s1 = edellinen[1] + sarak[i];

                if (voikoMenna(r1, s1, lauta.length)) {
                    if (lauta[r1][s1] == 0) {
                        return false;
                    } else if (lauta[r1][s1] == 2) {
                        int[] uusi = new int[]{r1, s1};
                        if (kaydyt[r1][s1] == false) {
                            jono.add(uusi);
                        }
                    } else if (lauta[r1][s1] == 3) {
                        int[] uusi = new int[]{r1, s1};
                        if (kaydyt[r1][s1] == false) {
                            jono.add(uusi);
                        }
                    }
                }
            }
        }
        return true;
    }
    
    // Apumetodi, joka tulostaa montako seuraajaa eri pelaajilla on linnoissa
    // Rivillä 0 on pelaajien numerot ja rivillä 1 seuraajien määrä
    public void tulostaPistetaulu(int[][] pisteet) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                System.out.print(pisteet[i][j]);
            }
            System.out.println();
        }
    }

    // Metodi, joka on vain tekoälyn käyttöön
    // Tekoäly laskee montako sen omaa ja muiden pelaajien seuraajaa
    // on ruudussa, johon se harkitsee pelaajansa linnan
    public int[][] linnassaOlevatSeuraajat(int rivi, int sarake, int[] pelaajat, int[][] lauta) {

        int[][] pistetaulu = luoPistetaulu(pelaajat);

        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];

        ArrayDeque<int[]> jono = new ArrayDeque();
        int[] eka = new int[]{rivi, sarake};
        jono.add(eka);

        // Taulukot, joilla algoritmi navigoi linnassa: ylos,alas,vasen,oikea
        // Näillä taulukoilla algoritmi navigoi viereisiin ruutuihin
        int[] rivit = new int[]{1, 0, -1, 0};
        int[] sarak = new int[]{0, 1, 0, -1};

        while (!jono.isEmpty()) {
            int[] edellinen = jono.poll();
            int luku = lauta[edellinen[0]][edellinen[1]];

            if (luku > 2 && kaydyt[edellinen[0]][edellinen[1]] == false) {
                int seuraajienmaara = pistetaulu[1][luku - 3];
                pistetaulu[1][luku - 3] = seuraajienmaara + 1;
            }

            kaydyt[edellinen[0]][edellinen[1]] = true;

            for (int i = 0; i < rivit.length; i++) {
                // lasketaan uudet kordinaatit ylos, alas, vasen ja oikea
                int uusirivi = edellinen[0] + rivit[i];
                int uusisarak = edellinen[1] + sarak[i];
                if (voikoMenna(uusirivi, uusisarak, lauta.length)) {
                    // Tarkistetaan, että laatta on linna
                    if (lauta[uusirivi][uusisarak] != 0 && lauta[uusirivi][uusisarak] != 1) {
                        if (kaydyt[uusirivi][uusisarak] == false) {
                            int[] uusi = new int[]{uusirivi, uusisarak};
                            jono.add(uusi);
                        }
                    }
                }
            }
        }
        return pistetaulu;
    }

    public int viereistenLinnojenPisteet(int rivi, int sarake, int[][] lauta) {

        int pist = 0;

        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];

        int[] rivit = new int[]{1, 0, -1, 0};
        int[] sarak = new int[]{0, 1, 0, -1};

        for (int i = 0; i < rivit.length; i++) {
            int r = rivi + rivit[i];
            int s = sarake + sarak[i];
            // Tarkistetaan, että ruutu ei ole pelilaudan ulkopuolella.
            if (voikoMenna(r, s, lauta.length)) {
                // Tarkistetaan, että viereinen ruutu on käymättä ja osa linnaa.
                if (kaydyt[r][s] == false && lauta[r][s] > 1) {
                    pist = pist + linnanPisteet(r, s, lauta);
                    kaydyt = merkitseLinnaPisteytetyksi(r, s, lauta, kaydyt);
                }
            }
        }
        return pist;
    }

    public int kulmittaistenLinnojenPisteet(int rivi, int sarake, int[][] lauta) {

        int pist = 0;

        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];

        int[] rivit = new int[]{1, -1, 1, -1};
        int[] sarak = new int[]{1, 1, -1, -1};

        for (int i = 0; i < rivit.length; i++) {
            int r = rivi + rivit[i];
            int s = sarake + sarak[i];
            // Tarkistetaan, että ruutu ei ole pelilaudan ulkopuolella.
            if (voikoMenna(r, s, lauta.length)) {
                // Tarkistetaan, että viereinen ruutu on käymättä ja osa linnaa.
                if (kaydyt[r][s] == false && lauta[r][s] > 1) {
                    pist = pist + linnanPisteet(r, s, lauta);
                    kaydyt = merkitseLinnaPisteytetyksi(r, s, lauta, kaydyt);
                }
            }
        }

        return pist;
    }
    
    // Tämä funktio laskee seuraajien määrät linnoissa, jotka ovat tämän ruudun
    // vieressä tai kulmissa.    
    public int pisteetVieressaJaKulmissa(int rivi, int sarake, int[][] lauta) {
                int pist = 0;

        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];

        int[] rivit = new int[]{1, -1, -1, 1,1, 0, -1, 0};
        int[] sarak = new int[]{1, -1, 1, -1,0, 1, 0, -1};

        for (int i = 0; i < rivit.length; i++) {
            int r = rivi + rivit[i];
            int s = sarake + sarak[i];
            // Tarkistetaan, että ruutu ei ole pelilaudan ulkopuolella.
            if (voikoMenna(r, s, lauta.length)) {
                // Tarkistetaan, että viereinen ruutu on käymättä ja osa linnaa.
                if (kaydyt[r][s] == false && lauta[r][s] > 1) {
                    pist = pist + linnanPisteet(r, s, lauta);
                    kaydyt = merkitseLinnaPisteytetyksi(r, s, lauta, kaydyt);
                }
            }
        }
        return pist;        
    }
    
    public int[][] seuraajatVieressaJaKulmissa (int rivi, int sarake, int[] pelaajat, int[][] lauta) {
        
        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];
        
        int[][] pistetaulu = luoPistetaulu(pelaajat);
        
        int[] rivit = new int[]{1, -1, -1, 1,1, 0, -1, 0};
        int[] sarak = new int[]{1, -1, 1, -1,0, 1, 0, -1};
        
        for (int i = 0; i < rivit.length; i++) {
            int r = rivi + rivit[i];
            int s = sarake + sarak[i];
            // Tarkistetaan, että ruutu ei ole pelilaudan ulkopuolella.
            if (voikoMenna(r, s, lauta.length)) {
                // Tarkistetaan, että viereinen ruutu on käymättä ja osa linnaa.
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

    // Tämä funktio katsoo montako seuraajaa kaikissa tämän ruudun viereisissä,
    // eli ylhäällä, alhaalla, vasemmalla ja oikealla olevissa linnoissa on.
    public int[][] ruudunViereistenLinnojenSeuraajat(int rivi, int sarake, int[] pelaajat, int[][] lauta) {

        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];

        int[][] pistetaulu = luoPistetaulu(pelaajat);

        int[] rivit = new int[]{1, 0, -1, 0};
        int[] sarak = new int[]{0, 1, 0, -1};

        for (int i = 0; i < rivit.length; i++) {
            int r = rivi + rivit[i];
            int s = sarake + sarak[i];
            // Tarkistetaan, että ruutu ei ole pelilaudan ulkopuolella.
            if (voikoMenna(r, s, lauta.length)) {
                // Tarkistetaan, että viereinen ruutu on käymättä ja osa linnaa.
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

    // Koska vain viereiset ruudut lasketaan samaksi linnaksi, on pelaajan 
    // mahdollista päästä osingoille muiden linnoihin asettamalla seuraajan
    // ruutuun, joka on kulmittain jonkin linnan kanssa.
    // Tämä funktio laskee montako seuraajaa eri pelaajilla on kulmittain
    // olevissa linnoissa. 
    // Tekoäly käyttää tätä tietoa hyväkseen päättäessään laajentaako se 
    // esimerkiksi omaa linnaansa vain pyrkiikö se osingoille isompaan linnaan
    public int[][] seuraajatKulmittainLinnoissa(int rivi, int sarake, int[] pelaajat, int[][] lauta) {

        boolean[][] kaydyt = new boolean[lauta.length][lauta.length];

        int[][] pistetaulu = luoPistetaulu(pelaajat);

        // Tässä navigoidaan kulmittain oleviin ruutuihin
        int[] rivit = new int[]{1, -1, -1, 1};
        int[] sarak = new int[]{1, -1, 1, -1};

        for (int i = 0; i < rivit.length; i++) {
            int r = rivi + rivit[i];
            int s = sarake + sarak[i];
            // Tarkistetaan, että ruutu ei ole pelilaudan ulkopuolella.
            if (voikoMenna(r, s, lauta.length)) {
                // Tarkistetaan, että viereinen ruutu on käymättä ja osa linnaa.
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

    // Funktio tarkistaa onko ruudun jossain viereisessä tai kulmassa olevassa
    // ruudussa linna
    public boolean kulmassaTaiVieressaOnLinna(int rivi, int sarake, int[][] lauta) {
        int[] rivit = new int[]{1, -1, -1, 1,1, 0, -1, 0};
        int[] sarak = new int[]{1, -1, 1, -1,0, 1, 0, -1};
        
        for (int i = 0; i < rivit.length; i++) {
            int uR = rivi + rivit[i];
            int uS = sarake + sarak[i];
            if (voikoMenna(uR, uS, lauta.length)) {
                if (lauta[uR][uS] > 1) {
                    return true;
                }
            }
        }
        return false;
        
    }
    
    // Funktio tarkistaa, onko ruudun kulmissa: ylhäällä, alhaalla, vasemmalla 
    // tai oikealla linnaan kuuluva ruutu.     
    public boolean kulmassaOnLinna(int rivi, int sarake, int[][] lauta) {

        int[] rivit = new int[]{1, -1, -1, 1};
        int[] sarak = new int[]{1, -1, 1, -1};

        for (int i = 0; i < rivit.length; i++) {
            int uR = rivi + rivit[i];
            int uS = sarake + sarak[i];
            if (voikoMenna(uR, uS, lauta.length)) {
                if (lauta[uR][uS] > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    // Funktio tarkistaa, onko ruudun vieressä: ylhäällä, alhaalla, vasemmalla 
    // tai oikealla linnaan kuuluva ruutu. 
    public boolean vieressaOnLinna(int rivi, int sarake, int[][] lauta) {

        int[] rivit = new int[]{1, 0, -1, 0};
        int[] sarak = new int[]{0, 1, 0, -1};

        for (int i = 0; i < rivit.length; i++) {
            int uR = rivi + rivit[i];
            int uS = sarake + sarak[i];
            if (voikoMenna(uR, uS, lauta.length)) {
                if (lauta[uR][uS] > 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
