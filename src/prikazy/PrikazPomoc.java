package prikazy;
import logika.Hra;

public class PrikazPomoc implements IPrikaz {
    private SeznamPrikazu seznam;
    public PrikazPomoc(SeznamPrikazu seznam) {
        this.seznam = seznam;
    }

    public String proved(String[] parametry) {
        return "Tvym ukolem je utect z hradu.\n" + "Muzes zadavat tyto prikazy: " + seznam.vratSeznamPrikazu();
    }

    public String getNazev() {
        return "pomoc";
    }
}
