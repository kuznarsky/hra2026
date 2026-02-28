package main;


import logika.Hra;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hra hra = new Hra();
        Scanner scanner = new Scanner(System.in);

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