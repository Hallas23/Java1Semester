package aggregation_group01_0mperson;

public class Person {
    private String name;
    private Spiller spiller;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}