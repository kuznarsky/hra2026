/**
 * Hlavní spouštěcí třida hry
 *
 * @author Lukáš Kuzňarský
 */
package main;

import logika.Hra;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    /**
     * Vstupní bod programu, vytvoří instanci hry
     * @param args Parametry (nevyužito)
     */
    public static void main(String[] args) {
        Hra hra = new Hra();
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        System.out.println(hra.vratUvitani());

        while (!hra.konecHry()) {
            System.out.println("\n> ");
            String radek = scanner.nextLine().trim();

           // if (radek.isEmpty()) continue;
            if (radek == null || radek.trim().isEmpty()) {
                System.out.println("Musíš zadat nějaký příkaz! Napiš pomoc pro seznam příkazů.");
                continue;
            }

            String odpoved = hra.zpracujPrikaz(radek.toLowerCase());
            System.out.println(odpoved);
        }
    }
}