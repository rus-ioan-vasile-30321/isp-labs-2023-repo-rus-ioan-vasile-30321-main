package Exercise2;

import isp.lab4.exercise2.Laptop;
import isp.lab4.exercise2.SmartPhone;
import isp.lab4.exercise2.SmartWatch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Functionality {
    @Test
    public void laptopChargeTest(){
        Laptop asus=new Laptop(23);
        asus.setCharging_speed(1.5F);
        asus.charge(23);
        int actual=asus.getBatteryLevel();
        int expected=57;
        assertEquals(expected,actual);
    }
    @Test
    public void SmartphoneChargeTest(){
        SmartPhone xiaomi=new SmartPhone(40);
        xiaomi.setCharging_speed(2.5F);
        xiaomi.charge(23);
        int actual=xiaomi.getBatteryLevel();
        int expected=97;
        assertEquals(expected,actual);
    }
    @Test
    public void SmartWatchTest(){
        SmartWatch huawai=new SmartWatch(1);
        huawai.setCharging_speed(1.3F);
        huawai.charge(23);
        int actual=huawai.getBatteryLevel();
        int expected=30;
        assertEquals(expected,actual);

    }
    @Test
    public void laptopChargeTestWithoutSettingSpeed(){
        Laptop asus=new Laptop(23);
        asus.charge(23);
        int actual=asus.getBatteryLevel();
        int expected=23;
        assertEquals(expected,actual);
    }
}
