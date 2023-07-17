package rabaty;

public class ObliczCenePoRabacieProcentowym implements IObliczCenePoRabacie {

    private int znizkaWProcentach = 50;
    @Override
    public double obliczCenePoRabacie(double cena) {
        return cena * znizkaWProcentach / 100;
    }

    @Override
    public String typRabatu() {
        return "rabat procentowy";
    }

    public int getZnizkaWProcentach() {
        return znizkaWProcentach;
    }
}
