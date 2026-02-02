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
            return "Musis zadat smer (napr. jdi sever)";
        }

        String smer = parametry[0];
        Mistnost aktualni = hra.getAktualniMistnost();
        Mistnost sousedni = aktualni.vratVychod(smer);

        if (sousedni == null) {
            return "Tam se odsud jit neda";
        }

        if (sousedni.getNazev().equals("Nadvori") && !hra.getBatoh().obsahujeVec("klic")) {
            return "Dvere jsou zamcene. potrebujes klic";
        }

        hra.setAktualniMistnost(sousedni);
        String vypis = sousedni.dlouhyPopis();

        if (sousedni.getNazev().equals("Straznice")) {
            Postava dozorce = sousedni.getPostava("dozorce");
            if (dozorce != null && !hra.getBatoh().obsahujeVec("mec")) {
                hra.setKonecHry(true);
                return vypis + "\n\n!! POZOR !!\n" +
                        dozorce.getDialog() + "\n" +
                        "Nemas zbran a dozorce te chytil" +
                        "--- KONEC HRY ---";
            } else if (dozorce != null && hra.getBatoh().obsahujeVec("mec")) {
                return vypis + "\n\nTasis svuj mec, cesta je volna";
            }
        }

        if (sousedni.getNazev().equals("Svoboda")) {
            hra.setKonecHry(true);
            return "\n*********************\n" +
                    "Prosel si branou ven z hradu.\n" +
                    "Jsi vitez. GG\n" +
                    "****************";
        }

        return vypis;
    }

    public String getNazev() {
        return "jdi";
    }
}
