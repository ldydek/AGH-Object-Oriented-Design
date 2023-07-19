package wzorceprojektowe.metodaszablonowa;

import dokumenty.Faktura;
import dokumenty.Pozycja;

import java.util.Iterator;

public abstract class AbstrakcyjnyWydrukFaktury {

    public final void drukujFakture(Faktura faktura) {
        drukujNaglowek(faktura);
        drukujPozycje(faktura);
        drukujStopke(faktura);
    }

    protected abstract void drukujNaglowek(Faktura faktura);

    protected void drukujPozycje(Faktura faktura) {
        Iterator<Pozycja> iteratorPozycji = faktura.getIteratorPozycji();
        while (iteratorPozycji.hasNext()) {
            Pozycja pozycja = iteratorPozycji.next();
            System.out.println("Towar: " + pozycja.getNazwa() + " Ilosc: " + pozycja.getIlosc() + " Wartosc:" + pozycja.getWartosc());
        }
    }

    protected abstract void drukujStopke(Faktura faktura);
}
