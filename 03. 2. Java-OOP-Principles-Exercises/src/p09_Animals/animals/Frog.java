package p09_Animals.animals;

public class Frog extends AnimalImpl {

    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void produceSound() {
        System.out.println("Frogggg");
    }
}
