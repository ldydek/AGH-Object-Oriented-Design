package kategorie;

import java.util.ArrayList;

public class Kategoria implements Komponent {
    private final String nazwa;
    private final ArrayList<Komponent> komponenty;

    public Kategoria(String nazwa) {
        this.nazwa = nazwa;
        this.komponenty = new ArrayList<>();
    }

    public void dodajPodkategorie(Komponent komponent) {
        komponenty.add(komponent);
    }

    @Override
    public void wypisz() {
        for (Komponent komponent: komponenty) {
            System.out.println(komponent);
            komponent.wypisz();
        }
    }

    @Override
    public String toString() {
        return "Kategoria: " + this.nazwa;
    }
}
