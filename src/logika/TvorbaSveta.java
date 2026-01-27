package logika;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.Reader;
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
            dataSeznam = gson.fromJson(reader)
        }
    }
}
