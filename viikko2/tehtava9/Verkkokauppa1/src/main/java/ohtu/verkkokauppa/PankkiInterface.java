package ohtu.verkkokauppa;

/**
 *
 * @author lauri
 */
public interface PankkiInterface {

    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
    
}
