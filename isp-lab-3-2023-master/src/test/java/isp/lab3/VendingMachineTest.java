package isp.lab3;

import isp.lab3.exercise1.Tree;
import isp.lab3.exercise5.VendingMachine;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    @Test
    public void testdisplayProducts() {
        VendingMachine machine=new VendingMachine();
        String actual =machine.displayProducts();
        String expected=" Product:ChipsCODE:11 Product:BurgerCODE:12 Product:ColaCODE:13 Product:SnickerCODE:14 Product:CovrigCODE:21 Product:WaterCODE:22 Product:BiscuitsCODE:23 Product:BakeRollsCODE:24";
        assertEquals(expected,actual);
    }
    @Test
    public void testinsetCoin() {
        VendingMachine machine=new VendingMachine();
        machine.insertCoin(20);
        float actual=machine.getCredit();
        float expected=20;

        assertEquals(expected,actual,0.0F);

    }
    @Test
    public void testselectProduct() {
        VendingMachine machine=new VendingMachine();
        String actual =machine.selectProduct(11);
        String expected="Name product:Chips";

        assertEquals(expected,actual);

    }

}