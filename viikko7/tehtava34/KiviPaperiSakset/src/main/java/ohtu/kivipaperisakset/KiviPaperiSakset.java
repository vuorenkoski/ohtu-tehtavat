package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KiviPaperiSakset {
    protected static final Scanner scanner = new Scanner(System.in);
    protected Moottori moottori;
    
    // tämä on ns template metodi
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        
        String ekanSiirto = ensimmaisenSiirto();
        String tokanSiirto = toisenSiirto(ekanSiirto);
        
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari + "\n");
            
            ekanSiirto = ensimmaisenSiirto();
            tokanSiirto = toisenSiirto(ekanSiirto);
        }

        System.out.println("\nKiitos!\n" + tuomari);
    }
    
    protected String ensimmaisenSiirto() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        return scanner.nextLine();
    }

    // tämä on abstrakti metodi sillä sen toteutus vaihtelee eri pelityypeissä
    abstract protected String toisenSiirto(String ekanSiirto);
    
    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}

