package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KiviPaperiSakset {

    @Override
    protected String toisenSiirto(String ekanSiirto) {
        System.out.print("Toisen pelaajan siirto: ");
        return scanner.nextLine();
    }
}