package isp.lab6.exercise3;

import java.util.Comparator;

public class Product{
    private String name;
    private float price;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Product){
            Product p = (Product) obj;
            return p.name.equalsIgnoreCase(this.name);
        }
        else return false;
    }

    @Override
    public int hashCode() {
        int result=1;
        if(this.name!=null)
            for(int i=0;i<this.name.length();i++)
                result+=(int)this.name.charAt(i);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

}
