package isp.lab4.exercise2;

public class SmartWatch implements Chargeable{
    private int batteryLevel;
    private float charging_speed;

    public SmartWatch(int batteryLevel){
        this.batteryLevel=batteryLevel;
    }

    public void setCharging_speed(float charging_speed) {
        this.charging_speed = charging_speed;
    }

    @Override
    public void charge(int duration) {
        if(this.charging_speed!=0) {
            int charging_procent = (int) (this.charging_speed * duration);
            if (this.batteryLevel + charging_procent > 100) {
                this.batteryLevel = 100;
                System.out.println("Dispozitiv incarcat 100%");
            } else {
                this.batteryLevel += charging_procent;
                System.out.println("Dispozitiv incarcat " + this.batteryLevel);
            }
        }
        else System.out.println("Charging speed not specified!");
    }

    @Override
    public int getBatteryLevel() {
        System.out.println("Battery level for SmartWatch is:"+this.batteryLevel);
        return this.batteryLevel;
    }
}
