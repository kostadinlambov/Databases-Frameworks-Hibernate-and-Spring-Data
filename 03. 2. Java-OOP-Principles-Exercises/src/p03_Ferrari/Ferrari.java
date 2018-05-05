package p03_Ferrari;

public class Ferrari implements Car {
    private String model;
    private String driverName;

    public Ferrari(String driverName) {
        this.setModel();
        this.setDriverName(driverName);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    private void setModel() {
        this.model = "488-Spider";
    }

    @Override
    public String getDriverName() {
        return this.driverName;
    }

    private void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String useBrakes(){
        return "Brakes!";
    }

    @Override
    public String useGasPedal(){
        return "Zadu6avam sA!";
    }
}
