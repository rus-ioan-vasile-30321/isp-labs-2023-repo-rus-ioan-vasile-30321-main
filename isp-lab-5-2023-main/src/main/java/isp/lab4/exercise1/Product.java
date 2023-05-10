package isp.lab4.exercise1;

public class Product {
    private String productId;
    private String name;
    private double price;
    private ProductCategory productCategory;
    private Customer customer;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getPrice() {
        return price;
    }

    public String getCustomerInfo(){
        return "CustomerId:"+customer.getCustomerId()+" Name:"+customer.getName()+" Phone:"+customer.getPhone();
    }
    @Override
    public String toString(){
        return getClass().getName()+"{productId="+this.productId+",name="+this.name+",price="+this.price+productCategory.toString()+"}";
    }
}
