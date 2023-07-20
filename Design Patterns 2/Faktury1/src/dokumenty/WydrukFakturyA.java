package dokumenty;

public class WydrukFakturyA extends AbstrakcyjnyWydrukFaktury {

    protected void drukujNaglowek(Faktura faktura) {
        System.out.println("=====================================================");
        System.out.println("PIERWSZY SZABLON FAKTURY");
        System.out.println("Faktura z dnia: " + faktura.getDataSprzedazy().toString());
        System.out.println("Wystawiona dla: " + faktura.getKontrahent());
    }

    @Override
    protected void drukujStopke(Faktura faktura) {
        System.out.println("Na kwote: " + faktura.getSuma() + " zł");
        System.out.println("Naliczono " + faktura.zwrocTypRabatu() + ": " + faktura.zwrocWielkoscRabatu() + ".");
        System.out.println("=====================================================");
    }
}
