package p05_Intersection_of_Circles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstInput = reader.readLine().split("\\s+");

        int x1 = Integer.parseInt(firstInput[0]);
        int y1 = Integer.parseInt(firstInput[1]);
        int firstRadius = Integer.parseInt(firstInput[2]);

        Point centerFirstCircle =  new Point(x1, y1);
        Circle c1 = new Circle(centerFirstCircle, firstRadius);

        String[] secondInput = reader.readLine().split("\\s+");

        int x2 = Integer.parseInt(secondInput[0]);
        int y2= Integer.parseInt(secondInput[1]);
        int secondRadius = Integer.parseInt(secondInput[2]);

        Point centerSecondCircle =  new Point(x2, y2);
        Circle c2 = new Circle(centerSecondCircle, secondRadius);

        intersect(c1,c2);
    }

    private static void intersect(Circle c1, Circle c2) {
        double distance = Math.sqrt(Math.pow(c1.getCenter().getX()-c2.getCenter().getX(), 2) +
                Math.pow(c1.getCenter().getY()-c2.getCenter().getY(), 2));

        if(distance <= c1.getRadius() + c2.getRadius()){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
