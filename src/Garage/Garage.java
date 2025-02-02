package Garage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Garage {

    private ProtocolGarage protocolGarage;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private int hours = 0;
    private int currVehicle = 0;
    private int totalhours = 0;
    private boolean garadgeIsOpen = true;

    public Garage(ProtocolGarage protocolGarage){
        this.protocolGarage = protocolGarage;
    }

    public void startWork(HashMap<DB.VehicleTypes, PriorityQueue<Vehicle>>vehiclesMap){

        ArrayList<DB.VehicleTypes> types = new ArrayList<>();
        types.add(DB.VehicleTypes.MOTORCYCLE);
        types.add(DB.VehicleTypes.CAR);
        types.add(DB.VehicleTypes.TRUCK);

        for(DB.VehicleTypes type: types){
            PriorityQueue<Vehicle> vehicleQueue = vehiclesMap.get(type);
            while (!vehicleQueue.isEmpty()){
                vehicles.add(vehicleQueue.poll());
            }
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                tick();
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(runnable,0,1,TimeUnit.SECONDS);

    }


    private void tick(){

        if (!garadgeIsOpen){
            return;
        }

        hours++;
        totalhours++;
        System.out.println("debug hour. "+totalhours);
        Vehicle v = vehicles.get(currVehicle);

        if (v.getFixTime() == hours){
            v.fixed();
            hours = 0;
            currVehicle++;
        }

        if (currVehicle == vehicles.size()) {
            protocolGarage.fixed();
            garadgeIsOpen = false;
        }

    }
}
