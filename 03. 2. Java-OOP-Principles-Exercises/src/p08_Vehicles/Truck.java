package p08_Vehicles;

import java.text.DecimalFormat;

public class Truck extends VehicleImpl {
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 1.6);
    }

    @Override
    public void drive(double distance) {
        if(distance * super.getFuelConsumption() > super.getFuelQuantity()){
            System.out.println("Truck needs refueling");
        }else{
            DecimalFormat df = new DecimalFormat("#.##########");
            super.setFuelQuantity(super.getFuelQuantity() - (distance * super.getFuelConsumption()));
            System.out.printf("Truck travelled %s km\n", df.format(distance));
        }
    }

    @Override
    public void refuel(double liters) {
        super.setFuelQuantity(super.getFuelQuantity() + liters * 0.95);
    }

    @Override
    public String toString(){
        return String.format("Truck: %.2f", super.getFuelQuantity());
    }
}
