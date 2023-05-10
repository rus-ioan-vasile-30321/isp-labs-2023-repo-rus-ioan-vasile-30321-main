package aut.isp.lab4.exercise5;

import aut.isp.lab4.exercise2.FishFeeder;
import aut.isp.lab4.exercise4.LightControll;

public class AquariumControllerex5 {
    private FishFeeder feeder;
    private  String manufacturer;
    private String model;
    private float currentTime;
    private float feedingTime;
    private int temperature;
    private LevelSensor levelSensor;
    private TemperatureSensor temperatureSensor;
    private Alarm alarm;
    private Heater heater;
    public AquariumControllerex5(FishFeeder feeder, String manufacturer, String model, float currentTime, float feedingTime) {
        this.heater=new Heater();
        this.alarm=new Alarm();
        this.levelSensor=new LevelSensor();
        this.temperatureSensor=new TemperatureSensor();
        this.feeder = feeder;
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = feedingTime;
    }

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
     }
    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;
    }

    /*
    DOAR ACUM AM VAZUT CA IN DIGRAMA ESTE PRESSENT LEVEL AND TEMPERATURE

    acum las asa,  oricum nu e imposibil sa adaug 2 atribute etc...
     */
    public String checkWaterLevel(){
        System.out.println("Water level checked!");
        //I assume that present value is 5
        if(levelSensor.getValue()<5) {
            alarm.turnOn();
            return "Alarm turnOn";
        }
        return "";
    }
    public String checkTemperature(){
        System.out.println("Temperature level checked!");
        if(temperatureSensor.getValue()<24){
            heater.turnOn();
            return "Heater turnON";
        }
        else heater.turnOff();
        return "Heater turnOff";
    }
    public String toString(){
        return "Manufacturer: "+this.manufacturer+" Model: "+this.model+" CurrentTime: "+this.currentTime+" FeedingTime: "+this.feedingTime;
    }
}
