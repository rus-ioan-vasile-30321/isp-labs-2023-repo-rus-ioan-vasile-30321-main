package isp.lab3;

import isp.lab3.example.Airplain;
import isp.lab3.exercise1.Tree;
import isp.lab3.exercise3.Vehicle;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class RegtangleTest {

    @Test
    public void testtoString(){
        Vehicle one=new Vehicle("Mercedes","G Class",210,'B');
        String actual =one.toString();
        String expected="Mercedes (G Class) speed 210 fuel type B";

        assertEquals(expected,actual);


    }

}