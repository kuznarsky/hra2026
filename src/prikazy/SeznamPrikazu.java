package prikazy;

import java.util.HashMap;
import java.util.Map;

public class SeznamPrikazu {
    private Map<String, IPrikaz> mapaPrikazu;

    public SeznamPrikazu() {
        mapaPrikazu = new HashMap<>();
    }

    public void vlozPrikaz(IPrikaz prikaz) {
        mapaPrikazu.put(prikaz.getNazev(), prikaz);
    }

    public IPrikaz vratPrikaz(String retezec) {
        return mapaPrikazu.get(retezec);
    }

    public boolean jePlatnyPrikaz(String retezec) {
        return mapaPrikazu.containsKey(retezec);
    }

    public String vratSeznamPrikazu() {
        return String.join(", ", mapaPrikazu.keySet());
    }
}
