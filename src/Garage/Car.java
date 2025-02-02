package Garage;

public class Car extends Vehicle {

    public Car(String name){
        super(name);
        setType(DB.VehicleTypes.CAR);
    }

    public static Car build(String name){
        return new Car(name);
    }

    @Override
    public int getFixTime() {
        return 5;
    }

    @Override
    public void fixed(){
        System.out.println("Car "+getName()+ " is fixed");
    }

    @Override
    public String toString() {
        return "Car: "+super.toString();
    }
}
