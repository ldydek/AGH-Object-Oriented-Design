package main;

import java.util.Calendar;
import wzorceprojektowe.fasada.WydrukFaktury;
import magazyn.Towar;
import dokumenty.Faktura;


public class Ui {

    public static void main(String[] args) {
        Calendar teraz = Calendar.getInstance();

        //Tworzymy towary
        Towar t1 = new Towar(10, "buty");
        Towar t2 = new Towar(2, "skarpety");

        //I przykladowa faktura
        Faktura f = new Faktura(teraz.getTime(), "Fido");
        f.dodajPozycje(t1, 3);
        f.dodajPozycje(t2, 5);

        WydrukFaktury wydrukFaktury = new WydrukFaktury();
        wydrukFaktury.drukujFakture(f);
    }
}
