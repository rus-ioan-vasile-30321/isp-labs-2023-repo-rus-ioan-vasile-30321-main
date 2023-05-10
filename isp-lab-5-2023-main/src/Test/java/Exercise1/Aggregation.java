package Exercise1;

import isp.lab4.exercise1.Order;
import isp.lab4.exercise1.Product;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class Aggregation {
    @Test
    //testere multiplicitate ordin
    public void orderTest(){
        Product[] product=new Product[]{new Product("1","Copac",100.0)};
        Order order=new Order("1", LocalDateTime.now(),2324.23,product);
        String actual=order.checkProduct();
        String expected="Invalid!Multiplicity Order problem.";
        assertEquals(actual,expected);
    }
}
