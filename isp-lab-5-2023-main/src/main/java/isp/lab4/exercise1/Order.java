package isp.lab4.exercise1;

import java.time.LocalDateTime;

public class Order {
    private String orderId;
    private LocalDateTime date;
    private double totalPrice;
    private Product[] product;

    public Order(String orderId, LocalDateTime date, double totalPrice, Product[] product) {
        this.orderId = orderId;
        this.date = date;
        this.totalPrice = totalPrice;
        if(product.length==10)this.product=product;
            else {
            System.out.println("Invalid number of products: REPLACED WITH NULL");
                this.product=null;
        }
    }

    public String checkProduct() {
        if(product==null)return "Invalid!Multiplicity Order problem.";
        else return "";
    }

    @Override
    public String toString(){
        return getClass().getName()+"{ordeId"+this.orderId+",localdatetime="+this.date+",totalprice="+this.totalPrice+",products:"+this.product;
    }
}
