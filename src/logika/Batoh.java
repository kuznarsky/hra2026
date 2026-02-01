package logika;

import java.util.HashMap;
import java.util.Map;

public class Batoh {
    private int kapacitaVahy;
    private int aktualniVaha;
    private Map<String, Predmet> obsah;

    public Batoh(int kapacitaVahy) {
        this.kapacitaVahy = kapacitaVahy;
        this.aktualniVaha = 0;
        this.obsah = new HashMap<>();
    }

    public boolean vlozVec(Predmet vec) {
        if (aktualniVaha + vec.getVaha() > kapacitaVahy) {
            return false;
        }
        obsah.put(vec.getNazev(), vec);
        aktualniVaha += vec.getVaha();
        return true;
    }

    public Predmet vyberVec(String nazev) {
        if (obsah.containsKey(nazev)) {
            Predmet vec = obsah.remove(nazev);
            aktualniVaha -= vec.getVaha();
            return vec;
        }
        return null;
    }

    public boolean obsahujeVec(String nazev) {
        return obsah.containsKey(nazev);
    }

    public String getSeznamVeci() {
        if (obsah.isEmpty()) {
            return "Batoh je prazdny.";
        }
        return "V batohu mas: " + String.join(", ", obsah.keySet()) + " (Vaha: " + aktualniVaha + "/" + kapacitaVahy + ")";
    }

    public int getAktualniVaha() {
        return 0;
    }
}
