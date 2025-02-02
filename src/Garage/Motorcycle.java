package Garage;

public class Motorcycle extends Vehicle {

    public Motorcycle(String name){
        super(name);
        setType(DB.VehicleTypes.MOTORCYCLE);
    }

    public static Motorcycle build(String name){
        return new Motorcycle(name);
    }

    @Override
    public int getFixTime() {
        return 3;
    }

    @Override
    public void fixed(){
        System.out.println("Motorcycle "+getName()+ " is fixed");
    }

    @Override
    public String toString() {
        return "Motorcycle: "+super.toString();
    }
}
