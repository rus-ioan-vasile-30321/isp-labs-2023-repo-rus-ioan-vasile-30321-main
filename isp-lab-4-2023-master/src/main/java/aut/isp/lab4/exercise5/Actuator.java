package aut.isp.lab4.exercise5;

public abstract class Actuator {
    private String manufacturer;
    private String model;
    public String turnOn(){
        System.out.println("Actuator TurnON");
        return null;
    }
    public void turnOff(){
        System.out.println("Actuator TurnOff");
    }
    public String toString(){
        return "Manufacturer: "+this.manufacturer+" Model: "+this.model;
    }

}
