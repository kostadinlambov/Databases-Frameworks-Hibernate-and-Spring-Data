package p08_Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carInfo = reader.readLine().split("\\s+");
        double fuelQuantityCar = Double.parseDouble(carInfo[1]);
        double fuelConsumptionCar = Double.parseDouble(carInfo[2]);
        Vehicle car = new Car(fuelQuantityCar, fuelConsumptionCar);

        String[] truckInfo = reader.readLine().split("\\s+");
        double fuelQuantityTruck = Double.parseDouble(truckInfo[1]);
        double fuelConsumptionTruck = Double.parseDouble(truckInfo[2]);
        Vehicle truck = new Truck(fuelQuantityTruck, fuelConsumptionTruck);

        int num = Integer.parseInt(reader.readLine());

        for (int i = 0; i < num; i++) {
          String[] tokens = reader.readLine().split("\\s+");

          if(tokens.length == 3) {
              switch (tokens[0]) {
                  case "Drive":
                      if (tokens[1].equals("Car")) {
                          car.drive(Double.parseDouble(tokens[2]));
                      } else {
                          truck.drive(Double.parseDouble(tokens[2]));
                      }
                      break;
                  case "Refuel":
                      if (tokens[1].equals("Car")) {
                          car.refuel(Double.parseDouble(tokens[2]));
                      } else {
                          truck.refuel(Double.parseDouble(tokens[2]));
                      }
                      break;
              }
          }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}
