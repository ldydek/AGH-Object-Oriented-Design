package dokumenty;

public class WydrukFakturyB extends AbstrakcyjnyWydrukFaktury {
    @Override
    protected void drukujNaglowek(Faktura faktura) {
        System.out.println("------------------------------------------------");
        System.out.println("DRUGI SZABLON FAKTURY");
        System.out.println("Faktura z dnia: " + faktura.getDataSprzedazy().toString());
        System.out.println("Wystawiona dla: " + faktura.getKontrahent());
        System.out.println("--------------------------------------");
    }

    @Override
    protected void drukujStopke(Faktura faktura) {
        System.out.println("--------------------------------------");
        System.out.println("Na kwote: " + faktura.getSuma() + " zł");
        System.out.println("Naliczono " + faktura.zwrocTypRabatu() + ": " + faktura.zwrocWielkoscRabatu() + ".");
        System.out.println("------------------------------------------------");
    }
}
