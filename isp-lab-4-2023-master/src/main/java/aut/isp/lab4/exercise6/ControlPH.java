package aut.isp.lab4.exercise6;

import aut.isp.lab4.exercise5.Actuator;

public class ControlPH extends Actuator {
    public String increasePH(){
        System.out.println("PH was increased.");
        return "PH was increased.";
    }

    public String decreasePH(){
        System.out.println("PH was decreased.");
        return "PH was decreased.";
    }
}
