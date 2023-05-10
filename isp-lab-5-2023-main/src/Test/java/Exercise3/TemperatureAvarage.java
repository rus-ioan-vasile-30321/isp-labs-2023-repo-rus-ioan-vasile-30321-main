package Exercise3;

import isp.lab4.exercise3.MonitoringService;
import isp.lab4.exercise3.PressureSensor;
import isp.lab4.exercise3.TemperatureSensor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TemperatureAvarage {
    @Test
    public void avarageTestTemperature(){
        TemperatureSensor temperatureSensor1=new TemperatureSensor(24.1);
        temperatureSensor1.setInstallLocation("Sera1");
        temperatureSensor1.setName("Row1");
        TemperatureSensor temperatureSensor2=new TemperatureSensor(23.5);
        temperatureSensor2.setInstallLocation("Sera1");
        temperatureSensor2.setName("Row2");
        TemperatureSensor temperatureSensor3=new TemperatureSensor(25.5);
        temperatureSensor3.setInstallLocation("Sera1");
        temperatureSensor3.setName("Row3");
        TemperatureSensor[] sera1T=new TemperatureSensor[]{temperatureSensor1,temperatureSensor2,temperatureSensor3};
        MonitoringService monitoringService=new MonitoringService(sera1T,new PressureSensor[]{});
        double actual=monitoringService.getAvarageTemperatureSensors();
        double expected=24.37f;
        assertEquals(expected,actual,0.1f);
    }
}
