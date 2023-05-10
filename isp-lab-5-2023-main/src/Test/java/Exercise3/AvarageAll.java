package Exercise3;

import isp.lab4.exercise3.MonitoringService;
import isp.lab4.exercise3.PressureSensor;
import isp.lab4.exercise3.TemperatureSensor;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AvarageAll {
    @Test
    public void allSensorsAvarageTest(){
        TemperatureSensor temperatureSensor1=new TemperatureSensor(24.1);
        temperatureSensor1.setInstallLocation("Sera1");
        temperatureSensor1.setName("Row1");
        TemperatureSensor temperatureSensor2=new TemperatureSensor(23.5);
        temperatureSensor2.setInstallLocation("Sera1");
        temperatureSensor2.setName("Row2");
        TemperatureSensor temperatureSensor3=new TemperatureSensor(25.5);
        temperatureSensor3.setInstallLocation("Sera1");
        temperatureSensor3.setName("Row3");
        PressureSensor pressureSensor1=new PressureSensor(1.01f);
        TemperatureSensor[] sera1T=new TemperatureSensor[]{temperatureSensor1,temperatureSensor2,temperatureSensor3};
        PressureSensor[] sera1P=new PressureSensor[]{pressureSensor1};
        MonitoringService monitoringService=new MonitoringService(sera1T,sera1P);
        double[] actual=monitoringService.getAvarageAllSensors();
        double[] expected={73.1, 1.0099999904632568};
        System.out.println(Arrays.toString(actual));
        assertEquals(Arrays.toString(expected),Arrays.toString(actual));

    }
}
