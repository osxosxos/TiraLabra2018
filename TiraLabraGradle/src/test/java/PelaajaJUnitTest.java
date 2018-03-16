
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testaus pelaaja -luokalle, joka pitää yllä yksittäiseen pelaajiin liittyviä
 * tietoja.
 *
 * @author Oskari Koskinen
 */
public class PelaajaJUnitTest {   
    
    public PelaajaJUnitTest() {
    
    }
    
    @Test 
    public void testiPelaaja() {
        
        Pelaaja pelaaja = new Pelaaja(3,true,false,false);
        
        boolean onIhminenOdotus = true;
        boolean onIhminen = pelaaja.isIhminen();
        
        assertEquals(onIhminenOdotus, onIhminen);
        
        boolean onDetOdotus = false;
        boolean onDet = pelaaja.isDetTekoAly();
        
        assertEquals(onDetOdotus, onDet);
        
        boolean onPuuOdotus = false;
        boolean onPuu = pelaaja.isPeliPuuTekoAly();
        
        assertEquals(onPuuOdotus, onPuu);
        
        int pisteetOdotus = 0;
        int pisteet = pelaaja.getPisteet();
        
        assertEquals(pisteetOdotus, pisteet);
        
        int seuraajatOdotus = 10;
        int seuraajat = pelaaja.getSeuraajat();
        
        assertEquals(seuraajatOdotus, seuraajat);
        
        int numeroOdotus = 3;
        int numero = pelaaja.getNumero();
        
        assertEquals(numeroOdotus, numero);
        
        pelaaja.asetaSeuraajienMaara(5);
        int seuraajatOdotus2 = 5;
        int seuraajat2 = pelaaja.getSeuraajat();
                
        assertEquals(seuraajatOdotus2, seuraajat2);    
        
        pelaaja.lisaaSeuraajia(8);
        int seuraajatOdotus3 = 13;
        int seuraajat3 = pelaaja.getSeuraajat();
                
        assertEquals(seuraajatOdotus3, seuraajat3);
        
        pelaaja.lisaaPisteita(67876);
        int pisteetOdotus2 = 67876;
        int pisteet2 = pelaaja.getPisteet();
        
        assertEquals(pisteetOdotus2, pisteet2);
        
    }
    
}
