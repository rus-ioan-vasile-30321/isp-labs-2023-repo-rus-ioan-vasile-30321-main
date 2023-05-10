package isp.lab3;

import isp.lab3.example.Airplain;
import isp.lab3.exercise1.Tree;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void testGrow() {
        Tree t=new Tree(20);
        int actual =t.Grow(10);
        int expected=30;

        assertEquals(expected,actual);

    }
    @Test
    public void testtoString() {
        Tree t=new Tree(20);
        String actual =t.toString();
        String expected="This is a tree with height:20";

        assertEquals(expected,actual);

    }


}