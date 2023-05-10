package aut.isp.lab4.exercise1;

public class AquariumController {

    //attributs
    private String manufacturer;
    private String model;
    private float currentTime;
    //constructors

    public AquariumController(String manufacturer, String model, float currentTime) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
    }

    //methods


    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
    }

    public float getCurrentTime() {
        return currentTime;
    }

    public String toString(){
        return "The manufacturer is: "+this.manufacturer+" The model is:"+this.model+ " The current time is:"+this.currentTime;
    }

}
