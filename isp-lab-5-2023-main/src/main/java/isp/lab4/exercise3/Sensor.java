package isp.lab4.exercise3;

abstract class  Sensor {
    private String installLocation;
    private String name;

    public void setInstallLocation(String installLocation) {
        this.installLocation = installLocation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstallLocation() {
        return installLocation;
    }

    public String getName() {
        return name;
    }
}
