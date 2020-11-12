
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int OLETUSKAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatus;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] joukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenMaara;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        joukko = new int[OLETUSKAPASITEETTI];
        alkioidenMaara = 0;
        this.kasvatus = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        joukko = new int[kapasiteetti];
        alkioidenMaara = 0;
        this.kasvatus = OLETUSKASVATUS;

    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");//heitin vaan jotain :D
        }
        joukko = new int[kapasiteetti];
        alkioidenMaara = 0;
        this.kasvatus = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            joukko[alkioidenMaara] = luku;
            alkioidenMaara++;
            if (alkioidenMaara >= joukko.length) {
                int[] uusiJoukko = new int[alkioidenMaara + kasvatus];
                kopioiTaulukko(joukko, uusiJoukko);
                joukko=uusiJoukko;
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenMaara; i++) {
            if (luku == joukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int kohta = -1;
        for (int i = 0; i < alkioidenMaara; i++) {
            if (luku == joukko[i]) {
                kohta = i; //siis luku löytyy tuosta kohdasta :D
                break;
            }
        }
        if (kohta != -1) {
            for (int j = kohta; j < alkioidenMaara - 1; j++) {
                joukko[j] = joukko[j + 1];
            }
            alkioidenMaara--;
            return true;
        }
       return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int alkio(int kohta) {
        return joukko[kohta];
    }
    
    public int koko() {
        return alkioidenMaara;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenMaara];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = joukko[i];
        }
        return taulu;
    }
        
    @Override
    public String toString() {
        String tuotos = "{";
        for (int i = 0; i < alkioidenMaara; i++) {
            if (i > 0) {
                tuotos += ", ";
            }
            tuotos += joukko[i];
        }
        tuotos += "}";
        return tuotos;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int i = 0; i < a.koko(); i++) {
            x.lisaa(a.alkio(i));
        }
        for (int i = 0; i < b.koko(); i++) {
            x.lisaa(b.alkio(i));
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int i = 0; i < a.koko(); i++) {
            for (int j = 0; j < b.koko(); j++) {
                if (a.alkio(i) == b.alkio(j)) {
                    x.lisaa(b.alkio(j));
                }
            }
        }
        return x;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int i = 0; i < a.koko(); i++) {
            x.lisaa(a.alkio(i));
        }
        for (int i = 0; i < b.koko(); i++) {
            x.poista(b.alkio(i));
        }
        return x;
    }
}
