package Exercise1;

import isp.lab4.exercise1.Address;
import isp.lab4.exercise1.Customer;
import isp.lab4.exercise1.Product;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Association {
    @Test
    public void addressTest(){
        Customer customer=new Customer("1","Rus Ioan","0758506003");
        Address address=new Address("Principala","Barsana");
        customer.setAddress(address);
        String actual=customer.getAddress();
        String expected="Address is: BarsanaPrincipala";
        assertEquals(expected,actual);
    }
    @Test
    public void customerTest(){
        Product product=new Product("1","Copac",100.0);
        Customer customer=new Customer("1","Rus Ioan","0758506003");
        product.setCustomer(customer);
        String actual=product.getCustomerInfo();
        String expected="CustomerId:1 Name:Rus Ioan Phone:0758506003";
        assertEquals(actual,expected);
    }
}
