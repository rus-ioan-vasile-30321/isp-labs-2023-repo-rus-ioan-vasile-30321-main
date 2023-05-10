package aut.isp.lab4.exercise1;

import aut.isp.lab4.exercise2.FishFeeder;
import aut.isp.lab4.exercise5.LevelSensor;
import aut.isp.lab4.exercise5.TemperatureSensor;
import aut.isp.lab4.exercise6.AquariumControllerex6;
import aut.isp.lab4.exercise6.LevelPH;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LevelPHTest {
    @Test
    public void controlPHtest(){
        FishFeeder feeder = new FishFeeder("Delonghi", "Small", 12);
        AquariumControllerex6 first = new AquariumControllerex6(feeder, "BioTech", "Medium", 0.30F, 5.40F,7.2f);
        LevelPH levelPH=new LevelPH();
        levelPH.setValue(7.4f);
        String actuall=first.checkPH();
        String expeced="PH was decreased.";
        assertEquals(expeced,actuall);
    }
    @Test
    public void alarmPHtest(){
        FishFeeder feeder = new FishFeeder("Delonghi", "Small", 12);
        AquariumControllerex6 first = new AquariumControllerex6(feeder, "BioTech", "Medium", 0.30F, 5.40F,7.2f);
        LevelPH levelPH=new LevelPH();
        levelPH.setValue(8.4f);
        String actuall=first.checkPH();
        String expeced="Alarm TurnON!";
        assertEquals(expeced,actuall);
    }

}
