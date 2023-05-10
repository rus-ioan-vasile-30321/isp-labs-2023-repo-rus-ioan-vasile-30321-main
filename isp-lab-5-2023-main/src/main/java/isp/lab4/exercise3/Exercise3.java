package isp.lab4.exercise3;

import java.util.Arrays;

public class Exercise3 {

    public static void main(String[] args) {
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
        System.out.println(String.format("%.2f",monitoringService.getAvarageTemperatureSensors() )+" Celsius");
        System.out.println(Arrays.toString(monitoringService.getAvarageAllSensors()));
    }

}
