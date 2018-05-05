package p09_Animals.animals;

import p09_Animals.interfaces.Animal;

public abstract class AnimalImpl implements Animal {
    private String name;
    private int age;
    private String gender;

    protected AnimalImpl(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {
        if("".equals(name)){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if(age <= 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    private void setGender(String gender) {
        if("".equals(gender)){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    @Override
    public void produceSound() {
        System.out.println("Not implemented!");
    }

    @Override
    public String toString() {
        return String.format("%s\n%s %d %s",
                this.getClass().getSimpleName(),
                this.name, this.age, this.gender);
    }
}
