package prikazy;
import logika.Hra;

public class PrikazNapoveda implements IPrikaz {
    private SeznamPrikazu seznam;
    public PrikazNapoveda(SeznamPrikazu seznam) {
        this.seznam = seznam;
    }

    public String proved(String[] parametry) {
        return "Tvym ukolem je utect z hradu. Příkazy zobrazíš příkazem 'pomoc'.";
    }

    public String getNazev() {
        return "napoveda";
    }
}
