package aut.isp.lab4.exercise1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AquariumControllerTest {
    @Test
    public void testtoString(){
        AquariumController first=new AquariumController("Bosch","Big",04.43F);
        String actual=first.toString();
        String expected="The manufacturer is: Bosch The model is:Big The current time is:4.43";
        assertEquals(expected,actual);
    }
    @Test
    public void testsetCurrentTime(){
        AquariumController first=new AquariumController("Bosch","Big",04.43F);
        first.setCurrentTime(0.34F);
        Float actual=first.getCurrentTime();
        Float expected= 0.34F;
        assertEquals(expected,actual);

    }
}
