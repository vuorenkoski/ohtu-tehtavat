package ohtu.kivipaperisakset;

public class Vastustaja {
    public KiviPaperiSakset tekoaly () {
        return new KPSTekoaly(new Tekoaly());
    }
    
    public KiviPaperiSakset tekoaly20 () {
        return new KPSTekoaly(new TekoalyParannettu(20));
    }
    
    public KiviPaperiSakset ihminen () {
        return new KPSPelaajaVsPelaaja();
    }
}
