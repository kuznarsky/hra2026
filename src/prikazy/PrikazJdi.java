package prikazy;
import logika.Hra;
import logika.Mistnost;
import logika.Postava;

public class PrikazJdi implements IPrikaz {
    private Hra hra;

    public PrikazJdi(Hra hra) {
        this.hra = hra;
    }

    public String proved(String[] parametry) {
        if (parametry.length == 0) {
            return "Musíte zadat směr (např. jdi sever)";
        }

        String smer = parametry[0];
        Mistnost aktualni = hra.getAktualniMistnost();
        Mistnost sousedni = aktualni.vratVychod(smer);

        if (sousedni == null) {
            return "Tam se odsud jít nedá";
        }

        if (sousedni.getNazev().equals("Nádvoří") && !hra.getBatoh().obsahujeVec("klíč")) {
            return "Dveře jsou zamčené";
        }

        Postava zamcenacela = hra.getAktualniMistnost().getPostava("zamcenacela");

        if (aktualni.getNazev().equals("Cela") && !zamcenacela.getTyp().equals("neutral")) {
            return "Cela je zamčená";
        }

        hra.setAktualniMistnost(sousedni);
        String vypis = sousedni.dlouhyPopis();

        if (sousedni.getNazev().equals("Strážnice")) {
            Postava dozorce = sousedni.getPostava("dozorce");
            if (dozorce != null && !hra.getBatoh().obsahujeVec("meč")) {
                hra.setKonecHry(true);
                return vypis + "\n\n!! POZOR !!\n" +
                        dozorce.getDialog() + "\n" +
                        "Nemáš zbraň a dozorce te chytil" +
                        "--- KONEC HRY ---";
            } else if (dozorce != null && hra.getBatoh().obsahujeVec("meč")) {
                return vypis + "\n\nTasíš svůj meč, cesta je volná";
            }
        }

        if (sousedni.getNazev().equals("Svoboda")) {
            hra.setKonecHry(true);
            return "\n*********************\n" +
                    "Prošel si bránou ven z hradu.\n" +
                    "Jsi vítěz. GG\n" +
                    "****************";
        }

        return vypis;
    }

    public String getNazev() {
        return "jdi";
    }
}
