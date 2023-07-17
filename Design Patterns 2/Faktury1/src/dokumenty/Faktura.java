package dokumenty;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

import magazyn.Towar;
import rabaty.IObliczCenePoRabacie;
import rabaty.Konfiguracja;


public class Faktura {
    Date dataSprzedazy;
    String kontrahent;
    ArrayList<Pozycja> pozycje;
    double suma;
    IObliczCenePoRabacie iObliczCenePoRabacie;

    public Faktura(Date dataSprzedazy, String kontrahent) {
        this.dataSprzedazy = dataSprzedazy;
        this.kontrahent = kontrahent;
        pozycje = new ArrayList<Pozycja>();
        suma = 0;
        iObliczCenePoRabacie = Konfiguracja.getInstance().getObliczanieRabatu();
    }

    public void dodajPozycje(Towar towar, double ilosc) {
        pozycje.add(new Pozycja(towar, ilosc));
        this.przeliczSume();
        this.dodajRabat(this.iObliczCenePoRabacie);
    }

    public double getSuma() {
        return suma;
    }

    public Date getDataSprzedazy() {
        return dataSprzedazy;
    }

    //jak sie zmieni cos na fakturze to trzeba wywolac te metode
    public Iterator<Pozycja> getIteratorPozycji() {
        return pozycje.iterator();
    }

    public String getKontrahent() {
        return this.kontrahent;
    }

    public void wybierzSposobNaliczaniaRabatu(IObliczCenePoRabacie iObliczCenePoRabacie) {
        this.iObliczCenePoRabacie = iObliczCenePoRabacie;
    }

    public String zwrocTypRabatu() {
        return this.iObliczCenePoRabacie.typRabatu();
    }

    private void przeliczSume() {
        Iterator<Pozycja> iteratorPozycji = pozycje.iterator();
        Pozycja pozycja;
        suma = 0;
        while (iteratorPozycji.hasNext()) {
            pozycja = iteratorPozycji.next();
            suma += pozycja.getWartosc();
        }
    }

    private void dodajRabat(IObliczCenePoRabacie iObliczCenePoRabacie) {
        this.suma = iObliczCenePoRabacie.obliczCenePoRabacie(this.suma);
    }
}
