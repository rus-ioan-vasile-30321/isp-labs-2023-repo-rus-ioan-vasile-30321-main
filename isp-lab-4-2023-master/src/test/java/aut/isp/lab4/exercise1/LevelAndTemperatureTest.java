package aut.isp.lab4.exercise1;

import aut.isp.lab4.exercise2.FishFeeder;
import aut.isp.lab4.exercise5.AquariumControllerex5;
import aut.isp.lab4.exercise5.LevelSensor;
import aut.isp.lab4.exercise5.TemperatureSensor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LevelAndTemperatureTest {
    @Test
    public void levelTest(){
        FishFeeder feeder = new FishFeeder("Delonghi", "Small", 12);
        AquariumControllerex5 first = new AquariumControllerex5(feeder, "BioTech", "Medium", 0.30F, 5.40F);
        LevelSensor levelSensor=new LevelSensor();
        TemperatureSensor temperatureSensor=new TemperatureSensor();

        levelSensor.setValue(4);
        String actual=first.checkWaterLevel();
        String expected="Alarm turnOn";
        assertEquals(actual,expected);
    }
    @Test
    public void temperatureTest() {
        FishFeeder feeder = new FishFeeder("Delonghi", "Small", 12);
        AquariumControllerex5 first = new AquariumControllerex5(feeder, "BioTech", "Medium", 0.30F, 5.40F);
        LevelSensor levelSensor = new LevelSensor();
        TemperatureSensor temperatureSensor = new TemperatureSensor();
        temperatureSensor.setValue(21);
        String actual=first.checkTemperature();
        String expected="Heater turnON";
        assertEquals(expected,actual);

    }
    }
