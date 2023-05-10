package isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        Laptop asus=new Laptop(23);
        asus.getBatteryLevel();
        asus.setCharging_speed(1.5F);
        asus.charge(23);
        asus.getBatteryLevel();
        asus.charge(50);
        SmartPhone xiaomi=new SmartPhone(40);
        xiaomi.getBatteryLevel();
        xiaomi.charge(30);
        xiaomi.setCharging_speed(2.5f);
        xiaomi.charge(23);
        xiaomi.getBatteryLevel();
        SmartWatch huawai=new SmartWatch(1);
        huawai.getBatteryLevel();
        huawai.charge(32);
        huawai.setCharging_speed(1.4f);
        huawai.charge(20);
        huawai.getBatteryLevel();





    }
}
