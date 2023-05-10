package aut.isp.lab4.exercise2;

public class FishFeeder {
    private String manufacturer;
    private String model;
    private int meals=0;

    public FishFeeder(String manufacturer, String model,int meals) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.meals=meals;
    }

    public void fillUp(){
        this.meals=14;
        System.out.println("The feeder is full with 14 meals");
    }
    public void feed(){
        if(this.meals>=1) {
            this.meals = this.meals - 1;
            System.out.println("We feed the fish! meals remain: "+this.meals);
        }
        else System.out.println("The feeder is empty!");
    }
    public String toString(){
        return "The manufacturer is: "+this.manufacturer+" The model is: "+this.model+" The maximum meals= 14";
    }

    public int getMeals() {
        return meals;
    }
}
