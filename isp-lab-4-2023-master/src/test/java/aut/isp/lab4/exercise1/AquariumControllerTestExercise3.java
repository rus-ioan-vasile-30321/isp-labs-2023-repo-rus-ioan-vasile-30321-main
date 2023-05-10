package aut.isp.lab4.exercise1;

import aut.isp.lab4.exercise2.FishFeeder;
import aut.isp.lab4.exercise3.AquariumController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AquariumControllerTestExercise3 {
    @Test
    public void testSetCurrentTime(){
        FishFeeder feeder =new FishFeeder("Delonghi","Small",12);
        AquariumController first=new AquariumController(feeder,"BioTech","Medium",5.38F,5.40F);
        first.setCurrentTime(5.47F);
        float actual=first.getCurrentTime();
        float expected=5.47F;
        int actualfeeder=feeder.getMeals();
        int expectedfeeder=11;
        assertEquals(expected,actual,0.0);
        assertEquals(expectedfeeder,actualfeeder);
    }
    @Test
    public void testSetFeedingTime(){
        FishFeeder feeder =new FishFeeder("Delonghi","Small",12);
        AquariumController first=new AquariumController(feeder,"BioTech","Medium",5.38F,5.40F);
        first.setFeedingTime(14.24F);
        float actual=first.getFeedingTime();
        float expected=14.24F;
        assertEquals(expected,actual,0.0F);
    }
    @Test
    public void testToString(){
        FishFeeder feeder =new FishFeeder("Delonghi","Small",12);
        AquariumController first=new AquariumController(feeder,"BioTech","Medium",5.38F,5.40F);
        String actual=first.toString();
        String expected="Manufacturer: BioTech Model: Medium CurrentTime: 5.38 FeedingTime: 5.4";
        assertEquals(actual,expected);
    }
}
