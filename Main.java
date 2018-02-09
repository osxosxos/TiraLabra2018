
package tiralabrapeli;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("anna laudan koko");
        int koko = Integer.parseInt(scanner.nextLine());
        System.out.println("anna laattojen määrä");
        int laattoja = Integer.parseInt(scanner.nextLine());
        */
        
        TestausDetTekoaly test = new TestausDetTekoaly();
        test.testaaLinnassaOlevatSeuraajat();
        test.testaaRuudunViereistenLinnojenSeuraajat();
        test.testaaSeuraajatKulmittainLinnoissa();
        test.testaaViereistenLinnojenPisteet();
        test.testaaKulmittaistenLinnojenPisteet();     
        test.testaaLinnanSijoitusMatriisi();
    }    
}
