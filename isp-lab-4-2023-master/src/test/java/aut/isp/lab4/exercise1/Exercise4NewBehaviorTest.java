package aut.isp.lab4.exercise1;

import aut.isp.lab4.exercise2.FishFeeder;
import aut.isp.lab4.exercise3.AquariumController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise4NewBehaviorTest {
    @Test
    public void testTimeUntilLightStops(){
        FishFeeder feeder =new FishFeeder("Delonghi","Small",12);
        aut.isp.lab4.exercise3.AquariumController first=new AquariumController(feeder,"BioTech","Medium",0.30F,5.40F);
        first.setCurrentTime(7.3f);
        float actual=first.getLightOnUntilStops();
        float expected=1.0f;
        assertEquals(expected,actual,0.0f);
    }
    @Test
    public void testTimeLightStartAgain(){
        FishFeeder feeder =new FishFeeder("Delonghi","Small",12);
        aut.isp.lab4.exercise3.AquariumController first=new AquariumController(feeder,"BioTech","Medium",0.30F,5.40F);
        first.setCurrentTime(8.3f);
        first.setCurrentTime(22.0f);
        float actual=first.getLightOffUntilResets();
        float expected=2.30f;
        assertEquals(expected,actual,0.1f);
    }

}
