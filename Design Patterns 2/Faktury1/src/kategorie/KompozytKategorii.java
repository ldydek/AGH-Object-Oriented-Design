package kategorie;

import magazyn.Towar;

import java.util.ArrayList;

public class KompozytKategorii implements Komponent {

    private final ArrayList<Komponent> komponenty;

    public KompozytKategorii() {
        komponenty = new ArrayList<>();
    }

    public Kategoria stworzDrzewo() {
        Kategoria kategoria1 = new Kategoria("Odzież");
        Kategoria kategoria2 = new Kategoria("Elektronika");

        Podkategoria podkategoria1 = new Podkategoria("Buty");
        Podkategoria podkategoria2 = new Podkategoria("Słuchawki");
        Podkategoria podkategoria3 = new Podkategoria("Telefony");

        Towar towar1 = new Towar(100, "Yeezy");
        Towar towar2 = new Towar(140, "Jordan");
        Towar towar3 = new Towar(10, "JBL");
        Towar towar4 = new Towar(15, "Air pods");
        Towar towar5 = new Towar(3, "iPhone 13 Pro");
        Towar towar6 = new Towar(5, "Samsung Galaxy S23");

        this.komponenty.add(kategoria1);
        this.komponenty.add(kategoria2);

        kategoria1.dodajPodkategorie(podkategoria1);
        kategoria2.dodajPodkategorie(podkategoria2);
        kategoria2.dodajPodkategorie(podkategoria3);

        podkategoria1.dodajTowar(towar1);
        podkategoria1.dodajTowar(towar2);
        podkategoria2.dodajTowar(towar3);
        podkategoria2.dodajTowar(towar4);
        podkategoria3.dodajTowar(towar5);
        podkategoria3.dodajTowar(towar6);

        return kategoria1;
    }

    @Override
    public void wypisz() {
        for (Komponent komponent: komponenty) {
            System.out.println(komponent);
            komponent.wypisz();
            System.out.println();
        }
    }
}
