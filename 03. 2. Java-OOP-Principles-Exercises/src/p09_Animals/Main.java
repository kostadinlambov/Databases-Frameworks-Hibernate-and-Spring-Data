package p09_Animals;

import p09_Animals.factories.AnimalFactory;
import p09_Animals.interfaces.Animal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String animalClass = reader.readLine();

            if("Beast!".equalsIgnoreCase(animalClass)){
                break;
            }
            String[] tokens = reader.readLine().split("\\s+");

            try{
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String gender = null;
                if(tokens.length == 3){
                    gender = tokens[2];
                }
                Animal animal = AnimalFactory.createAnimal(animalClass, name, age, gender);
                System.out.println(animal);
                animal.produceSound();
            }catch(Exception iae){
                System.out.println("Invalid input!");
//                iae.printStackTrace();
            }
        }
    }
}
