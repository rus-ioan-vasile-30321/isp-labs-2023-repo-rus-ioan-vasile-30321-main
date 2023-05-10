package aut.isp.lab4.exercise6;

import aut.isp.lab4.exercise2.FishFeeder;
import aut.isp.lab4.exercise5.AquariumControllerex5;
import aut.isp.lab4.exercise5.LevelSensor;
import aut.isp.lab4.exercise5.TemperatureSensor;

public class Exercise6 {
    /*
    check the diagram first
    PH ul poate fi  modificat,dar trebuie modificat foarte incet,
    ca sa nu omoram pesti
    ControlPH se ocupa sa schimbe valori incet, daca diferenta de PH dintre
    present ph and read ph este mai mare de 0.5 atunci actionam alarma.
    Clasa LevelPH este pentru a prelucra date...
     */
    public static void main(String[] args) {
        FishFeeder feeder = new FishFeeder("Delonghi", "Small", 12);
        AquariumControllerex6 first = new AquariumControllerex6(feeder, "BioTech", "Medium", 0.30F, 5.40F,7.2f);
        LevelSensor levelSensor=new LevelSensor();
        TemperatureSensor temperatureSensor=new TemperatureSensor();
        LevelPH levelPH=new LevelPH();

        levelPH.setValue(7.4f);
        first.checkPH();
        levelPH.setValue(8f);
        first.checkPH();
    }
}
