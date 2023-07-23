package magazyn;

import kategorie.Komponent;

public class Towar implements Komponent {
    private double cena;
    private String nazwa;

    public Towar(double cena, String nazwa) {
        this.cena = cena;
        this.nazwa = nazwa;
    }

    //operacje na cenie
    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getCena() {
        return cena;
    }

    //operacje na nazwie towaru
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public void wypisz() {
        System.out.println(this.nazwa);
    }
}
