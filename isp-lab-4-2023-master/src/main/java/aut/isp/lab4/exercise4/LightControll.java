package aut.isp.lab4.exercise4;

public class LightControll {
    private float lightOnTime=8F;
    private float lightOffTime=16F;

    public void setLightOnTime(float lightOnTime) {
        this.lightOnTime = lightOnTime;
    }

    public void setLightOffTime(float lightOffTime) {
        this.lightOffTime = lightOffTime;
    }

    public float getLightOnTime() {
        return lightOnTime;
    }

    public float getLightOffTime() {
        return lightOffTime;
    }
}
