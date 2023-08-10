package obliczanierabatu;

public class ObliczCenePoRabacieKwotowym implements IObliczCenePoRabacie {

    private final int znizkaWZlotowkach = 20;

    @Override
    public double obliczCenePoRabacie(double cena) {
        return Math.max(cena - znizkaWZlotowkach, 0);
    }

    @Override
    public String typRabatu() {
        return "rabat kwotowy";
    }

    @Override
    public String wielkoscZnizki() {
        return "(" + this.znizkaWZlotowkach + " zł)";
    }
}
