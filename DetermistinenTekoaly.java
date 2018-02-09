
package tiralabrapeli;

import java.util.ArrayDeque;

// Tämä luokka kuvaa determististä tekoälyä, joka laskee "heuristisen matriisin"
// avulla parhaan paikan laatalle vapaiden ruutujen joukosta. 
// Algoritmi toimii determistisesti, jos yksi ruutu on yli muiden, jos kaksi tai
// useampi ruutu saa saman arvon, tekoäly arpoo ruudun, johon se sijoittaa laatan
public class DetermistinenTekoaly {
    // Numero kuvaa tekoälyn seuraajia pelilaudalla
    // Pisteet kuvaa tekoälyn keräämiä pisteitä
    private int numero;
    private int seuraajat;
    private int pisteet;
    private Funktiot funktiot;

    // Konstruktorimme
    public DetermistinenTekoaly(int numero,int seuraajat) {
        this.numero = numero;
        this.seuraajat = seuraajat;
        this.pisteet = 0;
        this.funktiot = new Funktiot();
    }

    public int getNumero() {
        return numero;
    }

    public int getPisteet() {
        return pisteet;
    }
    
    // Apumetodi koodin yksinkertaistamiseksi
    public int[][] luoPistetaulu(int[]pelaajat) {
        int[][]pistetaulu = new int[2][pelaajat.length];        
        for (int i = 0; i < pelaajat.length; i++) {
            pistetaulu[0][i] = pelaajat[i];
        }
        return pistetaulu;
    }
    
    // Apumetodi, joka tulostaa montako seuraajaa eri pelaajilla on linnoissa
    // Rivillä 0 on pelaajien numerot ja rivillä 1 seuraajien määrä
    public void tulostaPistetaulu(int[][]pisteet) {
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
    public int[][] linnassaOlevatSeuraajat(int rivi, int sarake, int[]pelaajat, int[][]lauta){        
      
        int[][]pistetaulu = luoPistetaulu(pelaajat);
             
        boolean[][]kaydyt = new boolean[lauta.length][lauta.length];
        
        ArrayDeque<int[]>jono = new ArrayDeque();
        int[]eka = new int[]{rivi,sarake};
        jono.add(eka);
        
        // Taulukot, joilla algoritmi navigoi linnassa: ylos,alas,vasen,oikea
        // Näillä taulukoilla algoritmi navigoi viereisiin ruutuihin
        int[] rivit = new int[]{1, 0, -1, 0};
        int[] sarak = new int[]{0, 1, 0, -1};
        
        while (!jono.isEmpty()) {
            int[]edellinen = jono.poll();
            int luku = lauta[edellinen[0]][edellinen[1]];            

            if (luku > 2 && kaydyt[edellinen[0]][edellinen[1]] == false ) {
                int seuraajienmaara = pistetaulu[1][luku-3];
                pistetaulu[1][luku-3] = seuraajienmaara + 1;
            }
            
            kaydyt[edellinen[0]][edellinen[1]] = true;
            
            for (int i = 0; i < rivit.length; i++) {
                // lasketaan uudet kordinaatit ylos, alas, vasen ja oikea
                int uusirivi = edellinen[0] + rivit[i];
                int uusisarak = edellinen[1] + sarak[i];
                if (funktiot.voikoMenna(uusirivi, uusisarak, lauta.length)) {
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
    
    public int viereistenLinnojenPisteet(int rivi, int sarake, int[][]lauta) {
        
        int pist = 0;
        
        boolean[][]kaydyt = new boolean[lauta.length][lauta.length];
                
        int[] rivit = new int[]{1, 0,-1, 0};
        int[] sarak = new int[]{0, 1, 0, -1};
        
        for (int i = 0; i < rivit.length; i++) {
            int r = rivi + rivit[i];
            int s = sarake + sarak[i];
            // Tarkistetaan, että ruutu ei ole pelilaudan ulkopuolella.
            if (funktiot.voikoMenna(r,s,lauta.length)) {
                // Tarkistetaan, että viereinen ruutu on käymättä ja osa linnaa.
                if (kaydyt[r][s] == false && lauta[r][s] > 1) {
                    pist = pist + funktiot.linnanPisteet(r, s, lauta);
                    kaydyt = funktiot.merkitseLinnaPisteytetyksi(r, s, lauta, kaydyt);                         
                }
            }
        }
                
        return pist;
    }
    
    public int kulmittaistenLinnojenPisteet(int rivi, int sarake, int[][]lauta) {
        
        int pist = 0;
        
        boolean[][]kaydyt = new boolean[lauta.length][lauta.length];
                
        int[] rivit = new int[]{1,-1, 1,-1};
        int[] sarak = new int[]{1, 1,-1,-1};
        
        for (int i = 0; i < rivit.length; i++) {
            int r = rivi + rivit[i];
            int s = sarake + sarak[i];
            // Tarkistetaan, että ruutu ei ole pelilaudan ulkopuolella.
            if (funktiot.voikoMenna(r,s,lauta.length)) {
                // Tarkistetaan, että viereinen ruutu on käymättä ja osa linnaa.
                if (kaydyt[r][s] == false && lauta[r][s] > 1) {
                    pist = pist + funktiot.linnanPisteet(r, s, lauta);
                    kaydyt = funktiot.merkitseLinnaPisteytetyksi(r, s, lauta, kaydyt);                         
                }
            }
        }
                
        return pist;
    }
    
    // Tämä funktio katsoo montako seuraajaa kaikissa tämän ruudun viereisissä,
    // eli ylhäällä, alhaalla, vasemmalla ja oikealla olevissa linnoissa on.
    public int[][] ruudunViereistenLinnojenSeuraajat(int rivi, int sarake, int[]pelaajat, int[][]lauta) {
        
        boolean[][]kaydyt = new boolean[lauta.length][lauta.length];
        
        int[][]pistetaulu = luoPistetaulu(pelaajat);
        
        int[] rivit = new int[]{1, 0,-1, 0};
        int[] sarak = new int[]{0, 1, 0, -1};
        
        for (int i = 0; i < rivit.length; i++) {
            int r = rivi + rivit[i];
            int s = sarake + sarak[i];
            // Tarkistetaan, että ruutu ei ole pelilaudan ulkopuolella.
            if (funktiot.voikoMenna(r,s,lauta.length)) {
                // Tarkistetaan, että viereinen ruutu on käymättä ja osa linnaa.
                if (kaydyt[r][s] == false && lauta[r][s] > 1) {
                    int[][]p = linnassaOlevatSeuraajat(r ,s ,pelaajat, lauta);
                    kaydyt = funktiot.merkitseLinnaPisteytetyksi(r, s, lauta, kaydyt);
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
    public int[][] seuraajatKulmittainLinnoissa(int rivi, int sarake, int[]pelaajat, int[][]lauta) {
        
        boolean[][]kaydyt = new boolean[lauta.length][lauta.length];
        
        int[][]pistetaulu = luoPistetaulu(pelaajat);
        
        // Tässä navigoidaan kulmittain oleviin ruutuihin
        int[] rivit = new int[]{1,-1,-1, 1};
        int[] sarak = new int[]{1,-1, 1,-1};
        
        for (int i = 0; i < rivit.length; i++) {
            int r = rivi + rivit[i];
            int s = sarake + sarak[i];
            // Tarkistetaan, että ruutu ei ole pelilaudan ulkopuolella.
            if (funktiot.voikoMenna(r,s,lauta.length)) {
                // Tarkistetaan, että viereinen ruutu on käymättä ja osa linnaa.
                if (kaydyt[r][s] == false && lauta[r][s] > 1) {
                    int[][]p = linnassaOlevatSeuraajat(r ,s ,pelaajat, lauta);
                    kaydyt = funktiot.merkitseLinnaPisteytetyksi(r, s, lauta, kaydyt);
                    for (int j = 0; j < pelaajat.length; j++) {
                        int x = pistetaulu[1][j];
                        pistetaulu[1][j] = x + p[1][j];
                    }                          
                }
            }
        }
        return pistetaulu;        
    }
    
    // Funktio tarkistaa, onko ruudun kulmissa: ylhäällä, alhaalla, vasemmalla 
    // tai oikealla linnaan kuuluva ruutu. 
    public boolean kulmassaOnLinna(int rivi, int sarake, int[][]lauta) {
        
        int[] rivit = new int[]{1,-1,-1, 1};
        int[] sarak = new int[]{1,-1, 1,-1};
        
        for (int i = 0; i < rivit.length; i++) {
            int uR = rivi + rivit[i];
            int uS = sarake + sarak[i];
            if (funktiot.voikoMenna(uR,uS,lauta.length)) {
                if (lauta[uR][uS] > 1) {
                    return true;
                }
            }
        }
        return false;
    }
    
    // Funktio tarkistaa, onko ruudun vieressä: ylhäällä, alhaalla, vasemmalla 
    // tai oikealla linnaan kuuluva ruutu. 
    public boolean vieressaOnLinna(int rivi, int sarake, int[][]lauta) {
        
        int[] rivit = new int[]{1, 0,-1, 0};
        int[] sarak = new int[]{0, 1, 0, -1};
        
        for (int i = 0; i < rivit.length; i++) {
            int uR = rivi + rivit[i];
            int uS = sarake + sarak[i];
            if (funktiot.voikoMenna(uR,uS,lauta.length)) {
                if (lauta[uR][uS] > 1) {
                    return true;
                }
            }
        }
        return false;
    }
        
    // Tämä funktio laskee heuristisen matriisin, joka kuvaa sitä kuinka paljon
    // pisteitä tekoäly voi potentiaalisesti saada sijoittamalla linnan ruutuun.
    // Piste arvot eivät ole absoluuttisia, vaan niitä on painotettu siten, 
    // että tekoälyn mahdollisuus sijoittaa linnalaatta vastustajaa hyödyttävään
    // ruutuun olisi mahdollisimman pieni. 
    public int[][] linnanSijoitusMatriisi(int[]pelaajat,int[][]lauta, int pelaaja) {
        
        int[][]matrix = new int[lauta.length][lauta.length];
        
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                if (lauta[i][j] == 0) {
                    if (vieressaOnLinna(i,j,lauta)) {
                        int[][]seur = ruudunViereistenLinnojenSeuraajat(i,j,pelaajat,lauta);
                        int pist = viereistenLinnojenPisteet(i,j,lauta);
                        int pelaajanSeuraajat = 0;
                        int maxSeuraajat = 0;
                        for (int k = 0; k < seur.length; k++) {
                            if (seur[0][k] == pelaaja) {
                                pelaajanSeuraajat = seur[1][k];                                
                            }
                            if (seur[1][k] > maxSeuraajat && seur[0][k] != pelaaja) {
                                maxSeuraajat = seur[1][k];
                            }
                        }
                        int erotus = pelaajanSeuraajat - maxSeuraajat;
                        int kerroin = erotus*pist;
                        matrix[i][j] = kerroin;
                    }
                    if (!vieressaOnLinna(i,j,lauta) && kulmassaOnLinna(i,j,lauta)) {
                        int[][]seur = seuraajatKulmittainLinnoissa(i,j,pelaajat,lauta);
                        int pist = kulmittaistenLinnojenPisteet(i,j,lauta);
                        int pelaajanSeuraajat = 0;
                        int maxSeuraajat = 0;
                        for (int k = 0; k < seur.length; k++) {
                            if (seur[0][k] == pelaaja) {
                                pelaajanSeuraajat = seur[1][k];                                
                            }
                            if (seur[1][k] > maxSeuraajat && seur[0][k] != pelaaja) {
                                maxSeuraajat = seur[1][k];
                            }
                        }
                        int erotus = pelaajanSeuraajat - maxSeuraajat + 1;
                        int kerroin = erotus*pist + pist;
                        matrix[i][j] = kerroin;
                    }
                }
            }                
        }                
        return matrix;
    }
    
}
