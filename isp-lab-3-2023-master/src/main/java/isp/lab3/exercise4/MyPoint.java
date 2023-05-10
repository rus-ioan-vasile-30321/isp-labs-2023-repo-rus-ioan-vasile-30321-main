package isp.lab3.exercise4;

public class MyPoint {
    private int x,y,z;

    MyPoint(){
        this.x=0;
        this.z=0;
        this.y=0;
    }

    public MyPoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void setXYZ(int x,int y,int z){
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public  String toString(){
        return "("+this.x+","+this.y+","+this.z+")";
    }
    public float Distance(int x,int y,int z){
        return ((x-this.x)^2+(y-this.y)^2+(z-this.z)^2)^(1/2);
    }

    public float Distance(MyPoint given){
        return ((given.x-this.x)^2+(given.y-this.y)^2+(given.z-this.z)^2)^(1/2);
    }

    public static void main(String[] args) {
        MyPoint first=new MyPoint(-12,23,3);
        MyPoint second=new MyPoint();
        second.setXYZ(14,2,0);
        System.out.println(first.Distance(second));
    }

}
