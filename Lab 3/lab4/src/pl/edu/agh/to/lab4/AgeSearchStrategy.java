package pl.edu.agh.to.lab4;

public class AgeSearchStrategy implements SearchStrategy {

    private final int age;

    public AgeSearchStrategy(int age) {
        this.age = age;
    }

    @Override
    public boolean filter(Suspect suspect) {
        if (suspect instanceof Person) {
            return this.age == ((Person) suspect).getAge();
        }
        return false;
    }
}
