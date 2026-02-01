package main;

import logika.Mistnost;
import logika.TvorbaSveta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TvorbaSveta tvorba = new TvorbaSveta();

        Mistnost aktualniMistnost = tvorba.vytvorSvetZeSouboru("svet.json");

        if (aktualniMistnost == null) {
            System.out.println("Nepodarilo se nacist svet");
            return;
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n---------------------");
            System.out.println("Jsi v: " + aktualniMistnost.getNazev());
            System.out.println(aktualniMistnost.dlouhyPopis());
            System.out.println("Vychody: " + aktualniMistnost.seznamVychodu());
            System.out.println("Zadej smer (nebo 'konec'): ");

            String vstup = sc.nextLine().trim();

            if (vstup.equals("konec")) break;

            Mistnost novaMistnost = aktualniMistnost.vratVychod(vstup);

            if (novaMistnost == null) {
                System.out.println("-> Timto smerem nejde jit");
            } else {
                aktualniMistnost = novaMistnost;
            }
        }

        System.out.println("Hra ukoncena.");
    }
}