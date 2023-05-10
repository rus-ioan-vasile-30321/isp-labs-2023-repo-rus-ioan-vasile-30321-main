package aut.isp.lab4.exercise3;

import aut.isp.lab4.exercise2.FishFeeder;
import aut.isp.lab4.exercise4.LightControll;

public class AquariumController {
    private FishFeeder feeder;
    private  String manufacturer;
    private String model;
    private float currentTime;
    private float feedingTime;
    private LightControll light;
    public AquariumController(FishFeeder feeder, String manufacturer, String model, float currentTime, float feedingTime) {
        this.light=new LightControll();
        this.feeder = feeder;
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = feedingTime;
    }

    public float getCurrentTime() {
        return currentTime;
    }

    public float getFeedingTime() {
        return feedingTime;
    }

    public void setCurrentTime(float currentTime) {
        /*
            Note:This program work only in interval 00-24, and  was thinks to work for a read between 5-10 minutes, every time
            Note2:100% exista o alta modalitate,dar nu cred ca acesta este scopul
        Cum am gandit,timpul_scurs=differenta dintre currenTime-this.currentTime;
            lighton-trebuie sa fie pornit tot timpul,atata timp cat nu depaseste 8h,daca light on a ajuns la 0
            trebuie sa tinem lumina stinsa pentru urmatoarele 16h
            if(LightOn-expired)
                if(timpul_scurs>timp_ramas_lumina_stinsa)resetam lighton,lightof to 8h, respectiv 16h
                else scadem lightooff-timp_scurs
            else if(timpul_scurs>timp_ramas_lumina_aprinsa){lighton=0}
                  else scadem lighton-timp scurs
         */
        //implementare light sensor,ex4
        float diff=currentTime-this.currentTime;
        if(this.light.getLightOnTime()==0)
            if(diff>this.light.getLightOffTime()){
                this.light.setLightOffTime(16);this.light.setLightOnTime(8);
            }
            else this.light.setLightOffTime(this.light.getLightOffTime()-diff);
        else if (diff>this.light.getLightOnTime())
            this.light.setLightOnTime(0);
             else this.light.setLightOnTime(this.light.getLightOnTime()-diff);

        //necesare pentru ex3
        this.currentTime = currentTime;
        if(this.feedingTime<=this.currentTime)this.feeder.feed();
    }
    //pentru ex4
    public float getLightOnUntilStops(){
        return this.light.getLightOnTime();
    }
    public float getLightOffUntilResets(){
        return this.light.getLightOffTime();
    }
    //pana aici
    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;
    }
    public String toString(){
        return "Manufacturer: "+this.manufacturer+" Model: "+this.model+" CurrentTime: "+this.currentTime+" FeedingTime: "+this.feedingTime;
    }
}
