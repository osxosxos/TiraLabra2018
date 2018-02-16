package tiralabrapeli;

import java.util.ArrayDeque;
import java.util.Random;

// Tämä luokka kuvaa determististä tekoälyä, joka laskee "heuristisen matriisin"
// avulla parhaan paikan laatalle vapaiden ruutujen joukosta. 
// Algoritmi toimii determistisesti, jos yksi ruutu on yli muiden, jos kaksi tai
// useampi ruutu saa saman arvon, tekoäly arpoo ruudun, johon se sijoittaa laatan
public class DetermistinenTekoaly {
    private Funktiot funktiot;

    public DetermistinenTekoaly() {
        this.funktiot = new Funktiot();
    }
        
    // Tämä funktio laskee heuristisen matriisin, joka kuvaa sitä kuinka paljon
    // pisteitä tekoäly voi potentiaalisesti saada sijoittamalla linnan ruutuun.
    // Piste arvot eivät ole absoluuttisia, vaan niitä on painotettu siten, 
    // että tekoälyn mahdollisuus sijoittaa linnalaatta vastustajaa hyödyttävään
    // ruutuun olisi mahdollisimman pieni. 
    public int[][] linnanSijoitusMatriisi(int[] pelaajat, int[][] lauta, int pelaaja) {

        int[][] matrix = new int[lauta.length][lauta.length];

        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                if (lauta[i][j] == 0) {
                    if (funktiot.vieressaOnLinna(i, j, lauta)) {
                        int[][] seur = funktiot.ruudunViereistenLinnojenSeuraajat(i, j, pelaajat, lauta);
                        int pist = funktiot.viereistenLinnojenPisteet(i, j, lauta);
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
                        int kerroin = erotus * pist;
                        matrix[i][j] = kerroin;
                    }
                    if (!funktiot.vieressaOnLinna(i, j, lauta) && funktiot.kulmassaOnLinna(i, j, lauta)) {
                        int[][] seur = funktiot.seuraajatKulmittainLinnoissa(i, j, pelaajat, lauta);
                        int pist = funktiot.kulmittaistenLinnojenPisteet(i, j, lauta);
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
                        int kerroin = erotus * pist + pist;
                        matrix[i][j] = kerroin;
                    }
                }
            }
        }
        
        matrix = tasaaMatriisinPainot(matrix,lauta);
        return matrix;
    }

    public int[][] pellonSijoitusMartiisi(int[] pelaajat, int[][] lauta, int pelaaja) {

        int[][] matrix = new int[lauta.length][lauta.length];

        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                if (lauta[i][j] == 0) {
                    
                    if (funktiot.kulmassaTaiVieressaOnLinna(i,j,lauta)) {
                        int[][] kaikSeur = funktiot.seuraajatVieressaJaKulmissa(i,j,pelaajat,lauta);
                        int totalPist = funktiot.pisteetVieressaJaKulmissa(i,j,lauta);

                        int pelaajanSeuraajat = 0;
                        int maxSeuraajat = 0;
                        
                        for (int k = 0; k < pelaajat.length; k++) {
                            if (kaikSeur[0][k] == pelaaja) {
                                pelaajanSeuraajat = kaikSeur[1][k];
                            }
                            if (kaikSeur[1][k] > maxSeuraajat && kaikSeur[0][k] != pelaaja) {
                                maxSeuraajat = kaikSeur[1][k];
                            }
                        }
                 
                        if (pelaajanSeuraajat == 0) {
                            matrix[i][j] = 0;
                        } else if (pelaajanSeuraajat > maxSeuraajat) {
                            matrix[i][j] = totalPist*pelaajanSeuraajat;
                        } else {
                            matrix[i][j] = maxSeuraajat*pelaajanSeuraajat*totalPist;
                        }                            
                        
                    }
                    
                    if (funktiot.vieressaOnLinna(i, j, lauta) && !funktiot.kulmassaOnLinna(i, j, lauta)) {
                        int[][] seur = funktiot.ruudunViereistenLinnojenSeuraajat(i, j, pelaajat, lauta);
                        int pist = funktiot.viereistenLinnojenPisteet(i, j, lauta);
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
                        if (pelaajanSeuraajat == 0) {
                            matrix[i][j] = 0;
                        } else if (pelaajanSeuraajat > maxSeuraajat) {
                            matrix[i][j] = pist*pelaajanSeuraajat;
                        } else {
                            matrix[i][j] = maxSeuraajat*pelaajanSeuraajat*pist*3;
                        }                        
                    }
                    
                    if (!funktiot.vieressaOnLinna(i, j, lauta) && funktiot.kulmassaOnLinna(i, j, lauta)) {
                        int[][] seur = funktiot.seuraajatKulmittainLinnoissa(i, j, pelaajat, lauta);
                        int pist = funktiot.kulmittaistenLinnojenPisteet(i, j, lauta);
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
                                  
                        if (pelaajanSeuraajat == 0) {
                            matrix[i][j] = 0;
                        } else if (pelaajanSeuraajat > maxSeuraajat) {
                            matrix[i][j] = pist*pelaajanSeuraajat;
                        } else {
                            matrix[i][j] = maxSeuraajat*pelaajanSeuraajat*pist;
                        }  
                    }
                    
                }
            }
        }

        matrix = tasaaMatriisinPainot(matrix, lauta);
        return matrix;
    }
    
    // Tämä funktio tasapainottaa sijoitusmatriisin painot siten, että mitä
    // enemmän kohderuudun ympärillä on tärkeitä ruutuja, sitä suuremman 
    // painoarvon kyseinen ruutu saa. 
    public int[][] tasaaMatriisinPainot(int[][] matrix, int[][] lauta) {
        // Luodaan uusi matriisi, joka palautetaan.
        int[][] newMatrix = new int[matrix.length][matrix.length];
        // Nämä taulukot ovat pelilaudalla navigointia varten. 
        int[] rivit = new int[]{1, 0,-1, 0,1,-1,-1, 1};
        int[] sarak = new int[]{0, 1, 0,-1,1,-1, 1,-1};
        // Käydään matriisi läpi.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                // Painotetaan arvo ympäröivien ruutujen arvoilla, mutta
                // vain, jos paikka on kelvollinen pelattavaksi. 
                if (lauta[i][j] == 0) {
                    int arvo = matrix[i][j];
                    newMatrix[i][j] = arvo;
                    for (int k = 0; k < 8; k++) {
                        int uR = i + rivit[k];
                        int uS = j + sarak[k];
                        if (funktiot.voikoMenna(uR, uS, matrix.length)) {
                            newMatrix[i][j] = newMatrix[i][j] + matrix[uR][uS]/3;
                        }
                    }
                }
            }
        }
        return newMatrix;
    }
    
    // Tällä funktiolla tekoäly pelaa linna-ruudun.
    // Linnan sijoittamisessa tekoäly hyödyntää sijoitusmatriisia.
    // Jos sijoitusmatriisissa on useita paikkoja, jotka ovat yhtä hyviä,
    // Tekoäly arpoo ruudun, johon se sijoittaa linnan.
    // Tekoäly on ahne, joten se laittaa seuraajan aina kun mahdollista. 
    public int[][] pelaaLinna(int[][] lauta, int pelaaja, int seuraajat, int[]pelaajat) {
        // Sijoitusmatriisi, joka kertoo mihin linna kannattaa pelata.
        int[][] matrix = linnanSijoitusMatriisi(pelaajat,lauta,pelaaja);
        // Etsitään ensin sijoitusmatriisin maksimiarvo.
        int max = 0;
        
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
                
        // Apumuuttuja, joka laskee montako kertaa suurin arvo esiintyy
        int maara = 0;
        
        // Etsitään montako kertaa maksimiarvo esiintyy matriisissa        
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == max) {
                    maara++;
                }
            }
        }        
        
        // Tallennetaan taulukkoon koordinaatit, jossa maksimiarvo esiintyy
        int[][]koordinaatit = new int[3][maara];
        int k = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == max) {
                    koordinaatit[1][k] = i;
                    koordinaatit[2][k] = j;
                    k++; 
                }
            }
        }
        
        // Arvotaan kohta, johon linna asetetaan
        Random random = new Random();
        int sijoitus = random.nextInt(maara);
        int rivi = koordinaatit[1][sijoitus];
        int sarake = koordinaatit[2][sijoitus];

        
        lauta[rivi][sarake] = 2;
        
        if (!funktiot.onkoLinnassaJoSeuraaja(rivi, sarake, lauta)) {
            if (seuraajat > 0) {
                lauta[rivi][sarake] = pelaaja;
            }
        }
               
        return lauta;
    }
        
    // Tällä funktiolla tekoäly pelaa pelto-ruudun.
    // Pellon sijoittamisessa tekoäly hyödyntää sijoitusmatriisia.
    // Jos sijoitusmatriisissa on useita paikkoja, jotka ovat yhtä hyviä,
    // Tekoäly arpoo ruudun, johon se sijoittaa pellon.
    // Tekoäly pyrkii suojelemaan linnojaan, mitä arvokkaampi linna ja mitä
    // enemmän omia seuraaajia siellä on, sitä suurempi painoarvo pellon 
    // sijoittamiselle annetaan. 
    public int[][] pelaaPelto(int[][] lauta, int pelaaja, int[]pelaajat) {
        // Sijoitusmatriisi, joka kertoo mihin pelto kannattaa pelata.
        int[][] matrix = pellonSijoitusMartiisi(pelaajat,lauta,pelaaja);
        // Etsitään ensin sijoitusmatriisin maksimiarvo.
        int max = 0;
        
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
                
        // Apumuuttuja, joka laskee montako kertaa suurin arvo esiintyy
        int maara = 0;
        
        // Etsitään montako kertaa maksimiarvo esiintyy matriisissa        
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == max) {
                    maara++;
                }
            }
        }        
        
        // Tallennetaan taulukkoon koordinaatit, jossa maksimiarvo esiintyy
        int[][]koordinaatit = new int[3][maara];
        int k = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == max) {
                    koordinaatit[1][k] = i;
                    koordinaatit[2][k] = j;
                    k++; 
                }
            }
        }
        
        // Arvotaan kohta, johon pelto asetetaan
        Random random = new Random();
        int sijoitus = random.nextInt(maara);
        int rivi = koordinaatit[1][sijoitus];
        int sarake = koordinaatit[2][sijoitus];
        
        lauta[rivi][sarake] = 1;
                        
        return lauta;
    }
    
    // Funktio tulostaa tekoälyn laskemat koordinaatit.
    // Tämän tarkoitus on auttaa debuggaamisessa. 
    public void tulostaKoordinaatit(int[][] koordinaatit) {
        int k = 0;
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                System.out.print("numero: ");
            }                               
            if (i == 1) {                    
                System.out.print("rivi:   ");
            }
            if (i == 2) { 
                System.out.print("sarake: ");
            }
            for (int j = 0; j < koordinaatit[0].length; j++) {
                if (i == 0) {
                    System.out.print(k + " ");
                    k++;
                } else {
                    System.out.print(koordinaatit[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("");
    }
    
}
