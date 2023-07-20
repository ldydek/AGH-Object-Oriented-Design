package obliczanierabatu;

import rabatlosowy.LosowyRabat;

public class ObliczCenePoRabacieProcentowym implements IObliczCenePoRabacie {

    private double znizkaWProcentach = new LosowyRabat().losujRabat();

    public ObliczCenePoRabacieProcentowym() {
        this.znizkaWProcentach = this.dwaMiejscaPoPrzecinku(this.znizkaWProcentach);
    }
    @Override
    public double obliczCenePoRabacie(double cena) {
        return (double) Math.round(cena * (1 - znizkaWProcentach) * 100) / 100;
    }

    @Override
    public String typRabatu() {
        return "rabat procentowy";
    }

    @Override
    public String wielkoscZnizki() {
        return "(" + this.znizkaWProcentach + " %)";
    }

    private double dwaMiejscaPoPrzecinku(double liczba) {
        return (double) Math.round(liczba * 100) / 100;
    }
}
