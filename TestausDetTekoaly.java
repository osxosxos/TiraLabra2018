
package tiralabrapeli;

public class TestausDetTekoaly {
    Funktiot funktiot = new Funktiot();
    DetermistinenTekoaly aly = new DetermistinenTekoaly();
    
    public void testaaSijoitaPelto() {
        int[] pelaajat = new int[]{3,4,5};
        
        int[][] peli1 = new int[][]{
            {1,2,2,3,0,1,1},
            {1,2,3,2,0,0,0},
            {0,2,2,2,1,0,2},
            {0,1,2,0,0,2,4},
            {1,0,0,0,2,4,2},
            {1,0,0,2,5,2,5},
            {0,1,2,4,2,4,2},            
        };
        
        System.out.println("TESTI 1:");
        funktiot.tulostaKartta(peli1);
        System.out.println("pelaajan numero on: 3");
        System.out.println("");
        System.out.println("sijoitusmatriisi on:");
        funktiot.tulostaKartta(aly.pellonSijoitusMartiisi(pelaajat, peli1, 3));
        System.out.println("");
        funktiot.tulostaKartta(aly.pelaaPelto(peli1, 3, pelaajat));
        System.out.println("");
        
        int[][] peli2 = new int[][]{
            {5,2,2,3,0,1,1,0,0},
            {2,2,3,4,1,0,1,1,0},
            {2,3,2,2,0,1,0,0,0},
            {4,2,2,3,0,0,0,0,0},
            {0,0,0,0,0,2,2,5,2},
            {1,1,1,1,0,2,5,2,5},
            {1,0,0,1,0,2,2,5,2},
            {0,1,1,1,0,2,5,2,2},
            {1,1,1,1,0,5,2,2,5}          
        };
        
        System.out.println("TESTI 2:");
        funktiot.tulostaKartta(peli2);
        System.out.println("pelaajan numero on: 3");
        System.out.println("");
        System.out.println("sijoitusmatriisi on:");
        funktiot.tulostaKartta(aly.pellonSijoitusMartiisi(pelaajat, peli2, 3));
        System.out.println("");
        funktiot.tulostaKartta(aly.pelaaPelto(peli2, 3, pelaajat));
        System.out.println("");
                
        int[][] peli3 = new int[][]{
            {3,2,2,3,0,4,2,2,4},
            {2,2,3,4,1,2,4,2,2},
            {2,2,2,2,0,1,0,1,0},
            {0,1,0,1,0,0,0,0,0},
            {0,0,0,0,0,2,2,5,2},
            {1,4,2,2,0,2,5,2,5},
            {1,2,2,3,0,2,2,5,2},
            {0,4,2,2,0,1,1,0,0},
            {1,1,1,1,0,1,0,0,0}          
        };
        
        System.out.println("TESTI 3:");
        funktiot.tulostaKartta(peli3);
        System.out.println("pelaajan numero on: 3");
        System.out.println("");
        System.out.println("sijoitusmatriisi on:");
        funktiot.tulostaKartta(aly.pellonSijoitusMartiisi(pelaajat, peli3, 3));
        System.out.println("");
        funktiot.tulostaKartta(aly.pelaaPelto(peli3, 3, pelaajat));
        System.out.println("");
        
        int[][] peli4 = new int[][]{
            {1,3,0,0,0,2,1},
            {3,2,2,0,4,2,4},
            {0,2,1,0,1,4,1},
            {0,1,1,2,2,1,1},
            {1,0,3,2,4,2,1},
            {1,0,2,2,2,5,0},
            {0,1,1,3,2,0,0},            
        };
        
        System.out.println("TESTI 4:");
        funktiot.tulostaKartta(peli4);
        System.out.println("pelaajan numero on: 3");
        System.out.println("");
        System.out.println("sijoitusmatriisi on:");
        funktiot.tulostaKartta(aly.pellonSijoitusMartiisi(pelaajat, peli4, 3));
        System.out.println("");
        funktiot.tulostaKartta(aly.pelaaPelto(peli4, 3, pelaajat));
        System.out.println("");
                
        int[][] peli5 = new int[][]{
            {1,3,0,0,0,2,1},
            {3,2,2,0,4,2,4},
            {0,2,1,0,1,4,1},
            {0,1,1,0,1,1,1},
            {2,3,1,2,4,2,4},
            {2,2,0,2,2,2,2},
            {3,2,1,4,2,3,2},            
        };        
        
        System.out.println("TESTI 5:");
        funktiot.tulostaKartta(peli5);
        System.out.println("pelaajan numero on: 3");
        System.out.println("");
        System.out.println("sijoitusmatriisi on:");
        funktiot.tulostaKartta(aly.pellonSijoitusMartiisi(pelaajat, peli5, 3));
        System.out.println("");
        funktiot.tulostaKartta(aly.pelaaPelto(peli5, 3, pelaajat));
        System.out.println("");
                
    }
    
    public void testaaSijoitaLinna() {
        int[] pelaajat = new int[]{3,4,5};        
        int[][] peli1 = new int[][]{
            {2,4,2,3,2,0,2},
            {0,2,3,2,0,0,4},
            {0,2,2,0,1,0,2},
            {0,1,2,0,0,2,3},
            {0,0,0,0,2,4,2},
            {0,0,0,1,2,2,5},
            {0,1,0,0,3,2,2},            
        };
                
        System.out.println("TESTI 1:");
        funktiot.tulostaKartta(peli1);
        System.out.println("pelaajan numero on: 3");
        System.out.println("");
        System.out.println("sijoitusmatriisi on:");
        funktiot.tulostaKartta(aly.linnanSijoitusMatriisi(pelaajat, peli1, 3));
        System.out.println("");
        funktiot.tulostaKartta(aly.pelaaLinna(peli1, 3, 10, pelaajat));
        System.out.println("");
        
        int[][] peli2 = new int[][]{
            {2,4,2,0,0,0,0},
            {3,2,2,1,1,0,3},
            {4,2,4,1,0,2,2},
            {1,0,0,0,3,2,3},
            {0,0,0,2,0,2,2},
            {0,0,2,4,2,0,5},
            {0,5,2,2,2,4,2},            
        };
        
        System.out.println("TESTI 2:");
        funktiot.tulostaKartta(peli2);
        System.out.println("pelaajan numero on: 3");
        System.out.println("");
        System.out.println("sijoitusmatriisi on:");
        funktiot.tulostaKartta(aly.linnanSijoitusMatriisi(pelaajat, peli2, 3));
        System.out.println("");
        funktiot.tulostaKartta(aly.pelaaLinna(peli2, 3, 10, pelaajat));
        System.out.println("");
        
        int[][] peli3 = new int[][]{
            {5,2,2,3,0,1,1,0,0},
            {2,0,1,2,1,0,1,1,0},
            {2,1,2,2,0,1,0,0,0},
            {4,2,2,3,0,2,4,2,4},
            {0,0,0,0,0,2,2,5,2},
            {4,2,2,3,0,2,3,2,2},
            {2,3,0,2,0,0,1,1,0},
            {2,2,1,2,0,0,1,0,0},
            {5,2,2,3,0,0,0,0,0}          
        };
        
        System.out.println("TESTI 3:");
        funktiot.tulostaKartta(peli3);
        System.out.println("pelaajan numero on: 3");
        System.out.println("");
        System.out.println("sijoitusmatriisi on:");
        funktiot.tulostaKartta(aly.linnanSijoitusMatriisi(pelaajat, peli3, 3));
        System.out.println("");
        funktiot.tulostaKartta(aly.pelaaLinna(peli3, 3, 10, pelaajat));
        System.out.println("");
        
        int[][] peli4 = new int[][]{
            {4, 2, 2, 2, 2, 2, 2, 0, 1, 1},
            {2, 5, 2, 2, 2, 2, 2, 1, 0, 1},
            {2, 2, 4, 2, 2, 2, 2, 1, 0, 1},
            {2, 2, 2, 3, 2, 2, 2, 1, 1, 0},
            {2, 2, 2, 2, 3, 2, 2, 0, 1, 0},
            {2, 2, 2, 2, 2, 4, 2, 1, 1, 0},
            {2, 2, 2, 2, 2, 2, 4, 0, 1, 0},
            {1, 0, 0, 1, 1, 0, 0, 2, 2, 3},
            {0, 1, 1, 0, 0, 1, 0, 2, 3, 2},
            {0, 1, 0, 1, 0, 0, 1, 3, 2, 3},
        };  
        
        System.out.println("TESTI 4:");
        funktiot.tulostaKartta(peli4);
        System.out.println("pelaajan numero on: 3");
        System.out.println("");
        System.out.println("sijoitusmatriisi on:");
        funktiot.tulostaKartta(aly.linnanSijoitusMatriisi(pelaajat, peli4, 3));
        System.out.println("");
        funktiot.tulostaKartta(aly.pelaaLinna(peli4, 3, 10, pelaajat));
        System.out.println("");
    }
    
    
    
    public void testaaPellonSijoitusMatriisi() {
        int pelaaja = 3;
        int[] pelaajat = new int[]{3,4,5};
        
        int[][] peli1 = new int[][]{
            {1,2,2,3,0,1,1},
            {1,2,3,2,0,0,0},
            {0,2,2,2,1,0,2},
            {0,1,2,0,0,2,4},
            {1,0,0,0,2,4,2},
            {1,0,0,2,5,2,5},
            {0,1,2,4,2,4,2},            
        };
        
        System.out.println("TESTI 1:");
        funktiot.tulostaKartta(peli1);
        System.out.println("pelaajan numero on: 3");
        System.out.println("tulos on:");
        funktiot.tulostaKartta(aly.pellonSijoitusMartiisi(pelaajat, peli1, pelaaja));
        System.out.println("");
        
        int[][] peli2 = new int[][]{
            {5,2,2,3,0,1,1,0,0},
            {2,2,3,4,1,0,1,1,0},
            {2,3,2,2,0,1,0,0,0},
            {4,2,2,3,0,0,0,0,0},
            {0,0,0,0,0,2,2,5,2},
            {1,1,1,1,0,2,5,2,5},
            {1,0,0,1,0,2,2,5,2},
            {0,1,1,1,0,2,5,2,2},
            {1,1,1,1,0,5,2,2,5}          
        };
        
        System.out.println("TESTI 2:");
        funktiot.tulostaKartta(peli2);
        System.out.println("pelaajan numero on: 3");
        System.out.println("tulos on:");
        funktiot.tulostaKartta(aly.pellonSijoitusMartiisi(pelaajat, peli2, pelaaja));
        System.out.println("");
        
        int[][] peli3 = new int[][]{
            {3,2,2,3,0,4,2,2,4},
            {2,2,3,4,1,2,4,2,2},
            {2,2,2,2,0,1,0,1,0},
            {0,1,0,1,0,0,0,0,0},
            {0,0,0,0,0,2,2,5,2},
            {1,4,2,2,0,2,5,2,5},
            {1,2,2,3,0,2,2,5,2},
            {0,4,2,2,0,1,1,0,0},
            {1,1,1,1,0,1,0,0,0}          
        };
        
        System.out.println("TESTI 3:");
        funktiot.tulostaKartta(peli3);
        System.out.println("pelaajan numero on: 3");
        System.out.println("tulos on:");
        funktiot.tulostaKartta(aly.pellonSijoitusMartiisi(pelaajat, peli3, pelaaja));
        System.out.println("");
        
        int[][] peli4 = new int[][]{
            {1,3,0,0,0,2,1},
            {3,2,2,0,4,2,4},
            {0,2,1,0,1,4,1},
            {0,1,1,2,2,1,1},
            {1,0,3,2,4,2,1},
            {1,0,2,2,2,5,0},
            {0,1,1,3,2,0,0},            
        };
        
        System.out.println("TESTI 4:");
        funktiot.tulostaKartta(peli4);
        System.out.println("pelaajan numero on: 3");
        System.out.println("tulos on:");
        funktiot.tulostaKartta(aly.pellonSijoitusMartiisi(pelaajat, peli4, pelaaja));
        System.out.println("");
        
        int[][] peli5 = new int[][]{
            {1,3,0,0,0,2,1},
            {3,2,2,0,4,2,4},
            {0,2,1,0,1,4,1},
            {0,1,1,0,1,1,1},
            {2,3,1,2,4,2,4},
            {2,2,0,2,2,2,2},
            {3,2,1,4,2,3,2},            
        };        
        
        System.out.println("TESTI 5:");
        funktiot.tulostaKartta(peli5);
        System.out.println("pelaajan numero on: 3");
        System.out.println("tulos on:");
        funktiot.tulostaKartta(aly.pellonSijoitusMartiisi(pelaajat, peli5, pelaaja));
        System.out.println("");
               
    }
    
    public void testaaLinnanSijoitusMatriisi() {
        int pelaaja = 3;
        int[] pelaajat = new int[]{3,4,5};
        
        int[][] peli1 = new int[][]{
            {2,4,2,3,2,0,2},
            {0,2,3,2,0,0,4},
            {0,2,2,0,1,0,2},
            {0,1,2,0,0,2,3},
            {0,0,0,0,2,4,2},
            {0,0,0,1,2,2,5},
            {0,1,0,0,3,2,2},            
        };
        
        System.out.println("TESTI 1:");
        funktiot.tulostaKartta(peli1);
        System.out.println("pelaajan numero on 3");
        funktiot.tulostaKartta(aly.linnanSijoitusMatriisi(pelaajat, peli1, pelaaja));
        System.out.println("");
        
        int[][] peli2 = new int[][]{
            {2,4,2,0,0,0,0},
            {3,2,2,1,1,0,3},
            {4,2,4,1,0,2,2},
            {1,0,0,0,3,2,3},
            {0,0,0,2,0,2,2},
            {0,0,2,4,2,0,5},
            {0,5,2,2,2,4,2},            
        };
        
        System.out.println("TESTI 2:");
        funktiot.tulostaKartta(peli2);
        System.out.println("pelaajan numero on 3");
        funktiot.tulostaKartta(aly.linnanSijoitusMatriisi(pelaajat, peli2, pelaaja));
        System.out.println("");
        
        int[][] peli3 = new int[][]{
            {5,2,2,3,0,1,1,0,0},
            {2,0,1,2,1,0,1,1,0},
            {2,1,2,2,0,1,0,0,0},
            {4,2,2,3,0,2,4,2,4},
            {0,0,0,0,0,2,2,5,2},
            {4,2,2,3,0,2,3,2,2},
            {2,3,0,2,0,0,1,1,0},
            {2,2,1,2,0,0,1,0,0},
            {5,2,2,3,0,0,0,0,0}          
        };
        
        System.out.println("TESTI 3:");
        funktiot.tulostaKartta(peli3);
        System.out.println("pelaajan numero on 3");
        funktiot.tulostaKartta(aly.linnanSijoitusMatriisi(pelaajat, peli3, pelaaja));
        System.out.println("");
        
        int[][] peli4 = new int[][]{
            {4, 2, 2, 2, 2, 2, 2, 0, 1, 1},
            {2, 5, 2, 2, 2, 2, 2, 1, 0, 1},
            {2, 2, 4, 2, 2, 2, 2, 1, 0, 1},
            {2, 2, 2, 3, 2, 2, 2, 1, 1, 0},
            {2, 2, 2, 2, 3, 2, 2, 0, 1, 0},
            {2, 2, 2, 2, 2, 4, 2, 1, 1, 0},
            {2, 2, 2, 2, 2, 2, 4, 0, 1, 0},
            {1, 0, 0, 1, 1, 0, 0, 2, 2, 3},
            {0, 1, 1, 0, 0, 1, 0, 2, 3, 2},
            {0, 1, 0, 1, 0, 0, 1, 3, 2, 3},
        };  
        
        System.out.println("TESTI 4:");
        funktiot.tulostaKartta(peli4);
        System.out.println("pelaajan numero on 3");
        funktiot.tulostaKartta(aly.linnanSijoitusMatriisi(pelaajat, peli4, pelaaja));
        System.out.println("");
        
    }
    
    public void testaaSeuraajatKulmittainLinnoissa () {
        System.out.println("Funktion SeuraajatKulmittainLinnoissa testaus ");
        
        System.out.println("TESTI 1:");
        
        int[] pelaajat1 = new int []{3,4,5};
        
        int[][] peli1 = new int[][]{
            {2,4,2,3,2,0,0},
            {0,2,3,2,0,0,0},
            {0,0,2,0,1,0,2},
            {0,1,0,0,0,2,3},
            {0,0,0,0,2,4,2},
            {0,0,0,1,0,2,5},
            {0,1,0,0,0,0,2},            
        };
        
        int[][] vastaus1 = new int[][] {
            {3,4,5},
            {3,2,1}
        };
        
        funktiot.tulostaKartta(peli1);
        System.out.println("lähdetään ruudusta 3:3");
        System.out.println("vastauksen tulisi olla:");        
        funktiot.tulostaPistetaulu(vastaus1);
        System.out.println("metodi palauttaa:");
        funktiot.tulostaPistetaulu(funktiot.seuraajatKulmittainLinnoissa(3, 3, pelaajat1, peli1));
        System.out.println("");
        
        System.out.println("TESTI 2:");
        
        int[] pelaajat2 = new int []{3,4,5};
        
        int[][] peli2 = new int[][]{
            {0,4,2,3,2,5,2},
            {0,0,2,2,2,0,3},
            {0,0,0,5,0,2,2},
            {0,0,0,0,3,2,4},
            {0,0,0,2,0,2,2},
            {0,0,2,2,2,0,5},
            {0,5,2,2,2,4,2},            
        };
        
        int[][] vastaus2 = new int[][] {
            {3,4,5},
            {3,3,4}
        };
        
        funktiot.tulostaKartta(peli2);
        System.out.println("lähdetään ruudusta 1:0");
        System.out.println("vastauksen tulisi olla:");        
        funktiot.tulostaPistetaulu(vastaus2);
        System.out.println("metodi palauttaa:");
        funktiot.tulostaPistetaulu(funktiot.seuraajatKulmittainLinnoissa(1, 0, pelaajat2, peli2));
        System.out.println("");
        
        int[][] peli3 = new int[][]{
            {5,2,2,4,0,0,0,0,0},
            {2,0,0,2,0,0,0,0,0},
            {2,0,0,2,0,0,2,0,0},
            {6,2,2,3,0,2,4,2,0},
            {0,0,0,0,0,0,2,6,2},
            {4,2,2,3,0,2,3,2,0},
            {2,0,0,2,0,0,2,0,0},
            {2,0,0,2,0,0,0,0,0},
            {5,2,2,6,0,0,0,0,0}          
        };
        
        int[] pelaajat3 = new int []{3,4,5,6};
        
        int[][] vastaus3 = new int[][] {
            {3,4,5,6},
            {3,3,2,3}
        };
        
        funktiot.tulostaKartta(peli3);
        System.out.println("lähdetään ruudusta 4:4");
        System.out.println("vastauksen tulisi olla:");        
        funktiot.tulostaPistetaulu(vastaus3);
        System.out.println("metodi palauttaa:");
        funktiot.tulostaPistetaulu(funktiot.seuraajatKulmittainLinnoissa(4,4, pelaajat3, peli3));
        System.out.println("");
        
        int[][] peli4 = new int[][]{
            {5,2,2,4,1,4,2,2,5},
            {2,0,0,2,0,2,0,0,2},
            {2,0,0,2,1,2,0,0,2},
            {6,2,2,3,0,3,2,2,6},
            {1,0,1,0,1,0,1,0,1},
            {4,2,2,3,0,3,2,2,4},
            {2,0,0,2,1,2,0,0,2},
            {2,0,0,2,0,2,0,0,2},
            {5,2,2,6,1,6,2,2,5}          
        };
        
        int[] pelaajat4 = new int []{3,4,5,6};
        
        int[][] vastaus4 = new int[][] {
            {3,4,5,6},
            {4,4,4,4}
        };
        
        funktiot.tulostaKartta(peli4);
        System.out.println("lähdetään ruudusta 4:4");
        System.out.println("vastauksen tulisi olla:");        
        funktiot.tulostaPistetaulu(vastaus4);
        System.out.println("metodi palauttaa:");
        funktiot.tulostaPistetaulu(funktiot.seuraajatKulmittainLinnoissa(4,4, pelaajat4, peli4));
        System.out.println("");
        
    }
    
    public void testaaRuudunViereistenLinnojenSeuraajat() {
        
        System.out.println("TESTI 1:");
        
        int[] pelaajat1 = new int []{3,4,5};
        
        int[][] peli1 = new int[][]{
            {0,4,2,3,2,5,0},
            {0,0,2,2,2,0,3},
            {0,0,0,5,0,2,2},
            {0,0,0,0,3,2,4},
            {0,0,0,0,0,2,2},
            {0,0,0,0,0,0,5},
            {0,0,0,0,0,0,0},            
        };
        
        int[][] vastaus1 = new int[][] {
            {3,4,5},
            {3,2,3}
        };
        
        funktiot.tulostaKartta(peli1);
        System.out.println("lähdetään ruudusta 3:3");
        System.out.println("vastauksen tulisi olla:");        
        funktiot.tulostaPistetaulu(vastaus1);
        System.out.println("metodi palauttaa:");
        funktiot.tulostaPistetaulu(funktiot.ruudunViereistenLinnojenSeuraajat(3, 3, pelaajat1, peli1));
        System.out.println("");
        
        System.out.println("TESTI 2:");
        
        int[] pelaajat2 = new int []{3,4,5};
        
        int[][] peli2 = new int[][]{
            {1,4,2,3,2,5,2},
            {2,1,2,2,2,0,3},
            {4,2,0,5,0,2,2},
            {2,3,2,0,3,2,4},
            {2,2,1,2,0,2,2},
            {5,1,2,2,2,0,5},
            {0,5,2,2,2,4,0},            
        };
        
        int[][] vastaus2 = new int[][] {
            {3,4,5},
            {3,3,4}
        };
        
        funktiot.tulostaKartta(peli2);
        System.out.println("lähdetään ruudusta 3:3");
        System.out.println("vastauksen tulisi olla:");        
        funktiot.tulostaPistetaulu(vastaus2);
        System.out.println("metodi palauttaa:");
        funktiot.tulostaPistetaulu(funktiot.ruudunViereistenLinnojenSeuraajat(3, 3, pelaajat2, peli2));
        System.out.println("");
        
        System.out.println("TESTI 3:");
        
        int[][] peli3 = new int[][]{
            {5,2,2,4,0,0,0,0,0},
            {2,0,0,2,0,0,0,0,0},
            {2,0,0,2,0,0,2,0,0},
            {6,2,2,3,0,2,4,2,0},
            {0,0,0,0,2,5,2,6,2},
            {4,2,2,3,0,2,3,2,0},
            {2,0,0,2,0,0,2,0,0},
            {2,0,0,2,0,0,0,0,0},
            {5,2,2,6,0,0,0,0,0}          
        };
        
        int[] pelaajat3 = new int []{3,4,5,6};
        
        int[][] vastaus3 = new int[][] {
            {3,4,5,6},
            {3,3,3,3}
        };
        
        funktiot.tulostaKartta(peli3);
        System.out.println("lähdetään ruudusta 4:3");
        System.out.println("vastauksen tulisi olla:");        
        funktiot.tulostaPistetaulu(vastaus3);
        System.out.println("metodi palauttaa:");
        funktiot.tulostaPistetaulu(funktiot.ruudunViereistenLinnojenSeuraajat(4, 3, pelaajat3, peli3));
        System.out.println("");
        
        System.out.println("TESTI 4:");
        
        int[][] vastaus4 = new int[][] {
            {3,4,5,6},
            {2,2,2,2}
        };
        
        funktiot.tulostaKartta(peli3);
        System.out.println("lähdetään ruudusta 4:0");
        System.out.println("vastauksen tulisi olla:");        
        funktiot.tulostaPistetaulu(vastaus4);
        System.out.println("metodi palauttaa:");
        funktiot.tulostaPistetaulu(funktiot.ruudunViereistenLinnojenSeuraajat(4, 0, pelaajat3, peli3));
        System.out.println("");
        
    }
            
    public void testaaLinnassaOlevatSeuraajat() {
        
        System.out.println("TESTI 1:");
        
        int[] pelaajat1 = new int []{3,4,5};
                
        int[][] peli1 = new int[][]{
            { 3, 1, 0, 0, 0},
            { 4, 2, 1, 1, 1},
            { 5, 3, 2, 2, 2},
            { 4, 2, 1, 1, 1},
            { 3, 1, 0, 0, 0},
        };
        
        funktiot.tulostaKartta(peli1);
        System.out.println("lähdetään ruudusta 2:4");
        System.out.println("vastauksen tulisi olla:");
        
        int[][] vastaus1 = new int[][] {
            {3,4,5},
            {3,2,1}
        };
        
        funktiot.tulostaPistetaulu(vastaus1);
        System.out.println("metodi palauttaa:");
        funktiot.tulostaPistetaulu(funktiot.linnassaOlevatSeuraajat(2, 4, pelaajat1, peli1));
        System.out.println("");
        
        System.out.println("TESTI 2:");
        
        int[] pelaajat2 = new int []{3,4,5,6};
        
        int[][] peli2 = new int[][]{
            { 0, 1, 1, 1, 2},
            { 2, 2, 2, 2, 6},
            { 5, 3, 3, 3, 3},
            { 2, 2, 2, 2, 6},
            { 0, 1, 1, 1, 2},
        };
        
        funktiot.tulostaKartta(peli2);
        System.out.println("lähdetään ruudusta 2:0");
        System.out.println("vastauksen tulisi olla:");
        
        int[][] vastaus2 = new int[][] {
            {3,4,5,6},
            {4,0,1,2}
        };
        
        funktiot.tulostaPistetaulu(vastaus2);
        System.out.println("metodi palauttaa:");
        funktiot.tulostaPistetaulu(funktiot.linnassaOlevatSeuraajat(2, 0, pelaajat2, peli2));
        System.out.println("");
        
        System.out.println("TESTI 3:");
        
        int[] pelaajat3 = new int []{3,4,5,6,7,8};
        
        int[][] peli3 = new int[][]{
            {2, 8, 2, 7, 2, 6, 2, 5, 2, 2},
            {8, 2, 7, 2, 6, 2, 5, 2, 4, 0},
            {2, 7, 2, 6, 2, 5, 2, 4, 0, 0},
            {7, 2, 6, 2, 5, 2, 4, 0, 0, 0},
            {2, 6, 2, 5, 2, 4, 0, 0, 0, 0},
            {6, 2, 5, 2, 4, 0, 0, 0, 0, 0},
            {2, 5, 2, 4, 0, 0, 0, 0, 0, 1},
            {5, 2, 4, 0, 0, 0, 0, 0, 1, 3},
            {2, 4, 0, 0, 0, 0, 0, 1, 3, 2},
            {2, 0, 0, 0, 0, 0, 1, 3, 2, 3},
        };  
        
        funktiot.tulostaKartta(peli3);
        System.out.println("lähdetään ruudusta 0:0");
        System.out.println("vastauksen tulisi olla:");
        
        int[][] vastaus3 = new int[][] {
            {3,4,5,6,7,8},
            {0,8,8,6,4,2}
        };
        
        funktiot.tulostaPistetaulu(vastaus3);
        System.out.println("metodi palauttaa:");
        funktiot.tulostaPistetaulu(funktiot.linnassaOlevatSeuraajat(0, 0, pelaajat3, peli3));
        System.out.println("");
                
        System.out.println("TESTI 4:");
        
        int[]pelaajat4 = new int[]{3,4,5,6,7};
        
        int[][] peli4 = new int[][]{
            {4, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 5, 2, 2, 2, 2, 2, 0, 0, 2},
            {2, 2, 6, 2, 2, 2, 2, 0, 0, 2},
            {2, 2, 2, 7, 2, 2, 2, 0, 0, 2},
            {2, 2, 2, 2, 6, 2, 2, 0, 0, 2},
            {2, 2, 2, 2, 2, 5, 2, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 4, 0, 0, 2},
            {0, 0, 0, 0, 0, 0, 0, 2, 2, 3},
            {0, 0, 0, 0, 0, 0, 0, 2, 3, 2},
            {2, 2, 2, 2, 2, 2, 2, 3, 2, 3},
        };  
          
        funktiot.tulostaKartta(peli4);
        System.out.println("lähdetään ruudusta 9:9");
        System.out.println("vastauksen tulisi olla:");
        
        int[][] vastaus4 = new int[][] {
            {3,4,5,6,7},
            {4,2,2,2,1}
        };
        
        funktiot.tulostaPistetaulu(vastaus4);
        System.out.println("metodi palauttaa:");
        funktiot.tulostaPistetaulu(funktiot.linnassaOlevatSeuraajat(9, 9, pelaajat4, peli4));
        System.out.println("");        
                
    }
    
    public void testaaViereistenLinnojenPisteet() {
        
        System.out.println("Testataan funktiota: viereistenLinnojenPisteet");
        
        int[][] peli1 = new int[][]{
            {0,4,2,3,2,5,2},
            {0,0,2,2,2,2,3},
            {0,0,0,5,2,2,2},
            {0,0,0,0,3,2,4},
            {0,0,0,0,0,2,2},
            {0,0,0,0,0,0,5},
            {0,0,0,0,0,0,0},            
        };
        
        System.out.println("TESTI 1");
        funktiot.tulostaKartta(peli1);
        System.out.println("lähdetään ruudusta 0:0");
        System.out.println("tuloksen tulisi olla: 21");
        System.out.println("funktio palauttaa: " + funktiot.viereistenLinnojenPisteet(0, 0, peli1));
        
        int[][] peli2 = new int[][]{
            {0,0,2,2,2,0,0},
            {0,1,2,5,2,0,0},
            {0,0,3,2,2,1,0},
            {2,2,2,0,3,2,4},
            {2,2,2,1,2,2,2},
            {2,2,2,0,2,2,5},
            {0,1,0,0,1,0,0},            
        };
        
        System.out.println("TESTI 2");
        funktiot.tulostaKartta(peli2);
        System.out.println("lähdetään ruudusta 3:3");
        System.out.println("tuloksen tulisi olla: 27");
        System.out.println("funktio palauttaa: " + funktiot.viereistenLinnojenPisteet(3, 3, peli2));
        
                
        int[][] peli3 = new int[][]{
            {0,0,2,2,2,0,0},
            {0,1,2,5,2,0,0},
            {2,2,3,2,2,2,2},
            {2,2,2,0,3,2,4},
            {2,2,2,2,2,2,2},
            {0,0,2,2,2,0,0},
            {0,1,2,2,2,0,0},            
        };
        
        System.out.println("TESTI 3");
        funktiot.tulostaKartta(peli2);
        System.out.println("lähdetään ruudusta 3:3");
        System.out.println("tuloksen tulisi olla: 27");
        System.out.println("funktio palauttaa: " + funktiot.viereistenLinnojenPisteet(3, 3, peli2));
    }
    
    public void testaaKulmittaistenLinnojenPisteet() {
        
        System.out.println("Testataan funktiota: kulmittaistenLinnojenPisteet");
        
        int[][] peli1 = new int[][]{
            {0,4,2,3,2,5,2},
            {0,0,2,2,2,2,3},
            {0,0,0,5,2,2,2},
            {2,0,0,0,3,2,4},
            {2,4,0,0,0,2,2},
            {2,2,2,0,0,0,5},
            {3,2,4,2,0,0,0},            
        };
        
        System.out.println("TESTI 1");
        funktiot.tulostaKartta(peli1);
        System.out.println("lähdetään ruudusta 3:2");
        System.out.println("tuloksen tulisi olla: 31");
        System.out.println("funktio palauttaa: " + funktiot.kulmittaistenLinnojenPisteet(3, 2, peli1));
        
        int[][] peli2 = new int[][]{
            {1,4,2,3,2,5,2},
            {2,1,2,2,2,2,3},
            {2,3,0,5,2,2,2},
            {2,2,2,0,3,2,4},
            {2,4,2,5,0,2,2},
            {2,2,2,2,3,1,5},
            {3,2,4,2,2,3,1},            
        };
        
        System.out.println("TESTI 2");
        funktiot.tulostaKartta(peli2);
        System.out.println("lähdetään ruudusta 3:3");
        System.out.println("tuloksen tulisi olla: 42");
        System.out.println("funktio palauttaa: " + funktiot.kulmittaistenLinnojenPisteet(3, 3, peli2));
        
        int[][] peli3 = new int[][]{
            {1,4,2,3,2,5,2},
            {2,1,2,2,2,0,3},
            {4,2,0,5,0,2,2},
            {2,3,2,0,3,2,4},
            {2,2,1,2,0,2,2},
            {5,1,2,2,2,0,5},
            {0,5,2,2,2,4,0},            
        };
        
        System.out.println("TESTI 3");
        funktiot.tulostaKartta(peli3);
        System.out.println("lähdetään ruudusta 3:3");
        System.out.println("tuloksen tulisi olla: 0");
        System.out.println("funktio palauttaa: " + funktiot.kulmittaistenLinnojenPisteet(3, 3, peli3));
        
    
        int[][] peli4 = new int[][]{
            {0,4,2,3,2,2,0},
            {0,0,3,2,2,0,0},
            {0,0,0,2,1,0,2},
            {0,1,0,0,0,0,0},
            {0,0,2,0,2,4,2},
            {0,2,4,1,0,2,5},
            {2,3,2,0,0,0,2},            
        };
        
        System.out.println("TESTI 4");
        funktiot.tulostaKartta(peli4);
        System.out.println("lähdetään ruudusta 3:3");
        System.out.println("tuloksen tulisi olla: 12");
        System.out.println("funktio palauttaa: " + funktiot.kulmittaistenLinnojenPisteet(3, 3, peli4));
        
    }
}
