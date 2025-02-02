package Garage;

public class Truck extends Vehicle {

    public Truck(String name){
        super(name);
        setType(DB.VehicleTypes.TRUCK);
    }

    public static Truck build(String name){
        return new Truck(name);
    }

    @Override
    public int getFixTime() {
        return 10;
    }

    @Override
    public void fixed(){
        System.out.println("Truck "+getName()+ " is fixed");
    }

    @Override
    public String toString() {
        return "Truck: "+super.toString();
    }
}
