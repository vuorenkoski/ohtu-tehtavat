package ohtu.verkkokauppa;

import java.util.ArrayList;

/**
 *
 * @author lauri
 */
public interface KirjanpitoInterface {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
    
}
