package rabaty;

public class Konfiguracja {
    private static Konfiguracja instance;

    private Konfiguracja() {}

    public static Konfiguracja getInstance() {
        if (instance == null) {
            instance = new Konfiguracja();
        }
        return instance;
    }

    public IObliczCenePoRabacie getObliczanieRabatu() {
        return new ObliczCenePoRabacieProcentowym();
    }
}
