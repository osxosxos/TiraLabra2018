
/**
 * Tämä luokka kuvaa determististä tekoälyä, joka pelaa peliä heuristisen
 * matriisin avulla. Heuristisen matriisin laskemisessa otetaan huomioon
 * linnoissa olevat pisteet, vihollisten seuraajat ja pelaajan omat seuraajat.
 * Tämä tekoäly on nopea ja yksinkertainen. Se tekee päätöksen välittömän
 * tilanteen perusteella, eikä laske peliä eteenpäin, toisin kuin edistyneempi
 * pelipuuta käyttävä tekoäly.
 *
 * @author Oskari Koskinen
 */
public class DetermistinenTekoaly {

    private Funktiot funktiot;

    public DetermistinenTekoaly() {
        this.funktiot = new Funktiot();
    }

    /**
     * Tämä funktio laskee heuristisen matriisin, joka kuvaa sitä kuinka paljon
     * pisteitä tekoäly voi potentiaalisesti saada sijoittamalla linnan ruutuun.
     * Piste arvot eivät ole absoluuttisia, vaan niitä on painotettu siten, että
     * tekoälyn mahdollisuus sijoittaa linnalaatta vastustajaa hyödyttävään
     * ruutuun olisi mahdollisimman pieni. *
     *
     * @param pelaajat Pelissä mukana olevien pelaajien numerot
     * @param lauta Pelitilanne, jota tekoäly arvioi.
     * @param pelaaja Tekoälyn numero, jonka eduksi matriisi lasketaan.
     * @return Palauttaa sijoitusmatriisin, jolla tekoäly sijoittaa linnalaatan.
     */
    public int[][] linnanSijoitusMatriisi(int[] pelaajat, int[][] lauta, int pelaaja) {

        int[][] matrix = new int[lauta.length][lauta.length];

        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                if (lauta[i][j] == 0) {
                    if (funktiot.vieressaOnLinna(i, j, lauta)) {

                        // Jos löydetään ruutu, jonka vieressä on linna,
                        // selvitetään montako pistettä ja seuraajaa siihen 
                        // on sijoitettu.
                        int[][] seur = funktiot.ruudunViereistenLinnojenSeuraajat(i, j, pelaajat, lauta);
                        int pist = funktiot.viereistenLinnojenPisteet(i, j, lauta);
                        int pelaajanSeuraajat = 0;
                        int maxSeuraajat = 0;

                        // Lasketaan montako seuraajaa tekoälyllä ja eniten 
                        // eniten seuraajia linnassa olevalla pelaajalla on.
                        // Huomaa, että pelaajien numerot ovat rivillä 0 ja 
                        // viereisissä linnoissa olevat seuraajat rivillä 1. 
                        for (int k = 0; k < seur.length; k++) {
                            if (seur[0][k] == pelaaja) {
                                pelaajanSeuraajat = seur[1][k];
                            }
                            if (seur[1][k] > maxSeuraajat && seur[0][k] != pelaaja) {
                                maxSeuraajat = seur[1][k];
                            }
                        }

                        // Lasketaan kerroin, jos linna on tekoälyn dominoiva,
                        // kerroin on positiivinen, muulloin negatiivinen.
                        int erotus = pelaajanSeuraajat - maxSeuraajat;
                        int kerroin = erotus * pist;
                        matrix[i][j] = kerroin;

                    }

                    if (!funktiot.vieressaOnLinna(i, j, lauta) && funktiot.kulmassaOnLinna(i, j, lauta)) {

                        // Jos vain ruudun kulmissa on linna, tekoäly pyrkii 
                        // lisäämään seuraajia, mutta vain, jos linna on
                        // mahdollista pitää omassa hallinnassa. 
                        int[][] seur = funktiot.seuraajatKulmittainLinnoissa(i, j, pelaajat, lauta);
                        int pist = funktiot.kulmittaistenLinnojenPisteet(i, j, lauta);
                        int pelaajanSeuraajat = 0;
                        int maxSeuraajat = 0;

                        // Lasketaan montako seuraajaa tekoälyllä ja eniten 
                        // eniten seuraajia linnassa olevalla pelaajalla on.
                        // Huomaa, että pelaajien numerot ovat rivillä 0 ja 
                        // viereisissä linnoissa olevat seuraajat rivillä 1. 
                        for (int k = 0; k < seur.length; k++) {

                            if (seur[0][k] == pelaaja) {
                                pelaajanSeuraajat = seur[1][k];
                            }
                            if (seur[1][k] > maxSeuraajat && seur[0][k] != pelaaja) {
                                maxSeuraajat = seur[1][k];
                            }

                        }

                        // Kerroin on painotettu siten, että kulmaan linnan 
                        // asettaminen saa suuremman painon kuin linnan viereen
                        // uuden laatan asettaminen. 
                        int erotus = pelaajanSeuraajat - maxSeuraajat + 1;
                        int kerroin = erotus * pist + pist;
                        matrix[i][j] = kerroin;

                    }
                }
            }
        }

        matrix = tasaaMatriisinPainot(matrix, lauta);
        return matrix;
    }

    /**
     * Toimii samalla periaatteella kuin linnansijoitusmatriisi. Tämän funktion
     * tarkoitus on opastaa tekoäly suojelemaan pelloilla omaa linnaansa.
     *
     * @param pelaajat Pelissä olevien pelaajien numerot.
     * @param lauta Pelitilanne ennen tekoälyn siirtoa.
     * @param pelaaja Tekoälyn numero.
     * @return Palauttaa matriisin, joka ohjaa tekoälyn pellonsijoitusta.
     */
    public int[][] pellonSijoitusMatriisi(int[] pelaajat, int[][] lauta, int pelaaja) {

        int[][] matrix = new int[lauta.length][lauta.length];

        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                if (lauta[i][j] == 0) {

                    if (funktiot.kulmassaTaiVieressaOnLinna(i, j, lauta)) {

                        // Jos löydetään ruutu, jossa on useita linnoja vieressä
                        // ja kulmissa, tekoäly pyrkii suojelemaan sijoituksiaan.
                        // Pelloilla voi estää omien linnojen valtaamisen.
                        // Jos linnoissa ei ole tekoälyn seuraajia, tekoäly ei 
                        // vaivaudu suojelemaan niitä pelloilla. 
                        int[][] kaikSeur = funktiot.seuraajatVieressaJaKulmissa(i, j, pelaajat, lauta);
                        int totalPist = funktiot.pisteetVieressaJaKulmissa(i, j, lauta);

                        int pelaajanSeuraajat = 0;
                        int maxSeuraajat = 0;

                        // Selvitetään paljonko tekoälyllä ja eniten seuraajia 
                        // linnassa omistavalla pelaajalla on seuraajia. 
                        for (int k = 0; k < pelaajat.length; k++) {

                            if (kaikSeur[0][k] == pelaaja) {
                                pelaajanSeuraajat = kaikSeur[1][k];
                            }

                            if (kaikSeur[1][k] > maxSeuraajat && kaikSeur[0][k] != pelaaja) {
                                maxSeuraajat = kaikSeur[1][k];
                            }

                        }

                        // Tässä tilanne, jossa jollain muulla pelaajalla on 
                        // enemmän seuraajia kuin tekoälyllä saa suurimman arvon,
                        // koska se viestii tarpeesta suojella omaa linnaa. 
                        if (pelaajanSeuraajat == 0) {
                            matrix[i][j] = 0;
                        } else if (pelaajanSeuraajat > maxSeuraajat) {
                            matrix[i][j] = totalPist * pelaajanSeuraajat;
                        } else {
                            matrix[i][j] = maxSeuraajat * pelaajanSeuraajat * totalPist;
                        }

                    }

                    if (funktiot.vieressaOnLinna(i, j, lauta) && !funktiot.kulmassaOnLinna(i, j, lauta)) {

                        // Jos ollaan tilanteessa, jossa useampi linna voi 
                        // yhdistyä yhden laatan pelaamisella, tekoäly pyrkii
                        // estämään linnan omistuksen menettämisen.
                        int[][] seur = funktiot.ruudunViereistenLinnojenSeuraajat(i, j, pelaajat, lauta);
                        int pist = funktiot.viereistenLinnojenPisteet(i, j, lauta);
                        int pelaajanSeuraajat = 0;
                        int maxSeuraajat = 0;

                        // Selvitetään paljonko tekoälyllä ja eniten seuraajia 
                        // linnassa omistavalla pelaajalla on seuraajia. 
                        for (int k = 0; k < seur.length; k++) {

                            if (seur[0][k] == pelaaja) {
                                pelaajanSeuraajat = seur[1][k];
                            }

                            if (seur[1][k] > maxSeuraajat && seur[0][k] != pelaaja) {
                                maxSeuraajat = seur[1][k];
                            }
                        }

                        // Tässäkin tilanne, jossa vihollisella on suurempi määrä
                        // seuraajia saa suurimman painoarvon. Tämän tarkoitus on 
                        // saada tekoäly suojelemaan sijoituksiaan. 
                        if (pelaajanSeuraajat == 0) {
                            matrix[i][j] = 0;
                        } else if (pelaajanSeuraajat > maxSeuraajat) {
                            matrix[i][j] = pist * pelaajanSeuraajat;
                        } else {
                            matrix[i][j] = maxSeuraajat * pelaajanSeuraajat * pist * 3;
                        }
                    }

                    if (!funktiot.vieressaOnLinna(i, j, lauta) && funktiot.kulmassaOnLinna(i, j, lauta)) {

                        // Tässä tekoäly pyrkii omien linnojen kulmien suojeluun
                        // peltolaattoja asettamalla. 
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

                        // Suurimman arvon saa jälleen tilanne, jossa linnojen
                        // yhdistyminen tekoälyn harmiksi on mahdolista. 
                        if (pelaajanSeuraajat == 0) {
                            matrix[i][j] = 0;
                        } else if (pelaajanSeuraajat > maxSeuraajat) {
                            matrix[i][j] = pist * pelaajanSeuraajat;
                        } else {
                            matrix[i][j] = maxSeuraajat * pelaajanSeuraajat * pist;
                        }
                    }

                }
            }
        }

        matrix = tasaaMatriisinPainot(matrix, lauta);
        return matrix;
    }

    /**
     * Tämä funktio tasapainottaa sijoitusmatriisin painot siten, että mitä
     * enemmän kohderuudun ympärillä on tärkeitä ruutuja, sitä suuremman
     * painoarvon kyseinen ruutu saa.
     *
     * @param matrix Syötteenä annettu- linnan tai pellonsijoitusmatriisi.
     * @param lauta Pelitilanne, josta tarkistetaan, että painoja ei anneta
     * ruuduille, jotka on jo varattu.
     * @return Palauttaa painotetun sijoitusmatriisin.
     */
    public int[][] tasaaMatriisinPainot(int[][] matrix, int[][] lauta) {
        
        // Luodaan uusi matriisi, joka palautetaan.
        int[][] newMatrix = new int[matrix.length][matrix.length];
        
        // Nämä taulukot ovat pelilaudalla navigointia varten. 
        int[] rivit = new int[]{1, 0, -1, 0, 1, -1, -1, 1};
        int[] sarak = new int[]{0, 1, 0, -1, 1, -1, 1, -1};
        
        // Käydään matriisi läpi.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                
                // Painotetaan arvo ympäröivien ruutujen arvoilla, mutta
                // vain, jos paikka on kelvollinen pelattavaksi. 
                
                if (lauta[i][j] == 0) {
                    int arvo = matrix[i][j];
                    newMatrix[i][j] = arvo;
                    
                    for (int k = 0; k < 8; k++) {
                        int uusiRivi = i + rivit[k];
                        int uusiSarake = j + sarak[k];
                        
                        if (funktiot.voikoMenna(uusiRivi, uusiSarake, matrix.length)) {
                            newMatrix[i][j] = newMatrix[i][j] + matrix[uusiRivi][uusiSarake] / 3;
                        }
                        
                    }
                }
            }
        }
        return newMatrix;
    }

    /**
     * Tällä funktiolla tekoäly pelaa linna-laatan sijoitusmatriisin
     * perusteella. Se pelataan ensimmäiseen ruutuun, jossa on suurin arvo.
     *
     * @param lauta Pelitilanne ennen siirron tekemistä.
     * @param pelaaja Pelaajan numero, tarvitaan seuraajan asettamiseen.
     * @param seuraajat Pelaajalla olevien seuraajien määrä.
     * @param pelaajat Pelissä mukana olevat pelaajat.
     * @return Funktio palauttaa pelitilanteen, johon determistinen tekoäly on
     * pelannut linnalaatan ja mahdollisesti siihen myös seuraajan.
     */
    public int[][] pelaaLinna(int[][] lauta, int pelaaja, int seuraajat, int[] pelaajat) {

        // Sijoitusmatriisi, joka kertoo mihin linna kannattaa pelata.
        int[][] matrix = linnanSijoitusMatriisi(pelaajat, lauta, pelaaja);

        Lista vapaat = new Lista();

        // Etsitään vapaat ruudut
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                if (lauta[i][j] == 0) {
                    vapaat.add(new int[]{i, j, matrix[i][j]});
                }
            }
        }

        int suurin = Integer.MIN_VALUE;

        // Etsitään sijoitusmatriisin suurin arvo vapaiden ruutujen joukosta.        
        for (int i = 0; i < vapaat.size(); i++) {
            
            int[] taulu = (int[]) vapaat.get(i);
            
            if (taulu[2] >= suurin) {
                suurin = taulu[2];
            }
            
        }
        
        // Sijoitetaan laatta ensimmäiseen vapaaseen ruutuun. 
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
     * Tällä funktiolla tekoäly pelaa pelto-laatan sijoitusmatriisin
     * perusteella. Se pelataan ensimmäiseen ruutuun, jossa on suurin arvo.
     *
     * @param lauta Pelitilanne ennen siirron tekemistä.
     * @param pelaaja Pelaajan numero, tarvitaan seuraajan asettamiseen.
     * @param pelaajat Pelissä mukana olevat pelaajat.
     * @return Funktio palauttaa pelitilanteen, johon determistinen tekoäly on
     * pelannut pelto-laatan.
     */
    public int[][] pelaaPelto(int[][] lauta, int pelaaja, int[] pelaajat) {

        // Sijoitusmatriisi, joka kertoo mihin pelto kannattaa pelata.
        int[][] matrix = pellonSijoitusMatriisi(pelaajat, lauta, pelaaja);

        // Etsitään ensin sijoitusmatriisin maksimiarvo.
        Lista vapaat = new Lista();
        
        // Etsitään listaan vapaat ruudut. 
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                
                if (lauta[i][j] == 0) {
                    vapaat.add(new int[]{i, j, matrix[i][j]});
                }
            }
        }

        int suurin = Integer.MIN_VALUE;
        
        // Etsitään vapaiden ruutujen joukosta sijoitusmatriisin suurin arvo.
        for (int i = 0; i < vapaat.size(); i++) {
            int[] taulu = (int[]) vapaat.get(i);
            if (taulu[2] >= suurin) {
                suurin = taulu[2];
            }
        }

        // Pelataan tätä vastaavaan ruutuun annettu laatta. 
        for (int i = 0; i < vapaat.size(); i++) {
            int[] taulu = (int[]) vapaat.get(i);
            if (taulu[2] == suurin) {
                lauta = funktiot.asetaLaatta(taulu[0], taulu[1], 1, lauta);
                break;
            }
        }

        return lauta;

    }

}
