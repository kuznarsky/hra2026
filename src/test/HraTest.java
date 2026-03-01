package test;

import logika.Hra;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HraTest {
    private Hra hra;

    @Before
    public void cistaHra() {
        hra = new Hra();
    }

    @Test
    public void testStartovniMistnost() {
        assertEquals("Startovní místnost by měla být Cela", "Cela", hra.getAktualniMistnost().getNazev());
    }

    @Test
    public void testPlatnyPohyb() {
        hra.zpracujPrikaz("vezmi paklic");
        hra.zpracujPrikaz("pouzij paklic");
        hra.zpracujPrikaz("jdi sever");
        assertEquals("Temna chodba", hra.getAktualniMistnost().getNazev());
    }

    @Test
    public void testNeplatnyPohyb() {
        String odpoved = hra.zpracujPrikaz("jdi zapad");
        assertEquals("Hráč by měl zůstat v cele", "Cela", hra.getAktualniMistnost().getNazev());
        assertTrue("Hra by měla vypsat chybu", odpoved.contains("nedá"));
    }

    @Test
    public void testNeznamyPrikaz() {
        String odpoved = hra.zpracujPrikaz("prosím funguj");
        assertTrue("Hra musí ošetřit nesmysl", odpoved.contains("neexistuje"));
    }

    @Test
    public void testSberPredmetu() {
        hra.zpracujPrikaz("vezmi paklic");
        assertTrue("Paklíč by měl být v batohu", hra.getBatoh().obsahujeVec("paklic"));
        assertNull("Paklíč už by neměl být v místnosti", hra.getAktualniMistnost().najdiPredmet("paklic"));
    }

    @Test
    public void testProhraDozorce() {
        hra.zpracujPrikaz("vezmi paklic");
        hra.zpracujPrikaz("pouzij paklic");
        hra.zpracujPrikaz("jdi jih");
        hra.zpracujPrikaz("jdi jih");

        assertEquals("Straznice", hra.getAktualniMistnost().getNazev());
        assertTrue("Hra by měla skončit prohrou", hra.konecHry());
    }

    @Test
    public void testNeprenositelnyPredmet() {
        String odpoved = hra.zpracujPrikaz("vezmi kamen");
        assertFalse("Kámen nesmí být v batohu", hra.getBatoh().obsahujeVec("kamen"));
        assertNotNull("Kámen musí zůstat v místnosti", hra.getAktualniMistnost().najdiPredmet("kamen"));
    }
}
