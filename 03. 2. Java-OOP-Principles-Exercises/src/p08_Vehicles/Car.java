package p08_Vehicles;

import java.text.DecimalFormat;

public class Car extends VehicleImpl {
    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 0.9);
    }

    @Override
    public void drive(double distance) {
        if(distance * super.getFuelConsumption() > super.getFuelQuantity()){
            System.out.println("Car needs refueling");
        }else{
            DecimalFormat df = new DecimalFormat("#.##########");
            super.setFuelQuantity(super.getFuelQuantity() - (distance * super.getFuelConsumption()));
            System.out.printf("Car travelled %s km\n", df.format(distance));
        }
    }

    @Override
    public void refuel(double liters) {
        super.setFuelQuantity(super.getFuelQuantity() + liters);
    }


    @Override
    public String toString(){
        return String.format("Car: %.2f", super.getFuelQuantity());
    }
}
