package aut.isp.lab4.exercise1;

public class Exercise1 {

    public static void main(String[] args) {
        AquariumController first=new AquariumController("Bosch","Big",00.00F);
        first.setCurrentTime(04.43F);
        System.out.println(first.toString());
    }
}
