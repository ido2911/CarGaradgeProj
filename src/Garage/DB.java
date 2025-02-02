package Garage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DB {

    public enum VehicleTypes{
        MOTORCYCLE,
        CAR,
        TRUCK
    };

    private static HashMap<VehicleTypes, PriorityQueue<Vehicle>> vehicles = innitVehicles();

    public static HashMap<VehicleTypes, PriorityQueue<Vehicle>> innitVehicles(){
        HashMap<VehicleTypes, PriorityQueue<Vehicle>> map = new HashMap<>();

        map.put(VehicleTypes.MOTORCYCLE, new PriorityQueue<>((c1, c2) -> 0));
        map.put(VehicleTypes.CAR, new PriorityQueue<>((c1, c2) -> 0));
        map.put(VehicleTypes.TRUCK, new PriorityQueue<>((c1, c2) -> 0));

        return map;
    }

    public static HashMap<VehicleTypes, PriorityQueue<Vehicle>> getVehicles(){
        return  vehicles;
    }

    public static void addVehicle(Vehicle v){
        vehicles.get(v.getType()).add(v);
    }

    public static void build (int type, String name) {
        Vehicle newVehicle;
        switch (type) {
            case 1: // Motorcycle
                newVehicle = Motorcycle.build(name);
                break;
            case 2: // Car
                newVehicle = Car.build(name);
                break;
            case 3: // Truck
                newVehicle = Truck.build(name);
                break;
            default:
                System.out.println("not a valid type");
                return;
        }


        addVehicle(newVehicle);
    }
}
