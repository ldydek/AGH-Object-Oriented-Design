package pl.edu.agh.to.lab4;

public class AgeSearchStrategy implements SearchStrategy {

    private final int age;

    public AgeSearchStrategy(int age) {
        this.age = age;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return suspect.getAge() == age;
    }
}
