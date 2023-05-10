package isp.lab6.exercise1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestExercise1 {
    @Test
    public void addStudent(){
        List<Student> data= new ArrayList<>();
        HashMap<String,Integer> grades=new HashMap<>();
        grades.put("Mathematics",7);
        grades.put("Informatics",8);
        grades.put("Databases",9);
        Student student_read=new Student("123","Ioan",grades);
        data.add(student_read);
        boolean actual=true;
        boolean expect=data.contains(student_read);
        assertEquals(actual,expect);
    }
    @Test
    public void removeStudent(){
        List<Student> data= new ArrayList<>();
        HashMap<String,Integer> grades=new HashMap<>();
        grades.put("Mathematics",7);
        grades.put("Informatics",8);
        grades.put("Databases",9);
        Student student_read=new Student("123","Ioan",grades);
        data.add(student_read);
        data.remove(student_read);
        boolean actual=false;
        boolean expected=data.contains(student_read);
        assertEquals(actual,expected);
    }
    @Test
    public void updateStudent(){
        List<Student> data= new ArrayList<>();
        HashMap<String,Integer> grades=new HashMap<>();
        grades.put("Mathematics",7);
        grades.put("Informatics",8);
        grades.put("Databases",9);
        Student student_read=new Student("123","Ioan",grades);
        data.add(student_read);
        data.get(0).setName("Michael");
        String actual="Michael";
        String expected=data.get(0).getName();
        assertEquals(actual,expected);
    }
    @Test
    public void averageStudent(){
        List<Student> data= new ArrayList<>();
        HashMap<String,Integer> grades=new HashMap<>();
        grades.put("Mathematics",7);
        grades.put("Informatics",8);
        grades.put("Databases",9);
        Student student_read=new Student("123","Ioan",grades);
        data.add(student_read);
        float actual=8.0f;
        float expected=data.get(0).averageGrade();
        assertEquals(actual,expected,0.1f);
    }
}
