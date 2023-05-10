package isp.lab4.exercise3;

//nu inteleg diagrama, ordinul de multiplicitate
// se aplica pentru fiecare clasa care mosteneste Sensor
// asa cum am facut mai jos?
public class MonitoringService {
    private TemperatureSensor[] temperatureSensors;
    private PressureSensor[] pressureSensors;

    public MonitoringService(TemperatureSensor[] temperatureSensors, PressureSensor[] pressureSensors) {
        if(temperatureSensors.length>10){
            System.out.println("To many temperature sensors!Over 10.");
            for(int i=0;i<10;i++)this.temperatureSensors[i]=temperatureSensors[i];
        }
        else this.temperatureSensors = temperatureSensors;
        if(pressureSensors.length>10){
            System.out.println("To many pressure sensors!Over 10.");
            for(int i=0;i<10;i++)this.pressureSensors[i]=pressureSensors[i];
        }
        else this.pressureSensors = pressureSensors;
    }

    public double getAvarageTemperatureSensors(){
        double avarage=0f;
        for(int i=0;i<this.temperatureSensors.length;i++)
            avarage+=this.temperatureSensors[i].getTemperature();
        return avarage/this.temperatureSensors.length;
    }
    public double[] getAvarageAllSensors(){
        double avaraget=0f;
        for(int i=0;i<this.temperatureSensors.length;i++)
            avaraget+=this.temperatureSensors[i].getTemperature();
        double avaragep=0f;
        for(int i=0;i<this.pressureSensors.length;i++)
            avaragep+=this.pressureSensors[i].getPressure();

        return new double[]{avaraget, avaragep};
    }
}
