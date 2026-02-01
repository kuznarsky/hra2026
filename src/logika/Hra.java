package logika;

import prikazy.*;

public class Hra {
    private SeznamPrikazu platnePrikazy;
    private Mistnost aktualniMistnost;
    private Batoh batohHrace;
    private boolean konecHry = false;

    public Hra() {
        platnePrikazy = new SeznamPrikazu();
        batohHrace = new Batoh(15);
        zalozHru();
    }

    private void zalozHru() {
        //
    }

    public String zpracujPrikaz(String radek) {
        return "";
    }

    public String vratUvitani() {
        return "";
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
        return batohHrace;
    }
}
