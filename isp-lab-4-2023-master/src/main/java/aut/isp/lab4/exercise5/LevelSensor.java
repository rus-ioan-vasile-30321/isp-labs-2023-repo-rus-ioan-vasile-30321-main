package aut.isp.lab4.exercise5;

public class LevelSensor extends Sensor {
    private static float  value;
    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
