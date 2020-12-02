package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Vastustaja vastustaja = new Vastustaja();
        
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            if (vastaus.endsWith("a")) {
                vastustaja.ihminen().pelaa();
            } else if (vastaus.endsWith("b")) {
                vastustaja.tekoaly().pelaa();
            } else if (vastaus.endsWith("c")) {
                vastustaja.tekoaly20().pelaa();
            } else {
                break;
            }

        }

    }
}
