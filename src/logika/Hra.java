/**
 * Třída Hra řídí celou hru. Inicializuje svět, udržuje aktuální stav, zpracovává příkazy
 *
 * @author Lukáš Kuzňarský
 */
package logika;

import prikazy.*;

public class Hra {
    private SeznamPrikazu platnePrikazy;
    private Mistnost aktualniMistnost;
    private Batoh batoh;
    private boolean konecHry = false;

    public Hra() {
        platnePrikazy = new SeznamPrikazu();
        batoh = new Batoh(10);
        zalozSvet();
        zalozPrikazy();
    }

    private void zalozSvet() {
        TvorbaSveta tvorba = new TvorbaSveta();

        this.aktualniMistnost = tvorba.vytvorSvetZeSouboru("svet.json", "predmety.json", "postavy.json");


        if (this.aktualniMistnost == null) {
            System.err.println("CHYBA: SVĚT SE NENAČETL");
            return;
        }
    }

    private void zalozPrikazy() {
        platnePrikazy.vlozPrikaz(new PrikazJdi(this));
        platnePrikazy.vlozPrikaz(new PrikazVezmi(this));
        platnePrikazy.vlozPrikaz(new PrikazPoloz(this));
        platnePrikazy.vlozPrikaz(new PrikazProzkoumej(this));
        platnePrikazy.vlozPrikaz(new PrikazMluv(this));
        platnePrikazy.vlozPrikaz(new PrikazKonec(this));
        platnePrikazy.vlozPrikaz(new PrikazPouzij(this));
        platnePrikazy.vlozPrikaz(new PrikazPomoc(platnePrikazy));
        platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
    }

    /**
     * Zpracuje textový příkaz zadaný uživatelem
     * @param radek Celý text který napsal uživatel
     * @return Textová odpověď hry
     */

    public String zpracujPrikaz(String radek) {
        String[] slova = radek.split("\\s+");
        String nazevPrikazu = slova[0];
        String[] parametry = new String[slova.length - 1];

        for (int i = 0; i < parametry.length; i++) {
            parametry[i] = slova[i+1];
        }

        if (platnePrikazy.jePlatnyPrikaz(nazevPrikazu)) {
            IPrikaz prikaz = platnePrikazy.vratPrikaz(nazevPrikazu);
            return prikaz.proved(parametry);
        } else {
            return "Tento příkaz neexistuje. Pokud potřebujete pomoct, zkuste příkaz 'pomoc'";
        }
    }

    public String vratUvitani() {
        return "Vítejte ve hře Útěk z Temné věže!" + aktualniMistnost.dlouhyPopis();
    }

    public String vratEpilog() {
        return "";
    }

    public boolean konecHry() {
        return konecHry;
    }

    public void setKonecHry(boolean konec) {
        this.konecHry = konec;
    }

    public Mistnost getAktualniMistnost() {
        return aktualniMistnost;
    }

    public void setAktualniMistnost(Mistnost mistnost) {
        this.aktualniMistnost = mistnost;
    }

    public Batoh getBatoh() {
        return batoh;
    }
}
