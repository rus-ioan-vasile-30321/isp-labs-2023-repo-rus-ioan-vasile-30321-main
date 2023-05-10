package isp.lab3.exercise3;

import isp.lab3.exercise2.Rectangle;

public class Vehicle{
    private String model;
    private String type;
    private int speed;
    private char fuelType;

    private static int instances;


    public Vehicle(String model, String type, int speed, char fuelType) {
        this.model = model;
        this.type = type;
        this.speed = speed;
        this.fuelType = fuelType;
        instances++;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public int getSpeed() {
        return speed;
    }

    public char getFuelType() {
        return fuelType;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setFuelType(char fuelType) {
        this.fuelType = fuelType;
    }

    public String toString(){
        return this.model+" ("+this.type+") speed "+this.speed
                +" fuel type "+this.fuelType;
    }

    public boolean equals(Object other){
                if( other == this) {
                    return true;
                }
                else {
                    Vehicle one=(Vehicle) other;
                    return this.model== one.model && this.type==one.type && this.speed==one.speed && this.fuelType==one.fuelType;
                }
        }
    public static int getInstances(){
        return instances;
    }



    public static void main(String[] args) {
        Vehicle one=new Vehicle("Dacia","Logan",150,'D');
        Vehicle two=new Vehicle("Mercedes","G Class",210,'B');
        one.setType("Duster");
        one.setSpeed(140);

        System.out.println(one.getModel()+" ("+one.getType()+") speed "+one.getSpeed()+" fuel type "+one.getFuelType());
        System.out.println(two.toString());
        System.out.println(one.getInstances());

        if(one.equals(two)==true) System.out.println("The objects created in step before are equals");
        else System.out.println("The objects created in step before are NOT equals");

    }
}
