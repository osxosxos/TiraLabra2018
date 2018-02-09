package tiralabrapeli;

import java.util.ArrayDeque;
import java.util.Scanner;

// lauta-taulu pitää yllä pelitilanteen
// pisteytys-taulu pitää huolen, että jokainen ruutu pisteytetään vain kerran
public class Peli {
    Scanner scanner;
    Funktiot funktiot;

    // Konstruktorimme, koska Java. 
    public Peli() {
        this.funktiot = new Funktiot();
        this.scanner = new Scanner(System.in);
        // Tähän tulee erilliset listat pelaajille ja mahdollisille tekoälyille
    }
    /*
    // Pelin käyttöliittymä, koodin pitäisi selittää itse itseään IMO
    public void pelaa(int koko, int seuraajienMaara, int laattojenMaara) {

        System.out.println("--------tervetuloa pelaamaan!----------");
        System.out.println("peli jatkuu niin kauan kuin laattoja on");
        System.out.println("---------------------------------------");
        System.out.println("");

        int[][] lauta = new int[koko][koko];
        boolean[][] pisteytys = new boolean[koko][koko];
        ArrayDeque<Integer> laatat = funktiot.taytaPakka(laattojenMaara);
        int seuraajat = seuraajienMaara;
        int pisteet = 0;

        while (!laatat.isEmpty()) {
            System.out.println("sinulla on nyt pisteitä: " + pisteet);
            System.out.println("laattoja on jäljellä: " + laatat.size());
            System.out.println("kartta on nyt:");
            funktiot.tulostaKartta(lauta);

            int seuraava = laatat.poll();

            if (seuraava == 1) pelaaPelto(lauta); {

            } else {
                System.out.println("laatta on linna");
                while (true) {
                    System.out.println("anna rivi:");
                    int rivi = Integer.parseInt(scanner.nextLine());
                    System.out.println("anna sarake:");
                    int sarake = Integer.parseInt(scanner.nextLine());
                    if (voikoMenna(rivi, sarake) && onkoVapaa(rivi, sarake)) {
                        asetaLaatta(rivi, sarake, 2);
                        System.out.println("haluatko asettaa seuraajan");
                        System.out.println("1 = kyllä, 2 = ei");
                        int vastaus = Integer.parseInt(scanner.nextLine());
                        if (vastaus == 1) {
                            if (!onkoLinnassaJoSeuraaja(rivi, sarake)) {
                                asetaSeuraaja(rivi, sarake, 3);
                                System.out.println("seuraajan asettaminen onnistui");
                                if (onValmis(rivi, sarake)) {
                                    this.pisteet = this.pisteet + linnanPisteet(rivi, sarake);
                                }
                                break;
                            } else {
                                System.out.println("linnassa on jo seuraaja");
                                if (onValmis(rivi, sarake)) {
                                    this.pisteet = this.pisteet + linnanPisteet(rivi, sarake);
                                }
                                break;
                            }
                        } else {
                            if (onValmis(rivi, sarake)) {
                                this.pisteet = this.pisteet + linnanPisteet(rivi, sarake);
                            }
                            break;
                        }
                    } else {
                        System.out.println("epäkelpo ruutu!");
                    }
                }
            }
        }
        pisteet = pisteet + laskePisteet();
        System.out.println("Peli on nyt loppu.");
        System.out.println("sait " + pisteet + " pistettä!");
    }

    public int[][] pelaaPelto(int[][]lauta) {
        System.out.println("laatta on pelto");
        while (true) {
            System.out.println("anna rivi:");
            int rivi = Integer.parseInt(scanner.nextLine());
            System.out.println("anna sarake:");
            int sarake = Integer.parseInt(scanner.nextLine());
            if (funktiot.voikoMenna(rivi, sarake, lauta.length)
                    && funktiot.onkoVapaa(rivi, sarake, lauta)) {
                funktiot.asetaLaatta(rivi, sarake, 1, lauta);
                // Jos peloruudun vieressä on yksi tai useampi linna
                // Tarkistetaan, tuleeko yksi tai useampi näistä valmiiksi
                int[] rivit = new int[]{1, 0, -1, 0};
                int[] sarak = new int[]{0, 1, 0, -1};
                for (int i = 0; i < rivit.length; i++) {
                    int uusiRivi = rivi + rivit[0];
                    int uusiSara = sarake + sarak[0];
                    if (voikoMenna(uusiRivi, uusiSara)) {
                        if (lauta[uusiRivi][uusiSara] == 2) {
                            if (onValmis(uusiRivi, uusiSara)) {
                                this.pisteet = this.pisteet + linnanPisteet(uusiRivi, uusiSara);
                            }
                        }
                        if (lauta[uusiRivi][uusiSara] == 3) {
                            if (onValmis(uusiRivi, uusiSara)) {
                                this.pisteet = this.pisteet + linnanPisteet(uusiRivi, uusiSara);
                            }
                        }
                    }
                }
                break;
            } else {
                System.out.println("epäkelpo ruutu!");
            }
        }
        return lauta;
    }*/
}
