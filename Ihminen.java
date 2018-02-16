package tiralabrapeli;

import java.util.Scanner;

// Tämä luokka kuvaa pelaajaa, joka antaa syötteen pelille luonnollisella 
// älyllä tai sen puutteella, eli ihmisen aivoilla. 
class Ihminen {
    private Funktiot funktiot;

    public Ihminen() {
        this.funktiot = new Funktiot();
    }

    public int[][] pelaaPelto(int[][] lauta) {
        System.out.println("laatta on pelto");
        Scanner scanner = new Scanner(System.in);
        // Kysytään käyttäjältä mihin hän haluaa pelata pellon.
        // Jatketaan, kunnes käyttäjä on syöttänyt kelvollisen ruudun. 
        while (true) {
            System.out.println("anna rivi:");
            int rivi = Integer.parseInt(scanner.nextLine());
            System.out.println("anna sarake:");
            int sarake = Integer.parseInt(scanner.nextLine());
            if (funktiot.voikoMenna(rivi, sarake, lauta.length)) {
                if (funktiot.onkoVapaa(rivi, sarake, lauta)) {
                    lauta = funktiot.asetaLaatta(rivi, sarake, 1, lauta);
                    break;
                }
            } else {
                System.out.println("ruutu ei ole kelvollinen, yritä uudestaan!");
            }
        }
        return lauta;
    }

    int[][] pelaaLinna(int pNumero, int pSeuraajat, int[][] lauta) {
        System.out.println("laatta on linna");
        Scanner scanner = new Scanner(System.in);
        int rivi = 0;
        int sarake = 0;
        // Kysytään käyttäjältä mihin hän haluaa pelata pellon.
        // Jatketaan, kunnes käyttäjä on syöttänyt kelvollisen ruudun. 
        while (true) {
            System.out.println("anna rivi:");
            rivi = Integer.parseInt(scanner.nextLine());
            System.out.println("anna sarake:");
            sarake = Integer.parseInt(scanner.nextLine());
            if (funktiot.voikoMenna(rivi, sarake, lauta.length)) {
                if (funktiot.onkoVapaa(rivi, sarake, lauta)) {
                    lauta = funktiot.asetaLaatta(rivi, sarake, 2, lauta);
                    break;
                }
            } else {
                System.out.println("ruutu ei ole kelvollinen, yritä uudestaan!");
            }
        }
        // Kysytään pelaajalta haluaako hän asettaa seuraajan. 
        if (pSeuraajat > 0 && !funktiot.onkoLinnassaJoSeuraaja(rivi, sarake, lauta)) {
            System.out.println("haluatko asettaa seuraajan?");
            System.out.println("0 = ei, 1 = kyllä");
            int vastaus = Integer.parseInt(scanner.nextLine());
            if (vastaus == 1) {
                lauta = funktiot.asetaLaatta(rivi, sarake, pNumero, lauta);
            }
        }      
        return lauta;
    }

}
