package aut.isp.lab4.exercise3;

import aut.isp.lab4.exercise2.FishFeeder;

public class Exercise3 {
    public static void main(String[] args) {
        FishFeeder feeder =new FishFeeder("Delonghi","Small",12);
        AquariumController first=new AquariumController(feeder,"BioTech","Medium",5.38F,5.40F);
        first.setCurrentTime(5.44F);
        first.setFeedingTime(4.43F);
        System.out.println(first.toString());

    }
}
