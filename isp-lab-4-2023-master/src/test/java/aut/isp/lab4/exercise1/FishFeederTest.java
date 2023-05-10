package aut.isp.lab4.exercise1;

import aut.isp.lab4.exercise2.FishFeeder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FishFeederTest {

    @Test
    public void testFeed(){
        FishFeeder first =new FishFeeder("Delonghi","Small",12);
        first.fillUp();
        int expected=first.getMeals()-1;
        first.feed();
        int actual=13;
        assertEquals(expected,actual);
    }
    @Test
    public void testFillUp(){
        FishFeeder first =new FishFeeder("Delonghi","Small",12);
        first.fillUp();
        int expected=14;
        int actual= first.getMeals();
        assertEquals(expected,actual);
    }
    @Test
    public void testtoString(){
        FishFeeder first =new FishFeeder("Delonghi","Small",12);
        String expected= "The manufacturer is: Delonghi The model is: Small The maximum meals= 14";
        String actual=first.toString();
    }

}
