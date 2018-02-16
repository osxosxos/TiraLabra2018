
package tiralabrapeli;

public class Pelaaja {
    int numero;
    int seuraajat;
    int pisteet;
    boolean ihminen;
    boolean detTekoAly;
     
    public Pelaaja(boolean ihm, boolean det, int numero) {
        this.numero = numero;
        this.seuraajat = 10;
        this.pisteet = 0;
        this.ihminen = ihm;
        this.detTekoAly = det;
    }
    
    public void setPisteet(int x) {
        this.pisteet = this.pisteet + x;
    }
    
    public void setSeuraajatArvoon(int x) {
        this.seuraajat = x;
    }
    
    public void setSeuraajat(int x) {
        this.seuraajat = this.seuraajat + x;
    }

    public int getSeuraajat() {
        return seuraajat;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isIhminen() {
        return ihminen;
    }

    public boolean isDetTekoAly() {
        return detTekoAly;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setIhminen(boolean ihminen) {
        this.ihminen = ihminen;
    }

    public void setDetTekoAly(boolean detTekoAly) {
        this.detTekoAly = detTekoAly;
    }
    
    
    
    
    
}
