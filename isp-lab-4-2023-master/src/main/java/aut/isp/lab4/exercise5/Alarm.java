package aut.isp.lab4.exercise5;

public class Alarm extends Actuator{
    public String turnOn(){
        System.out.println("Alarm TurnON!");
        return "Alarm TurnON!";
    }
    public void turnOff(){
        System.out.println("Alarm TurnOff");
    }
}
