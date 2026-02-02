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

        this.aktualniMistnost = tvorba.vytvorSvetZeSouboru("svet.json", "predmety.json");


        if (this.aktualniMistnost == null) {
            System.err.println("CHYBA: SVET SE NENACETL");
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
        platnePrikazy.vlozPrikaz(new PrikazPomoc(platnePrikazy));
    }

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
            return "Tento prikaz neexistuje, zkus prikaz 'pomoc'";
        }
    }

    public String vratUvitani() {
        return "Vitej ve hre Utek z Temne veze" + aktualniMistnost.dlouhyPopis();
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
