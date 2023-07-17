package rabaty;

public class ObliczCenePoRabacieKwotowym implements IObliczCenePoRabacie {

    private int znizkaWZlotowkach = 50;
    @Override
    public double obliczCenePoRabacie(double cena) {
        return Math.max(cena - znizkaWZlotowkach, 0);
    }

    public int getZnizkaWZlotowkach() {
        return znizkaWZlotowkach;
    }

    @Override
    public String typRabatu() {
        return "rabat kwotowy";
    }
}
