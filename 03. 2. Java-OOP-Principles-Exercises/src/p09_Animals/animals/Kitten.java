package p09_Animals.animals;

public class Kitten extends Cat {

    public Kitten(String name, int age, String gender) {
        super(name, age, "female");
    }

    @Override
    public void produceSound() {
        System.out.println("Miau");
    }
}

