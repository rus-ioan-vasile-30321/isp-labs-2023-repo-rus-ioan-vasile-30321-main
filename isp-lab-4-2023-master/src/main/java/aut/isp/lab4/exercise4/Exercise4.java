package aut.isp.lab4.exercise4;

import aut.isp.lab4.exercise2.FishFeeder;
import aut.isp.lab4.exercise3.AquariumController;

public class Exercise4 {
    public static void main(String[] args) {
        FishFeeder feeder =new FishFeeder("Delonghi","Small",12);
        AquariumController first=new AquariumController(feeder,"BioTech","Medium",0.30F,5.40F);
        first.setCurrentTime(8.30f);
        System.out.println(first.getLightOnUntilStops());
        System.out.println(first.getLightOffUntilResets());

        first.setCurrentTime(22.0f);
        System.out.println(first.getLightOnUntilStops());
        System.out.println(first.getLightOffUntilResets());
        first.setCurrentTime(26.2f);
        System.out.println(first.getLightOnUntilStops());
        System.out.println(first.getLightOffUntilResets());
        //testare noua clasa
        LightControll light=new LightControll();
        light.setLightOffTime(2);
        System.out.println(light.getLightOnTime());
        System.out.println(light.getLightOffTime());

    }
}
