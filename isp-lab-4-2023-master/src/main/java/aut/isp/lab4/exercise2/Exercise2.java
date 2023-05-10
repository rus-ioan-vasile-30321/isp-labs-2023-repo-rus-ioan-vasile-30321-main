package aut.isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
    FishFeeder first =new FishFeeder("Delonghi","Small",12);
        System.out.println(first.toString());
        first.feed();
        first.fillUp();
        first.feed();
    }
}
