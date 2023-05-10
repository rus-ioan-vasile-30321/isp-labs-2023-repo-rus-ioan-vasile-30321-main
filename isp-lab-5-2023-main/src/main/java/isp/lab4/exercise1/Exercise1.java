package isp.lab4.exercise1;

import java.time.LocalDateTime;

public class Exercise1 {
    //exerciutiu finalizat complet,fiecare clasa functioneaza
    //corect

    public static void main(String[] args) {
    //list of product ordered by customer
    Product product1=new Product("1","Laptop",4560.99);
    product1.setProductCategory(ProductCategory.ELECTRONICS);
    Product product2=new Product("2","Telefon",2060.99);
    product2.setProductCategory(ProductCategory.ELECTRONICS);
    Product product3=new Product("3","Pantaloni",60.99);
    product3.setProductCategory(ProductCategory.FASHION);
    Product product4=new Product("4","Palarie",20.99);
    product4.setProductCategory(ProductCategory.FASHION);
    Product product5=new Product("5","Foisor",43000.00);
    product5.setProductCategory(ProductCategory.HOME_AND_GARDEN);
    Product product6=new Product("6","Floricele",5.99);
    product6.setProductCategory(ProductCategory.HOME_AND_GARDEN);
    Product product7=new Product("7","Font de ten",11.99);
    product7.setProductCategory(ProductCategory.BEAUTY);
    Product product8=new Product("8","Rimel",22.99);
    product8.setProductCategory(ProductCategory.BEAUTY);
    Product product9=new Product("9","Ursulet",7.99);
    product9.setProductCategory(ProductCategory.TOYS);
    Product product10=new Product("10","Trenulet",33.99);
    product10.setProductCategory(ProductCategory.TOYS);

    Product[] listProduct=new Product []{product1,product2,product3,product4,product5,product6,product7,product8,product9,product10};
    double sum=0;
    for(int i=0;i<listProduct.length;i++)
        sum+=listProduct[i].getPrice();


    Customer customer=new Customer("1","Ioan","0758506003");
    Address address=new Address("Principala","Barsana");
    customer.setAddress(address);
    for(int i=0;i< listProduct.length;i++)
        listProduct[i].setCustomer(customer);

    LocalDateTime date=LocalDateTime.now();
    Order first=new Order("1",date,sum,listProduct);


    }
}
