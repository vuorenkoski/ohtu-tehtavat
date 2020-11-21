package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        try {
            sovellus.nollaa();
            int laskunTulos = sovellus.tulos();
            syotekentta.setText("");
            this.edellinenArvo=tuloskentta.getText();
            tuloskentta.setText("" + laskunTulos);
        } catch (Exception e) {
        }
    }

}