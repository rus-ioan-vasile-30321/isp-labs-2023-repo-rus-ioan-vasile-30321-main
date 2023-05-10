package isp.lab3.exercise1;

public class Tree {
    //attributes
    int height;
    String name;
    //constructors
    public Tree(){
        height=15;
    }
    //overloading constructor, different parameters
    public Tree(int height){
        this.height=height;
    }

    //methods
    public int Grow(int meters){
        if(meters>=1)
            this.height=this.height+meters;
        return this.height;
    }

    public String toString(){
        return "This is a tree with height:"+this.height;
    }

    //main method
    public static void main(String[] args) {
        Tree t;
        t=new Tree();

        Tree t2=new Tree(25);
        t2.Grow(10);
        System.out.println(t2.toString());

    }
}
