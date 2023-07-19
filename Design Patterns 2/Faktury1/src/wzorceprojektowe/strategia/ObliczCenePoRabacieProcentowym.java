package wzorceprojektowe.strategia;

import rabatlosowy.LosowyRabat;

public class ObliczCenePoRabacieProcentowym implements IObliczCenePoRabacie {

    private double znizkaWProcentach = new LosowyRabat().losujRabat();
    @Override
    public double obliczCenePoRabacie(double cena) {
        return cena * znizkaWProcentach;
    }

    @Override
    public String typRabatu() {
        return "rabat procentowy";
    }

    public double getZnizkaWProcentach() {
        return znizkaWProcentach;
    }
}
