package p09_Animals.factories;

import p09_Animals.interfaces.Animal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class AnimalFactory {
    private static final String ANIMAL_PACKAGE_NAME ="p09_Animals.animals.";

    private AnimalFactory(){}

    public static Animal createAnimal(String animalType, String name, int age, String gender) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> animalClass = Class.forName(ANIMAL_PACKAGE_NAME + animalType);
        Constructor<?> animalConstructor = animalClass.getDeclaredConstructor(String.class, int.class, String.class);

        Animal animal = (Animal) animalConstructor.newInstance(name, age, gender);

        return animal;
    }
}
