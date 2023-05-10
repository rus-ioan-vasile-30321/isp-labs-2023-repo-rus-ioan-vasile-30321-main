package aut.isp.lab4.exercise6;

import aut.isp.lab4.exercise5.Sensor;

public class LevelPH extends Sensor {
    private static float value;

    public void setValue(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
