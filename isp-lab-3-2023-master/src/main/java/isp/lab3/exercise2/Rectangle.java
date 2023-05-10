package isp.lab3.exercise2;

public class Rectangle {
    private int length=2;
    private int width=1;
    private String color="red";
    Rectangle(){
        this.length=2;
        this.width=1;
        this.color="red";
    }
    Rectangle(int length,int width){
        this.length=length;
        this.width=width;
    }
    Rectangle(int length,int width, String color){
        this.length=length;
        this.width=width;
        this.color=color;
    }
    //methods
    public int getLength(){
        return this.length;
    }
    public int getWidth(){
        return this.width;
    }
    public String getColor(){
        return this.color;
    }
    public int getPerimeter(){
        return 2*this.length+2*this.width;
    }
    public int getArea(){
        return this.length*this.width;
    }

    public static void main(String[] args) {
        Rectangle gresie=new Rectangle(50,50,"Antracit");
        System.out.println("Information about class Rectangle:length-"+gresie.getLength()+
                " width-"+ gresie.getWidth()+" color-"+ gresie.getColor()+
                " Perimeter-"+ gresie.getPerimeter()+" Area-"+ gresie.getArea());

    }





}
