
package tiralabrapeli;

public class Testaus {
    Funktiot funktiot;
    
    public Testaus() {
        this.funktiot = new Funktiot();
    }
    
    public void testaaLaskePisteet() {
        int[][] peli1 = new int[][]{
            { 2, 2, 0, 2, 2},
            { 2, 0, 1, 0, 2},
            { 0, 1, 2, 1, 0},
            { 2, 0, 1, 0, 2},
            { 2, 2, 0, 2, 2},
        };
        
        boolean[][] pisteytys1 = new boolean[][]{
            { false, false, false, false, false},
            { false, false, false, false, false},
            { false, false, true , false, false},
            { false, false, false, false, false},
            { false, false, false, false, false}
        };
        
        System.out.println("TESTI 1:");
        System.out.println("testataan lautaa:");
        funktiot.tulostaKartta(peli1);
        System.out.println("josta on jo pisteytetty:");
        funktiot.tulostaBoolean(pisteytys1);
        System.out.println("funktion pitäisi palauttaa: 12");
        System.out.println("funktio palauttaa: " + funktiot.laskePisteet(peli1, pisteytys1));
        System.out.println("");
        
        int[][] peli2 = new int[][]{
            { 3, 2, 2, 2, 2},
            { 2, 0, 0, 0, 1},
            { 2, 0, 0, 1, 2},
            { 2, 0, 0, 0, 1},
            { 3, 2, 2, 2, 2},
        };
        
        boolean[][] pisteytys2 = new boolean[][]{
            { false, false, false, false, false},
            { false, false, false, false, false},
            { false, false, false ,false, true },
            { false, false, false, false, false},
            { false, false, false, false, false}
        };
        
        System.out.println("TESTI 2:");
        System.out.println("testataan lautaa:");
        funktiot.tulostaKartta(peli2);
        System.out.println("josta on jo pisteytetty:");
        funktiot.tulostaBoolean(pisteytys2);
        System.out.println("funktion pitäisi palauttaa: 13");
        System.out.println("funktio palauttaa: " + funktiot.laskePisteet(peli2, pisteytys2));
        System.out.println("");
        
        int[][] peli3 = new int[][]{
            { 1, 1, 1, 2, 3},
            { 1, 2, 2, 2, 1},
            { 2, 2, 2, 2, 1},
            { 2, 2, 2, 2, 1},
            { 2, 1, 1, 1, 1},
        };          
        
        boolean[][] pisteytys3 = new boolean[][]{
            { false, false, false, true , true },
            { false, true , true , true , false},
            { true , true , true , true , false},
            { true , true , true , true, false},
            { true , false, false, false, false}
        };       
        
                
        System.out.println("TESTI 3:");
        System.out.println("testataan lautaa:");
        funktiot.tulostaKartta(peli3);
        System.out.println("josta on jo pisteytetty:");
        funktiot.tulostaBoolean(pisteytys3);
        System.out.println("funktion pitäisi palauttaa: 0");
        System.out.println("funktio palauttaa: " + funktiot.laskePisteet(peli3, pisteytys3));
        System.out.println("");
        
        int[][] peli4 = new int[][]{
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 0, 2, 2, 2, 2, 2, 2, 2, 0},
            {2, 0, 2, 0, 2, 0, 2, 0, 0, 3}
        };  
        
        boolean[][]pisteytys4 = new boolean[peli4.length][peli4.length];
        
        System.out.println("TESTI 4:");
        System.out.println("testataan lautaa:");
        funktiot.tulostaKartta(peli4);
        System.out.println("josta on jo pisteytetty:");
        funktiot.tulostaBoolean(pisteytys4);
        System.out.println("funktion pitäisi palauttaa: 57");
        System.out.println("funktio palauttaa: " + funktiot.laskePisteet(peli4, pisteytys4));
        System.out.println("");
        
    }
            
    public void testaaMerkitseLinnaPisteytetyksi() {
        
        int[][] peli1 = new int[][]{
            { 3, 2, 1, 0, 0},
            { 2, 1, 2, 1, 0},
            { 1, 2, 2, 2, 1},
            { 0, 1, 2, 1, 0},
            { 0, 0, 1, 0, 0},
        };
        
        boolean[][] peli1Pisteytetyt = new boolean[peli1.length][peli1.length];
        
        boolean[][] odotus1 = new boolean[][]{
            { false, false, false, false, false},
            { false, false, true , false, false},
            { false, true , true , true , false},
            { false, false, true , false, false},
            { false, false, false, false, false}
        };
        
        System.out.println("TESTI 1:");
        System.out.println("lähdetään ruudusta 2:2");
        System.out.println("pisteytetyt ruudut ovat ennen funktion kutsua:");
        funktiot.tulostaBoolean(peli1Pisteytetyt);
        System.out.println("funktion kutsun jälkeen niiden pitäisi olla:");
        funktiot.tulostaBoolean(odotus1);
        System.out.println("funktio palauttaa:");
        funktiot.tulostaBoolean(funktiot.merkitseLinnaPisteytetyksi(2, 2, peli1, peli1Pisteytetyt));
        System.out.println("");
        
        int[][] peli2 = new int[][]{
            { 1, 1, 1, 2, 3},
            { 1, 2, 2, 2, 1},
            { 2, 2, 2, 2, 1},
            { 2, 2, 2, 0, 1},
            { 2, 1, 1, 1, 1},
        };  
        
        boolean[][] peli2Pisteytetyt = new boolean[peli1.length][peli1.length];
        
        boolean[][] odotus2 = new boolean[][]{
            { false, false, false, true , true },
            { false, true , true , true , false},
            { true , true , true , true , false},
            { true , true , true , false, false},
            { true , false, false, false, false}
        };
        
        System.out.println("TESTI 2:");
        System.out.println("lähdetään ruudusta 4:0");
        System.out.println("pisteytetyt ruudut ovat ennen funktion kutsua:");
        funktiot.tulostaBoolean(peli2Pisteytetyt);
        System.out.println("funktion kutsun jälkeen niiden pitäisi olla:");
        funktiot.tulostaBoolean(odotus2);
        System.out.println("funktio palauttaa:");
        funktiot.tulostaBoolean(funktiot.merkitseLinnaPisteytetyksi(4, 0, peli2, peli2Pisteytetyt));
        System.out.println("");
        
        
        int[][] peli3 = new int[][]{
            { 2, 2, 2, 2, 2},
            { 2, 1, 1, 1, 2},
            { 2, 1, 2, 0, 2},
            { 2, 1, 2, 1, 2},
            { 2, 2, 2, 1, 3},
        };
        
        boolean[][] peli3Pisteytetyt = new boolean[peli1.length][peli1.length];
        
        boolean[][] odotus3 = new boolean[][]{
            { true , true , true , true , true},
            { true , false, false, false, true},
            { true , false, true , false, true},
            { true , false, true , false, true},
            { true , true , true , false, true}
        };
        
        System.out.println("TESTI 3:");
        System.out.println("lähdetään ruudusta 2:2");
        System.out.println("pisteytetyt ruudut ovat ennen funktion kutsua:");
        funktiot.tulostaBoolean(peli3Pisteytetyt);
        System.out.println("funktion kutsun jälkeen niiden pitäisi olla:");
        funktiot.tulostaBoolean(odotus3);
        System.out.println("funktio palauttaa:");
        funktiot.tulostaBoolean(funktiot.merkitseLinnaPisteytetyksi(2, 2, peli3, peli3Pisteytetyt));
        System.out.println("");            
        
    }
    
    public void testaaLinnanPisteet() {
        
        int[][] peli1 = new int[][]{
            { 3, 2, 1, 0, 0},
            { 2, 1, 2, 1, 0},
            { 1, 2, 2, 2, 1},
            { 0, 1, 2, 1, 0},
            { 0, 0, 1, 0, 0},
        };
        
        System.out.println("TESTI 1:");
        funktiot.tulostaKartta(peli1);
        System.out.println("testataan keskellä oleva linna, lähdetään ruudusta: [2:2]");
        System.out.println("funktion tulisi palauttaa: 5");
        System.out.println("funktio palauttaa: " + funktiot.linnanPisteet(2, 2, peli1));
        System.out.println("");
        
        
        int[][] peli2 = new int[][]{
            { 1, 1, 1, 2, 3},
            { 1, 2, 2, 2, 1},
            { 2, 2, 2, 2, 1},
            { 2, 2, 2, 0, 1},
            { 2, 1, 1, 1, 1},
        };  
                
        System.out.println("TESTI 2:");
        funktiot.tulostaKartta(peli2);
        System.out.println("testataan keskellä oleva linna, lähdetään ruudusta: [4:0]");
        System.out.println("funktion tulisi palauttaa: 13");
        System.out.println("funktio palauttaa: " + funktiot.linnanPisteet(4, 0, peli2));
        System.out.println("");
        
        
        int[][] peli3 = new int[][]{
            { 2, 2, 2, 2, 2},
            { 2, 1, 1, 1, 2},
            { 2, 1, 2, 0, 2},
            { 2, 1, 2, 1, 2},
            { 2, 2, 2, 1, 3},
        };
        
        System.out.println("TESTI 3:");
        funktiot.tulostaKartta(peli3);
        System.out.println("testataan keskellä oleva linna, lähdetään ruudusta: [2:2]");
        System.out.println("funktion tulisi palauttaa: 17");
        System.out.println("funktio palauttaa: " + funktiot.linnanPisteet(2, 2, peli3));
        System.out.println("");
        
        int[][] peli4 = new int[][]{
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 0, 2, 2, 2, 2, 2, 2, 2, 0},
            {2, 0, 2, 0, 2, 0, 2, 0, 0, 3}
        };     
        
        System.out.println("TESTI 4:");
        funktiot.tulostaKartta(peli4);
        System.out.println("testataan keskellä oleva linna, lähdetään ruudusta: [0:0]");
        System.out.println("funktion tulisi palauttaa: 46");
        System.out.println("funktio palauttaa: " + funktiot.linnanPisteet(0, 0, peli4));
        System.out.println("");
        
        int[][] peli5 = new int[][]{
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 0, 2, 2, 2, 0, 2, 2, 2, 0},
            {2, 2, 2, 0, 2, 2, 2, 0, 2, 3}
        };
        
        System.out.println("TESTI 5:");
        funktiot.tulostaKartta(peli5);
        System.out.println("testataan keskellä oleva linna, lähdetään ruudusta: [0:0]");
        System.out.println("funktion tulisi palauttaa: 59");
        System.out.println("funktio palauttaa: " + funktiot.linnanPisteet(0, 0, peli5));
        System.out.println("");
        
    }
    
    public void testaaOnkoLinnassaJoSeuraaja () {
        int[][] peli1 = new int[][]{
            { 3, 2, 1, 0, 0},
            { 2, 1, 2, 1, 0},
            { 1, 2, 2, 2, 1},
            { 0, 1, 2, 1, 0},
            { 0, 0, 1, 0, 0},
        };
        
        System.out.println("TESTI 1:");
        funktiot.tulostaKartta(peli1);
        System.out.println("keskimmäisessä linnassa ei ole seuraajaa");
        System.out.println("yläreunassa olevassa linnassa on");
        System.out.println("testataan yläreunan linna, lähdetään ruudusta: [1:0]");
        System.out.println("funktion tulisi palauttaa true");
        System.out.println("funktio palauttaa: " + funktiot.onkoLinnassaJoSeuraaja(1, 0, peli1));
        System.out.println("");
        System.out.println("testataan keskellä oleva linna, lähdetään ruudusta: [2:2]");
        System.out.println("funktion tulisi palauttaa false");
        System.out.println("funktio palauttaa: " + funktiot.onkoLinnassaJoSeuraaja(2, 2, peli1));
        System.out.println("");
                       
        int[][] peli2 = new int[][]{
            { 1, 1, 1, 2, 3},
            { 1, 2, 2, 2, 1},
            { 2, 2, 2, 2, 1},
            { 2, 2, 2, 0, 1},
            { 2, 1, 1, 1, 1},
        };        
        
        System.out.println("TESTI 2:");
        funktiot.tulostaKartta(peli2);
        System.out.println("testataan linna, lähdetään ruudusta: [4:0]");
        System.out.println("funktion tulisi palauttaa true");
        System.out.println("funktio palauttaa: " + funktiot.onkoLinnassaJoSeuraaja(4, 0, peli2));
        System.out.println("");
                                
        int[][] peli3 = new int[][]{
            { 2, 2, 2, 2, 2},
            { 2, 1, 1, 1, 2},
            { 2, 1, 2, 0, 2},
            { 2, 1, 2, 1, 2},
            { 2, 2, 2, 1, 3},
        };
        
        System.out.println("TESTI 3:");
        funktiot.tulostaKartta(peli3);
        System.out.println("testataan linna, lähdetään ruudusta: [2:2]");
        System.out.println("funktion tulisi palauttaa true");
        System.out.println("funktio palauttaa: " + funktiot.onkoLinnassaJoSeuraaja(2, 2, peli3));
        System.out.println("");
                
        int[][] peli4 = new int[][]{
            { 3, 1, 2, 1, 1},
            { 0, 2, 2, 2, 1},
            { 2, 2, 2, 2, 1},
            { 1, 2, 2, 2, 1},
            { 0, 1, 2, 1, 0},
        };   
        
        System.out.println("TESTI 4:");
        funktiot.tulostaKartta(peli4);
        System.out.println("testataan linna, lähdetään ruudusta: [2:2]");
        System.out.println("funktion tulisi palauttaa false");
        System.out.println("funktio palauttaa: " + funktiot.onkoLinnassaJoSeuraaja(2, 2, peli4));
        System.out.println("");
                
        int[][] peli5 = new int[][]{
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 0, 2, 2, 2, 2, 2, 2, 2, 0},
            {2, 0, 2, 0, 2, 0, 2, 0, 0, 3}
        };     
        
        System.out.println("TESTI 5:");
        funktiot.tulostaKartta(peli5);
        System.out.println("testataan linna, lähdetään ruudusta: [0:0]");
        System.out.println("funktion tulisi palauttaa false");
        System.out.println("funktio palauttaa: " + funktiot.onkoLinnassaJoSeuraaja(0, 0, peli5));
        System.out.println("");
        
        int[][] peli6 = new int[][]{
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 0, 2, 2, 2, 0, 2, 2, 2, 0},
            {2, 2, 2, 0, 2, 2, 2, 0, 2, 3}
        };
        
        System.out.println("TESTI 6:");
        funktiot.tulostaKartta(peli6);
        System.out.println("testataan linna, lähdetään ruudusta: [0:0]");
        System.out.println("funktion tulisi palauttaa true");
        System.out.println("funktio palauttaa: " + funktiot.onkoLinnassaJoSeuraaja(0, 0, peli6));
        System.out.println("");        
    }
    
    public void testaaOnValmis() {
        int[][] peli1 = new int[][]{
            { 0, 0, 1, 0, 0},
            { 0, 1, 2, 1, 0},
            { 1, 2, 2, 2, 1},
            { 0, 1, 2, 1, 0},
            { 0, 0, 1, 0, 0},
        };
        
        System.out.println("TESTI 1:");
        funktiot.tulostaKartta(peli1);
        System.out.println("lähdetään ruudusta rivi:2, sarake:2");
        System.out.println("tuloksen pitäisi olla true");
        System.out.println("metodi palauttaa: " + funktiot.onValmis(2,2, peli1));
        System.out.println("");
        
        int[][] peli2 = new int[][]{
            { 0, 1, 1, 1, 0},
            { 1, 2, 2, 2, 1},
            { 1, 2, 2, 2, 1},
            { 1, 2, 2, 2, 1},
            { 0, 1, 1, 1, 0},
        };
        
        System.out.println("TESTI 2:");
        funktiot.tulostaKartta(peli2);
        System.out.println("lähdetään ruudusta rivi:2, sarake:2");
        System.out.println("tuloksen pitäisi olla true");
        System.out.println("metodi palauttaa: " + funktiot.onValmis(2,2, peli2));
        System.out.println("");
                                
        int[][] peli3 = new int[][]{
            { 0, 0, 0, 0, 0},
            { 0, 1, 1, 1, 0},
            { 0, 1, 2, 1, 0},
            { 0, 1, 0, 1, 0},
            { 0, 0, 0, 0, 0},
        };
        
        System.out.println("TESTI 3:");
        funktiot.tulostaKartta(peli3);
        System.out.println("lähdetään ruudusta rivi:2, sarake:2");
        System.out.println("tuloksen pitäisi olla false");
        System.out.println("metodi palauttaa: " + funktiot.onValmis(2,2, peli3));
        System.out.println("");
        
        int[][] peli4 = new int[][]{
            { 0, 0, 0, 0, 0},
            { 0, 2, 2, 2, 0},
            { 0, 2, 3, 2, 0},
            { 0, 2, 2, 2, 0},
            { 0, 0, 0, 0, 0},
        };   
        
        System.out.println("TESTI 4:");
        funktiot.tulostaKartta(peli4);
        System.out.println("lähdetään ruudusta rivi:2, sarake:2");
        System.out.println("tuloksen pitäisi olla false");
        System.out.println("metodi palauttaa: " + funktiot.onValmis(2,2, peli4));
        System.out.println("");
        
        int[][] peli5 = new int[][]{
            { 0, 1, 1, 0, 0},
            { 1, 2, 2, 2, 0},
            { 1, 2, 3, 2, 0},
            { 0, 2, 2, 2, 0},
            { 0, 0, 0, 0, 0},
        }; 
        
        System.out.println("TESTI 5:");
        funktiot.tulostaKartta(peli5);
        System.out.println("lähdetään ruudusta rivi:2, sarake:2");
        System.out.println("tuloksen pitäisi olla false");
        System.out.println("metodi palauttaa: " + funktiot.onValmis(2,2, peli5));
        System.out.println("");
        
        int[][] peli6 = new int[][]{
            { 0, 0, 0, 0, 0},
            { 0, 1, 1, 1, 0},
            { 1, 2, 3, 2, 1},
            { 0, 1, 0, 1, 0},
            { 0, 0, 0, 0, 0},
        };       
        
        System.out.println("TESTI 6:");
        funktiot.tulostaKartta(peli6);
        System.out.println("lähdetään ruudusta rivi:2, sarake:2");
        System.out.println("tuloksen pitäisi olla false");
        System.out.println("metodi palauttaa: " + funktiot.onValmis(2,2, peli6));
        System.out.println("");                
    }
    
}
