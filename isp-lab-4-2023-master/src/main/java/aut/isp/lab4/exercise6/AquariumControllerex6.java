package aut.isp.lab4.exercise6;

import aut.isp.lab4.exercise2.FishFeeder;
import aut.isp.lab4.exercise5.Alarm;
import aut.isp.lab4.exercise5.Heater;
import aut.isp.lab4.exercise5.LevelSensor;
import aut.isp.lab4.exercise5.TemperatureSensor;


public class AquariumControllerex6 {
    private FishFeeder feeder;
    private  String manufacturer;
    private String model;
    private float currentTime;
    private float feedingTime;
    private int temperature;
    private float presentPH;
    private LevelSensor levelSensor;
    private TemperatureSensor temperatureSensor;

    private Alarm alarm;
    private Heater heater;
    //for ex6
    private LevelPH levelPH;
    private ControlPH controlPH;

    public AquariumControllerex6(FishFeeder feeder, String manufacturer, String model, float currentTime, float feedingTime,float presentPH) {
        this.presentPH=presentPH;
        this.levelPH=new LevelPH();
        this.controlPH=new ControlPH();
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

    /*CHECK PH FOR EX6
    * am stabilit ca limitile pentru a creste si scadea ph
    * sunt intre 0.0-0.6
    * */
    public String checkPH(){
        float difference_Ph=this.presentPH-this.levelPH.getValue();
        if(difference_Ph>0 && difference_Ph<0.6) {
            this.controlPH.increasePH();
            return this.controlPH.increasePH();
        }
        else if(difference_Ph<0 && difference_Ph>-0.6) {
            this.controlPH.decreasePH();
            return this.controlPH.decreasePH();
        }
              else {
                  this.alarm.turnOn();
                  return this.alarm.turnOn();
              }
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
