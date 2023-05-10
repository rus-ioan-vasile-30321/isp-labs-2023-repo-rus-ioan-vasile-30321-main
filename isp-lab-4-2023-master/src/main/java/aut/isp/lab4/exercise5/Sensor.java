package aut.isp.lab4.exercise5;

public abstract class Sensor {
    private String manufacturer;
    private String model;
    public String toString(){
        return "Manufacturer: "+this.manufacturer+" Model: "+this.model;
    }
}
