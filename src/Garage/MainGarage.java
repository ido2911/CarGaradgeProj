package Garage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MainGarage {
    public static void start(){

        DB.build(2, "Honda Accord");
        DB.build(1, "Yamaha YZF-R3");
        DB.build(1, "Harley-Davidson Street Glide");
        DB.build(3, "Ford F-150");
        DB.build(2, "Tesla Model S");
        DB.build(3, "Volvo FH16");

        Garage garage = new Garage(protocolGarage);
        garage.startWork(DB.getVehicles());

    }

    private static ProtocolGarage protocolGarage = new ProtocolGarage() {
        @Override
        public void fixed() {
            System.out.println("the vehicles are fixed $$ \uD83E\uDD11");
        }
    };
}
