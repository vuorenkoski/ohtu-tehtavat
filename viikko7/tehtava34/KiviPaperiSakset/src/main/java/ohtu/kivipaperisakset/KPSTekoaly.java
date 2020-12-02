package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KiviPaperiSakset {

    public KPSTekoaly(Moottori moottori) {
        this.moottori = moottori;
    }
    
    @Override
    protected String toisenSiirto(String ekanSiirto) {
        String tokanSiirto = moottori.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        moottori.asetaSiirto(ekanSiirto);
        return tokanSiirto;
    }
}