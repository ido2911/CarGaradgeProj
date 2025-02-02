package Garage;

public abstract class Vehicle implements Fixable {

    private String name;
    private DB.VehicleTypes type;

    public Vehicle (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DB.VehicleTypes getType() {
        return type;
    }

    public void setType(DB.VehicleTypes type) {
        this.type = type;
    }

    public abstract int getFixTime();

    public abstract void fixed();

    @Override
    public String toString() {
        return name;
    }
}
