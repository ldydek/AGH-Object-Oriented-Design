package kategorie;

import magazyn.Towar;

import java.util.ArrayList;

public class Podkategoria implements Komponent {

    private final String nazwa;
    private final ArrayList<Komponent> komponenty;

    public Podkategoria(String nazwa) {
        this.nazwa = nazwa;
        this.komponenty = new ArrayList<>();
    }

    public void dodajTowar(Towar towar) {
        this.komponenty.add(towar);
    }

    @Override
    public void wypisz() {
        for (Komponent komponent : komponenty) {
            komponent.wypisz();
        }
    }

    @Override
    public String toString() {
        return "Podkategoria: " + this.nazwa;
    }
}
