package isp.lab3;

import isp.lab3.example.Airplain;
import isp.lab3.exercise3.Vehicle;
import isp.lab3.exercise4.MyPoint;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class MyPointTest {

    @Test
    public void testDistance(){
        MyPoint first=new MyPoint(-12,23,3);
        float actual =first.Distance(14,2,0);
        float expected= 10.0F;
        assertEquals(expected,actual,0.0F);


    }
}