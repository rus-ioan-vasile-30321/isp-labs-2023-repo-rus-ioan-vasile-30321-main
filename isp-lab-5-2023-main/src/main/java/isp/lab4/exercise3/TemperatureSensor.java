package isp.lab4.exercise3;

public class TemperatureSensor extends Sensor{
    private double temperature;
    public TemperatureSensor(double temperature) {
        this.temperature = temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public void setInstallLocation(String installLocation) {
        super.setInstallLocation(installLocation);
    }

    @Override
    public String getInstallLocation() {
        return super.getInstallLocation();
    }
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
