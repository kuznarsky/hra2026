package logika;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TvorbaSveta {
    private class MistnostData {
        String nazev;
        String popis;
        Map<String, String> vychody;
    }
    public Mistnost vytvorSvetZeSouboru(String cestaKSouboru) {
        Gson gson = new Gson();
        List<MistnostData> dataSeznam;

        try (Reader reader = new FileReader(cestaKSouboru)) {
          Type listType = new TypeToken<List<MistnostData>>(){}.getType();
            dataSeznam = gson.fromJson(reader, listType);
        } catch (IOException e) {
            System.err.println("Chyba pri cteni souboru: " + e.getMessage());
            return null;
        }

        Map<String, Mistnost> hotoveMistnosti = new HashMap<>();

        for (MistnostData data : dataSeznam) {
            Mistnost nova = new Mistnost(data.nazev, data.popis);
            hotoveMistnosti.put(data.nazev, nova);
        }

        for (MistnostData data : dataSeznam) {
            Mistnost aktualni = hotoveMistnosti.get(data.nazev);

            if (data.vychody != null) {
                for (Map.Entry<String, String> entry : data.vychody.entrySet()) {
                    String smer = entry.getKey();
                    String nazevCile = entry.getValue();

                    Mistnost cilova = hotoveMistnosti.get(nazevCile);

                    if (cilova != null) {
                        aktualni.setVychod(smer, cilova);
                    } else {
                        System.out.println("Cílová místnost " + nazevCile + " neexistuje");
                    }
                }
            }
        }
        return hotoveMistnosti.get(dataSeznam.get(0).nazev);
    }
}
