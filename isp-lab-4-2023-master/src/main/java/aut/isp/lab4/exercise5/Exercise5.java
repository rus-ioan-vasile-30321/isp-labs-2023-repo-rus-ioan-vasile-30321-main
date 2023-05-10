package aut.isp.lab4.exercise5;

import aut.isp.lab4.exercise2.FishFeeder;
import aut.isp.lab4.exercise3.AquariumController;

public class Exercise5 {
    public static void main(String[] args) {
        FishFeeder feeder = new FishFeeder("Delonghi", "Small", 12);
        AquariumControllerex5 first = new AquariumControllerex5(feeder, "BioTech", "Medium", 0.30F, 5.40F);
        LevelSensor levelSensor=new LevelSensor();
        TemperatureSensor temperatureSensor=new TemperatureSensor();

        levelSensor.setValue(4);
        first.checkWaterLevel();
        levelSensor.setValue(5);
        first.checkWaterLevel();

        temperatureSensor.setValue(22);
        first.checkTemperature();
        temperatureSensor.setValue(25);
        first.checkTemperature();


    }
}