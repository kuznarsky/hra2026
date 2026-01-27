package main;

import logika.Mistnost;
import logika.TvorbaSveta;

public class Main {
    public static void main(String[] args) {
        TvorbaSveta tvorba = new TvorbaSveta();

        Mistnost aktualniMistnost = tvorba.vytvorSvetZeSouboru("svet.json");

        if (aktualniMistnost == null) {
            System.out.println("Nepodarilo se nacist svet");
        } else {
            System.out.println(aktualniMistnost.getNazev());
        }



    }
}